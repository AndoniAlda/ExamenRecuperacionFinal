package com.example.dm2.examenrecuperacionfinal;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {
    EditText nombre;
    Spinner provincias;
    RadioButton masculino;
    RadioButton femenino;
    CheckBox php;
    CheckBox java;
    CheckBox html;
    CheckBox css;
    TextView operador1;
    TextView operador2;
    EditText resultado;
    Button evaluar;
    TextView numeroCandidatos;
    Button salir;
    int numeroIntentos = 0;
    int contCandidatos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        setTitle(R.string.Actividad1);


        salir = (Button) findViewById(R.id.botonSalir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        nombre = (EditText) findViewById(R.id.nombre);
        provincias = (Spinner) findViewById(R.id.spinnerPro);
        masculino = (RadioButton) findViewById(R.id.masculino);
        femenino = (RadioButton) findViewById(R.id.femenino);
        php = (CheckBox) findViewById(R.id.php);
        java = (CheckBox) findViewById(R.id.java);
        html = (CheckBox) findViewById(R.id.html);
        css = (CheckBox) findViewById(R.id.css);
        operador1 = ( TextView) findViewById(R.id.operador1);

        operador2 = ( TextView) findViewById(R.id.operador2);
        resultado = (EditText) findViewById(R.id.resultadoOperacion);
        evaluar = (Button) findViewById(R.id.botonEvaluar);
        numeroCandidatos = (TextView) findViewById(R.id.numeroCandidatos);

        String [] provincia = {"Alava","Bizkaia","Gipuzkua"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,provincia);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincias.setAdapter(adaptador);




        gennerarOperacion();

        evaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().equals("")){
                   Toast.makeText(Actividad1.this, "Nombre es un campo obligatorio",Toast.LENGTH_SHORT).show();
                }else{
                    boolean pasa=false;
                    pasa = comprobarResultado();
                    if(pasa==false){
                        numeroIntentos++;
                        Toast.makeText(Actividad1.this, "Intento fallido : "+numeroIntentos,Toast.LENGTH_SHORT).show();
                    }
                    if(numeroIntentos>=3){
                        finish();
                    }else if(pasa==true){
                        Intent intent = new Intent(Actividad1.this, Actividad1B.class);
                        intent.putExtra("nombre",nombre.getText().toString());
                        intent.putExtra("provincia",provincias.getSelectedItem().toString());
                        if(masculino.isChecked()) {
                            intent.putExtra("genero", masculino.getText().toString());
                        }else {
                            intent.putExtra("genero", femenino.getText().toString());
                        }
                        if(php.isChecked())intent.putExtra("php",php.getText().toString());
                        if(java.isChecked())intent.putExtra("java",java.getText().toString());
                        if(css.isChecked())intent.putExtra("css",css.getText().toString());
                        if(html.isChecked())intent.putExtra("html",html.getText().toString());

                        startActivityForResult(intent,1234);


                    }


                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1234 && resultCode==RESULT_OK){
            contCandidatos = contCandidatos +  1 ;
            numeroCandidatos.setText(contCandidatos+"");

            if (contCandidatos >= 4){
                evaluar.setEnabled(false);
                evaluar.setVisibility(View.INVISIBLE);
                salir.setVisibility(View.VISIBLE);
            }
        }else{
            Toast.makeText(Actividad1.this, "El candidato ha sido rechazado",Toast.LENGTH_SHORT).show();
        }
       vaciarCampos();
    }
    public void vaciarCampos(){
        nombre.setText("");
        provincias.setSelected(false);
        masculino.setChecked(false);
        femenino.setChecked(false);
        php.setChecked(false);
        java.setChecked(false);
        html.setChecked(false);
        css.setChecked(false);
        resultado.setText("");
    }
    public void gennerarOperacion(){
        long numero = Math.round(Math.random()*100);
        operador1.setText(numero+"");
        numero = (int) Math.round(Math.random()*100);
        operador2.setText(numero+"");
        resultado.setText("");
    }
    public boolean comprobarResultado(){
        int numero1 = Integer.parseInt(operador1.getText().toString());
        int numero2 = Integer.parseInt(operador2.getText().toString());
        int resultadoEsperado= numero1+numero2;//0;
        String resultadoIntroducido = resultado.getText().toString();
        try{
          int resultadoIntroducidoI =  Integer.parseInt(resultadoIntroducido);
            Log.i("Aaa",resultadoIntroducidoI+"");
            if (resultadoEsperado != resultadoIntroducidoI){
                Toast.makeText(Actividad1.this, "La suma es incorrecta",Toast.LENGTH_SHORT).show();
                return false;
            }
            else{
                return true;
            }
        }catch (NumberFormatException e){
           Toast.makeText(Actividad1.this, "Introduce un numero valido",Toast.LENGTH_SHORT).show();
           return false;
        }


    }
}

package com.example.dm2.examenrecuperacionfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad1B extends AppCompatActivity {
    TextView nom;
    TextView pro;
    TextView sex;
    TextView cono;
    Button aceptar;
    Button rechazar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1_b);
        setTitle(R.string.Actividad1B);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String provincia = extras.getString("provincia");
        String sexo = extras.getString("genero");
        ArrayList<String>conocimientos = new ArrayList<String>();
        if(extras.get("php")!= null){
            conocimientos.add(extras.getString("php"));
        }
        if(extras.get("java")!=null){
            conocimientos.add(extras.getString("java"));
        }
        if(extras.get("css")!=null){
            conocimientos.add(extras.getString("css"));
        }
        if(extras.get("html")!=null){
            conocimientos.add(extras.getString("html"));
        }





        nom = (TextView) findViewById(R.id.nombreb);
        pro = (TextView) findViewById(R.id.provinciab);
        sex = (TextView) findViewById(R.id.sexob);
        cono = (TextView) findViewById(R.id.conocimientob);
        aceptar = ( Button) findViewById(R.id.aceptar);
        rechazar = (Button) findViewById(R.id.rechazar);


        nom.setText(nombre);
        pro.setText(provincia);
        sex.setText(sexo);
        String conocimientosS="";
        for (int z=0;z<conocimientos.size();z++){
            if (z==0){
                conocimientosS += conocimientos.get(z);
            }else{
                conocimientosS +=", "+ conocimientos.get(z);
            }

        }

        cono.setText(conocimientosS);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}


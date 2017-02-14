package com.example.dm2.examenrecuperacionfinal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URLConnection;

public class Actividad2 extends AppCompatActivity {
    ListView listaColes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        setTitle("Actividad 2");
        listaColes = (ListView) findViewById(R.id.listaInstitutos);

       final Colegio[] datos = new Colegio[]{
                new Colegio("CIFp Ciudad Jardin LHII","C/ALava 39","www.icjardin.net","im_icjardin"),
                new Colegio("CIFP Mendizorroza LHII","Portal de lasarte","www.mendizabala.hezkuntza.net","im_mendizorrotza"),
                new Colegio("ERAIKEN CIFP Construccion LHII","Av de lso huetos","www.construccionvitoria.hezkuntza.net","im_construccion"),
                new Colegio("gamarra Ostalaritza Eskola","Calle Presaga","www.hosteleriagamarra.hezkuntza.net","im_gamarra"),
                new Colegio("IES Instituto Agrario Arkaute","Arkaute","www.arkaute.hezkuntza.net",""),
               new Colegio("IES Mendebaldea BHI ","Donostia San Sebastian kalea,3","www.mendebaldea.hezkuntza.net","im_mendebaldea")
        };


        class AdaptadorLista extends ArrayAdapter<Colegio>{

            public AdaptadorLista(Context context, Colegio[] datos){
                super(context,R.layout.listlayout,datos);
            }
            public View getView (int posicion, View convertView, ViewGroup parent){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                View item = inflater.inflate(R.layout.listlayout,null);
                TextView titulo =(TextView) item.findViewById(R.id.tituloList) ;
                TextView calle = (TextView) item.findViewById(R.id.calleList) ;
                TextView web=(TextView) item.findViewById(R.id.webList) ;
                ImageView imagen = (ImageView) item.findViewById(R.id.imgList);
                titulo.setText(datos[posicion].getNombre());
                calle.setText(datos[posicion].getCalle());
                web.setText(datos[posicion].getWeb());
                String imgNombre = datos[posicion].getImagen();
                if (imgNombre.equals("im_icjardin")){
                    imagen.setImageResource(R.drawable.im_icjardin);
                }else if (imgNombre.equals("im_mendizorrotza")){
                    imagen.setImageResource(R.drawable.im_mendizabala);
                }else if (imgNombre.equals("im_construccion")){
                    imagen.setImageResource(R.drawable.im_construccion);
                }else if (imgNombre.equals("im_gamarra")){
                    imagen.setImageResource(R.drawable.im_gamarra);
                }else if (imgNombre.equals("im_mendebaldea")){
                    imagen.setImageResource(R.drawable.im_mendebaldea);
                }

                return item;
            }
        }
        AdaptadorLista adaptador = new AdaptadorLista(this,datos);
        listaColes.setAdapter(adaptador);
        listaColes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String opcion =
                        ((Colegio)adapterView.getItemAtPosition(i)).getWeb();

                Intent intent =  new Intent (Intent.ACTION_VIEW,Uri.parse("http://"+opcion));
                startActivity(intent);
            }
        });


    }
}

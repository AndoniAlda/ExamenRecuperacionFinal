package com.example.dm2.examenrecuperacionfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button actividad1;
    Button actividad2;
    Button actividad3;
    Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actividad1 =(Button) findViewById(R.id.actividad1);
        actividad2 =(Button) findViewById(R.id.actividad2);
        actividad3 = (Button) findViewById(R.id.actividad3);
        exit = (Button) findViewById(R.id.exit);


        actividad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.notImplement,Toast.LENGTH_SHORT).show();

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        actividad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Actividad1.class);
                startActivity(intent);
            }
        });
        actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intent);
            }
        });


    }
}

package com.cifpceuta.proyectopreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TimerTask;

public class ConfiguracionActivity extends AppCompatActivity {

    Switch aleatorio,respuestaCorrecta,temporizador;
    MainActivity ma;
    PreguntaRespuesta[] mod=null;
    Button guardar;
    boolean flag=false;

    boolean flagRespuestas=false;

    boolean flagTemporizador=false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        aleatorio= (Switch) findViewById(R.id.swRandom);
        respuestaCorrecta= (Switch) findViewById(R.id.switchRespuestaCorrecta);
        temporizador= (Switch) findViewById(R.id.swTemporizador);
        ma=new MainActivity();
        guardar = (Button) findViewById(R.id.botonGuardar);
        PreguntaRespuesta[] preguntaModificada=ma.getPreguntas();



        aleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aleatorio.isChecked()){
                    flag=true;
                }else{
                    flag=false;
                }
            }
        });


        respuestaCorrecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respuestaCorrecta.isChecked()){
                    flagRespuestas=true;
                }else{
                    flagRespuestas=false;
                }
            }
        });

        temporizador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temporizador.isChecked()){
                    flagTemporizador=true;
                }else{
                    flagTemporizador=false;
                }
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfiguracionActivity.this, MainActivity.class);
                if (flag){
                    modificarArray();
                }
                i.putExtra("preguntas",mod);
                i.putExtra("random",flag);
                i.putExtra("respuestasCorrectas",flagRespuestas);
                i.putExtra("temporizador",flagTemporizador);
                startActivity(i);
            }
        });


    }



    public void modificarArray(){
        ArrayList<PreguntaRespuesta> preguntasAleatorias = new ArrayList<>(Arrays.asList(ma.getPreguntas()));
        Collections.shuffle(preguntasAleatorias);
        PreguntaRespuesta[] mod=new PreguntaRespuesta[ma.getPreguntas().length];
        for (int i=0;i<ma.getPreguntas().length;i++){
            mod[i]=preguntasAleatorias.get(i);

        }
        this.mod=mod;
        System.out.println(Arrays.toString(mod));
    }
}
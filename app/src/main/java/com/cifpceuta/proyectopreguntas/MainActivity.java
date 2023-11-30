package com.cifpceuta.proyectopreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView contadorPregunta;
    private TextView pregunta;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3;
    private Button botonSiguiente;

    //private AdapterPreguntas adapterPreguntas;

    private PreguntaRespuesta[] preguntas = {
            new PreguntaRespuesta("¿Qué tipo de animal es la ballena? ", "Mamifero", "Reptil", "Anfibio", 1),
            new PreguntaRespuesta("¿Dónde está Transilvania?", "Madagascar", "Disney", "Rumania", 3),
            new PreguntaRespuesta("¿Cuántos años duró la Primera Guerra Mundial?", "3", "4", "5", 2),
            new PreguntaRespuesta("¿Cuándo murió Freddie Mercury?", "1991", "2010", "1960", 1),
            new PreguntaRespuesta("¿Cuál es el océano más grande del mundo?", "Oceano indíco", "Oceano pacífico", "Oceano atlantico", 2)

    };
    private int contadorGeneral = 0;
    public int aciertos = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adapterPreguntas = new AdapterPreguntas(this,preguntas);

        contadorPregunta = findViewById(R.id.contadorPregunta);
        pregunta = findViewById(R.id.pregunta);
        radioGroup = findViewById(R.id.grupoBoton);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        botonSiguiente = findViewById(R.id.botonSiguiente);
        mostrarPregunta();

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Hola",radioGroup.getCheckedRadioButtonId()+"");
                boolean flag2=false;


                if  (estaMarcado()){



                if (radioButton1.isChecked()){
                    if (preguntas[contadorGeneral].getPreguntaCorrecta()==1){
                        preguntas[contadorGeneral].setFlag(true);
                        aciertos++;
                    }
                } else if (radioButton2.isChecked()) {
                    if (preguntas[contadorGeneral].getPreguntaCorrecta()==2){
                        preguntas[contadorGeneral].setFlag(true);
                        aciertos++;
                    }

                } else if (radioButton3.isChecked()) {
                    if (preguntas[contadorGeneral].getPreguntaCorrecta()==3){
                        preguntas[contadorGeneral].setFlag(true);
                        aciertos++;
                    }

                }

                contadorGeneral++;
                mostrarSiguientePregunta(v);

                }
            }
        });

    }


    public  boolean estaMarcado(){
        return radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked();
    }

    private void mostrarSiguientePregunta(View v){
        if (contadorGeneral==preguntas.length-1){
            botonSiguiente.setText("Finalizar");

        }
        if (contadorGeneral==preguntas.length){
            intentD(v);
            //
        }else {
            mostrarPregunta();
        }
    }

    private void mostrarPregunta() {
        contadorPregunta.setText("Pregunta " + (contadorGeneral + 1) + "/" + preguntas.length);
        pregunta.setText(preguntas[contadorGeneral].getPregunta());
        radioButton1.setText(preguntas[contadorGeneral].getRespuesta1());
        radioButton2.setText(preguntas[contadorGeneral].getRespuesta2());
        radioButton3.setText(preguntas[contadorGeneral].getRespuesta3());
        radioGroup.clearCheck();



    }

    public void intentD(View view) {
        Intent i = new Intent(this, FinalizadoActivity.class);
        i.putExtra("resultado",aciertos);
        i.putExtra("contadorGen",contadorGeneral);
        i.putExtra("preguntasArray",preguntas);
        startActivity(i);

    }



}
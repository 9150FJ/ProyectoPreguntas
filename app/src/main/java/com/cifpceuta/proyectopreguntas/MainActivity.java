package com.cifpceuta.proyectopreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
    private PreguntaRespuesta[] preguntas = {
            new PreguntaRespuesta("¿Cuál es la capital de Francia?", "París", "Madrid", "Londres", 1),
            new PreguntaRespuesta("¿Cuántos planetas hay en el sistema solar?", "7", "8", "9", 2),

    };
    private int contadorGeneral = 0;
    private int aciertos = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                //System.out.println(radioGroup.getCheckedRadioButtonId());
                Log.d("Hola",radioGroup.getCheckedRadioButtonId()+"");


            }
        });

    }



    private void mostrarPregunta() {
        contadorPregunta.setText("Pregunta " + (contadorGeneral + 1) + "/" + preguntas.length);
        pregunta.setText(preguntas[contadorGeneral].getPregunta());
        radioButton1.setText(preguntas[contadorGeneral].getRespuesta1());
        radioButton2.setText(preguntas[contadorGeneral].getRespuesta2());
        radioButton3.setText(preguntas[contadorGeneral].getRespuesta3());

    }

}
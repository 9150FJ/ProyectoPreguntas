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
            new PreguntaRespuesta("¿Cuál fue el detonante de la Primera Guerra Mundial? ","respuesta1","respuesta2","respuesta3",2),
            new PreguntaRespuesta("¿Quién fue el primer presidente de Estados Unidos? ","respuesta4","respuesta5","respuesta6",1),
            new PreguntaRespuesta("¿Qué calavera no regresó tras el primer viaje de Colón a América?  ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿Qué exploradores dieron la primera vuelta al mundo?  ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿En qué año se disolvió la Unión Soviética? ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿En qué isla estuvo preso Napoleón?","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿En qué año se creó la Organización de las Naciones Unidas? ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿En qué año pisó el hombre la luna por primera vez?  ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿Quién fue el primer presidente de la democracia española tras el franquismo?  ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿En qué ciudad tuvieron una reunión Hitler y Franco?","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿Quién fue el presidente de la URSS que instauró la Perestroika? ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿Cuál es la narración épica más antigua?","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿Qué famosa batalla marítima tuvo lugar en 1805? ","respuesta8","respuesta9","respuesta10",1),
            new PreguntaRespuesta("¿Quién era el emperador de Roma durante la época de Jesús de Nazaret? ","respuesta8","respuesta9","respuesta10",1),

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
        });

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
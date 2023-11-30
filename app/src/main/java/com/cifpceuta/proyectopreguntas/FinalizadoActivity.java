package com.cifpceuta.proyectopreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class FinalizadoActivity extends AppCompatActivity {
    TextView resultado;
    private AdapterPreguntas adapterPreguntas;
    ListView lista;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizado);
        resultado=(TextView) findViewById(R.id.tvResultado);

        Intent i = this.getIntent();
        int resul = i.getIntExtra("resultado",0);
        int contadorGeneral = i.getIntExtra("contadorGen",0);
        PreguntaRespuesta[] preguntas = (PreguntaRespuesta[])getIntent().getSerializableExtra("preguntasArray");
        resultado.setText("Preguntas acertadas "+String.valueOf(resul) + "/" + contadorGeneral);
        adapterPreguntas = new AdapterPreguntas(this,preguntas);
        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adapterPreguntas);
        for (int o=0;o<preguntas.length;o++){
            Log.i("i: ",preguntas[o].getPregunta());
        }

    }
}
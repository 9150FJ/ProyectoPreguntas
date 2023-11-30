package com.cifpceuta.proyectopreguntas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterPreguntas extends ArrayAdapter<PreguntaRespuesta>{

    private Activity context;
    PreguntaRespuesta[] preguntas;
    public AdapterPreguntas(Activity c, PreguntaRespuesta[] pr){
        super(c,R.layout.pregunta_finalizada_layout,pr);
        this.context=c;
        this.preguntas=pr;
    }

    @SuppressLint("MissingInflatedId")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.pregunta_finalizada_layout,parent,false);
        PreguntaRespuesta pr = preguntas[position];
        TextView pregunta,respuestaDada;
        pregunta=(TextView) rowView.findViewById(R.id.pregunta);
        respuestaDada=(TextView) rowView.findViewById(R.id.respuestaDada);
        pregunta.setText(pr.getPregunta());
        if (pr.isFlag()){
            respuestaDada.setText("Correcta");
            respuestaDada.setTextColor(Color.GREEN);

        }else {
            respuestaDada.setText("Erronea");
            respuestaDada.setTextColor(Color.RED);

        }


        return rowView;
    }

}

package com.cifpceuta.proyectopreguntas;

public class PreguntaRespuesta {


    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;

    private int preguntaCorrecta;

    public PreguntaRespuesta(String pregunta, String respuesta1, String respuesta2, String respuesta3, int preguntaCorrecta) {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.preguntaCorrecta = preguntaCorrecta;
    }

    public int getPreguntaCorrecta() {
        return preguntaCorrecta;
    }


}


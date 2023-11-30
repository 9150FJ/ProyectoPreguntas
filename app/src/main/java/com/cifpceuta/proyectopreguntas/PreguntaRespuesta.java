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

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public void setPreguntaCorrecta(int preguntaCorrecta) {
        this.preguntaCorrecta = preguntaCorrecta;
    }
}


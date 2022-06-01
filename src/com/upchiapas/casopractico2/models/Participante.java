package com.upchiapas.casopractico2.models;

public class Participante {
    private String participante;
    private int folio;
    private String lugar;
    private int seccion = 0;

    public Participante(String part, int folio, String lugar) {
        this.participante = part;
        this.folio = folio;
        this.lugar = lugar;
    }

    public String getParticipante() {
        return participante;
    }

    public int getSeccion(){
        return this.seccion;
    }

    public void setSeccion(int seccion)
    {
        this.seccion =  seccion;

    }
    public int getFolio() {
        return folio;
    }

    public String getLugar() {
        return lugar;
    }
}

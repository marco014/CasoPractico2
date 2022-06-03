package com.upchiapas.casopractico2.models;
public class Participante {
    private String participante;
    private String folio;
    private String lugar;
    private int seccion = 0;
    public Participante(String part, String folio, String lugar, int seccion) {
        this.participante = part;
        this.folio = folio;
        this.lugar = lugar;
        this.seccion = seccion;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public int getSeccion(){
        return this.seccion;
    }

    public void setSeccion(int seccion)
    {
        this.seccion =  seccion;
    }
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "participante='" + participante + '\'' +
                ", folio=" + folio +
                ", lugar='" + lugar + '\'' +
                ", seccion=" + seccion +
                '}';
    }
}

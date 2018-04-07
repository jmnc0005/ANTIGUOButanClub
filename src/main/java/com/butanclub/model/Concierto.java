/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.model;

import java.util.Date;

/**
 *
 * @author Pedro Luis
 */
public class Concierto {
    private String nombreArtista;
    private int hora;
    private Date fecha;
    private float precio;
    private String tipoMusica;
    private String imagen;

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public String getTipoMuaica() {
        return tipoMusica;
    }
    
    public Concierto(String _nombreArtista,int _hora,Date _fecha,float _precio,String _tipoMusica,String _imagen){
        nombreArtista=_nombreArtista;
        hora=_hora;
        fecha=_fecha;
        precio=_precio;
        tipoMusica=_tipoMusica;
        imagen=_imagen;
    }

    public String getTitulo() {
        return nombreArtista;
    }

    public int getHora() {
        return hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setTitulo(String _nombreArtista) {
        nombreArtista = _nombreArtista;
    }

    public void setHora(int _hora) {
        hora = _hora;
    }

    public void setFecha(Date _fecha) {
        fecha = _fecha;
    }

    public void setPrecio(float _precio) {
        precio = _precio;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionConciertos;

/**
 *
 * @author Pedro Luis
 */
public class Concierto {
    private String titulo;
    private int hora;
    private int fecha;
    private float precio;
    
    public Concierto(String _titulo,int _hora,int _fecha,float _precio){
        titulo=_titulo;
        hora=_hora;
        fecha=_fecha;
        precio=_precio;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public int getHora() {
        return hora;
    }

    public int getFecha() {
        return fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setTitulo(String _titulo) {
        titulo = _titulo;
    }

    public void setHora(int _hora) {
        hora = _hora;
    }

    public void setFecha(int _fecha) {
        fecha = _fecha;
    }

    public void setPrecio(float _precio) {
        precio = _precio;
    }
    
    
}

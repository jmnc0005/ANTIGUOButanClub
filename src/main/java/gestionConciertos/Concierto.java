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
    private String nombreArtista;
    private String hora;
    private String fecha;
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

    public String getTipoMusica() {
        return tipoMusica;
    }
    
    public Concierto(String _nombreArtista,String _hora,String _fecha,float _precio,String _tipoMusica,String _imagen){
        nombreArtista=_nombreArtista;
        hora=_hora;
        fecha=_fecha;
        precio=_precio;
        tipoMusica=_tipoMusica;
        imagen=_imagen;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombreArtista(String _nombreArtista) {
        nombreArtista = _nombreArtista;
    }

    public void setHora(String _hora) {
        hora = _hora;
    }

    public void setFecha(String _fecha) {
        fecha = _fecha;
    }

    public void setPrecio(float _precio) {
        precio = _precio;
    }
    
    
}

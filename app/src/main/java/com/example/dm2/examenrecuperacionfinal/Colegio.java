package com.example.dm2.examenrecuperacionfinal;

/**
 * Created by dm2 on 14/02/2017.
 */

public class Colegio {
    private String nombre;
    private String calle;
    private String web;
    private String imagen;

    public Colegio(String nombre,String calle,String web, String imagen){
        this.nombre = nombre;
        this.calle = calle;
        this.web = web;
        this.imagen = imagen;
    }
    public String getCalle() {
        return calle;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getWeb() {
        return web;
    }
    public void setCalle(String calle) {
        calle = calle;
    }
    public void setWeb(String web) {
        web = web;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

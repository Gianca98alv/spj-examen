/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spj.examen.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */

public class Sorteo {
    
    private int numero_sorteo;
    private Date fecha;
    private String motivo;
    private int retorno;
    private Integer numero_ganador;
    private int estado;
    
    public Sorteo() {
    }
    
    public Sorteo(int numero_sorteo, Date fecha, String motivo, int retorno, Integer numero_ganador, int estado) {
        this.numero_sorteo = numero_sorteo;
        this.fecha = fecha;
        this.motivo = motivo;
        this.retorno = retorno;
        this.numero_ganador = numero_ganador;
        this.estado = estado;
    }
    
    public int getNumero_sorteo() {
        return numero_sorteo;
    }
    
    public void setNumero_sorteo(int numero_sorteo) {
        this.numero_sorteo = numero_sorteo;
    }
    
    public Date getFecha() {
        return fecha;
    } 
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getStringDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fecha);
    }
    
    public String getMotivo() {
        return motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    public int getRetorno() {
        return retorno;
    }
    
    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }
    
    public Integer getNumero_ganador() {
        return numero_ganador;
    }
    
    public void setNumero_ganador(Integer numero_ganador) {
        this.numero_ganador = numero_ganador;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sorteo{" + "numero_sorteo=" + numero_sorteo + ", fecha=" + fecha + ", motivo=" + motivo + ", retorno=" + retorno + ", numero_ganador=" + numero_ganador + ", estado=" + estado + '}';
    }
    
    
    
    
    
    
    
}

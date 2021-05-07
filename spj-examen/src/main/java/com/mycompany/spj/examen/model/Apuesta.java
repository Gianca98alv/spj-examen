/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spj.examen.model;

/**
 *
 * @author User
 */

public class Apuesta {
    
    private Usuario usuario;
    private Sorteo sorteo;
    private int monto_apuesta;
    private int monto_premio;
    
    public Apuesta() {
    }
    
    public Apuesta(Usuario usuario, Sorteo sorteo, int monto_apuesta, int monto_premio) {
        this.usuario = usuario;
        this.sorteo = sorteo;
        this.monto_apuesta = monto_apuesta;
        this.monto_premio = monto_premio;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Sorteo getSorteo() {
        return sorteo;
    }
    
    public void setSorteo(Sorteo sorteo) {
        this.sorteo = sorteo;
    }
    
    public int getMonto_apuesta() {
        return monto_apuesta;
    }
    
    public void setMonto_apuesta(int monto_apuesta) {
        this.monto_apuesta = monto_apuesta;
    }
    
    public int getMonto_premio() {
        return monto_premio;
    }
    
    public void setMonto_premio(int monto_premio) {
        this.monto_premio = monto_premio;
    }

    @Override
    public String toString() {
        return "Apuesta{" + "usuario=" + usuario + ", sorteo=" + sorteo + ", monto_apuesta=" + monto_apuesta + ", monto_premio=" + monto_premio + '}';
    }
    

    
    
    
    
    
    
}

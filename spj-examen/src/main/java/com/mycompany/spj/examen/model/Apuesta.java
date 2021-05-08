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
    private int numero_juego;
    private int monto_apuesta;
    private int monto_premio;
    
    public Apuesta() {
        this.sorteo = null;
    }

    public Apuesta(Usuario usuario, Sorteo sorteo, int numero_juego, int monto_apuesta, int monto_premio) {
        this.usuario = usuario;
        this.sorteo = sorteo;
        this.numero_juego = numero_juego;
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

    public int getNumero_juego() {
        return numero_juego;
    }

    public void setNumero_juego(int numero_juego) {
        this.numero_juego = numero_juego;
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
        return "Apuesta{" + "usuario=" + usuario + ", sorteo=" + sorteo + ", numero_juego=" + numero_juego + ", monto_apuesta=" + monto_apuesta + ", monto_premio=" + monto_premio + '}';
    }

    
    

    
    
    
    
}

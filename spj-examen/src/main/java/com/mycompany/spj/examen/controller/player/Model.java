package com.mycompany.spj.examen.controller.player;


import com.mycompany.spj.examen.model.Apuesta;
import com.mycompany.spj.examen.model.Sorteo;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Model {
    
    private List<Sorteo> lista_sorteos;
    private List<Apuesta> lista_apuestas;
    private Apuesta apuesta;

    public Model() {
        this.lista_sorteos = new ArrayList<>();
        this.lista_apuestas = new ArrayList<>();
        this.apuesta = new Apuesta();
    }

    public List<Sorteo> getLista_sorteos() {
        return lista_sorteos;
    }

    public void setLista_sorteos(List<Sorteo> lista_sorteos) {
        this.lista_sorteos = lista_sorteos;
    }

    public List<Apuesta> getLista_apuestas() {
        return lista_apuestas;
    }

    public void setLista_apuestas(List<Apuesta> lista_apuestas) {
        this.lista_apuestas = lista_apuestas;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }

    @Override
    public String toString() {
        return "Model{" + "lista_sorteos=" + lista_sorteos + ", lista_apuestas=" + lista_apuestas + ", apuesta=" + apuesta + '}';
    }

    
        
}

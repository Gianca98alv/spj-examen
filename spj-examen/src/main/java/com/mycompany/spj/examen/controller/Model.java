/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spj.examen.controller;

import com.mycompany.spj.examen.model.Sorteo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */

public class Model {
    
    private List<Sorteo> sorteos_terminados;
    private List<Sorteo> sorteos_futuros;

    public Model() {
        this.sorteos_terminados = new ArrayList();
        this.sorteos_futuros = new ArrayList();
    }

    public List<Sorteo> getSorteos_terminados() {
        return sorteos_terminados;
    }

    public void setSorteos_terminados(List<Sorteo> sorteos_terminados) {
        this.sorteos_terminados = sorteos_terminados;
    }

    public List<Sorteo> getSorteos_futuros() {
        return sorteos_futuros;
    }

    public void setSorteos_futuros(List<Sorteo> sorteos_futuros) {
        this.sorteos_futuros = sorteos_futuros;
    }

    @Override
    public String toString() {
        return "Model{" + "sorteos_terminados=" + sorteos_terminados + ", sorteos_futuros=" + sorteos_futuros + '}';
    }
    
    
}

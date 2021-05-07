/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spj.examen.data;

import com.mycompany.spj.examen.model.Apuesta;
import com.mycompany.spj.examen.model.Sorteo;
import com.mycompany.spj.examen.model.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */

public class Model {
    
    private List<Usuario> lista_usuarios;
    private List<Sorteo> lista_sorteos;
    private List<Apuesta> lista_apuestas;
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }

    private Model() {
        
        try {
            lista_usuarios = new ArrayList<>();
            Usuario u = new Usuario(true, "1234", "1234", "Gonzalez", "Luis");
            lista_usuarios.add(u);
            
            lista_sorteos = new ArrayList<>();
            String string = "1/1/2010";
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(string);
            Sorteo s = new Sorteo(1, date, "Sorteo LGBTQ+", 4, 11, 3);
            lista_sorteos.add(s);
            
            lista_apuestas = new ArrayList<>();
            Apuesta a = new Apuesta(u, s, 2500, 50000); 
            lista_apuestas.add(a);
            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Usuario> getLista_usuarios() {
        return lista_usuarios;
    }

    public void setLista_usuarios(List<Usuario> lista_usuarios) {
        this.lista_usuarios = lista_usuarios;
    }

    public List<Sorteo> getLista_sorteo() {
        return lista_sorteos;
    }

    public void setLista_sorteo(List<Sorteo> lista_sorteo) {
        this.lista_sorteos = lista_sorteo;
    }

    public List<Apuesta> getLista_apuestas() {
        return lista_apuestas;
    }

    public void setLista_apuestas(List<Apuesta> lista_apuestas) {
        this.lista_apuestas = lista_apuestas;
    }
    
    public List<Sorteo> getListaSorteosTerminados() {
        Date date = new Date();
        List<Sorteo> terminados = new ArrayList<>();
        for(Sorteo sorteo : this.lista_sorteos) {
            if(sorteo.getFecha().compareTo(date) > 0) {
                terminados.add(sorteo);
            }
        }
        return terminados;
    }
    
    public List<Sorteo> getListaSorteosFuturos() {
        Date date = new Date();
        List<Sorteo> futuros = new ArrayList<>();
        for(Sorteo sorteo : this.lista_sorteos) {
            if(sorteo.getFecha().compareTo(date) <= 0) {
                futuros.add(sorteo);
            }
        }
        return futuros;
    }
    
    public Usuario findUsuarioByCedula(String cedula) {
        for(Usuario usuario : this.lista_usuarios) {
            if(usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }
    
}

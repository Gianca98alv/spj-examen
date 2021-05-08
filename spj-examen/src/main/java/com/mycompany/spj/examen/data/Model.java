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
            Usuario u1 = new Usuario(true, "1234", "1234", "Gonzalez", "Luis");
            lista_usuarios.add(u1);
            Usuario u2 = new Usuario(false, "0000", "4567", "Villalobos", "Davide");
            lista_usuarios.add(u2);
            Usuario u3 = new Usuario (false, "8900", "3456", "Alfaro", "Carlos");
            lista_usuarios.add(u3);
            
            lista_sorteos = new ArrayList<>();
            String fecha1 = "1/1/2010";
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = format.parse(fecha1);
            Sorteo s1 = new Sorteo(1, date1, "Sorteo LGBTQ+", 4, 11, 3);
            lista_sorteos.add(s1);
            
            String fecha2 = "2/2/2022";
            Date date2 = format.parse(fecha2);
            Sorteo s2 = new Sorteo(2, date2, "Sorteo Día de las Madres", 2, null, 3);
            lista_sorteos.add(s2);
            
            String fecha3 = "3/3/2003";
            Date date3 = format.parse(fecha3);
            Sorteo s3 = new Sorteo(3, date3, "Sorteo Cruz Roja", 5, 7, 1);
            lista_sorteos.add(s3);
            
            lista_apuestas = new ArrayList<>();
            
            Apuesta a1 = new Apuesta(u1, s1, 11, 2500, 10000); 
            lista_apuestas.add(a1);
            Apuesta a2 = new Apuesta(u1, s2, 3, 1500, 0);
            lista_apuestas.add(a2);
            Apuesta a3 = new Apuesta(u1, s3, 5, 5000, 0);
            lista_apuestas.add(a3);
            
            Apuesta a4 = new Apuesta(u2, s1, 2, 2000, 0);
            lista_apuestas.add(a4);
            Apuesta a5 = new Apuesta(u2, s2, 4, 4000, 0);
            lista_apuestas.add(a5);
            Apuesta a6 = new Apuesta(u2, s3, 7, 7000, 35000);
            lista_apuestas.add(a6);
            
            Apuesta a7 = new Apuesta(u3, s2, 6, 3000, 0);
            lista_apuestas.add(a7);
            Apuesta a8 = new Apuesta(u3, s2, 8, 3000, 6000);
            lista_apuestas.add(a8);
            Apuesta a9 = new Apuesta(u3, s3, 10, 5000, 0);
            lista_apuestas.add(a9);
            
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
            if(sorteo.getFecha().compareTo(date) <= 0) {
                terminados.add(sorteo);
            }
        }
        return terminados;
    }
    
    public List<Sorteo> getListaSorteosFuturos() {
        Date date = new Date();
        List<Sorteo> futuros = new ArrayList<>();
        for(Sorteo sorteo : this.lista_sorteos) {
            if(sorteo.getFecha().compareTo(date) > 0) {
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
    
    public List<Apuesta> findApuestasByUsuario(String cedula) {
        List<Apuesta> apuestas = new ArrayList<>();
        for(Apuesta apuesta : this.lista_apuestas) {
            if(apuesta.getUsuario().getCedula().equals(cedula)) {
                apuestas.add(apuesta);
            }
        }
        return apuestas;
    }
    
    public Sorteo findSorteo(int numero_sorteo) {
        for(Sorteo sorteo : this.lista_sorteos) {
            if(sorteo.getNumero_sorteo() == numero_sorteo) {
                return sorteo;
            }
        }
        return null;
    }
    
    public void addBet(Apuesta apuesta) {
        lista_apuestas.add(apuesta);
    }
    
    public void updateSort(int numero_sorteo, int numero_ganador) {
        for(Sorteo sorteo : this.lista_sorteos) {
            if(sorteo.getNumero_sorteo() == numero_sorteo) {
                sorteo.setNumero_ganador(numero_ganador);
                updatePrize(sorteo);
                break;
            }
        }
    }
    
    public void updatePrize(Sorteo sorteo) {
        for(Apuesta apuesta : this.lista_apuestas) {
            if(apuesta.getSorteo().getNumero_sorteo() == sorteo.getNumero_sorteo()) {
                if(apuesta.getNumero_juego() == sorteo.getNumero_ganador()) {
                    int prize = apuesta.getMonto_apuesta() * sorteo.getRetorno();
                    apuesta.setMonto_premio(prize);
                } else {
                    apuesta.setMonto_premio(0);
                }
            }
        }
    }
    
}

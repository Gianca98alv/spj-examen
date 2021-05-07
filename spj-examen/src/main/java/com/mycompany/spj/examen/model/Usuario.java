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
public class Usuario {
    
    private Boolean administrador;
    private String cedula;
    private String clave;
    private String apellidos;
    private String nombre;
    
    public Usuario() {
    }
    
    public Usuario(Boolean administrador, String cedula, String clave, String apellidos, String nombre){
        this.administrador = administrador;
        this.cedula = cedula;
        this.clave = clave;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }
    
    public Boolean getAdministrador() {
        return administrador;
    }
    
    public void setAdministrador(Boolean adfministrador) {
        this.administrador = administrador;
    }
    
    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }    
    
    public String apellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "administrador=" + administrador + ", cedula=" + cedula + ", clave=" + clave + ", apellidos=" + apellidos + ", nombre=" + nombre + '}';
    }
    
    
    
}

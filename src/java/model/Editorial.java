/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
/**
 *
 * @author HP
 */
public class Editorial implements Serializable{
    private String rfc;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String sitioweb;
    
    //constructor inicial
    public Editorial() { 
        this.rfc = "";
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.email = "";
        this.sitioweb = "";
    }
    //constructor sobrecargado

    public Editorial(String rfc, String nombre, String telefono, String direccion, String email, String sitioweb) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.sitioweb = sitioweb;
    }
    //método get para recibir
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    //método get para recibir
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //método get para recibir
    public String getTelefono() {
        return telefono;
    }
    //método set para establecer
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //método get para recibir
    public String getDireccion() {
        return direccion;
    }
    //método set para establecer
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //método get para recibir
    public String getEmail() {
        return email;
    }
    //método set para establecer
    public void setEmail(String email) {
        this.email = email;
    }
    //método get para recibir
    public String getSitioweb() {
        return sitioweb;
    }
    //método set para establecer
    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    } 
}



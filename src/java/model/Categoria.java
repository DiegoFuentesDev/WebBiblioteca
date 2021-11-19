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
public class Categoria implements Serializable{
    //declaracion de las variables respecto a las usadas en sql
    private int codigo;
    private String nombre;
    //constructor 1 para inicializarlas
    public Categoria() {
        this.codigo = 0;
        this.nombre = "";
    }
    //constructor 2 para identarlas
    public Categoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    //método get para recibir
    public int getCodigo() {
        return codigo;
    }
    //método set para establecer
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //método get para recibir
    public String getNombre() {
        return nombre;
    }
    //método set para establecer
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }         
    
}

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
public class Libro implements Serializable{
    private String isbn;
    private String titulo;
    private String descripcion;
    private String autor;
    private String anio_publica;
    private String fecha_registro;
    private int codigo_categoria;
    private String rfc_editorial;

    public Libro() {
        this.isbn = "";
        this.titulo = "";
        this.descripcion = "";
        this.autor = "";
        this.anio_publica = "";
        this.fecha_registro = "";
        this.codigo_categoria = 0;
        this.rfc_editorial = "";
    }

    public Libro(String isbn, String titulo, String descripcion, String autor, String anio_publica, String fecha_registro, int codigo_categoria, String rfc_editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.anio_publica = anio_publica;
        this.fecha_registro = fecha_registro;
        this.codigo_categoria = codigo_categoria;
        this.rfc_editorial = rfc_editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio_publica() {
        return anio_publica;
    }

    public void setAnio_publica(String anio_publica) {
        this.anio_publica = anio_publica;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public String getRfc_editorial() {
        return rfc_editorial;
    }

    public void setRfc_editorial(String rfc_editorial) {
        this.rfc_editorial = rfc_editorial;
    }
    
    
}

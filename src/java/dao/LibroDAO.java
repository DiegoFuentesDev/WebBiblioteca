/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editorial;
import model.Libro;

/**
 *
 * @author HP
 */
public class LibroDAO {
        public static boolean registrar(Libro l){
        try {
            String SQL = "INSERT INTO libros values (?,?,?,?,?, (select now()),?,?);";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, l.getIsbn());
            st.setString(2, l.getTitulo());
            st.setString(3, l.getDescripcion());
            st.setString(4, l.getAutor());
            st.setString(5, l.getAnio_publica());
            st.setInt(6, l.getCodigo_categoria());
            st.setString(7, l.getRfc_editorial());
            /*si retorna un numero positivo vamos bien*/
            if(st.executeUpdate() > 0){
                return true;
            } else {
                /*sino quiere decir que no pudo hacer la inserción*/
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    ////////////////////////////////////////////////
        public static ArrayList<Libro> listar(){
        try {
            String SQL = "select * from libros;";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            /*st.setString(1, cat.getNombre());
              esto de arriba se comenta porque no enviamos ningún parámetro*/
            /*--- guarda resultado de la consulta en la variable "resultado" ---*/
            ResultSet resultado = st.executeQuery();
            ArrayList<Libro> lista = new ArrayList<>();
            Libro l;
            while(resultado.next()){
                l = new Libro();
                l.setIsbn(resultado.getString("isbn"));
                l.setTitulo(resultado.getString("titulo"));
                l.setDescripcion(resultado.getString("descripcion"));
                l.setAutor(resultado.getString("autor"));
                l.setFecha_registro(resultado.getString("fecha_registro"));
                l.setRfc_editorial(resultado.getString("rfc_editorial"));
                l.setCodigo_categoria(resultado.getInt("codigo_categoria"));
                lista.add(l);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
        }
        
    /////////////////////////////////////////////////////
        public static boolean actualizar(Libro l){
        try {
            String SQL = "update libros set titulo=?, descripcion=?, autor=?, anio_publica=?, codigo_categoria=?, rfc_editorial=? where isbn=?";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(7, l.getIsbn());
            st.setString(1, l.getTitulo());
            st.setString(2, l.getDescripcion());
            st.setString(3, l.getAutor());
            st.setString(4, l.getAnio_publica());
            st.setInt(5, l.getCodigo_categoria());
            st.setString(6, l.getRfc_editorial());
            /*si retorna un numero positivo vamos bien*/
            if(st.executeUpdate() > 0){
                return true;
            } else {
                /*sino quiere decir que no pudo hacer la inserción*/
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    /////////////////////////////////////////////////////
        public static boolean eliminar(Libro l){
        try {
            String SQL = "delete from libros where isbn=?";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, l.getIsbn());
            /*si retorna un numero positivo vamos bien*/
            if(st.executeUpdate() > 0){
                return true;
            } else {
                /*sino quiere decir que no pudo hacer la inserción*/
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
}

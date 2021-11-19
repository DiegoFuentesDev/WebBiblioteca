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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Editorial;

/**
 *
 * @author HP
 */
public class CategoriaDAO {
    /*cada que enviemos una categoria vamos a necesitar 
    EL ESTADO DE ESA CATEGORIA*/
    public static boolean registrar(Categoria cat){
        try {
            String SQL = "INSERT INTO categorias(nombre) values (?);";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
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
        public static ArrayList<Categoria> listar(){
        try {
            String SQL = "select * from categorias;";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            /*st.setString(1, cat.getNombre());
              esto de arriba se comenta porque no enviamos ningún parámetro*/
            /*--- guarda resultado de la consulta en la variable "resultado" ---*/
            ResultSet resultado = st.executeQuery();
            ArrayList<Categoria> lista = new ArrayList<>();
            Categoria cat;
            while(resultado.next()){
                cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
        
    /////////////////////////////////////////////////////
        public static String getCategoria(int cod){
        try {
            String SQL = "select nombre from categorias where codigo=?;";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, cod);
              /*esto de arriba se comenta porque no enviamos ningún parámetro*/
            /*--- guarda resultado de la consulta en la variable "resultado" ---*/
            ResultSet resultado = st.executeQuery();
            if(resultado.next()){
                return resultado.getString("nombre");
            }
            return "--";
        } catch (SQLException ex) {
            return "--";
        }
    }
}

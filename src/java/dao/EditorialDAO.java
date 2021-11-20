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
//import model.Categoria;

/**
 *
 * @author HP
 */
public class EditorialDAO {
        public static boolean registrar(Editorial e){
        try {
            String SQL = "INSERT INTO editoriales(rfc,nombre,telefono,direccion,email,sitioweb) values (?,?,?,?,?,?);";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, e.getRfc());
            st.setString(2, e.getNombre());
            st.setString(3, e.getTelefono());
            st.setString(4, e.getDireccion());
            st.setString(5, e.getEmail());
            st.setString(6, e.getSitioweb());
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
        public static ArrayList<Editorial> listar(){
        try {
            String SQL = "select * from editoriales;";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            /*st.setString(1, cat.getNombre());
              esto de arriba se comenta porque no enviamos ningún parámetro*/
            /*--- guarda resultado de la consulta en la variable "resultado" ---*/
            ResultSet resultado = st.executeQuery();
            ArrayList<Editorial> lista = new ArrayList<>();
            Editorial edi;
            while(resultado.next()){
                edi = new Editorial();
                edi.setRfc(resultado.getString("rfc"));
                edi.setNombre(resultado.getString("nombre"));
                edi.setTelefono(resultado.getString("telefono"));
                edi.setDireccion(resultado.getString("direccion"));
                edi.setEmail(resultado.getString("email"));
                edi.setSitioweb(resultado.getString("sitioweb"));
                lista.add(edi);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
        
    /////////////////////////////////////////////////////
        public static String getEditorial(String rfc){
        try {
            String SQL = "select nombre from editoriales where rfc =?;";
            /*cuando se conecte, guarda esa conexion en la variable "c"*/
            Connection con = Conexion.conectar();
            /*consulta preparada*/
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, rfc);
              /*esto de arriba se comenta porque no enviamos ningún parámetro*/
            /*--- guarda resultado de la consulta en la variable "resultado" ---*/
            ResultSet resultado = st.executeQuery();
            Editorial edi;
            if(resultado.next()){
                return resultado.getString("nombre");
            }
            return "--";
        } catch (SQLException ex) {
            return "--";
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.LibroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Libro;

/**
 *
 * @author HP
 */
public class LibroControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LibroControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LibroControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String publicacion = request.getParameter("publicacion");
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        String editorial = request.getParameter("editorial");
        String descripcion = request.getParameter("descripcion");
        String accion = request.getParameter("accion").toLowerCase();
        
        Libro l = new Libro();
        l.setIsbn(isbn);
        l.setTitulo(titulo);
        l.setAutor(autor);
        l.setAnio_publica(publicacion);
        l.setCodigo_categoria(categoria);
        l.setRfc_editorial(editorial);
        l.setDescripcion(descripcion);
        
        if(accion.equals("registrar")){
            if(LibroDAO.registrar(l)){
                request.setAttribute("mensaje", "Libro Registrado =3");
            } else {
                request.setAttribute("mensaje", "Libro NO Registrado :c");
            }
        } else if(accion.equals("actualizar")){
            if(LibroDAO.actualizar(l)){
                request.setAttribute("mensaje", "Libro Actualizado =3");
            } else {
                request.setAttribute("mensaje", "Libro NO Actualizado :c");
            }
        } else if(accion.equals("eliminar")){
            if(LibroDAO.eliminar(l)){
                request.setAttribute("mensaje", "Libro Eliminado =3");
            } else {
                request.setAttribute("mensaje", "Libro NO Eliminado :c");
            }
        } else {
            request.setAttribute("mensaje", "404 Accion Desconocida");            
        //aqui acaba el anidado
        }
        request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

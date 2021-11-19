<%-- 
    Document   : index
    Created on : 18 nov. 2021, 21:21:13
    Author     : HP
--%>
<%@page import = "dao.LibroDAO"%>
<%@page import = "model.Libro"%>
<%@page import = "controller.LibroControl"%>
<%@page import = "dao.EditorialDAO"%>
<%@page import = "model.Editorial"%>
<%@page import = "dao.CategoriaDAO"%>
<%@page import = "model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:forward page="listarLibros.jsp"></jsp:forward>
        <!--<button><a href="listarLibros.jsp">Ir ahi</a></button> -->
    </body>
</html>

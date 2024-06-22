<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import = "java.util.List" %>
<%@page import = "mrysi.beans.Entidad" %>
<%@page import = "mrysi.beans.Localidad" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.getRequestDispatcher("/Localidad").include(request, response);
    if(request.getAttribute("ListaEntidades")==null){
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AgregarLocalidad</title>
    </head>
    <body>
        <h2>Agregar Localidad</h2>
        <form action="../LocalidadLoad" method="POST">
            Nombre: <input type="text" name="nombreLocalidad" value=""/><br>
            Entidad:
            <select name = "idEntidad">
                <c:forEach var="entidad" items="${requestScope.ListaEntidades}">
                    <option value = "${entidad.idEntidad}">
                        ${entidad.nombreEntidad}
                    </option>
                </c:forEach>
            </select>
            
            <p>
                <input type="submit" value="Guardar"/>
                <input type="button" value="Cancelar" onclick="windows.history.back();"/>
            </p>
        </form>
    </body>
</html>

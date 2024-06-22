<%-- 
    Document   : edit
    Created on : 21 jun. 2024, 13:11:22
    Author     : crist
--%>

<%@page import="java.util.List" %>
<%@page import="mrysi.beans.Entidad" %>
<%@page import="mrysi.beans.Localidad" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
    if(request.getAttribute("ListaEntidades")==null||
       request.getAttribute("Localidad")==null){
        response.sendRedirect("index.jsp");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditarLocalidad</title>
    </head>
    <body>
        <h2>EditarLocalidad</h2>
        <form action="../LocalidadEdits" method="POST">
            <input type="hidden" name="_METHOD" value="PUT"/>
            <input type="hidden" name="idLocalidad"
                   value="${requestScope.Localidad.idLocalidad}"/>
            Nombre: <input type="text" name="nombreLocalidad"
                           value="${requestScope.Localidad.nombreLocalidad}"/></br>
            Entidad:
            <select name="idEntidad">
                <c:forEach var="entidad" items="${requestScope.ListaEntidades}">
                    <c:choose>
                        <c:when test="${entidad.idEntidad == requestScope.Localidad.idEntidad}">
                            <option value="${entidad.idEntidad}" selected>
                                ${entidad.nombreEntidad}
                            </option>
                        </c:when>
                        <c:otherwise>
                            <option value="${entidad.idEntidad}">
                                ${entidad.nombreEntidad}
                            </option>
                        </c:otherwise>    
                    </c:choose>
                </c:forEach>
            </select>
            
            <p>
                <input type="submit" value="Guardar"/>
                <input type="button" value="Cancelar" onclick="window.history.back"/>
            </p>
        </form>
    </body>
</html>

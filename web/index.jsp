<%@page import = "java.util.List" %>
<%@page import = "mrysi.beans.Localidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Localidades</title>
    </head>
    <body>
        <%request.getRequestDispatcher("/Localidad").include(request, response); %>
        <h2>Entidades Federativas</h2>
        <a href = "new.jsp">Agregar</a>
        <table>
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>ENTIDAD</th>
                <th>    </th>
            </tr>
            <c:forEach var = "loc" items = "${requestScope.ListaLocalidades}">
                <tr>
                    <td>${loc.idLocalidad}</td>
                    <td>${loc.nombreLocalidad}<td>
                    <td>${loc.entidad.nombreEntidad}</td>
                    <td>
                        <a href = "../LocalidadEdits?id=${loc.idLocalidad}">Editar</a>|
                        <a href = "../LocalidadDeletes?id=${loc.idLocalidad}"
                           onclick="return confirm('¿Estas seguro de Elimnar el registro?')">
                            Borrar</a>
                    </td>
                </tr>
            <c:forEach>
        </table>
    </body>
</html>


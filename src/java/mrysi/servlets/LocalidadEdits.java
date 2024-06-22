/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mrysi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mrysi.beans.EntidadDAOImp;
import mrysi.beans.Localidad;
import mrysi.beans.LocalidadDAOImp;


@WebServlet(name = "LocalidadEdit", urlPatterns = {"/LocalidadEdit"})
public class LocalidadEdits extends HttpServlet {

    private LocalidadDAOImp ldi;
    private EntidadDAOImp edi;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LocalidadEdit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LocalidadEdit at " + request.getContextPath() + "</h1>");
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
        try{
            if(request.getParameter("id")!=null){
                int id= Integer.parseInt(request.getParameter("id"));
                request.setAttribute("Localidad", ldi.read(id));
                request.setAttribute("ListaEntidades", edi.readAll());
                request.getRequestDispatcher("/Localidad/edit.jsp")
                        .forward(request, response);
            }
        }catch (SQLException ex){
            getServletContext().setAttribute("Err", ex);
            response.sendRedirect("Err.jsp");
        }
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
        if(esValido(request)){
            int id = Integer.parseInt(request.getParameter("idLocalidad"));
            String name = request.getParameter(request.getParameter("idEntidad"));
            try{
                ldi.update(new Localidad(id, name, idEntidad));
                response.sendRedirect("Localidades/index.jsp");
            }catch(SQLException ex){
                getServletContext().setAttribute("Err", ex);
                response.sendRedirect("Err.jsp");
            }
        } else{
            getServletContext().setAttribute("msj", "No se pudo guardar registro, "
                + "debido a que"
                + "uno de los campos no es valido.");
            response.sendRedirect("Localidades/edit.jsp");
        }
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

    private boolean esValido(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

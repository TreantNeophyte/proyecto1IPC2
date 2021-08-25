/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import procesos.consultas;

/**
 *
 * @author alpha
 */
public class Agregar extends HttpServlet {

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
        String boton = request.getParameter("boton");
        consultas a1 = new consultas();
        if (boton.equalsIgnoreCase("Eliminar")) {
            String nombre = request.getParameter("Npieza");
            if (nombre!=null) {
                a1.AgregarPieza(nombre);
                response.sendRedirect("Area1/CrearPiezas.jsp");
            }
        }else if (boton.equalsIgnoreCase("Agregar")) {
            String precio = request.getParameter("precio");
            String tipo = request.getParameter("tipo");
            int cantidad=Integer.parseInt(request.getParameter("cantidad"));
            if (precio!=null) {
                try{
                    float prec= Float.parseFloat(precio);
                    a1.AgregarInventarioPieza(tipo, prec, cantidad);
                    response.sendRedirect("Area1/CrearPiezas.jsp");
                }catch(Exception e){
                }
            }
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
        processRequest(request, response);
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

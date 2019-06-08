/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.PersonaDTO;
import ejb.PersonaEjb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Utilitario;

/**
 *
 * @author juanpablo
 */
public class Persona extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        PersonaEjb ejb = new PersonaEjb();
        PersonaDTO persona = null;
        try {
            if (request.getMethod().equalsIgnoreCase("GET")) {
                String menu = request.getParameter("menu");
                if (menu == null) {
                    String personas = ejb.traerPersonas();
                    request.getSession().setAttribute("personas", personas);
                    request.getRequestDispatcher("jsp/persona.jsp").forward(request, response);
                } else {
                    if (!menu.equalsIgnoreCase("crear")) {
                        String rut = request.getParameter("rut");
                        persona = ejb.traePersonaRut(rut);
                    }
                    request.getSession().setAttribute("persona", persona);
                    request.getRequestDispatcher("jsp/menuPersona.jsp").forward(request, response);
                }
            } else {
                String accion = Utilitario.noNull(request.getParameter("accion")).trim();
                String rut = Utilitario.noNull(request.getParameter("rut")).trim();
                String rutDv = Utilitario.noNull(request.getParameter("rutDv")).trim();
                String nombres = Utilitario.noNull(request.getParameter("nombres")).trim();
                String apellidos = Utilitario.noNull(request.getParameter("apellidos")).trim();
                String correo = Utilitario.noNull(request.getParameter("correo")).trim();
                String fechaNacimiento = Utilitario.noNull(request.getParameter("fechaNacimiento")).trim();
                String direccion = Utilitario.noNull(request.getParameter("direccion")).trim();
                String respuesta = "";

                if (accion.equals("validar")) {
                    respuesta = ejb.validarPersona(rut, rutDv, nombres, apellidos, correo, fechaNacimiento, direccion);
                } else {
                    if (accion.equalsIgnoreCase("grabar")) {
                        //int anionum = Integer.parseInt(anio); nombre debe ser solo letras 
                        persona = new PersonaDTO(rut, rutDv, nombres, apellidos, correo, fechaNacimiento, direccion);

                        respuesta = ejb.grabarPersona(persona);
                    } else if (accion.equalsIgnoreCase("eliminar")) {
                        respuesta = ejb.eliminarPersona(rut);
                    } else {
                        throw new Exception("Error opcion Invalida");
                    }
                }
                out.print(respuesta);
            }
        } catch (Exception e) {
            String mensaje = e.getMessage();
            request.getSession().setAttribute("error", mensaje);
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
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

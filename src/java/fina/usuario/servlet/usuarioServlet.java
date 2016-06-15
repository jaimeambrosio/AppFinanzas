/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.usuario.servlet;

import fina.entity.Mensaje;
import fina.usuario.dao.UsuarioDao;
import fina.usuario.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Jaime Ambrosio
 */
@WebServlet(name = "usuarioServlet", urlPatterns = {"/usuarioServlet"})
public class usuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion").trim();
        switch (accion) {
            case "LOGIN": {
                validarUsuario(request, response);
                break;
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

    private void validarUsuario(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION, "");
        String usuario = request.getParameter("txtUsuario").trim();
        String pass = request.getParameter("txtContrasenia").trim();
        boolean recordar = request.getParameter("txtRecordarP") == null;
        boolean hayacceso = false;
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usu = usuarioDao.validarIngreso(usuario, pass);
            if (usu != null) {
                request.getSession().setAttribute("usuarioLogeado", usu);
                mensaje.setHayMensaje(false);
                hayacceso = true;
                //response.sendRedirect("paginas/inicio.jsp");
            } else {
                mensaje.setHayMensaje(true);
                mensaje.setTipo(Mensaje.INFORMACION);
                mensaje.setMensaje("Usuario o contrseña no reconocidos.");
            }

        } catch (Exception e) {
            mensaje.setHayMensaje(true);
            mensaje.setTipo(Mensaje.ERROR);
            mensaje.setMensaje("Error al procesar la solicitud en el servidor.");
            mensaje.setDetalle(e.toString());
        }

        JSONObject jsonMensaje = new JSONObject(mensaje);
        try {
            jsonResult.put("msj", jsonMensaje);
            jsonResult.put("url", "paginas/inicio.jsp");
            enviarDatos(response, jsonResult.toString());

        } catch (Exception e) {
        }

    }

    private void enviarDatos(HttpServletResponse response, String datos) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        out.print(datos);
        out.close();
    }

}

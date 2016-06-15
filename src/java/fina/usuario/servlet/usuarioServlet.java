/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.usuario.servlet;

import fina.entity.Mensaje;
import fina.usuario.dao.UsuarioDao;
import fina.usuario.entity.Tipousuario;
import fina.usuario.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
            case "VALIDAPASS": {
                validarPass(request, response);
                break;
            }
            case "MODIFICAR": {
                modificarUsu(request, response);
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
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        String usuario = request.getParameter("txtUsuario").trim();
        String pass = request.getParameter("txtContrasenia").trim();
        boolean recordar = request.getParameter("txtRecordarP") == null;
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usu = usuarioDao.validarIngreso(usuario, pass);
            if (usu != null) {
                request.getSession().setAttribute("usuarioLogeado", usu);
                mensaje.setHayMensaje(false);
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

    private void validarPass(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(true, Mensaje.INFORMACION);
        String usuario = request.getParameter("txtUsuario").trim();
        String pass = request.getParameter("txtContrasenia").trim();
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usu = usuarioDao.validarIngreso(usuario, pass);
            if (usu != null) {
                mensaje.setHayMensaje(false);
                //response.sendRedirect("paginas/inicio.jsp");
            } else {
                mensaje.setHayMensaje(true);
                mensaje.setTipo(Mensaje.ADVERTENCIA);
                mensaje.setMensaje("Contrseña no reconocida.");
            }

        } catch (Exception e) {
            mensaje.setHayMensaje(true);
            mensaje.setTipo(Mensaje.ERROR);
            mensaje.setDetalle(e.toString());
        }

        try {
            JSONObject jsonMensaje = new JSONObject(mensaje);
            jsonResult.put("msj", jsonMensaje);
            enviarDatos(response, jsonResult.toString());

        } catch (Exception e) {
        }
    }

    private void modificarUsu(HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(true, Mensaje.INFORMACION);
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> listField = upload.parseRequest(request);
            Usuario usuario = new Usuario();
            UsuarioDao usuarioDao = new UsuarioDao();
            for (FileItem file : listField) {
                if (file.getFieldName().equals("txtNombres")) {
                    usuario.setNombres(file.getString().trim());
                } else if (file.getFieldName().equals("txtApellidos")) {
                    usuario.setApellidos(file.getString().trim());
                } else if (file.getFieldName().equals("txtFechaNacimiento")) {
                    usuario.setFechaNacimiento(format.parse(file.getString().trim()));
                } else if (file.getFieldName().equals("txtUsuario")) {
                    usuario.setUsername(file.getString().trim());
                } else if (file.getFieldName().equals("txtContrasenia")) {
                    usuario.setContrasenia(file.getString());
                } else if (file.getFieldName().equals("rbSexo")) {
                    usuario.setSexo("M".equals(file.getString()));
                } else if (file.getFieldName().equals("txtFoto")) {
                    byte[] imagen = file.get();
                    if (imagen != null && imagen.length > 0) {
                        usuario.setFoto(imagen);
                        usuario.setNombreFoto(file.getName());
                    } else {
                        Usuario actual = usuarioDao.Obtener(usuario.getIdUSUARIO());
                        usuario.setFoto(actual.getFoto());
                        usuario.setNombreFoto(actual.getNombreFoto());
                    }
                } else if (file.getFieldName().equals("txtDNI")) {
                    usuario.setDni(file.getString().trim());
                } else if (file.getFieldName().equals("tipoUsuario")) {
                    Tipousuario tipou = usuarioDao.getTipousuarioById(file.getString().trim());
                    usuario.setIdTipoUsuario(tipou);
                } else if (file.getFieldName().equals("txtIdUsuario")) {
                    usuario.setIdUSUARIO(Integer.valueOf(file.getString()));
                }
            }
            usuarioDao.Actualizar(usuario);
             request.getSession().setAttribute("usuarioLogeado", usuario);
            mensaje.setMensaje("Se actualizo correctamente.");

        } catch (Exception ex) {
            ex.printStackTrace();
            mensaje.setTipo(Mensaje.ERROR);
            mensaje.setDetalle(ex.toString());
        }
        try {
            JSONObject jsonMensaje = new JSONObject(mensaje);
            jsonResult.put("msj", jsonMensaje);
            enviarDatos(response, jsonResult.toString());
        } catch (Exception ex) {
        }
    }

}

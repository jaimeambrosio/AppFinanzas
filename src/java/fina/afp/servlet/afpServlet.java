/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.afp.servlet;

import fina.afp.dao.AfpDao;
import fina.afp.entity.Afp;
import fina.afp.entity.Tipocomision;
import fina.afp.entity.Tipocomisionxafp;
import fina.afp.entity.Tipofondo;
import fina.afp.entity.Tipofondoxafp;
import fina.afp.entity.TipofondoxafpPK;
import fina.entity.Mensaje;
import fina.util.Formato;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jaime Ambrosio
 */
@WebServlet(name = "afpServlet", urlPatterns = {"/afpServlet"})
public class afpServlet extends HttpServlet {

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
        String accion = request.getParameter("accion").trim();
        switch (accion) {
            case "TBRENTABILIDAD": {
                mostrarRentabilidadesPorAfp(request, response);
                break;
            }
            case "ACTRENTSUG": {
                actualizarRentSug(request, response);
                break;
            }
            case "aaa": {
                actualizarComisiones(request, response);
                break;
            }
            case "TBCOMISIONES": {
                mostrarComisionesXAfp(request, response);
                break;
            }
        }
    }

    private void enviarDatos(HttpServletResponse response, String datos) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        out.print(datos);
        out.close();
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

    private void mostrarRentabilidadesPorAfp(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        StringBuilder sb = new StringBuilder();
        try {

            sb.append("<thead>");
            sb.append("<tr><th>AFP \\ Tipo fondo</th>");

            List<Tipofondo> listTipofondo = afpDao.listarTipofondo();
            List<Afp> listAfp = afpDao.listar();
            List<Tipofondoxafp> listTipofondoxafp = afpDao.listarTipoFondoXAfp();
            for (Tipofondo tipofondo : listTipofondo) {
                sb.append("<th>")
                        .append("Fondo ")
                        .append(tipofondo.getIdTIPOFONDO() - 1)
                        .append("</th>");
            }
            sb.append("</tr></thead><tbody>");
            for (Afp afp : listAfp) {
                sb.append("<tr><td>").append(afp.getTitulo()).append("</td>");
                for (Tipofondo tipofondo : listTipofondo) {
                    sb.append("<td><div class=\"input-group\">");
                    if (listTipofondoxafp.isEmpty()) {
                        sb.append("<input afp='").append(afp.getIdAFP()).append("' fondo='").append(tipofondo.getIdTIPOFONDO()).append("' class=\"form-control\" value='")
                                .append(Formato.formatoDecimal(0.0)).append("' >");
                    } else {
                        for (Tipofondoxafp tipofondoxafp : listTipofondoxafp) {
                            if (tipofondo.getIdTIPOFONDO() == tipofondoxafp.getTipofondoxafpPK().getIdTIPOFONDO()
                                    && afp.getIdAFP() == tipofondoxafp.getTipofondoxafpPK().getIdAFP()) {
                                String valor = Formato.formatoDecimal(tipofondoxafp.getRentabilidadSugerida());
                                sb.append("<input afp='").append(afp.getIdAFP()).append("' fondo='").append(tipofondo.getIdTIPOFONDO()).append("' class=\"form-control\" value='").append(valor).append("' >");
                            } else {
                            }
                        }
                    }
                    sb.append("<div class=\"input-group-addon\">%</div></div></td>");
                }
                sb.append("</tr>");
            }
            sb.append("</tbody>");
        } catch (Exception e) {
            mensaje.establecerError(e);
        }
        try {
            JSONObject jsonMensaje = new JSONObject(mensaje);
            jsonResult.put("msj", jsonMensaje);
            jsonResult.put("tbl", sb.toString());
            enviarDatos(response, jsonResult.toString());
        } catch (Exception ex) {

        }
    }

    private void actualizarRentSug(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        try {
            String valores = request.getParameter("valores");
            JSONArray jsonArray = new JSONArray(valores);
            List<Tipofondoxafp> listTipoFondoXAfp = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String afp = jsonObject.getString("afp");
                String fondo = jsonObject.getString("fondo");
                String valor = jsonObject.getString("valor");
                Tipofondoxafp t = new Tipofondoxafp(Integer.valueOf(fondo), Integer.valueOf(afp));
                t.setRentabilidadSugerida(Double.valueOf(valor));
                listTipoFondoXAfp.add(t);
            }
            afpDao.Actualizar(listTipoFondoXAfp);

        } catch (Exception e) {
            mensaje.establecerError(e);
        }
        try {
            JSONObject jsonMensaje = new JSONObject(mensaje);
            jsonResult.put("msj", jsonMensaje);
            enviarDatos(response, jsonResult.toString());
        } catch (Exception ex) {

        }
    }

    private void actualizarComisiones(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarComisionesXAfp(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        StringBuilder sb = new StringBuilder();
        try {
            List<Tipocomision> listTipocomision = afpDao.listarTipocomision();
            List<Afp> listAfp = afpDao.listar();
            List<Tipocomisionxafp> listTipocomisionxafp = afpDao.listarTipocomisionxafp();
            sb.append(" <thead><tr>");
            sb.append("<th rowspan=\"2\">AFP \\ Tipo Comsion </th>");
            sb.append("<th rowspan=\"2\">").append("COMISION ").append(listTipocomision.get(0).getTitulo()).append("</th>");
            sb.append("<th colspan=\"2\">").append("COMISION ").append(listTipocomision.get(1).getTitulo()).append("</th></tr>");

            sb.append("<tr> <th>Sobre Flujo</th> <th>Sobre Saldo</th></tr>");
            sb.append("</thead>");
            sb.append(" <tbody>");
            for (Afp afp : listAfp) {
                sb.append("<tr><td>").append(afp.getTitulo()).append("</td>");
                boolean flag = false;
                for (Tipocomision tipocomision : listTipocomision) {

                    if (listTipocomisionxafp.isEmpty()) {
                        sb.append("<td>");
                        sb.append("<div class=\"input-group\">"+
                                "<input saldo='true' afp='").append(afp.getIdAFP()).append("' comision='").append(tipocomision.getIdTIPOCOMISION()).append("' class=\"form-control\" value='")
                                .append(Formato.formatoDecimal(0.0)).append("' ></div>");
                        sb.append("</td>");
                    } else {
                        for (Tipocomisionxafp tipocomisionxafp : listTipocomisionxafp) {

                        }
                    }
                }

            }
            sb.append("</tbody>");
        } catch (Exception e) {
            mensaje.establecerError(e);
        }

        try {
            JSONObject jsonMensaje = new JSONObject(mensaje);
            jsonResult.put("msj", jsonMensaje);
            jsonResult.put("tbl", sb.toString());
            enviarDatos(response, jsonResult.toString());
        } catch (Exception ex) {

        }
    }

}

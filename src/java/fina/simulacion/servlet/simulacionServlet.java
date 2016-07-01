/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.simulacion.servlet;

import fina.afp.dao.AfpDao;
import fina.entity.Mensaje;
import fina.simulacion.dao.SimulacionDao;
import fina.simulacion.entity.Simulacion;
import fina.simulacion.entity.Simulacionhito;
import fina.usuario.entity.Usuario;
import fina.util.Formato;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author Jaime Ambrosio
 */
@WebServlet(name = "simulacionServlet", urlPatterns = {"/simulacionServlet"})
public class simulacionServlet extends HttpServlet {

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
            case "GETRENT": {
                getRentabilidadSugerida(request, response);
                break;
            }
            case "NUEVASIM": {
                crearNuevaSimulacion(request, response);
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

    private void getRentabilidadSugerida(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        Double rentabilidad = -1.0;
        try {

            Integer idAfp = Integer.valueOf(request.getParameter("idAfp"));
            Integer idTipoFondo = Integer.valueOf(request.getParameter("idTipoFondo"));
            rentabilidad = afpDao.getRentabilidad(idAfp, idTipoFondo);

        } catch (Exception e) {
            mensaje.establecerError(e);
        }
        JSONObject jsonMensaje = new JSONObject(mensaje);
        try {
            jsonResult.put("msj", jsonMensaje);
            jsonResult.put("rentabilidad", Formato.formatoDecimal(rentabilidad));
            enviarDatos(response, jsonResult.toString());

        } catch (Exception ex) {
        }
    }

    private void enviarDatos(HttpServletResponse response, String datos) throws Exception {
        PrintWriter out = null;
        out = response.getWriter();
        out.print(datos);
        out.close();
    }

    private Integer getDias(Calendar calendar) {
        Integer imes = calendar.get(Calendar.MONTH);
        Integer[] diasDelMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dias = diasDelMes[imes];
        if (imes == 1) {
            int anio = calendar.get(Calendar.YEAR);
            if (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0)) {
                ++dias;
            }
        }
        return dias;
    }

    private void crearNuevaSimulacion(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        SimulacionDao simulacionDao = new SimulacionDao();
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogeado");
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
            String txtAlias = request.getParameter("txtAlias").trim();
            String cbxAfp = request.getParameter("cbxAfp").trim();
            String txtFechaDesde = request.getParameter("txtFechaDesde").trim();
            String rbTipoFondo = request.getParameter("rbTipoFondo").trim();
            String txtAportacionMensual = request.getParameter("txtAportacionMensual").trim();
            String txtRentabilidadProbable = request.getParameter("txtRentabilidadProbable").trim();
            String txtDescripcionHito = request.getParameter("txtDescripcionHito").trim();

            Calendar fecha = new GregorianCalendar();
            fecha.setTime(dateFormat.parse(txtFechaDesde));
            fecha.set(Calendar.DAY_OF_YEAR, getDias(fecha));

            Simulacion simulacion = new Simulacion();
            simulacion.setAlias(txtAlias);
            simulacion.setFechaCreacion(new Date());
            simulacion.setIdUSUARIO(usuario);
            simulacionDao.Insertar(simulacion);

            Simulacionhito hitoa = new Simulacionhito();
            hitoa.setDescripcion(txtDescripcionHito);
            hitoa.setFecha(fecha.getTime());
            hitoa.setIdAFP(afpDao.Obtener(Integer.valueOf(cbxAfp)));
            hitoa.setIdSIMULACION(simulacion);
            hitoa.setIdTIPOFONDO(afpDao.ObtenerTipoFondo(Integer.valueOf(rbTipoFondo)));
            hitoa.setRentabilidad(Double.valueOf(txtRentabilidadProbable));
            hitoa.setTasaAportacionMesual(Double.valueOf(txtAportacionMensual));
            hitoa.setSaldoFinal(0.0);

            Calendar fecha65 = new GregorianCalendar();
            fecha65.setTime(usuario.getFechaNacimiento());
            fecha65.add(Calendar.YEAR, 65);

            Simulacionhito hitob = new Simulacionhito();
            hitob.setFecha(fecha65.getTime());
            hitoa.setIdSIMULACION(simulacion);
            hitoa.setSaldoFinal(0.0);

            List<Simulacionhito> listSimulacionhito = new ArrayList<>();
            listSimulacionhito.add(hitoa);
            listSimulacionhito.add(hitob);
            simulacionDao.InsertarHitos(listSimulacionhito);
            

        } catch (Exception e) {
            mensaje.establecerError(e);
        }
        JSONObject jsonMensaje = new JSONObject(mensaje);
        try {
            jsonResult.put("msj", jsonMensaje);

            enviarDatos(response, jsonResult.toString());

        } catch (Exception ex) {
        }
    }
}

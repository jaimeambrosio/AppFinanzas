/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.simulacion.servlet;

import fina.afp.dao.AfpDao;
import fina.afp.entity.Tipocomisionxafp;
import fina.entity.Mensaje;
import fina.simulacion.dao.SimulacionDao;
import fina.simulacion.entity.HitoDatos;
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
import java.util.HashMap;
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
            case "NUEVOHITO": {
                crearNuevoHito(request, response);
                break;
            }

            case "ABRIRSIM": {
                abrirSimulacion(request, response);
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
            jsonResult.put("rentabilidad", Formato.formatoDecimal(rentabilidad * 100));
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

    private Integer getDias(int imes, Calendar calendar) {

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

    private Double aMensual(Double anual) {

        Double p = Math.pow(1 + anual, 30.0 / 360.0);

        return p - 1;
    }

    private void crearNuevaSimulacion(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        SimulacionDao simulacionDao = new SimulacionDao();
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogeado");
        String[] result = new String[2];
        Simulacion simulacion = new Simulacion();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
            String txtAlias = request.getParameter("txtAlias").trim();
            String cbxAfp = request.getParameter("cbxAfp").trim();
            String txtFechaDesde = request.getParameter("txtFechaDesde").trim();
            String rbTipoFondo = request.getParameter("rbTipoFondo").trim();
            String txtAportacionMensual = request.getParameter("txtAportacionMensual").trim();
            String txtRentabilidadProbable = request.getParameter("txtRentabilidadProbable").trim();
            String txtDescripcionHito = request.getParameter("txtDescripcionHito").trim();
            String txtSueldoInicial = request.getParameter("txtSueldoInicial").replaceAll(",", "");

            Calendar fecha = new GregorianCalendar();
            fecha.setTime(dateFormat.parse(txtFechaDesde));
            fecha.add(Calendar.DAY_OF_YEAR, getDias(fecha));

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
            hitoa.setRentabilidad(Double.valueOf(txtRentabilidadProbable) / 100);
            hitoa.setTasaAportacionMesual(Double.valueOf(txtAportacionMensual) / 100);
            //hitoa.setSaldoFinal(0.0);
            hitoa.setSueldo(Double.valueOf(txtSueldoInicial));

            Calendar fecha65 = new GregorianCalendar();
            fecha65.setTime(usuario.getFechaNacimiento());
            fecha65.add(Calendar.YEAR, 65);

            Simulacionhito hitob = new Simulacionhito();
            hitob.setFecha(fecha65.getTime());
            hitob.setIdSIMULACION(simulacion);
            // hitob.setSaldoFinal(0.0);

            List<Simulacionhito> listSimulacionhito = new ArrayList<>();
            listSimulacionhito.add(hitoa);
            listSimulacionhito.add(hitob);
            simulacionDao.InsertarHitos(listSimulacionhito);

            listSimulacionhito.clear();
            listSimulacionhito = simulacionDao.listarSimulacionhito(simulacion);
            List<HitoDatos> listHitoDatos = getlistHitoDatos(listSimulacionhito);
            result = fillHtmlFromHitosDatos(listHitoDatos);

        } catch (Exception e) {
            mensaje.establecerError(e);
        }
        JSONObject jsonMensaje = new JSONObject(mensaje);
        try {
            jsonResult.put("msj", jsonMensaje);
            jsonResult.put("header", result[0]);
            jsonResult.put("body", result[1]);
            jsonResult.put("alias", simulacion.getAlias());
            jsonResult.put("idSimulacion", simulacion.getIdSIMULACION());

            enviarDatos(response, jsonResult.toString());

        } catch (Exception ex) {
        }
    }

    private Double[] getTipocomisionxafp(List<Tipocomisionxafp> listTipocomisionxafp, Integer idAfp) {
        Double[] d = new Double[2];
        for (Tipocomisionxafp tipocomisionxafp : listTipocomisionxafp) {
            if (tipocomisionxafp.getTipocomisionxafpPK().getIdAFP() == idAfp) {
                if (tipocomisionxafp.getTipocomisionxafpPK().getIdTIPOCOMISION() == 1) {
                    d[0] = tipocomisionxafp.getComision();
                } else {
                    d[1] = tipocomisionxafp.getComision();
                }
            }
        }
        return d;
    }

    private List<HitoDatos> getlistHitoDatos(List<Simulacionhito> listSimulacionhito) {
        AfpDao afpDao = new AfpDao();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        SimpleDateFormat formatLarga = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatCorta = new SimpleDateFormat("MMM yyyy");
        String[] result = new String[2];
        HashMap<String, Simulacionhito> mapSimHit = new HashMap<>();
        listSimulacionhito.stream().forEach((sh) -> {
            mapSimHit.put(dateFormat.format(sh.getFecha()), sh);
        });

        Calendar ini = new GregorianCalendar();
        ini.setTime(listSimulacionhito.get(0).getFecha());

        Calendar fin = new GregorianCalendar();
        fin.setTime(listSimulacionhito.get(listSimulacionhito.size() - 1).getFecha());

        List<HitoDatos> listHitoDatos = new ArrayList<HitoDatos>();
        List<Tipocomisionxafp> listTipocomisionxafp = afpDao.listarTipocomisionxafp();

        Double saldoXFlujo = 0.0;
        Double saldoXSaldo = 0.0;
        Double coTotalFlu = 0.0;
        Double coTotalSal = 0.0;
        Double rentabilidad = 0.0;
        Double sueldo = 0.0;
        Double tasaAportacion = 0.0;

        Double comisionF = 0.0;
        Double comisionS = 0.0;
        int imes = ini.get(Calendar.MONTH);

        while (ini.getTimeInMillis() < fin.getTimeInMillis()) {
            Simulacionhito sh = mapSimHit.get(dateFormat.format(ini.getTime()));
            if (sh != null) {
                rentabilidad = aMensual(sh.getRentabilidad());
                sueldo = sh.getSueldo();
                tasaAportacion = sh.getTasaAportacionMesual();

                HitoDatos hd = new HitoDatos();
                hd.setSaldoPorFlujo(saldoXFlujo);
                hd.setSaldoPorSaldo(saldoXSaldo);
                hd.setFechaCorta(formatCorta.format(ini.getTime()));
                hd.setFechaLarga(formatLarga.format(ini.getTime()));
                hd.setComisionEntregadaF(coTotalFlu);
                hd.setComisionEntregadaS(coTotalSal);
                listHitoDatos.add(hd);

                Double[] comisiones = getTipocomisionxafp(listTipocomisionxafp, sh.getIdAFP().getIdAFP());
                comisionF = comisiones[0];
                comisionS = comisiones[1];
            }
            /*FLUJO*/
            coTotalFlu = coTotalFlu + comisionF * sueldo;
            saldoXFlujo = saldoXFlujo + (saldoXFlujo * rentabilidad) + (sueldo * tasaAportacion);

            /*SALDO*/
            Double comisionSm = aMensual(comisionS);
            coTotalSal = coTotalSal + comisionSm * saldoXSaldo;
            saldoXSaldo = saldoXSaldo + (saldoXSaldo * rentabilidad) + (sueldo * tasaAportacion) - saldoXSaldo * comisionSm;

            ++imes;
            if (imes >= 12) {
                imes = 0;
            }
            int dias = getDias(imes, ini);
            ini.add(Calendar.DAY_OF_MONTH, dias);
        }
        HitoDatos hd = new HitoDatos();
        hd.setSaldoPorFlujo(saldoXFlujo);
        hd.setSaldoPorSaldo(saldoXSaldo);
        hd.setFechaCorta(formatCorta.format(ini.getTime()));
        hd.setFechaLarga(formatLarga.format(ini.getTime()));
        hd.setComisionEntregadaF(coTotalFlu);
        hd.setComisionEntregadaS(coTotalSal);
        listHitoDatos.add(hd);

        return listHitoDatos;
    }

    private String[] fillHtmlFromHitosDatos(List<HitoDatos> listHitoDatos) {
        String[] result = new String[2];
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        String selected = "class='selected'";
        for (HitoDatos hitoDato : listHitoDatos) {
            sbA.append("<li>");
            sbA.append("<a href='#0' data-date='")
                    .append(hitoDato.getFechaLarga())
                    .append("' ")
                    .append(selected)
                    .append(" >")
                    .append(hitoDato.getFechaCorta()).append("</a>");
            sbA.append("</li>");

            sbB.append("<li ").append(selected).append(" data-date='").append(hitoDato.getFechaLarga()).append("'>");
            sbB.append("<h3>Resumen al ").append(hitoDato.getFechaLarga()).append("</h3><br><br>");
            sbB.append("<table class=\"display nowrap\" cellspacing=\"0\" width=\"100%\">");
            sbB.append("<thead> <tr><th > ... </th ><th >Fondo acumulado</th><th >Comision entregada</th> </tr></thead>");
            sbB.append("<tbody  >");
            sbB.append("<tr>");
            sbB.append("<td>Flujo</td>");
            sbB.append("<td>").append(Formato.formatoDecimal(hitoDato.getSaldoPorFlujo())).append("</td>");
            sbB.append("<td>").append(Formato.formatoDecimal(hitoDato.getComisionEntregadaF())).append("</td>");
            sbB.append("</tr>");
            sbB.append("<tr>");
            sbB.append("<td>Saldo</td>");
            sbB.append("<td>").append(Formato.formatoDecimal(hitoDato.getSaldoPorSaldo())).append("</td>");
            sbB.append("<td>").append(Formato.formatoDecimal(hitoDato.getComisionEntregadaS())).append("</td>");
            sbB.append("</tr>");
            sbB.append("</tbody  >");
            sbB.append("</table>");

            sbB.append("</li>");
            selected = "";
        }

        result[0] = sbA.toString();
        result[1] = sbB.toString();
        return result;
    }

    private void crearNuevoHito(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        SimulacionDao simulacionDao = new SimulacionDao();
        String[] result = new String[2];
        Simulacion simulacion = new Simulacion();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");

            String hddIdSimulacion = request.getParameter("hddIdSimulacion").trim();
            String cbxAfp = request.getParameter("cbxAfp").trim();
            String txtFechaDesde = request.getParameter("txtFechaDesde").trim();
            String rbTipoFondo = request.getParameter("rbTipoFondo").trim();
            String txtAportacionMensual = request.getParameter("txtAportacionMensual").trim();
            String txtRentabilidadProbable = request.getParameter("txtRentabilidadProbable").trim();
            String txtDescripcionHito = request.getParameter("txtDescripcionHito").trim();
            String txtSueldoInicial = request.getParameter("txtSueldoInicial").replaceAll(",", "");

            Calendar fecha = new GregorianCalendar();
            fecha.setTime(dateFormat.parse(txtFechaDesde));
            fecha.set(Calendar.DAY_OF_YEAR, getDias(fecha));

            simulacion = simulacionDao.Obtener(Integer.valueOf(hddIdSimulacion));

            Simulacionhito hitoa = new Simulacionhito();
            hitoa.setDescripcion(txtDescripcionHito);
            hitoa.setFecha(fecha.getTime());
            hitoa.setIdAFP(afpDao.Obtener(Integer.valueOf(cbxAfp)));
            hitoa.setIdSIMULACION(simulacion);
            hitoa.setIdTIPOFONDO(afpDao.ObtenerTipoFondo(Integer.valueOf(rbTipoFondo)));
            hitoa.setRentabilidad(Double.valueOf(txtRentabilidadProbable) / 100);
            hitoa.setTasaAportacionMesual(Double.valueOf(txtAportacionMensual) / 100);
            //hitoa.setSaldoFinal(0.0);
            hitoa.setSueldo(Double.valueOf(txtSueldoInicial));

            List<Simulacionhito> listSimulacionhito = new ArrayList<>();
            listSimulacionhito.add(hitoa);
            simulacionDao.InsertarHitos(listSimulacionhito);

            listSimulacionhito.clear();
            listSimulacionhito = simulacionDao.listarSimulacionhito(simulacion);
            List<HitoDatos> listHitoDatos = getlistHitoDatos(listSimulacionhito);
            result = fillHtmlFromHitosDatos(listHitoDatos);

        } catch (Exception e) {
            mensaje.establecerError(e);
        }
        JSONObject jsonMensaje = new JSONObject(mensaje);
        try {
            jsonResult.put("msj", jsonMensaje);
            jsonResult.put("header", result[0]);
            jsonResult.put("body", result[1]);
            jsonResult.put("alias", simulacion.getAlias());
            jsonResult.put("idSimulacion", simulacion.getIdSIMULACION());

            enviarDatos(response, jsonResult.toString());

        } catch (Exception ex) {
        }
    }

    private void abrirSimulacion(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonResult = new JSONObject();
        Mensaje mensaje = new Mensaje(false, Mensaje.INFORMACION);
        AfpDao afpDao = new AfpDao();
        SimulacionDao simulacionDao = new SimulacionDao();
        String[] result = new String[2];
        Simulacion simulacion = new Simulacion();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");

            String hddIdSimulacion = request.getParameter("idSimulacion").trim();

            simulacion = simulacionDao.Obtener(Integer.valueOf(hddIdSimulacion));

            List<Simulacionhito> listSimulacionhito = simulacionDao.listarSimulacionhito(simulacion);
            List<HitoDatos> listHitoDatos = getlistHitoDatos(listSimulacionhito);
            result = fillHtmlFromHitosDatos(listHitoDatos);

        } catch (Exception e) {
            mensaje.establecerError(e);
        }
        JSONObject jsonMensaje = new JSONObject(mensaje);
        try {
            jsonResult.put("msj", jsonMensaje);
            jsonResult.put("header", result[0]);
            jsonResult.put("body", result[1]);
            jsonResult.put("alias", simulacion.getAlias());
            jsonResult.put("idSimulacion", simulacion.getIdSIMULACION());

            enviarDatos(response, jsonResult.toString());

        } catch (Exception ex) {
        }

    }

}

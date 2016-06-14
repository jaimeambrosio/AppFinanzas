/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.entity;

/**
 *
 * @author Jaime Ambrosio
 */
public class Mensaje {

    public static final String ERROR = "ERROR";
    public static final String ADVERTENCIA = "ADVERTENCIA";
    public static final String INFORMACION = "INFORMACION";

    public Mensaje() {
    }

    public Mensaje(boolean hayMensaje, String tipo, String mensaje) {
        this.hayMensaje = hayMensaje;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    private boolean hayMensaje;
    private String tipo;
    private String mensaje;

    /**
     * @return the hayMensaje
     */
    public boolean isHayMensaje() {
        return hayMensaje;
    }

    /**
     * @param hayMensaje the hayMensaje to set
     */
    public void setHayMensaje(boolean hayMensaje) {
        this.hayMensaje = hayMensaje;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

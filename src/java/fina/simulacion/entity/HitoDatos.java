/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.simulacion.entity;

/**
 *
 * @author Jaime Ambrosio
 */
public class HitoDatos {
    private String fechaCorta;
    private String fechaLarga;
    private Double saldoPorFlujo;
    private Double saldoPorSaldo;
    private Double comisionEntregadaF;
    private Double comisionEntregadaS;

    /**
     * @return the fechaCorta
     */
    public String getFechaCorta() {
        return fechaCorta;
    }

    /**
     * @param fechaCorta the fechaCorta to set
     */
    public void setFechaCorta(String fechaCorta) {
        this.fechaCorta = fechaCorta;
    }

    /**
     * @return the fechaLarga
     */
    public String getFechaLarga() {
        return fechaLarga;
    }

    /**
     * @param fechaLarga the fechaLarga to set
     */
    public void setFechaLarga(String fechaLarga) {
        this.fechaLarga = fechaLarga;
    }

    /**
     * @return the saldoPorFlujo
     */
    public Double getSaldoPorFlujo() {
        return saldoPorFlujo;
    }

    /**
     * @param saldoPorFlujo the saldoPorFlujo to set
     */
    public void setSaldoPorFlujo(Double saldoPorFlujo) {
        this.saldoPorFlujo = saldoPorFlujo;
    }

    /**
     * @return the saldoPorSaldo
     */
    public Double getSaldoPorSaldo() {
        return saldoPorSaldo;
    }

    /**
     * @param saldoPorSaldo the saldoPorSaldo to set
     */
    public void setSaldoPorSaldo(Double saldoPorSaldo) {
        this.saldoPorSaldo = saldoPorSaldo;
    }

    /**
     * @return the comisionEntregadaF
     */
    public Double getComisionEntregadaF() {
        return comisionEntregadaF;
    }

    /**
     * @param comisionEntregadaF the comisionEntregadaF to set
     */
    public void setComisionEntregadaF(Double comisionEntregadaF) {
        this.comisionEntregadaF = comisionEntregadaF;
    }

    /**
     * @return the comisionEntregadaS
     */
    public Double getComisionEntregadaS() {
        return comisionEntregadaS;
    }

    /**
     * @param comisionEntregadaS the comisionEntregadaS to set
     */
    public void setComisionEntregadaS(Double comisionEntregadaS) {
        this.comisionEntregadaS = comisionEntregadaS;
    }

    
    
}

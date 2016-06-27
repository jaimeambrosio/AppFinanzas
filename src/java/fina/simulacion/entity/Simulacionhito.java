/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.simulacion.entity;

import fina.afp.entity.Afp;
import fina.afp.entity.Tipocomision;
import fina.afp.entity.Tipofondo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaime Ambrosio
 */
@Entity
@Table(name = "simulacionhito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Simulacionhito.findAll", query = "SELECT s FROM Simulacionhito s")})
public class Simulacionhito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tasaAportacionMesual")
    private Double tasaAportacionMesual;
    @Column(name = "saldoFinal")
    private Double saldoFinal;
    @Column(name = "rentabilidad")
    private Double rentabilidad;
    @Column(name = "densidad")
    private Double densidad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSimulacionHito")
    private Integer idSimulacionHito;
    @JoinColumn(name = "idAFP", referencedColumnName = "idAFP")
    @ManyToOne(optional = false)
    private Afp idAFP;
    @JoinColumn(name = "idTIPOCOMISION", referencedColumnName = "idTIPOCOMISION")
    @ManyToOne(optional = false)
    private Tipocomision idTIPOCOMISION;
    @JoinColumn(name = "idTIPOFONDO", referencedColumnName = "idTIPOFONDO")
    @ManyToOne(optional = false)
    private Tipofondo idTIPOFONDO;
    @JoinColumn(name = "idSIMULACION", referencedColumnName = "idSIMULACION")
    @ManyToOne(optional = false)
    private Simulacion idSIMULACION;

    public Simulacionhito() {
    }

    public Simulacionhito(Integer idSimulacionHito) {
        this.idSimulacionHito = idSimulacionHito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTasaAportacionMesual() {
        return tasaAportacionMesual;
    }

    public void setTasaAportacionMesual(Double tasaAportacionMesual) {
        this.tasaAportacionMesual = tasaAportacionMesual;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Double getRentabilidad() {
        return rentabilidad;
    }

    public void setRentabilidad(Double rentabilidad) {
        this.rentabilidad = rentabilidad;
    }

    public Double getDensidad() {
        return densidad;
    }

    public void setDensidad(Double densidad) {
        this.densidad = densidad;
    }

    public Integer getIdSimulacionHito() {
        return idSimulacionHito;
    }

    public void setIdSimulacionHito(Integer idSimulacionHito) {
        this.idSimulacionHito = idSimulacionHito;
    }

    public Afp getIdAFP() {
        return idAFP;
    }

    public void setIdAFP(Afp idAFP) {
        this.idAFP = idAFP;
    }

    public Tipocomision getIdTIPOCOMISION() {
        return idTIPOCOMISION;
    }

    public void setIdTIPOCOMISION(Tipocomision idTIPOCOMISION) {
        this.idTIPOCOMISION = idTIPOCOMISION;
    }

    public Tipofondo getIdTIPOFONDO() {
        return idTIPOFONDO;
    }

    public void setIdTIPOFONDO(Tipofondo idTIPOFONDO) {
        this.idTIPOFONDO = idTIPOFONDO;
    }

    public Simulacion getIdSIMULACION() {
        return idSIMULACION;
    }

    public void setIdSIMULACION(Simulacion idSIMULACION) {
        this.idSIMULACION = idSIMULACION;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSimulacionHito != null ? idSimulacionHito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Simulacionhito)) {
            return false;
        }
        Simulacionhito other = (Simulacionhito) object;
        if ((this.idSimulacionHito == null && other.idSimulacionHito != null) || (this.idSimulacionHito != null && !this.idSimulacionHito.equals(other.idSimulacionHito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.simulacion.entity.Simulacionhito[ idSimulacionHito=" + idSimulacionHito + " ]";
    }
    
}

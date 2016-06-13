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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    @Id
    @Basic(optional = false)
    @Column(name = "idSIMULACION")
    private Integer idSIMULACION;
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
    @JoinColumn(name = "idAFP", referencedColumnName = "idAFP")
    @ManyToOne(optional = false)
    private Afp idAFP;
    @JoinColumn(name = "idSIMULACION", referencedColumnName = "idSIMULACION", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Simulacion simulacion;
    @JoinColumn(name = "idTIPOCOMISION", referencedColumnName = "idTIPOCOMISION")
    @ManyToOne(optional = false)
    private Tipocomision idTIPOCOMISION;
    @JoinColumn(name = "idTIPOFONDO", referencedColumnName = "idTIPOFONDO")
    @ManyToOne(optional = false)
    private Tipofondo idTIPOFONDO;

    public Simulacionhito() {
    }

    public Simulacionhito(Integer idSIMULACION) {
        this.idSIMULACION = idSIMULACION;
    }

    public Integer getIdSIMULACION() {
        return idSIMULACION;
    }

    public void setIdSIMULACION(Integer idSIMULACION) {
        this.idSIMULACION = idSIMULACION;
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

    public Afp getIdAFP() {
        return idAFP;
    }

    public void setIdAFP(Afp idAFP) {
        this.idAFP = idAFP;
    }

    public Simulacion getSimulacion() {
        return simulacion;
    }

    public void setSimulacion(Simulacion simulacion) {
        this.simulacion = simulacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSIMULACION != null ? idSIMULACION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Simulacionhito)) {
            return false;
        }
        Simulacionhito other = (Simulacionhito) object;
        if ((this.idSIMULACION == null && other.idSIMULACION != null) || (this.idSIMULACION != null && !this.idSIMULACION.equals(other.idSIMULACION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.simulacion.entity.Simulacionhito[ idSIMULACION=" + idSIMULACION + " ]";
    }
    
}

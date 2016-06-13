/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.afp.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaime Ambrosio
 */
@Entity
@Table(name = "licitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licitacion.findAll", query = "SELECT l FROM Licitacion l")})
public class Licitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLICITACION")
    private Integer idLICITACION;
    @Column(name = "fechaDesde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Column(name = "fechaHasta")
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "urlDetalle")
    private String urlDetalle;
    @JoinColumn(name = "idAFP", referencedColumnName = "idAFP")
    @ManyToOne(optional = false)
    private Afp idAFP;

    public Licitacion() {
    }

    public Licitacion(Integer idLICITACION) {
        this.idLICITACION = idLICITACION;
    }

    public Integer getIdLICITACION() {
        return idLICITACION;
    }

    public void setIdLICITACION(Integer idLICITACION) {
        this.idLICITACION = idLICITACION;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getUrlDetalle() {
        return urlDetalle;
    }

    public void setUrlDetalle(String urlDetalle) {
        this.urlDetalle = urlDetalle;
    }

    public Afp getIdAFP() {
        return idAFP;
    }

    public void setIdAFP(Afp idAFP) {
        this.idAFP = idAFP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLICITACION != null ? idLICITACION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licitacion)) {
            return false;
        }
        Licitacion other = (Licitacion) object;
        if ((this.idLICITACION == null && other.idLICITACION != null) || (this.idLICITACION != null && !this.idLICITACION.equals(other.idLICITACION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.Licitacion[ idLICITACION=" + idLICITACION + " ]";
    }
    
}

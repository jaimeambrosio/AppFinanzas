/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.simulacion.entity;

import fina.usuario.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "simulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Simulacion.findAll", query = "SELECT s FROM Simulacion s")})
public class Simulacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSIMULACION")
    private Integer idSIMULACION;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "idUSUARIO", referencedColumnName = "idUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idUSUARIO;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "simulacion")
    private Simulacionhito simulacionhito;

    public Simulacion() {
    }

    public Simulacion(Integer idSIMULACION) {
        this.idSIMULACION = idSIMULACION;
    }

    public Integer getIdSIMULACION() {
        return idSIMULACION;
    }

    public void setIdSIMULACION(Integer idSIMULACION) {
        this.idSIMULACION = idSIMULACION;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getIdUSUARIO() {
        return idUSUARIO;
    }

    public void setIdUSUARIO(Usuario idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public Simulacionhito getSimulacionhito() {
        return simulacionhito;
    }

    public void setSimulacionhito(Simulacionhito simulacionhito) {
        this.simulacionhito = simulacionhito;
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
        if (!(object instanceof Simulacion)) {
            return false;
        }
        Simulacion other = (Simulacion) object;
        if ((this.idSIMULACION == null && other.idSIMULACION != null) || (this.idSIMULACION != null && !this.idSIMULACION.equals(other.idSIMULACION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.simulacion.entity.Simulacion[ idSIMULACION=" + idSIMULACION + " ]";
    }
    
}

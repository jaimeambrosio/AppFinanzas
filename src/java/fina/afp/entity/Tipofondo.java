/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.afp.entity;

import fina.simulacion.entity.Simulacionhito;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jaime Ambrosio
 */
@Entity
@Table(name = "tipofondo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipofondo.findAll", query = "SELECT t FROM Tipofondo t")})
public class Tipofondo implements Serializable {

    @Column(name = "mayorA")
    private Integer mayorA;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTIPOFONDO")
    private List<Simulacionhito> simulacionhitoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTIPOFONDO")
    private Integer idTIPOFONDO;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "isActivo")
    private Boolean isActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipofondo")
    private List<Tipofondoxafp> tipofondoxafpList;

    public Tipofondo() {
    }

    public Tipofondo(Integer idTIPOFONDO) {
        this.idTIPOFONDO = idTIPOFONDO;
    }

    public Integer getIdTIPOFONDO() {
        return idTIPOFONDO;
    }

    public void setIdTIPOFONDO(Integer idTIPOFONDO) {
        this.idTIPOFONDO = idTIPOFONDO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Boolean getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(Boolean isActivo) {
        this.isActivo = isActivo;
    }

    @XmlTransient
    public List<Tipofondoxafp> getTipofondoxafpList() {
        return tipofondoxafpList;
    }

    public void setTipofondoxafpList(List<Tipofondoxafp> tipofondoxafpList) {
        this.tipofondoxafpList = tipofondoxafpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPOFONDO != null ? idTIPOFONDO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipofondo)) {
            return false;
        }
        Tipofondo other = (Tipofondo) object;
        if ((this.idTIPOFONDO == null && other.idTIPOFONDO != null) || (this.idTIPOFONDO != null && !this.idTIPOFONDO.equals(other.idTIPOFONDO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.Tipofondo[ idTIPOFONDO=" + idTIPOFONDO + " ]";
    }

    @XmlTransient
    public List<Simulacionhito> getSimulacionhitoList() {
        return simulacionhitoList;
    }

    public void setSimulacionhitoList(List<Simulacionhito> simulacionhitoList) {
        this.simulacionhitoList = simulacionhitoList;
    }

    public Integer getMayorA() {
        return mayorA;
    }

    public void setMayorA(Integer mayorA) {
        this.mayorA = mayorA;
    }
    
}

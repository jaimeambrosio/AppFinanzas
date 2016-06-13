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
@Table(name = "tipocomision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocomision.findAll", query = "SELECT t FROM Tipocomision t")})
public class Tipocomision implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTIPOCOMISION")
    private List<Simulacionhito> simulacionhitoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTIPOCOMISION")
    private Integer idTIPOCOMISION;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipocomision")
    private List<Tipocomisionxafp> tipocomisionxafpList;

    public Tipocomision() {
    }

    public Tipocomision(Integer idTIPOCOMISION) {
        this.idTIPOCOMISION = idTIPOCOMISION;
    }

    public Integer getIdTIPOCOMISION() {
        return idTIPOCOMISION;
    }

    public void setIdTIPOCOMISION(Integer idTIPOCOMISION) {
        this.idTIPOCOMISION = idTIPOCOMISION;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Tipocomisionxafp> getTipocomisionxafpList() {
        return tipocomisionxafpList;
    }

    public void setTipocomisionxafpList(List<Tipocomisionxafp> tipocomisionxafpList) {
        this.tipocomisionxafpList = tipocomisionxafpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPOCOMISION != null ? idTIPOCOMISION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocomision)) {
            return false;
        }
        Tipocomision other = (Tipocomision) object;
        if ((this.idTIPOCOMISION == null && other.idTIPOCOMISION != null) || (this.idTIPOCOMISION != null && !this.idTIPOCOMISION.equals(other.idTIPOCOMISION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.Tipocomision[ idTIPOCOMISION=" + idTIPOCOMISION + " ]";
    }

    @XmlTransient
    public List<Simulacionhito> getSimulacionhitoList() {
        return simulacionhitoList;
    }

    public void setSimulacionhitoList(List<Simulacionhito> simulacionhitoList) {
        this.simulacionhitoList = simulacionhitoList;
    }
    
}

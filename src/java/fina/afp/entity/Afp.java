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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "afp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Afp.findAll", query = "SELECT a FROM Afp a")})
public class Afp implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAFP")
    private List<Simulacionhito> simulacionhitoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAFP")
    private Integer idAFP;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;

    public Afp() {
    }

    public Afp(Integer idAFP) {
        this.idAFP = idAFP;
    }

    public Integer getIdAFP() {
        return idAFP;
    }

    public void setIdAFP(Integer idAFP) {
        this.idAFP = idAFP;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAFP != null ? idAFP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Afp)) {
            return false;
        }
        Afp other = (Afp) object;
        if ((this.idAFP == null && other.idAFP != null) || (this.idAFP != null && !this.idAFP.equals(other.idAFP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.Afp[ idAFP=" + idAFP + " ]";
    }

    @XmlTransient
    public List<Simulacionhito> getSimulacionhitoList() {
        return simulacionhitoList;
    }

    public void setSimulacionhitoList(List<Simulacionhito> simulacionhitoList) {
        this.simulacionhitoList = simulacionhitoList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.afp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaime Ambrosio
 */
@Entity
@Table(name = "tipocomisionxafp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocomisionxafp.findAll", query = "SELECT t FROM Tipocomisionxafp t")})
public class Tipocomisionxafp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipocomisionxafpPK tipocomisionxafpPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "comisionSaldo")
    private Double comisionSaldo;
    @Column(name = "comisionFlujo")
    private Double comisionFlujo;
    @JoinColumn(name = "idAFP", referencedColumnName = "idAFP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Afp afp;
    @JoinColumn(name = "idTIPOCOMISION", referencedColumnName = "idTIPOCOMISION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipocomision tipocomision;

    public Tipocomisionxafp() {
    }

    public Tipocomisionxafp(TipocomisionxafpPK tipocomisionxafpPK) {
        this.tipocomisionxafpPK = tipocomisionxafpPK;
    }

    public Tipocomisionxafp(int idTIPOCOMISION, int idAFP) {
        this.tipocomisionxafpPK = new TipocomisionxafpPK(idTIPOCOMISION, idAFP);
    }

    public TipocomisionxafpPK getTipocomisionxafpPK() {
        return tipocomisionxafpPK;
    }

    public void setTipocomisionxafpPK(TipocomisionxafpPK tipocomisionxafpPK) {
        this.tipocomisionxafpPK = tipocomisionxafpPK;
    }

    public Double getComisionSaldo() {
        return comisionSaldo;
    }

    public void setComisionSaldo(Double comisionSaldo) {
        this.comisionSaldo = comisionSaldo;
    }

    public Double getComisionFlujo() {
        return comisionFlujo;
    }

    public void setComisionFlujo(Double comisionFlujo) {
        this.comisionFlujo = comisionFlujo;
    }

    public Afp getAfp() {
        return afp;
    }

    public void setAfp(Afp afp) {
        this.afp = afp;
    }

    public Tipocomision getTipocomision() {
        return tipocomision;
    }

    public void setTipocomision(Tipocomision tipocomision) {
        this.tipocomision = tipocomision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipocomisionxafpPK != null ? tipocomisionxafpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocomisionxafp)) {
            return false;
        }
        Tipocomisionxafp other = (Tipocomisionxafp) object;
        if ((this.tipocomisionxafpPK == null && other.tipocomisionxafpPK != null) || (this.tipocomisionxafpPK != null && !this.tipocomisionxafpPK.equals(other.tipocomisionxafpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.Tipocomisionxafp[ tipocomisionxafpPK=" + tipocomisionxafpPK + " ]";
    }
    
}

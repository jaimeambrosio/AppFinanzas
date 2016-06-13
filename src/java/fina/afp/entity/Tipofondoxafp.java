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
@Table(name = "tipofondoxafp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipofondoxafp.findAll", query = "SELECT t FROM Tipofondoxafp t")})
public class Tipofondoxafp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipofondoxafpPK tipofondoxafpPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rentabilidadSugerida")
    private Double rentabilidadSugerida;
    @JoinColumn(name = "idAFP", referencedColumnName = "idAFP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Afp afp;
    @JoinColumn(name = "idTIPOFONDO", referencedColumnName = "idTIPOFONDO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipofondo tipofondo;

    public Tipofondoxafp() {
    }

    public Tipofondoxafp(TipofondoxafpPK tipofondoxafpPK) {
        this.tipofondoxafpPK = tipofondoxafpPK;
    }

    public Tipofondoxafp(int idTIPOFONDO, int idAFP) {
        this.tipofondoxafpPK = new TipofondoxafpPK(idTIPOFONDO, idAFP);
    }

    public TipofondoxafpPK getTipofondoxafpPK() {
        return tipofondoxafpPK;
    }

    public void setTipofondoxafpPK(TipofondoxafpPK tipofondoxafpPK) {
        this.tipofondoxafpPK = tipofondoxafpPK;
    }

    public Double getRentabilidadSugerida() {
        return rentabilidadSugerida;
    }

    public void setRentabilidadSugerida(Double rentabilidadSugerida) {
        this.rentabilidadSugerida = rentabilidadSugerida;
    }

    public Afp getAfp() {
        return afp;
    }

    public void setAfp(Afp afp) {
        this.afp = afp;
    }

    public Tipofondo getTipofondo() {
        return tipofondo;
    }

    public void setTipofondo(Tipofondo tipofondo) {
        this.tipofondo = tipofondo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipofondoxafpPK != null ? tipofondoxafpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipofondoxafp)) {
            return false;
        }
        Tipofondoxafp other = (Tipofondoxafp) object;
        if ((this.tipofondoxafpPK == null && other.tipofondoxafpPK != null) || (this.tipofondoxafpPK != null && !this.tipofondoxafpPK.equals(other.tipofondoxafpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.Tipofondoxafp[ tipofondoxafpPK=" + tipofondoxafpPK + " ]";
    }
    
}

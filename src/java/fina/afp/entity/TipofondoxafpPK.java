/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.afp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jaime Ambrosio
 */
@Embeddable
public class TipofondoxafpPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idTIPOFONDO")
    private int idTIPOFONDO;
    @Basic(optional = false)
    @Column(name = "idAFP")
    private int idAFP;

    public TipofondoxafpPK() {
    }

    public TipofondoxafpPK(int idTIPOFONDO, int idAFP) {
        this.idTIPOFONDO = idTIPOFONDO;
        this.idAFP = idAFP;
    }

    public int getIdTIPOFONDO() {
        return idTIPOFONDO;
    }

    public void setIdTIPOFONDO(int idTIPOFONDO) {
        this.idTIPOFONDO = idTIPOFONDO;
    }

    public int getIdAFP() {
        return idAFP;
    }

    public void setIdAFP(int idAFP) {
        this.idAFP = idAFP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTIPOFONDO;
        hash += (int) idAFP;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipofondoxafpPK)) {
            return false;
        }
        TipofondoxafpPK other = (TipofondoxafpPK) object;
        if (this.idTIPOFONDO != other.idTIPOFONDO) {
            return false;
        }
        if (this.idAFP != other.idAFP) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.TipofondoxafpPK[ idTIPOFONDO=" + idTIPOFONDO + ", idAFP=" + idAFP + " ]";
    }
    
}

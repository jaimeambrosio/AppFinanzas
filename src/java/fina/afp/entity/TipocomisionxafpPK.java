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
public class TipocomisionxafpPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idTIPOCOMISION")
    private int idTIPOCOMISION;
    @Basic(optional = false)
    @Column(name = "idAFP")
    private int idAFP;

    public TipocomisionxafpPK() {
    }

    public TipocomisionxafpPK(int idTIPOCOMISION, int idAFP) {
        this.idTIPOCOMISION = idTIPOCOMISION;
        this.idAFP = idAFP;
    }

    public int getIdTIPOCOMISION() {
        return idTIPOCOMISION;
    }

    public void setIdTIPOCOMISION(int idTIPOCOMISION) {
        this.idTIPOCOMISION = idTIPOCOMISION;
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
        hash += (int) idTIPOCOMISION;
        hash += (int) idAFP;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipocomisionxafpPK)) {
            return false;
        }
        TipocomisionxafpPK other = (TipocomisionxafpPK) object;
        if (this.idTIPOCOMISION != other.idTIPOCOMISION) {
            return false;
        }
        if (this.idAFP != other.idAFP) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.afp.entity.TipocomisionxafpPK[ idTIPOCOMISION=" + idTIPOCOMISION + ", idAFP=" + idAFP + " ]";
    }
    
}

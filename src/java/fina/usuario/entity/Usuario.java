/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.usuario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUSUARIO")
    private Integer idUSUARIO;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "sexo")
    private Boolean sexo;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "dni")
    private String dni;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "nombreFoto")
    private String nombreFoto;
    @JoinColumn(name = "idTipoUsuario", referencedColumnName = "idTipoUsuario")
    @ManyToOne(optional = false)
    private Tipousuario idTipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public Usuario(Integer idUSUARIO, String username, String contrasenia) {
        this.idUSUARIO = idUSUARIO;
        this.username = username;
        this.contrasenia = contrasenia;
    }

    public Integer getIdUSUARIO() {
        return idUSUARIO;
    }

    public void setIdUSUARIO(Integer idUSUARIO) {
        this.idUSUARIO = idUSUARIO;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public Tipousuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Tipousuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUSUARIO != null ? idUSUARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUSUARIO == null && other.idUSUARIO != null) || (this.idUSUARIO != null && !this.idUSUARIO.equals(other.idUSUARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fina.usuario.entity.Usuario[ idUSUARIO=" + idUSUARIO + " ]";
    }
    
}

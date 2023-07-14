/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.munduscreator;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "tbl_usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_usu_id")
    private Integer pkUsuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usu_tipodedato")
    private String usuTipodedato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usu_nombre")
    private String usuNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usu_apellido")
    private String usuApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usu_fechanac")
    private String usuFechanac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "usu_genero")
    private String usuGenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "usu_correo")
    private String usuCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usu_nomusu")
    private String usuNomusu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usu_contrasenha")
    private String usuContrasenha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_estado")
    private short usuEstado;
    @Size(max = 21000)
    @Column(name = "usu_foto")
    private String usuFoto;
    @JoinTable(name = "tbl_usuario_rol", joinColumns = {
        @JoinColumn(name = "fk_usu_id", referencedColumnName = "pk_usu_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_rol_id", referencedColumnName = "pk_rol_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Roles> rolesCollection;
    @JoinTable(name = "tbl_cursos_usuarios", joinColumns = {
        @JoinColumn(name = "fk_usu_id", referencedColumnName = "pk_usu_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_cur_id", referencedColumnName = "pk_cur_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Cursos> cursosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUsuId", fetch = FetchType.LAZY)
    private Collection<Certificados> certificadosCollection;

    public Usuarios() {
    }

    public Usuarios(Integer pkUsuId) {
        this.pkUsuId = pkUsuId;
    }

    public Usuarios(Integer pkUsuId, String usuTipodedato, String usuNombre, String usuApellido, String usuFechanac, String usuGenero, String usuCorreo, String usuNomusu, String usuContrasenha, short usuEstado) {
        this.pkUsuId = pkUsuId;
        this.usuTipodedato = usuTipodedato;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuFechanac = usuFechanac;
        this.usuGenero = usuGenero;
        this.usuCorreo = usuCorreo;
        this.usuNomusu = usuNomusu;
        this.usuContrasenha = usuContrasenha;
        this.usuEstado = usuEstado;
    }

    public Integer getPkUsuId() {
        return pkUsuId;
    }

    public void setPkUsuId(Integer pkUsuId) {
        this.pkUsuId = pkUsuId;
    }

    public String getUsuTipodedato() {
        return usuTipodedato;
    }

    public void setUsuTipodedato(String usuTipodedato) {
        this.usuTipodedato = usuTipodedato;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuFechanac() {
        return usuFechanac;
    }

    public void setUsuFechanac(String usuFechanac) {
        this.usuFechanac = usuFechanac;
    }

    public String getUsuGenero() {
        return usuGenero;
    }

    public void setUsuGenero(String usuGenero) {
        this.usuGenero = usuGenero;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuNomusu() {
        return usuNomusu;
    }

    public void setUsuNomusu(String usuNomusu) {
        this.usuNomusu = usuNomusu;
    }

    public String getUsuContrasenha() {
        return usuContrasenha;
    }

    public void setUsuContrasenha(String usuContrasenha) {
        this.usuContrasenha = usuContrasenha;
    }

    public short getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(short usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuFoto() {
        return usuFoto;
    }

    public void setUsuFoto(String usuFoto) {
        this.usuFoto = usuFoto;
    }

    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    public Collection<Certificados> getCertificadosCollection() {
        return certificadosCollection;
    }

    public void setCertificadosCollection(Collection<Certificados> certificadosCollection) {
        this.certificadosCollection = certificadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkUsuId != null ? pkUsuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.pkUsuId == null && other.pkUsuId != null) || (this.pkUsuId != null && !this.pkUsuId.equals(other.pkUsuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Usuarios[ pkUsuId=" + pkUsuId + " ]";
    }
    
}

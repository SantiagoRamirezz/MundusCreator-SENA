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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_roles")
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_rol_id")
    private Integer pkRolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @ManyToMany(mappedBy = "rolesCollection", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkRolId", fetch = FetchType.LAZY)
    private Collection<Mensajes> mensajesCollection;

    public Roles() {
    }

    public Roles(Integer pkRolId) {
        this.pkRolId = pkRolId;
    }

    public Roles(Integer pkRolId, String rolNombre) {
        this.pkRolId = pkRolId;
        this.rolNombre = rolNombre;
    }

    public Integer getPkRolId() {
        return pkRolId;
    }

    public void setPkRolId(Integer pkRolId) {
        this.pkRolId = pkRolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Collection<Mensajes> getMensajesCollection() {
        return mensajesCollection;
    }

    public void setMensajesCollection(Collection<Mensajes> mensajesCollection) {
        this.mensajesCollection = mensajesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkRolId != null ? pkRolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.pkRolId == null && other.pkRolId != null) || (this.pkRolId != null && !this.pkRolId.equals(other.pkRolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Roles[ pkRolId=" + pkRolId + " ]";
    }
    
}

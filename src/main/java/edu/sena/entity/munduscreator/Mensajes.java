/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.munduscreator;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "tbl_mensajes")
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_men_id")
    private Integer pkMenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "men_ descripcion")
    private String menDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "men_fecha")
    private String menFecha;
    @JoinColumn(name = "fk_rol_id", referencedColumnName = "pk_rol_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roles fkRolId;
    @JoinColumn(name = "fk_est_id", referencedColumnName = "pk_est_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estados fkEstId;

    public Mensajes() {
    }

    public Mensajes(Integer pkMenId) {
        this.pkMenId = pkMenId;
    }

    public Mensajes(Integer pkMenId, String menDescripcion, String menFecha) {
        this.pkMenId = pkMenId;
        this.menDescripcion = menDescripcion;
        this.menFecha = menFecha;
    }

    public Integer getPkMenId() {
        return pkMenId;
    }

    public void setPkMenId(Integer pkMenId) {
        this.pkMenId = pkMenId;
    }

    public String getMenDescripcion() {
        return menDescripcion;
    }

    public void setMenDescripcion(String menDescripcion) {
        this.menDescripcion = menDescripcion;
    }

    public String getMenFecha() {
        return menFecha;
    }

    public void setMenFecha(String menFecha) {
        this.menFecha = menFecha;
    }

    public Roles getFkRolId() {
        return fkRolId;
    }

    public void setFkRolId(Roles fkRolId) {
        this.fkRolId = fkRolId;
    }

    public Estados getFkEstId() {
        return fkEstId;
    }

    public void setFkEstId(Estados fkEstId) {
        this.fkEstId = fkEstId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkMenId != null ? pkMenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.pkMenId == null && other.pkMenId != null) || (this.pkMenId != null && !this.pkMenId.equals(other.pkMenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Mensajes[ pkMenId=" + pkMenId + " ]";
    }
    
}

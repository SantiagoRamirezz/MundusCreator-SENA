/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.munduscreator;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "tbl_actividades")
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_act_id")
    private Integer pkActId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "act_nombre")
    private String actNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "act_descripcion")
    private String actDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "act_ruta")
    private String actRuta;
    @ManyToMany(mappedBy = "actividadesCollection", fetch = FetchType.LAZY)
    private Collection<Papeleria> papeleriaCollection;

    public Actividades() {
    }

    public Actividades(Integer pkActId) {
        this.pkActId = pkActId;
    }

    public Actividades(Integer pkActId, String actNombre, String actDescripcion, String actRuta) {
        this.pkActId = pkActId;
        this.actNombre = actNombre;
        this.actDescripcion = actDescripcion;
        this.actRuta = actRuta;
    }

    public Integer getPkActId() {
        return pkActId;
    }

    public void setPkActId(Integer pkActId) {
        this.pkActId = pkActId;
    }

    public String getActNombre() {
        return actNombre;
    }

    public void setActNombre(String actNombre) {
        this.actNombre = actNombre;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActRuta() {
        return actRuta;
    }

    public void setActRuta(String actRuta) {
        this.actRuta = actRuta;
    }

    public Collection<Papeleria> getPapeleriaCollection() {
        return papeleriaCollection;
    }

    public void setPapeleriaCollection(Collection<Papeleria> papeleriaCollection) {
        this.papeleriaCollection = papeleriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkActId != null ? pkActId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.pkActId == null && other.pkActId != null) || (this.pkActId != null && !this.pkActId.equals(other.pkActId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Actividades[ pkActId=" + pkActId + " ]";
    }
    
}

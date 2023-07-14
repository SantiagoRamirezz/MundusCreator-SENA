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
@Table(name = "tbl_evaluaciones")
@NamedQueries({
    @NamedQuery(name = "Evaluaciones.findAll", query = "SELECT e FROM Evaluaciones e")})
public class Evaluaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_eva_id")
    private Integer pkEvaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "eva_nombre")
    private String evaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "eva_descripcion")
    private String evaDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "eva_ruta")
    private String evaRuta;
    @ManyToMany(mappedBy = "evaluacionesCollection", fetch = FetchType.LAZY)
    private Collection<Papeleria> papeleriaCollection;

    public Evaluaciones() {
    }

    public Evaluaciones(Integer pkEvaId) {
        this.pkEvaId = pkEvaId;
    }

    public Evaluaciones(Integer pkEvaId, String evaNombre, String evaDescripcion, String evaRuta) {
        this.pkEvaId = pkEvaId;
        this.evaNombre = evaNombre;
        this.evaDescripcion = evaDescripcion;
        this.evaRuta = evaRuta;
    }

    public Integer getPkEvaId() {
        return pkEvaId;
    }

    public void setPkEvaId(Integer pkEvaId) {
        this.pkEvaId = pkEvaId;
    }

    public String getEvaNombre() {
        return evaNombre;
    }

    public void setEvaNombre(String evaNombre) {
        this.evaNombre = evaNombre;
    }

    public String getEvaDescripcion() {
        return evaDescripcion;
    }

    public void setEvaDescripcion(String evaDescripcion) {
        this.evaDescripcion = evaDescripcion;
    }

    public String getEvaRuta() {
        return evaRuta;
    }

    public void setEvaRuta(String evaRuta) {
        this.evaRuta = evaRuta;
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
        hash += (pkEvaId != null ? pkEvaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluaciones)) {
            return false;
        }
        Evaluaciones other = (Evaluaciones) object;
        if ((this.pkEvaId == null && other.pkEvaId != null) || (this.pkEvaId != null && !this.pkEvaId.equals(other.pkEvaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Evaluaciones[ pkEvaId=" + pkEvaId + " ]";
    }
    
}

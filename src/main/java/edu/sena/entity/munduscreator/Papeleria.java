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
@Table(name = "tbl_papeleria")
@NamedQueries({
    @NamedQuery(name = "Papeleria.findAll", query = "SELECT p FROM Papeleria p")})
public class Papeleria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_pap_id")
    private Integer pkPapId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "pap_descripcion")
    private String papDescripcion;
    @JoinTable(name = "tbl_papeleria_documento", joinColumns = {
        @JoinColumn(name = "fk_pap_id", referencedColumnName = "pk_pap_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_doc_id", referencedColumnName = "pk_doc_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Documentos> documentosCollection;
    @JoinTable(name = "tbl_papeleria_evaluacion", joinColumns = {
        @JoinColumn(name = "fk_pap_id", referencedColumnName = "pk_pap_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_eva_id", referencedColumnName = "pk_eva_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Evaluaciones> evaluacionesCollection;
    @JoinTable(name = "tbl_papeleria_actividad", joinColumns = {
        @JoinColumn(name = "fk_pap_id", referencedColumnName = "pk_pap_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_act_id", referencedColumnName = "pk_act_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Actividades> actividadesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPapId", fetch = FetchType.LAZY)
    private Collection<Cursos> cursosCollection;

    public Papeleria() {
    }

    public Papeleria(Integer pkPapId) {
        this.pkPapId = pkPapId;
    }

    public Papeleria(Integer pkPapId, String papDescripcion) {
        this.pkPapId = pkPapId;
        this.papDescripcion = papDescripcion;
    }

    public Integer getPkPapId() {
        return pkPapId;
    }

    public void setPkPapId(Integer pkPapId) {
        this.pkPapId = pkPapId;
    }

    public String getPapDescripcion() {
        return papDescripcion;
    }

    public void setPapDescripcion(String papDescripcion) {
        this.papDescripcion = papDescripcion;
    }

    public Collection<Documentos> getDocumentosCollection() {
        return documentosCollection;
    }

    public void setDocumentosCollection(Collection<Documentos> documentosCollection) {
        this.documentosCollection = documentosCollection;
    }

    public Collection<Evaluaciones> getEvaluacionesCollection() {
        return evaluacionesCollection;
    }

    public void setEvaluacionesCollection(Collection<Evaluaciones> evaluacionesCollection) {
        this.evaluacionesCollection = evaluacionesCollection;
    }

    public Collection<Actividades> getActividadesCollection() {
        return actividadesCollection;
    }

    public void setActividadesCollection(Collection<Actividades> actividadesCollection) {
        this.actividadesCollection = actividadesCollection;
    }

    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPapId != null ? pkPapId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Papeleria)) {
            return false;
        }
        Papeleria other = (Papeleria) object;
        if ((this.pkPapId == null && other.pkPapId != null) || (this.pkPapId != null && !this.pkPapId.equals(other.pkPapId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Papeleria[ pkPapId=" + pkPapId + " ]";
    }
    
}

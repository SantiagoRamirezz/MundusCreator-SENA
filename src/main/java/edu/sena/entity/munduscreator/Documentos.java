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
@Table(name = "tbl_documentos")
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d")})
public class Documentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_doc_id")
    private Integer pkDocId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "doc_nombre")
    private String docNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "doc_descripcion")
    private String docDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "doc_ruta")
    private String docRuta;
    @ManyToMany(mappedBy = "documentosCollection", fetch = FetchType.LAZY)
    private Collection<Papeleria> papeleriaCollection;

    public Documentos() {
    }

    public Documentos(Integer pkDocId) {
        this.pkDocId = pkDocId;
    }

    public Documentos(Integer pkDocId, String docNombre, String docDescripcion, String docRuta) {
        this.pkDocId = pkDocId;
        this.docNombre = docNombre;
        this.docDescripcion = docDescripcion;
        this.docRuta = docRuta;
    }

    public Integer getPkDocId() {
        return pkDocId;
    }

    public void setPkDocId(Integer pkDocId) {
        this.pkDocId = pkDocId;
    }

    public String getDocNombre() {
        return docNombre;
    }

    public void setDocNombre(String docNombre) {
        this.docNombre = docNombre;
    }

    public String getDocDescripcion() {
        return docDescripcion;
    }

    public void setDocDescripcion(String docDescripcion) {
        this.docDescripcion = docDescripcion;
    }

    public String getDocRuta() {
        return docRuta;
    }

    public void setDocRuta(String docRuta) {
        this.docRuta = docRuta;
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
        hash += (pkDocId != null ? pkDocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.pkDocId == null && other.pkDocId != null) || (this.pkDocId != null && !this.pkDocId.equals(other.pkDocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Documentos[ pkDocId=" + pkDocId + " ]";
    }
    
}

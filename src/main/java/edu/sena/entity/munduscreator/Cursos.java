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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_cursos")
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cur_id")
    private Integer pkCurId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cur_nombre")
    private String curNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cur_fecha_creacion")
    private String curFechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cur_descripcion")
    private String curDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "cur_imagen")
    private String curImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cur_estado")
    private short curEstado;
    @ManyToMany(mappedBy = "cursosCollection", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "fk_mul_id", referencedColumnName = "pk_mul_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Multimedia fkMulId;
    @JoinColumn(name = "fk_pap_id", referencedColumnName = "pk_pap_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Papeleria fkPapId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCurId", fetch = FetchType.LAZY)
    private Collection<Certificados> certificadosCollection;

    public Cursos() {
    }

    public Cursos(Integer pkCurId) {
        this.pkCurId = pkCurId;
    }

    public Cursos(Integer pkCurId, String curNombre, String curFechaCreacion, String curDescripcion, String curImagen, short curEstado) {
        this.pkCurId = pkCurId;
        this.curNombre = curNombre;
        this.curFechaCreacion = curFechaCreacion;
        this.curDescripcion = curDescripcion;
        this.curImagen = curImagen;
        this.curEstado = curEstado;
    }

    public Integer getPkCurId() {
        return pkCurId;
    }

    public void setPkCurId(Integer pkCurId) {
        this.pkCurId = pkCurId;
    }

    public String getCurNombre() {
        return curNombre;
    }

    public void setCurNombre(String curNombre) {
        this.curNombre = curNombre;
    }

    public String getCurFechaCreacion() {
        return curFechaCreacion;
    }

    public void setCurFechaCreacion(String curFechaCreacion) {
        this.curFechaCreacion = curFechaCreacion;
    }

    public String getCurDescripcion() {
        return curDescripcion;
    }

    public void setCurDescripcion(String curDescripcion) {
        this.curDescripcion = curDescripcion;
    }

    public String getCurImagen() {
        return curImagen;
    }

    public void setCurImagen(String curImagen) {
        this.curImagen = curImagen;
    }

    public short getCurEstado() {
        return curEstado;
    }

    public void setCurEstado(short curEstado) {
        this.curEstado = curEstado;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Multimedia getFkMulId() {
        return fkMulId;
    }

    public void setFkMulId(Multimedia fkMulId) {
        this.fkMulId = fkMulId;
    }

    public Papeleria getFkPapId() {
        return fkPapId;
    }

    public void setFkPapId(Papeleria fkPapId) {
        this.fkPapId = fkPapId;
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
        hash += (pkCurId != null ? pkCurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.pkCurId == null && other.pkCurId != null) || (this.pkCurId != null && !this.pkCurId.equals(other.pkCurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Cursos[ pkCurId=" + pkCurId + " ]";
    }

    
    
}

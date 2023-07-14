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
@Table(name = "tbl_multimedia")
@NamedQueries({
    @NamedQuery(name = "Multimedia.findAll", query = "SELECT m FROM Multimedia m")})
public class Multimedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_mul_id")
    private Integer pkMulId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mul_descripcion")
    private String mulDescripcion;
    @JoinTable(name = "tbl_multimedia_video", joinColumns = {
        @JoinColumn(name = "fk_mul_id", referencedColumnName = "pk_mul_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_vid_id", referencedColumnName = "pk_vid_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Videos> videosCollection;
    @JoinTable(name = "tbl_multimedia_imagen", joinColumns = {
        @JoinColumn(name = "fk_mul_id", referencedColumnName = "pk_mul_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_img_id", referencedColumnName = "pk_img_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Imagenes> imagenesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMulId", fetch = FetchType.LAZY)
    private Collection<Cursos> cursosCollection;

    public Multimedia() {
    }

    public Multimedia(Integer pkMulId) {
        this.pkMulId = pkMulId;
    }

    public Multimedia(Integer pkMulId, String mulDescripcion) {
        this.pkMulId = pkMulId;
        this.mulDescripcion = mulDescripcion;
    }

    public Integer getPkMulId() {
        return pkMulId;
    }

    public void setPkMulId(Integer pkMulId) {
        this.pkMulId = pkMulId;
    }

    public String getMulDescripcion() {
        return mulDescripcion;
    }

    public void setMulDescripcion(String mulDescripcion) {
        this.mulDescripcion = mulDescripcion;
    }

    public Collection<Videos> getVideosCollection() {
        return videosCollection;
    }

    public void setVideosCollection(Collection<Videos> videosCollection) {
        this.videosCollection = videosCollection;
    }

    public Collection<Imagenes> getImagenesCollection() {
        return imagenesCollection;
    }

    public void setImagenesCollection(Collection<Imagenes> imagenesCollection) {
        this.imagenesCollection = imagenesCollection;
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
        hash += (pkMulId != null ? pkMulId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multimedia)) {
            return false;
        }
        Multimedia other = (Multimedia) object;
        if ((this.pkMulId == null && other.pkMulId != null) || (this.pkMulId != null && !this.pkMulId.equals(other.pkMulId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Multimedia[ pkMulId=" + pkMulId + " ]";
    }
    
}

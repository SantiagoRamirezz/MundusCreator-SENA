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
@Table(name = "tbl_imagenes")
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_img_id")
    private Integer pkImgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "img_ruta_img")
    private String imgRutaImg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "img_descripcion")
    private String imgDescripcion;
    @ManyToMany(mappedBy = "imagenesCollection", fetch = FetchType.LAZY)
    private Collection<Multimedia> multimediaCollection;

    public Imagenes() {
    }

    public Imagenes(Integer pkImgId) {
        this.pkImgId = pkImgId;
    }

    public Imagenes(Integer pkImgId, String imgRutaImg, String imgDescripcion) {
        this.pkImgId = pkImgId;
        this.imgRutaImg = imgRutaImg;
        this.imgDescripcion = imgDescripcion;
    }

    public Integer getPkImgId() {
        return pkImgId;
    }

    public void setPkImgId(Integer pkImgId) {
        this.pkImgId = pkImgId;
    }

    public String getImgRutaImg() {
        return imgRutaImg;
    }

    public void setImgRutaImg(String imgRutaImg) {
        this.imgRutaImg = imgRutaImg;
    }

    public String getImgDescripcion() {
        return imgDescripcion;
    }

    public void setImgDescripcion(String imgDescripcion) {
        this.imgDescripcion = imgDescripcion;
    }

    public Collection<Multimedia> getMultimediaCollection() {
        return multimediaCollection;
    }

    public void setMultimediaCollection(Collection<Multimedia> multimediaCollection) {
        this.multimediaCollection = multimediaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkImgId != null ? pkImgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.pkImgId == null && other.pkImgId != null) || (this.pkImgId != null && !this.pkImgId.equals(other.pkImgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Imagenes[ pkImgId=" + pkImgId + " ]";
    }
    
}

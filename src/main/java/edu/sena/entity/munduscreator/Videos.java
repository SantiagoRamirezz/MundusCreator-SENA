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
@Table(name = "tbl_videos")
@NamedQueries({
    @NamedQuery(name = "Videos.findAll", query = "SELECT v FROM Videos v")})
public class Videos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_vid_id")
    private Integer pkVidId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "vid_ruta_video")
    private String vidRutaVideo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vid_descripcion")
    private String vidDescripcion;
    @ManyToMany(mappedBy = "videosCollection", fetch = FetchType.LAZY)
    private Collection<Multimedia> multimediaCollection;

    public Videos() {
    }

    public Videos(Integer pkVidId) {
        this.pkVidId = pkVidId;
    }

    public Videos(Integer pkVidId, String vidRutaVideo, String vidDescripcion) {
        this.pkVidId = pkVidId;
        this.vidRutaVideo = vidRutaVideo;
        this.vidDescripcion = vidDescripcion;
    }

    public Integer getPkVidId() {
        return pkVidId;
    }

    public void setPkVidId(Integer pkVidId) {
        this.pkVidId = pkVidId;
    }

    public String getVidRutaVideo() {
        return vidRutaVideo;
    }

    public void setVidRutaVideo(String vidRutaVideo) {
        this.vidRutaVideo = vidRutaVideo;
    }

    public String getVidDescripcion() {
        return vidDescripcion;
    }

    public void setVidDescripcion(String vidDescripcion) {
        this.vidDescripcion = vidDescripcion;
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
        hash += (pkVidId != null ? pkVidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videos)) {
            return false;
        }
        Videos other = (Videos) object;
        if ((this.pkVidId == null && other.pkVidId != null) || (this.pkVidId != null && !this.pkVidId.equals(other.pkVidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Videos[ pkVidId=" + pkVidId + " ]";
    }
    
}

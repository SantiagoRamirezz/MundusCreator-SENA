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

/**
 *
 * @author santi
 */
@Entity
@Table(name = "tbl_certificados")
@NamedQueries({
    @NamedQuery(name = "Certificados.findAll", query = "SELECT c FROM Certificados c")})
public class Certificados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cer_id")
    private Integer pkCerId;
    @JoinColumn(name = "fk_usu_id", referencedColumnName = "pk_usu_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios fkUsuId;
    @JoinColumn(name = "fk_cur_id", referencedColumnName = "pk_cur_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cursos fkCurId;

    public Certificados() {
    }

    public Certificados(Integer pkCerId) {
        this.pkCerId = pkCerId;
    }

    public Integer getPkCerId() {
        return pkCerId;
    }

    public void setPkCerId(Integer pkCerId) {
        this.pkCerId = pkCerId;
    }

    public Usuarios getFkUsuId() {
        return fkUsuId;
    }

    public void setFkUsuId(Usuarios fkUsuId) {
        this.fkUsuId = fkUsuId;
    }

    public Cursos getFkCurId() {
        return fkCurId;
    }

    public void setFkCurId(Cursos fkCurId) {
        this.fkCurId = fkCurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCerId != null ? pkCerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificados)) {
            return false;
        }
        Certificados other = (Certificados) object;
        if ((this.pkCerId == null && other.pkCerId != null) || (this.pkCerId != null && !this.pkCerId.equals(other.pkCerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Certificados[ pkCerId=" + pkCerId + " ]";
    }
    
}

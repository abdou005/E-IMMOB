/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author abdo
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("ANNONCEBIEN")
public class AnnonceBien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String titre;
    protected int nbimpr;
    protected double prix;
    protected boolean titreBleau;
    protected String description;
    @Temporal(DATE)
    protected Date dateAjout;
    @Temporal(DATE)
    protected Date dateModif;
    @Enumerated(EnumType.STRING)
    private Gov gov;
    protected boolean active;
    protected boolean activeAdmin;

    public boolean isActiveAdmin() {
        return activeAdmin;
    }

    public void setActiveAdmin(boolean activeAdmin) {
        this.activeAdmin = activeAdmin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    protected int superficieTotal;
    
    @OneToMany(mappedBy = "bien")
    protected List<Commentaire> commentaires;
    
    @OneToMany(mappedBy = "bien")
    protected List<Image> images;
    @OneToMany(mappedBy = "bien")
    protected List<Sauvgarde> sauvs;
    @ManyToOne
    protected AnnonceType type;
    
    @ManyToOne
    protected Delegation deleg;
    
    @ManyToOne
    protected Abonne abonne;

    public List<Sauvgarde> getSauvs() {
        return sauvs;
    }

    public void setSauvs(List<Sauvgarde> sauvs) {
        this.sauvs = sauvs;
    }

    public int getNbimpr() {
        return nbimpr;
    }

    public void setNbimpr(int nbimpr) {
        this.nbimpr = nbimpr;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Gov getGov() {
        return gov;
    }

    public void setGov(Gov gov) {
        this.gov = gov;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
   
    public Delegation getDeleg() {
        return deleg;
    }

    public void setDeleg(Delegation deleg) {
        this.deleg = deleg;
    }

    public AnnonceType getType() {
        return type;
    }

    public void setType(AnnonceType type) {
        this.type = type;
    }
   
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isTitreBleau() {
        return titreBleau;
    }

    public void setTitreBleau(boolean titreBleau) {
        this.titreBleau = titreBleau;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public int getSuperficieTotal() {
        return superficieTotal;
    }

    public void setSuperficieTotal(int superficieTotal) {
        this.superficieTotal = superficieTotal;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnnonceBien)) {
            return false;
        }
        AnnonceBien other = (AnnonceBien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AnnonceBien[ id=" + id + " ]";
    }

    
    
}

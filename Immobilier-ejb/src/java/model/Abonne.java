/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 *
 * @author abdo
 */
@Entity
@DiscriminatorValue("ABONNE")
public class Abonne extends Personne{
    private boolean admin;
    @Enumerated(EnumType.STRING)
    private Type abonneType;
    @OneToMany(mappedBy = "abonne")
    private List<Proposition> propositions;
    @OneToMany(mappedBy = "abonne")   
    protected List<Commentaire> commentaires;
    
    @OneToMany(mappedBy = "abonne")
    protected List<AnnonceBien> bienImmobiliers;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<AnnonceBien> getBienImmobiliers() {
        return bienImmobiliers;
    }

    public void setBienImmobiliers(List<AnnonceBien> bienImmobiliers) {
        this.bienImmobiliers = bienImmobiliers;
    }

    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    public Type getAbonneType() {
        return abonneType;
    }

    public void setAbonneType(Type abonneType) {
        this.abonneType = abonneType;
    }
    
}

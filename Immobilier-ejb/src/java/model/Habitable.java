/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 *
 * @author abdo
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("HABITABLE")
public class Habitable extends AnnonceBien {
  protected int superficieHabitable;
  protected int anneeConstruction;
  protected int nbrDePiece;
  protected int salon;
  protected int chambre;
  protected int salleDeBain;
  protected int wc;
  protected int cuisine;
  protected boolean balcon;
  protected boolean climatisation;
  protected boolean chauffage;

    public boolean isClimatisation() {
        return climatisation;
    }

    public void setClimatisation(boolean climatisation) {
        this.climatisation = climatisation;
    }

    public boolean isChauffage() {
        return chauffage;
    }

    public void setChauffage(boolean chauffage) {
        this.chauffage = chauffage;
    }

    public int getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(int anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }

    public int getSuperficieHabitable() {
        return superficieHabitable;
    }

    public void setSuperficieHabitable(int superficieHabitable) {
        this.superficieHabitable = superficieHabitable;
    }

    public int getNbrDePiece() {
        return nbrDePiece;
    }

    public void setNbrDePiece(int nbrDePiece) {
        this.nbrDePiece = nbrDePiece;
    }

    public int getSalon() {
        return salon;
    }

    public void setSalon(int salon) {
        this.salon = salon;
    }

    public int getChambre() {
        return chambre;
    }

    public void setChambre(int chambre) {
        this.chambre = chambre;
    }

    public int getSalleDeBain() {
        return salleDeBain;
    }

    public void setSalleDeBain(int salleDeBain) {
        this.salleDeBain = salleDeBain;
    }

    public int getWc() {
        return wc;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public int getCuisine() {
        return cuisine;
    }

    public void setCuisine(int cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }
         
}

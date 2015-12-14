/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author abdo
 */
@Entity
@DiscriminatorValue("APPARTEMENT")
public class Appartement extends Habitable {
  private int numEtage;
  private boolean assenceur;
  private boolean parking;
  private boolean sandic;

    public boolean isSandic() {
        return sandic;
    }

    public void setSandic(boolean sandic) {
        this.sandic = sandic;
    }
  
    public int getNumEtage() {
        return numEtage;
    }

    public void setNumEtage(int numEtage) {
        this.numEtage = numEtage;
    }

    public boolean isAssenceur() {
        return assenceur;
    }

    public void setAssenceur(boolean assenceur) {
        this.assenceur = assenceur;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }
    
}

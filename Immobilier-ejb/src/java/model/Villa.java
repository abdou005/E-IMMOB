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
@DiscriminatorValue("VILLA")
public class Villa extends Habitable {
  private boolean jardin;
  private boolean piscine;
  private int nbrEtage;
  private boolean Garage;

    public boolean isPiscine() {
        return piscine;
    }

    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    public boolean isJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public int getNbrEtage() {
        return nbrEtage;
    }

    public void setNbrEtage(int nbrEtage) {
        this.nbrEtage = nbrEtage;
    }

    public boolean isGarage() {
        return Garage;
    }

    public void setGarage(boolean Garage) {
        this.Garage = Garage;
    }
  
    
}

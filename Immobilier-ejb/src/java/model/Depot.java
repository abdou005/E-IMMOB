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
@DiscriminatorValue("DEPOT")
public class Depot extends AnnonceBien {
 
    private int superficieCouvert;
    private int anneeConstruction;

    public int getAnneeConstruction() {
        return anneeConstruction;
    }

    public void setAnneeConstruction(int anneeConstruction) {
        this.anneeConstruction = anneeConstruction;
    }
    
    public int getSuperficieCouvert() {
        return superficieCouvert;
    }

    public void setSuperficieCouvert(int superficieCouvert) {
        this.superficieCouvert = superficieCouvert;
    }
    
    
}

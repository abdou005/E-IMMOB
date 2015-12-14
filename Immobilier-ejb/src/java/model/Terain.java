/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
/**
 *
 * @author abdo
 */
@Entity
@DiscriminatorValue("TERAIN")
public class Terain extends AnnonceBien {
   
   private TypeTerain terainType;

    public TypeTerain getTerainType() {
        return terainType;
    }

    public void setTerainType(TypeTerain terainType) {
        this.terainType = terainType;
    }

   
    
}

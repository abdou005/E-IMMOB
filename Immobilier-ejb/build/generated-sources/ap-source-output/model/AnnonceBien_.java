package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Abonne;
import model.AnnonceType;
import model.Commentaire;
import model.Delegation;
import model.Gov;
import model.Image;
import model.Sauvgarde;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-30T02:22:23")
@StaticMetamodel(AnnonceBien.class)
public class AnnonceBien_ { 

    public static volatile SingularAttribute<AnnonceBien, Boolean> activeAdmin;
    public static volatile ListAttribute<AnnonceBien, Image> images;
    public static volatile SingularAttribute<AnnonceBien, Double> prix;
    public static volatile SingularAttribute<AnnonceBien, String> titre;
    public static volatile ListAttribute<AnnonceBien, Sauvgarde> sauvs;
    public static volatile SingularAttribute<AnnonceBien, Boolean> titreBleau;
    public static volatile SingularAttribute<AnnonceBien, Date> dateAjout;
    public static volatile SingularAttribute<AnnonceBien, Abonne> abonne;
    public static volatile SingularAttribute<AnnonceBien, String> description;
    public static volatile SingularAttribute<AnnonceBien, Boolean> active;
    public static volatile SingularAttribute<AnnonceBien, AnnonceType> type;
    public static volatile SingularAttribute<AnnonceBien, Gov> gov;
    public static volatile SingularAttribute<AnnonceBien, Integer> superficieTotal;
    public static volatile SingularAttribute<AnnonceBien, Integer> nbimpr;
    public static volatile ListAttribute<AnnonceBien, Commentaire> commentaires;
    public static volatile SingularAttribute<AnnonceBien, Long> id;
    public static volatile SingularAttribute<AnnonceBien, Date> dateModif;
    public static volatile SingularAttribute<AnnonceBien, Delegation> deleg;

}
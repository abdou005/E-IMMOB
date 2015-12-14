package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Abonne;
import model.AnnonceType;
import model.Image;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-30T02:22:23")
@StaticMetamodel(Proposition.class)
public class Proposition_ { 

    public static volatile SingularAttribute<Proposition, Date> date;
    public static volatile SingularAttribute<Proposition, Image> image;
    public static volatile SingularAttribute<Proposition, String> Contenu;
    public static volatile SingularAttribute<Proposition, String> titre;
    public static volatile SingularAttribute<Proposition, Abonne> abonne;
    public static volatile SingularAttribute<Proposition, Long> id;
    public static volatile SingularAttribute<Proposition, AnnonceType> type;

}
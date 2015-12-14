package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Abonne;
import model.AnnonceBien;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-30T02:22:23")
@StaticMetamodel(Commentaire.class)
public class Commentaire_ { 

    public static volatile SingularAttribute<Commentaire, Date> date;
    public static volatile SingularAttribute<Commentaire, Abonne> abonne;
    public static volatile SingularAttribute<Commentaire, String> nomuser;
    public static volatile SingularAttribute<Commentaire, Long> id;
    public static volatile SingularAttribute<Commentaire, String> contenu;
    public static volatile SingularAttribute<Commentaire, String> email;
    public static volatile SingularAttribute<Commentaire, AnnonceBien> bien;
    public static volatile SingularAttribute<Commentaire, String> urlsite;

}
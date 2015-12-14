package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AnnonceBien;
import model.Commentaire;
import model.Proposition;
import model.Type;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-30T02:22:23")
@StaticMetamodel(Abonne.class)
public class Abonne_ extends Personne_ {

    public static volatile SingularAttribute<Abonne, Type> abonneType;
    public static volatile ListAttribute<Abonne, Proposition> propositions;
    public static volatile SingularAttribute<Abonne, Boolean> admin;
    public static volatile ListAttribute<Abonne, Commentaire> commentaires;
    public static volatile ListAttribute<Abonne, AnnonceBien> bienImmobiliers;

}
package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AnnonceBien;
import model.Proposition;
import model.TypeAnnonce;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-30T02:22:23")
@StaticMetamodel(AnnonceType.class)
public class AnnonceType_ { 

    public static volatile SingularAttribute<AnnonceType, TypeAnnonce> typeAnnonce;
    public static volatile ListAttribute<AnnonceType, Proposition> propositions;
    public static volatile SingularAttribute<AnnonceType, Long> id;
    public static volatile ListAttribute<AnnonceType, AnnonceBien> bienImmobiliers;

}
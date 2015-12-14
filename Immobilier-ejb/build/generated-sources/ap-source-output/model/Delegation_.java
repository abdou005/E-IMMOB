package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AnnonceBien;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-30T02:22:23")
@StaticMetamodel(Delegation.class)
public class Delegation_ { 

    public static volatile SingularAttribute<Delegation, Long> id;
    public static volatile SingularAttribute<Delegation, String> region;
    public static volatile ListAttribute<Delegation, AnnonceBien> bienImmobiliers;

}
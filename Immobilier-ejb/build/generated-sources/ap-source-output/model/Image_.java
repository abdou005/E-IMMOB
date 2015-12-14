package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AnnonceBien;
import model.Proposition;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-30T02:22:23")
@StaticMetamodel(Image.class)
public class Image_ { 

    public static volatile SingularAttribute<Image, Proposition> proposition;
    public static volatile SingularAttribute<Image, String> description;
    public static volatile SingularAttribute<Image, Long> id;
    public static volatile SingularAttribute<Image, String> url;
    public static volatile SingularAttribute<Image, AnnonceBien> bien;

}
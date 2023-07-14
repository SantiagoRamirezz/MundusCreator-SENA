package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Multimedia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Videos.class)
public class Videos_ { 

    public static volatile SingularAttribute<Videos, String> vidRutaVideo;
    public static volatile SingularAttribute<Videos, String> vidDescripcion;
    public static volatile SingularAttribute<Videos, Integer> pkVidId;
    public static volatile CollectionAttribute<Videos, Multimedia> multimediaCollection;

}
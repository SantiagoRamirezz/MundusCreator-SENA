package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Multimedia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Imagenes.class)
public class Imagenes_ { 

    public static volatile SingularAttribute<Imagenes, String> imgRutaImg;
    public static volatile SingularAttribute<Imagenes, String> imgDescripcion;
    public static volatile SingularAttribute<Imagenes, Integer> pkImgId;
    public static volatile CollectionAttribute<Imagenes, Multimedia> multimediaCollection;

}
package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import edu.sena.entity.munduscreator.Imagenes;
import edu.sena.entity.munduscreator.Videos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Multimedia.class)
public class Multimedia_ { 

    public static volatile SingularAttribute<Multimedia, Integer> pkMulId;
    public static volatile CollectionAttribute<Multimedia, Imagenes> imagenesCollection;
    public static volatile SingularAttribute<Multimedia, String> mulDescripcion;
    public static volatile CollectionAttribute<Multimedia, Videos> videosCollection;
    public static volatile CollectionAttribute<Multimedia, Cursos> cursosCollection;

}
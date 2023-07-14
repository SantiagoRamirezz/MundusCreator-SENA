package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Papeleria;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Documentos.class)
public class Documentos_ { 

    public static volatile SingularAttribute<Documentos, String> docDescripcion;
    public static volatile SingularAttribute<Documentos, Integer> pkDocId;
    public static volatile SingularAttribute<Documentos, String> docRuta;
    public static volatile CollectionAttribute<Documentos, Papeleria> papeleriaCollection;
    public static volatile SingularAttribute<Documentos, String> docNombre;

}
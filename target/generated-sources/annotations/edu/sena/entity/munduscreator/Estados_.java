package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Mensajes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Estados.class)
public class Estados_ { 

    public static volatile SingularAttribute<Estados, Integer> pkEstId;
    public static volatile SingularAttribute<Estados, String> estDescripcion;
    public static volatile CollectionAttribute<Estados, Mensajes> mensajesCollection;

}
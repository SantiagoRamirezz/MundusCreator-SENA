package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Papeleria;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Actividades.class)
public class Actividades_ { 

    public static volatile SingularAttribute<Actividades, String> actDescripcion;
    public static volatile SingularAttribute<Actividades, Integer> pkActId;
    public static volatile SingularAttribute<Actividades, String> actNombre;
    public static volatile SingularAttribute<Actividades, String> actRuta;
    public static volatile CollectionAttribute<Actividades, Papeleria> papeleriaCollection;

}
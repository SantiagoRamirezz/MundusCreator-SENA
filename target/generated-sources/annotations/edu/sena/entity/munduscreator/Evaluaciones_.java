package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Papeleria;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Evaluaciones.class)
public class Evaluaciones_ { 

    public static volatile SingularAttribute<Evaluaciones, String> evaDescripcion;
    public static volatile SingularAttribute<Evaluaciones, Integer> pkEvaId;
    public static volatile SingularAttribute<Evaluaciones, String> evaNombre;
    public static volatile CollectionAttribute<Evaluaciones, Papeleria> papeleriaCollection;
    public static volatile SingularAttribute<Evaluaciones, String> evaRuta;

}
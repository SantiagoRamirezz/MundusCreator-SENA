package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Actividades;
import edu.sena.entity.munduscreator.Cursos;
import edu.sena.entity.munduscreator.Documentos;
import edu.sena.entity.munduscreator.Evaluaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Papeleria.class)
public class Papeleria_ { 

    public static volatile CollectionAttribute<Papeleria, Evaluaciones> evaluacionesCollection;
    public static volatile SingularAttribute<Papeleria, String> papDescripcion;
    public static volatile CollectionAttribute<Papeleria, Actividades> actividadesCollection;
    public static volatile SingularAttribute<Papeleria, Integer> pkPapId;
    public static volatile CollectionAttribute<Papeleria, Documentos> documentosCollection;
    public static volatile CollectionAttribute<Papeleria, Cursos> cursosCollection;

}
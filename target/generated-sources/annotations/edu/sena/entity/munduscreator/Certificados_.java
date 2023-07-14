package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import edu.sena.entity.munduscreator.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Certificados.class)
public class Certificados_ { 

    public static volatile SingularAttribute<Certificados, Integer> pkCerId;
    public static volatile SingularAttribute<Certificados, Usuarios> fkUsuId;
    public static volatile SingularAttribute<Certificados, Cursos> fkCurId;

}
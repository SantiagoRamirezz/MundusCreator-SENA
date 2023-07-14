package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Estados;
import edu.sena.entity.munduscreator.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Mensajes.class)
public class Mensajes_ { 

    public static volatile SingularAttribute<Mensajes, String> menFecha;
    public static volatile SingularAttribute<Mensajes, Estados> fkEstId;
    public static volatile SingularAttribute<Mensajes, Integer> pkMenId;
    public static volatile SingularAttribute<Mensajes, String> menDescripcion;
    public static volatile SingularAttribute<Mensajes, Roles> fkRolId;

}
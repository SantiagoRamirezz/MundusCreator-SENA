package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Mensajes;
import edu.sena.entity.munduscreator.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile CollectionAttribute<Roles, Mensajes> mensajesCollection;
    public static volatile SingularAttribute<Roles, Integer> pkRolId;
    public static volatile CollectionAttribute<Roles, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Roles, String> rolNombre;

}
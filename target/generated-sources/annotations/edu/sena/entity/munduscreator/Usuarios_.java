package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Certificados;
import edu.sena.entity.munduscreator.Cursos;
import edu.sena.entity.munduscreator.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> usuCorreo;
    public static volatile SingularAttribute<Usuarios, String> usuContrasenha;
    public static volatile SingularAttribute<Usuarios, String> usuFechanac;
    public static volatile SingularAttribute<Usuarios, Integer> pkUsuId;
    public static volatile CollectionAttribute<Usuarios, Certificados> certificadosCollection;
    public static volatile SingularAttribute<Usuarios, Short> usuEstado;
    public static volatile CollectionAttribute<Usuarios, Cursos> cursosCollection;
    public static volatile SingularAttribute<Usuarios, String> usuNombre;
    public static volatile SingularAttribute<Usuarios, String> usuNomusu;
    public static volatile SingularAttribute<Usuarios, String> usuFoto;
    public static volatile SingularAttribute<Usuarios, String> usuGenero;
    public static volatile SingularAttribute<Usuarios, String> usuApellido;
    public static volatile CollectionAttribute<Usuarios, Roles> rolesCollection;
    public static volatile SingularAttribute<Usuarios, String> usuTipodedato;

}
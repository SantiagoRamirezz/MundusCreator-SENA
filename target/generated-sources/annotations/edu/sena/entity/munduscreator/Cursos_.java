package edu.sena.entity.munduscreator;

import edu.sena.entity.munduscreator.Certificados;
import edu.sena.entity.munduscreator.Multimedia;
import edu.sena.entity.munduscreator.Papeleria;
import edu.sena.entity.munduscreator.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-12-15T22:37:42")
@StaticMetamodel(Cursos.class)
public class Cursos_ { 

    public static volatile SingularAttribute<Cursos, Papeleria> fkPapId;
    public static volatile SingularAttribute<Cursos, String> curImagen;
    public static volatile SingularAttribute<Cursos, Integer> pkCurId;
    public static volatile SingularAttribute<Cursos, String> curDescripcion;
    public static volatile CollectionAttribute<Cursos, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Cursos, String> curNombre;
    public static volatile SingularAttribute<Cursos, Short> curEstado;
    public static volatile SingularAttribute<Cursos, String> curFechaCreacion;
    public static volatile CollectionAttribute<Cursos, Certificados> certificadosCollection;
    public static volatile SingularAttribute<Cursos, Multimedia> fkMulId;

}
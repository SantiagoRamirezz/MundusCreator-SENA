create database if not exists `bds_mundus_creator` default character set utf8 collate utf8_general_ci;


use bds_mundus_creator;

create table `tbl_roles` (
`pk_rol_id` int(11) not null auto_increment,
`rol_nombre` varchar(50) not null,
primary key (pk_rol_id)
);


create table `tbl_usuarios` (
`pk_usu_id` int(11) not null unique,
`usu_tipodedato` varchar(20) not null,
`usu_nombre` varchar(50) not null,
`usu_apellido` varchar(50) not null,
`usu_fechanac` varchar(50) not null,
`usu_genero` varchar(60) not null,
`usu_correo` varchar(60) not null unique,
`usu_nomusu` varchar(50) not null unique,
`usu_contrasenha` varchar(50) not null,
`usu_estado` smallint(11) not null,
`usu_foto` varchar(21000) ,
primary key (pk_usu_id)
) engine=innodb default charset=utf8;


create table `tbl_usuario_rol`(
`fk_usu_id` int(11) not null ,
`fk_rol_id` int(11) not null ,
foreign key (fk_usu_id) references tbl_usuarios(pk_usu_id),
foreign key (fk_rol_id) references tbl_roles(pk_rol_id)
);


create table `tbl_estados`(
`pk_est_id` int (11) not null auto_increment,
`est_descripcion` char(50) not null,
primary key (pk_est_id)
);

create table `tbl_mensajes`(
`pk_men_id` int (11) not null auto_increment,
`men_ descripcion` char(50) not null,
`men_fecha` char(50) not null,
`fk_rol_id` int(11) not null,
`fk_est_id` int(11) not null,
primary key (pk_men_id),
foreign key (fk_rol_id)references tbl_roles (pk_rol_id),
foreign key (fk_est_id)references tbl_estados (pk_est_id)
);

create table `tbl_evaluaciones` (
`pk_eva_id`  int(11) not null auto_increment,
`eva_nombre` varchar(50) not null unique,
`eva_descripcion` varchar(450) not null,
`eva_ruta` varchar(21000) not null,
primary key (pk_eva_id)
);

create table `tbl_actividades` (
`pk_act_id`  int(11) not null auto_increment,
`act_nombre` varchar(50) not null unique,
`act_descripcion` varchar(450) not null ,
`act_ruta` varchar(21000) not null,
primary key (pk_act_id)
);


create table `tbl_documentos` (
`pk_doc_id` int(11) not null auto_increment,
`doc_nombre` varchar(50) not null unique,
`doc_descripcion` varchar(450) not null ,
`doc_ruta` varchar(21000) not null,
primary key (pk_doc_id)
);


create table `tbl_papeleria` (
`pk_pap_id` int(11) not null auto_increment,
`pap_descripcion` varchar (450) not null,
primary key (pk_pap_id)
);

create table `tbl_papeleria_documento`(
`fk_pap_id` int(11) not null ,
`fk_doc_id` int(11) not null ,
foreign key (fk_pap_id) references tbl_papeleria(pk_pap_id),
foreign key (fk_doc_id) references tbl_documentos(pk_doc_id)
);

create table `tbl_papeleria_evaluacion`(
`fk_pap_id` int(11) not null ,
`fk_eva_id` int(11) not null ,
foreign key (fk_pap_id) references tbl_papeleria(pk_pap_id),
foreign key (fk_eva_id) references tbl_evaluaciones(pk_eva_id)
);



create table `tbl_papeleria_actividad`(
`fk_pap_id` int(11) not null ,
`fk_act_id` int(11) not null ,
foreign key (fk_pap_id) references tbl_papeleria(pk_pap_id),
foreign key (fk_act_id) references tbl_actividades(pk_act_id)
);


create table `tbl_videos` (
`pk_vid_id` int(11) not null auto_increment,
`vid_ruta_video` varchar(21000) not null unique,
`vid_descripcion` varchar(255) not null,
primary key (pk_vid_id)
);



create table `tbl_imagenes` (
`pk_img_id` int(11) not null auto_increment,
`img_ruta_img` varchar(21000) not null unique,
`img_descripcion` varchar(255) not null,
primary key (pk_img_id)
);



create table `tbl_multimedia` (
`pk_mul_id` int(11) not null auto_increment,
`mul_descripcion` varchar(255) not null,
primary key (pk_mul_id)
);

create table `tbl_multimedia_imagen`(
`fk_mul_id` int(11) not null ,
`fk_img_id` int(11) not null ,
foreign key (fk_mul_id) references tbl_multimedia(pk_mul_id),
foreign key (fk_img_id) references tbl_imagenes(pk_img_id)
);

create table `tbl_multimedia_video`(
`fk_mul_id` int(11) not null ,
`fk_vid_id` int(11) not null ,
foreign key (fk_mul_id) references tbl_multimedia(pk_mul_id),
foreign key (fk_vid_id) references tbl_videos(pk_vid_id)
);



create table `tbl_cursos` (
`pk_cur_id` int(11) not null auto_increment,
`cur_nombre` varchar(100) not null unique,
`cur_fecha_creacion` varchar (30) not null,
`cur_descripcion` varchar(255) not null,
`cur_imagen` varchar(21000)  not null,
`cur_estado` smallint(11) not null,
`fk_mul_id` int(11)  ,
`fk_pap_id` int(11)  ,
primary key (pk_cur_id),
foreign key (fk_mul_id) references tbl_multimedia(pk_mul_id),
foreign key (fk_pap_id) references tbl_papeleria(pk_pap_id)
);



create table `tbl_cursos_usuarios`(
`fk_usu_id` int(11) not null,
`fk_cur_id` int(11) not null,
foreign key (fk_usu_id)references tbl_usuarios (pk_usu_id),
foreign key (fk_cur_id)references tbl_cursos (pk_cur_id)
);


create table `tbl_certificados` (
`pk_cer_id` int(11) not null auto_increment,
`fk_usu_id` int(11) not null ,
`fk_cur_id` int(11) not null ,
primary key (pk_cer_id),
foreign key (fk_usu_id)references tbl_usuarios (pk_usu_id),
foreign key (fk_cur_id)references tbl_cursos (pk_cur_id)
);


create table `tbl_notas` (
`fk_usu_id` int(11) not null ,
`fk_cur_id` int(11) not null ,
`not_estado` varchar(30)  ,
foreign key (fk_usu_id) references tbl_usuarios(pk_usu_id),
foreign key (fk_cur_id) references tbl_cursos(pk_cur_id)
);


insert into tbl_roles (pk_rol_id, rol_nombre) 
values (1,'Estudiante'),(2,'Administrador');

 




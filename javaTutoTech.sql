--TABLA ROLE--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbROLE (
idRole NUMBER GENERATED AS IDENTITY START WITH 1 INCREMENT BY 1 PRIMARY KEY,
nombreRole VARCHAR2(25) CHECK (nombreRole IN ('admin', 'tutor', 'tutorado'))
);

-- Insercion de datos en la tabla tbROLE
INSERT INTO tbROLE (nombreRole) VALUES ('admin');
INSERT INTO tbROLE (nombreRole) VALUES ('tutor');
INSERT INTO tbROLE (nombreRole) VALUES ('tutorado');

--Procedimientos almacenados para eliminar datos en la tabla tbROLE--
CREATE OR REPLACE PROCEDURE eliminar_role (
    p_nombreRole in tbROLE.nombreRole%type
) AS
BEGIN
DELETE FROM tbROLE WHERE nombreRole = p_nombreRole;
END;

-- Eliminación de datos en la tabla tbROLE
BEGIN
eliminar_role('admin');
eliminar_role('tutor');
eliminar_role('tutorado');
END;

select * from tbROLE;
drop table tbROLE;
delete from tbROLE;
 
--TABLA USUARIO------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbUsuario (
idUsuario VARCHAR2(100) PRIMARY KEY,
nombreUsuario VARCHAR2(15) NOT NULL,
edadUsuario INT NOT NULL,
correoUsuario VARCHAR2(200) NOT NULL UNIQUE,
contrasenaUsuario VARCHAR2(100) NOT NULL,
fotoUsuario VARCHAR2(1000), -- Foto de perfil
idRole NUMBER NOT NULL,
 
CONSTRAINT FK_Role FOREIGN KEY (idRole) REFERENCES tbROLE(idRole)
);

-- Inserciones a la tabla tbUsuario
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, fotoUsuario, idRole) 
VALUES ('aB3#xY9!', 'calolin123', 20, '20220482@ricaldone.edu.sv', 'contrasena123', null, 1);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, fotoUsuario, idRole) 
VALUES ('7z@Q2w$L', 'pbl.l55__', 29, '20200135@ricaldone.edu.sv', 'hormigaatomica', null, 2);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, fotoUsuario, idRole) 
VALUES ('mN8*5pZ', 'mrPatoo', 42, '20230333@ricaldone.edu.sv', '321senacontra', null, 2);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, fotoUsuario, idRole) 
VALUES ('4R^t1U%v', 'rafa-vargas', 19, '20230402@ricaldone.edu.sv', 'fanta457', null, 3);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, fotoUsuario, idRole) 
VALUES ('j6!H3s#P', 'steveen07__', 18, '20220721@ricaldone.edu.sv', 'bdtiendamusica', null, 3);


--Comando para iniciar sesión en la aplicación de Java 
update tbUsuario set contrasenaUsuario = 'fe3a646a168c88a7ad70522485aed3c74d0cb7223bf5a5274d26c8a09f743e7b' where correoUsuario = '20220721@ricaldone.edu.sv';
commit;

--Comando para iniciar sesión en la aplicación de Android
update tbUsuario set contrasenaUsuario = '' where correUsuario = '20220721@ricaldone.edu.sv';

--Procedimientos almacenados para eliminar datos en la tabla tbUsuario
CREATE OR REPLACE PROCEDURE eliminar_usuario (
    p_idUsuario in tbUsuario.idUsuario%type
) AS
BEGIN
DELETE FROM tbUsuario WHERE idUsuario = p_idUsuario;
END;

--Eliminacion de datos en la tabla tbUsuario
BEGIN
eliminar_usuario('aB3#xY9!');
eliminar_usuario('7z@Q2w$L');
eliminar_usuario('mN8*5p&Z');
eliminar_usuario('4R^t1U%v');
eliminar_usuario('j6!H3s#P');
END;

drop procedure eliminar_usuario
select * from tbUsuario;
drop table tbUsuario;
delete from tbUsuario;

--TABLA TUTORIA------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbTutoria (
idTutoria VARCHAR2(100) PRIMARY KEY,
nombreTutoria VARCHAR2(50) NOT NULL,
descripcionTutoria VARCHAR2(200) NOT NULL,
imagenTutoria VARCHAR2(1000), -- Foto de la tutoria
idUsuario VARCHAR2(100),
 
CONSTRAINT FK_Usuario FOREIGN KEY (idUsuario) REFERENCES tbUsuario(idUsuario) ON DELETE CASCADE
);

-- Inserciones a la tabla tbTutoria
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('fB7#xY1!', 'Tutoria de Matematicas', 'En esta tutoria aprenderas sobre algebra', NULL, 'aB3#xY9!');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('9z@Q8w$L', 'Tutoria de Fisica', 'En esta tutoria aprenderas sobre conceptos basicos de la fisica', NULL, '7z@Q2w$L');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('d6!H2s#P', 'Tutoria de Quimica', 'En esta tutoria aprenderas sobre conceptos basicos de la quimica', NULL, 'mN8*5p&Z');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('8R^t4U%v', 'Tutoria de Historia', 'En esta tutoria aprenderas sobre periodos de tiempo', NULL, '4R^t1U%v');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('nN6*3p&K', 'Tutoria de Literatura', 'En esta tutoria aprenderas sobre conceptos obras literarias', NULL, 'j6!H3s#P');

--Procedimiento almacenado para eliminar datos en tbTutoria
CREATE OR REPLACE PROCEDURE eliminar_tutoria (
    p_idTutoria in tbTutoria.idTutoria%type
) AS
BEGIN
DELETE FROM tbTutoria WHERE idTutoria = p_idTutoria;
END;

--Eliminacion de datos en la tabla tbTutoria
BEGIN
eliminar_tutoria('fB7#xY1!');
eliminar_tutoria('9z@Q8w$L');
eliminar_tutoria('d6!H2s#P');
eliminar_tutoria('8R^t4U%v');
eliminar_tutoria('nN6*3p&K');
END;
    
select * from tbTutoria;
drop table tbTutoria;
delete from tbTutoria;

--TABLA LECCION------------------------------------------------------------------------------------------------------------------------------------------------ 
CREATE TABLE tbLeccion (
idLeccion VARCHAR2(100) PRIMARY KEY,
tituloLeccion VARCHAR2(100) NOT NULL,
fechaLeccion DATE NOT NULL,
contenidoLeccion VARCHAR2(2000) NOT NULL,
statusLeccion NUMBER(1) NOT NULL  CHECK (statusLeccion IN (0,1)),
idTutoria VARCHAR2(100) NOT NULL,
 
CONSTRAINT FK_Tutoria FOREIGN KEY (idTutoria) REFERENCES tbTutoria(idTutoria)
);
 
--Inserciones a la tabla tbLeccion
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria)
VALUES ('0123456789', 'Introduccion a Matematicas', TO_DATE('2024-07-01', 'YYYY-MM-DD'), 'Contenido de la leccion de introduccion a matematicas.', 1, 'fB7#xY1!');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria)
VALUES ('H#23I@', 'Fisica Basica', TO_DATE('2024-07-02', 'YYYY-MM-DD'), 'Contenido de la leccion de fisica basica.', 1, '9z@Q8w$L');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria)
VALUES ('F*01G$', 'Quimica Organica', TO_DATE('2024-07-03', 'YYYY-MM-DD'), 'Contenido de la leccion de quimica organica.', 1, 'd6!H2s#P');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria)
VALUES ('D@89E&', 'Historia Mundial', TO_DATE('2024-07-04', 'YYYY-MM-DD'), 'Contenido de la leccion de historia mundial.', 1, '8R^t4U%v');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria)
VALUES ('B%67C*', 'Literatura Clasica', TO_DATE('2024-07-05', 'YYYY-MM-DD'), 'Contenido de la leccion de literatura clasica.', 1, 'nN6*3p&K');

--Procedimiento almacenado para eliminar datos en la tabla tbLeccion
CREATE OR REPLACE PROCEDURE eliminar_leccion (
    p_idLeccion in tbLeccion.idLeccion%type
) AS
BEGIN
DELETE FROM tbLeccion WHERE idLeccion = p_idLeccion;
END;

--Eliminacion de datos en tbLeccion
BEGIN
eliminar_leccion('0123456789');
eliminar_leccion('H#23I@');
eliminar_leccion('F*01G$');
eliminar_leccion('D@89E&');
eliminar_leccion('B%67C*');
END;

select * from tbLeccion;
drop table tbLeccion;
delete from tbLeccion;

--RECORDATORIO--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbRecordatorio (
idRecordatorio VARCHAR2(100) PRIMARY KEY,
nombreRecordatorio VARCHAR2(100) NOT NULL,
fechaRecordatorio DATE NOT NULL,
detalleRecordatorio VARCHAR2(300) NOT NULL,
idLeccion VARCHAR2(100) NOT NULL,
 
CONSTRAINT FK_Leccion FOREIGN KEY (idLeccion) REFERENCES tbLeccion(idLeccion)
);
 
-- Inserciones a la tabla tbRecordatorio
INSERT INTO tbRecordatorio (idRecordatorio, nombreRecordatorio, fechaRecordatorio, detalleRecordatorio, idLeccion) 
VALUES ('2nsj', 'Recordatorio 1', TO_DATE('2024-09-05', 'YYYY-MM-DD'), 'Desarrollo del examen de matemáticas', '0123456789');
INSERT INTO tbRecordatorio (idRecordatorio, nombreRecordatorio, fechaRecordatorio, detalleRecordatorio, idLeccion) 
VALUES ('23dsb2', 'Recordatorio 2', TO_DATE('2024-09-10', 'YYYY-MM-DD'), 'Completar el cuestionario de ondas', 'H#23I@');
INSERT INTO tbRecordatorio (idRecordatorio, nombreRecordatorio, fechaRecordatorio, detalleRecordatorio, idLeccion) 
VALUES ('dsb94', 'Recordatorio 3', TO_DATE('2024-09-03', 'YYYY-MM-DD'), 'Leer el manual de quimica organica', 'F*01G$');
INSERT INTO tbRecordatorio (idRecordatorio, nombreRecordatorio, fechaRecordatorio, detalleRecordatorio, idLeccion) 
VALUES ('ds0nd3', 'Recordatorio 4', TO_DATE('2024-08-28', 'YYYY-MM-DD'), 'Realizar la investigacion sobre la historia de El Salvador', 'D@89E&');
INSERT INTO tbRecordatorio (idRecordatorio, nombreRecordatorio, fechaRecordatorio, detalleRecordatorio, idLeccion) 
VALUES ('cb37kq', 'Recordatorio 5', TO_DATE('2024-09-07', 'YYYY-MM-DD'), 'Leer la obra de literatura', 'B%67C*');

--Procedimientos almacenados para eliminar datos en la tabla tbRecordatorio
CREATE OR REPLACE PROCEDURE eliminar_recordatorio (
    p_idRecordatorio in tbRecordatorio.idRecordatorio%type
) AS
BEGIN
DELETE FROM tbRecordatorio WHERE idRecordatorio = p_idRecordatorio;
END;

--Eliminacion de datos en la tabla tbRecordatorio
BEGIN
eliminar_recordatorio('2nsj');
eliminar_recordatorio('23dsb2');
eliminar_recordatorio('dsb94');
eliminar_recordatorio('ds0nd3');
eliminar_recordatorio('cb37kq');
END;

select * from tbRecordatorio;
drop table tbRecordatorio;
delete from tbRecordatorio;

--TABLA AUDITORIA-----------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbAuditoria (
    idAuditoria NUMBER GENERATED AS IDENTITY START WITH 1 INCREMENT BY 1 PRIMARY KEY,
    fechaAuditoria TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    tipoAccion VARCHAR2(10) CHECK (tipoAccion IN ('INSERT', 'DELETE')) NOT NULL,
    tablaAfectada VARCHAR2(50) NOT NULL,
    idRegistroAfectado VARCHAR2(100) NOT NULL, 
    idUsuario VARCHAR2(100),
    descripcionAccion VARCHAR2(500),
    
CONSTRAINT FK_Usuario2 FOREIGN KEY (idUsuario) REFERENCES tbUsuario(idUsuario)
);

--Procedimiento almacenado para eliminar datos en la tabla de auditoria
CREATE OR REPLACE PROCEDURE eliminar_auditoria (
    p_tipoAccion in tbAuditoria.tipoAccion%type
) AS
BEGIN
DELETE FROM tbAuditoria WHERE tipoAccion = p_tipoAccion;
END;

--Eliminacion de datos en la tabla de auditoria
BEGIN
eliminar_auditoria('');
eliminar_auditoria('');
eliminar_auditoria('');
eliminar_auditoria('');
eliminar_auditoria('');
END;

select * from tbAuditoria;
drop table tbAuditoria;
delete from tbAuditoria;

--Este trigger se dispara despues de una insercion en la tabla tbTutoria y registra la nueva informacion en la tabla auditoria.
CREATE OR REPLACE TRIGGER trigTUTOINS AFTER INSERT ON tbTutoria FOR EACH ROW
BEGIN
    INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, idUsuario, descripcionAccion)
    VALUES ('INSERT', 'tbTutoria', :NEW.idTutoria, :NEW.idUsuario, 'Inserción de una nueva tutoría');
END;

--Este trigger se dispara despues de una eliminación en la tabla tbTutoria y registra la informacion anterior en la tabla auditoria.
CREATE OR REPLACE TRIGGER trigTUTODEL AFTER DELETE ON tbTutoria FOR EACH ROW
BEGIN
    INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, idUsuario, descripcionAccion)
    VALUES ('DELETE', 'tbTutoria', :OLD.idTutoria, :OLD.idUsuario, 'Eliminación de una tutoria');
END;

 
--Union de las tablas tbUsuario y tbTutoria en una sola tabla donde el idRole representa a los tutores
SELECT  u.nombreUsuario,  u.correoUsuario,  tu.nombreTutoria, tu.descripcionTutoria
FROM  tbUsuario u INNER JOIN  tbTutoria tu ON u.idUsuario = tu.idUsuario WHERE u.idRole = 2;
 
--Union de las tablas tbLeccion y tbRecordatorio en una sola tabla
SELECT l.tituloLeccion, l.fechaLeccion, l.contenidoLeccion, l.statusLeccion, r.nombreRecordatorio, r.fechaRecordatorio, r.detalleRecordatorio
FROM tbLeccion l INNER JOIN tbrecordatorio r ON l.idLeccion = r.idLeccion;
 
--Prueba con left join usando tbUsuario y tbTutorado 
--(Supongamos que quieres obtener una lista de todos los tutorados y sus tutorias, incluyendo 
--aquellos tutorados que no tienen tutorias asignadas.)
SELECT u.nombreUsuario, tu.nombreTutoria
FROM tbUsuario u LEFT JOIN  tbTutoria tu ON u.idUsuario = tu.idUsuario WHERE u.idRole = 3;
 
--Prueba con right join usando tbUsuario y tbTutorado 
--(Supongamos que quieres obtener una lista de todas las tutorias y los tutorados asignados a ellas,
--incluyendo aquellas tutor?as que no tienen tutorados asignados.)
SELECT u.nombreUsuario, tu.nombreTutoria
FROM tbUsuario u RIGHT JOIN tbTutoria tu ON tu.idUsuario = u.idUsuario WHERE u.idRole = 3;

create table tbRegistroCodigo(
    correo varchar2(200) not null,
    codigo varchar2(20) not null,
    estado char(1) not null,
    primary key(correo, codigo)
); 

--TABLA ROLE--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbROLE (
idRole NUMBER GENERATED AS IDENTITY START WITH 1 INCREMENT BY 1 PRIMARY KEY, -- Aquí se incluye el auto-incremento
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
idRole NUMBER NOT NULL,
 
CONSTRAINT FK_Role FOREIGN KEY (idRole) REFERENCES tbROLE(idRole)
);

-- Inserciones a la tabla tbUsuario
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, idRole) 
VALUES ('aB3#xY9!', 'calolin123', 20, '20220482@ricaldone.edu.sv', 'contrasena123', 1);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, idRole) 
VALUES ('7z@Q2w$L', 'pbl.l55__', 29, '20200135@ricaldone.edu.sv', 'hormigaatomica', 2);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, idRole) 
VALUES ('mN8*5pZ', 'mrPatoo', 42, '20230333@ricaldone.edu.sv', '321senacontra', 2);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, idRole) 
VALUES ('4R^t1U%v', 'rafa-vargas', 19, '20230402@ricaldone.edu.sv', 'fanta457', 3);
INSERT INTO tbUsuario (idUsuario, nombreUsuario, edadUsuario, correoUsuario, contrasenaUsuario, idRole) 
VALUES ('j6!H3s#P', 'steveen07__', 18, '20220721@ricaldone.edu.sv', 'bdtiendamusica', 3);

--Comando para iniciar sesión en la aplicación de Java o Android (Solo ejecutar si se va a testear)
update tbUsuario set contrasenaUsuario = 'fe3a646a168c88a7ad70522485aed3c74d0cb7223bf5a5274d26c8a09f743e7b' where correoUsuario = '20220721@ricaldone.edu.sv';
commit;

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

select * from tbUsuario;
drop table tbUsuario;
delete from tbUsuario;

--TABLA TUTORIA------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbTutoria (
idTutoria VARCHAR2(100) PRIMARY KEY,
nombreTutoria VARCHAR2(50) NOT NULL,
descripcionTutoria VARCHAR2(200) NOT NULL,
imagenTutoria VARCHAR2(300),
idUsuario VARCHAR2(100),
 
CONSTRAINT FK_Usuario FOREIGN KEY (idUsuario) REFERENCES tbUsuario(idUsuario) ON DELETE CASCADE
);

-- Inserciones a la tabla tbTutoria
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('fB7#xY1!', 'Tutoria de Matematicas', 'En esta tutoria aprenderas sobre algebra', null, 'aB3#xY9!');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('9z@Q8w$L', 'Tutoria de Fisica', 'En esta tutoria aprenderas sobre conceptos basicos de la fisica', null, '7z@Q2w$L');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('d6!H2s#P', 'Tutoria de Quimica', 'En esta tutoria aprenderas sobre conceptos basicos de la quimica', null, 'mN8*5p&Z');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('8R^t4U%v', 'Tutoria de Historia', 'En esta tutoria aprenderas sobre periodos de tiempo', null, '4R^t1U%v');
INSERT INTO tbTutoria (idTutoria, nombreTutoria, descripcionTutoria, imagenTutoria, idUsuario)
VALUES ('nN6*3p&K', 'Tutoria de Literatura', 'En esta tutoria aprenderas sobre conceptos obras literarias', null, 'j6!H3s#P');

UPDATE tbTutoria SET imagenTutoria = SYS_GUID();

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
fechaLeccion VARCHAR2(100) NOT NULL,
contenidoLeccion VARCHAR2(2000) NOT NULL,
statusLeccion INT NOT NULL CHECK (statusLeccion IN (1,2)),
idTutoria VARCHAR2(100),
idUsuario VARCHAR2(100),
 
CONSTRAINT FK_Tutoria FOREIGN KEY (idTutoria) REFERENCES tbTutoria(idTutoria),
CONSTRAINT FK_Usuario2 FOREIGN KEY (idUsuario) REFERENCES tbUsuario(idUsuario)
);
 
--Inserciones a la tabla tbLeccion
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria, idUsuario)
VALUES ('0123456789', 'Introduccion a Matematicas', '2024-07-01', 'Contenido de la leccion de introduccion a matematicas.', 1, 'fB7#xY1!', 'aB3#xY9!');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria, idUsuario)
VALUES ('H#23I@', 'Fisica Basica', '2024-07-02', 'Contenido de la leccion de fisica basica.', 1, '9z@Q8w$L', '7z@Q2w$L');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria, idUsuario)
VALUES ('F*01G$', 'Quimica Organica', '2024-07-03', 'Contenido de la leccion de quimica organica.', 1, 'd6!H2s#P', 'mN8*5p&Z');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria, idUsuario)
VALUES ('D@89E&', 'Historia Mundial', '2024-07-04', 'Contenido de la leccion de historia mundial.', 1, '8R^t4U%v', '4R^t1U%v');
INSERT INTO tbLeccion (idLeccion, tituloLeccion, fechaLeccion, contenidoLeccion, statusLeccion, idTutoria, idUsuario)
VALUES ('B%67C*', 'Literatura Clasica', '2024-07-05', 'Contenido de la leccion de literatura clasica.', 1, 'nN6*3p&K', 'j6!H3s#P');

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

--TABLA AUDITORIA-----------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE tbAuditoria (
idAuditoria NUMBER GENERATED AS IDENTITY START WITH 1 INCREMENT BY 1 PRIMARY KEY,
fechaAuditoria TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
tipoAccion VARCHAR2(10) CHECK (tipoAccion IN ('INSERT', 'DELETE')) NOT NULL,
tablaAfectada VARCHAR2(50) NOT NULL,
idRegistroAfectado VARCHAR2(100) NOT NULL, 
idUsuario VARCHAR2(100),
descripcionAccion VARCHAR2(500),
    
CONSTRAINT FK_Usuario3 FOREIGN KEY (idUsuario) REFERENCES tbUsuario(idUsuario)
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
eliminar_auditoria(1);
eliminar_auditoria(2);
eliminar_auditoria(3);
eliminar_auditoria(4);
eliminar_auditoria(5);
END;

select * from tbAuditoria;
drop table tbAuditoria;
delete from tbAuditoria;

--Este trigger se dispara despues de una insercion en la tabla tbTutoria y registra la nueva informacion en la tabla tbAuditoria.
CREATE OR REPLACE TRIGGER trigTUTOINS AFTER INSERT ON tbTutoria FOR EACH ROW
BEGIN
    INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, idUsuario, descripcionAccion)
    VALUES ('INSERT', 'tbTutoria', :NEW.idTutoria, :NEW.idUsuario, 'Inserción de una nueva tutoría');
END;

--Este trigger se dispara despues de una eliminacion en la tabla tbTutoria y registra la informacion anterior en la tabla tbAuditoria.
CREATE OR REPLACE TRIGGER trigTUTODEL AFTER DELETE ON tbTutoria FOR EACH ROW
BEGIN
    INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, idUsuario, descripcionAccion)
    VALUES ('DELETE', 'tbTutoria', :OLD.idTutoria, :OLD.idUsuario, 'Eliminación de una tutoria');
END;

--Este trigger se dispara despues de una insercion en la tabla tbLeccion y registra la nueva informacion en la tabla tbAuditoria.
CREATE OR REPLACE TRIGGER trigLECINS AFTER INSERT ON tbLeccion FOR EACH ROW
BEGIN
    INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, idUsuario, descripcionAccion)
    VALUES ('INSERT', 'tbLeccion', :NEW.idLeccion, :NEW.idUsuario, 'Inserción de una nueva leccion');
END;

--Este trigger se dispara despues de una eliminacion en la tabla tbLeccion y registra la nueva informacion en la tabla tbAuditoria.
CREATE OR REPLACE TRIGGER trigLECDEL AFTER INSERT ON tbLeccion FOR EACH ROW
BEGIN
    INSERT INTO tbAuditoria (tipoAccion, tablaAfectada, idRegistroAfectado, idUsuario, descripcionAccion)
    VALUES ('DELETE', 'tbLeccion', :NEW.idLeccion, :NEW.idUsuario, 'Eliminación de una leccion');
END;

--Union de las tablas tbUsuario y tbTutoria en una sola tabla donde el idRole representa a los tutores
SELECT  u.nombreUsuario,  u.correoUsuario,  tu.nombreTutoria, tu.descripcionTutoria
FROM  tbUsuario u INNER JOIN  tbTutoria tu ON u.idUsuario = tu.idUsuario WHERE u.idRole = 2;
 
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

CREATE TABLE tbRegistroCodigo(
correo VARCHAR2(200) NOT NULL,
codigo VARCHAR2(20) NOT NULL,
estado CHAR(1) NOT NULL,
PRIMARY KEY(correo, codigo)
); 

select * from tbRegistroCodigo;
drop table tbRegistroCodigo;
delete from tbRegistroCodigo;

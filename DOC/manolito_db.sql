CREATE TABLE Permisos(
    nombre VARCHAR2(15) NOT NULL PRIMARY KEY
);

CREATE TABLE Estados(
    estado CHAR(1)NOT NULL PRIMARY KEY,
    descipcion VARCHAR(50) NULL
);

CREATE TABLE Empleados(das VARCHAR2(15) NOT NULL PRIMARY KEY,
                    password VARCHAR2(20) NOT NULL,
                    nombre VARCHAR2(20) NOT NULL,
                    apellido VARCHAR2(40) NOT NULL,
                    email VARCHAR2(40) NULL,
                    estado CHAR NOT NULL,
                    permiso VARCHAR(15) NOT NULL,
                    CONSTRAINT FK_EstadoEmpleado FOREIGN KEY (estado)
                    REFERENCES Estados(estado),
                    CONSTRAINT FK_PermisoEmpleado FOREIGN KEY (permiso)
                    REFERENCES Permisos(nombre)
                    );

ALTER TABLE Empleados ADD FOREIGN KEY (estado) REFERENCES Estados(estado);
                    
                    
CREATE TABLE Tareas(
                    nombre VARCHAR2(15) NOT NULL PRIMARY KEY,
                    descripcion VARCHAR2(50) NOT NULL,
                    estado CHAR NOT NULL);/*No me ha aceptado BOOLEAN como tipo de dato*/

ALTER TABLE Tareas ADD FOREIGN KEY (estado) REFERENCES Estados(estado);
					
                    

insert into permisos values("admin");
insert into permisos values("basico");


/*insert into empleados values('c00001', 'pepe', 'pepe', 'pepe', 'pepe@p.es', 'i', 'b');*/

insert into estados values('a','Usuario activo.Puede acceder a la aplicación');
insert into estados values('i','Usuario inactivo.No puede acceder a la aplicación');
insert into estados values('n','Usuario nuevo.Necesita una nueva contraseña');

insert into permisos values("admin");
insert into permisos values("basico");
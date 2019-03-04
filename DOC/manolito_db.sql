CREATE TABLE Permisos(
    nombre VARCHAR2(15) NOT NULL PRIMARY KEY
);

CREATE TABLE Empleados(das VARCHAR2(15) NOT NULL PRIMARY KEY,
                    password VARCHAR2(20) NOT NULL,
                    nombre VARCHAR2(20) NOT NULL,
                    apellido VARCHAR2(40) NOT NULL,
                    email VARCHAR2(40) NULL,
                    estado CHAR NOT NULL,
                    permiso VARCHAR(15) NOT NULL,
                    CONSTRAINT FK_PermisoEmpleado FOREIGN KEY (permiso)
                    REFERENCES Permisos(nombre)
                    );
                    
                    
CREATE TABLE Tareas(
                    nombre VARCHAR2(15) NOT NULL PRIMARY KEY,
                    descripcion VARCHAR2(50) NOT NULL,
                    estado CHAR NOT NULL);/*No me ha aceptado BOOLEAN como tipo de dato*/
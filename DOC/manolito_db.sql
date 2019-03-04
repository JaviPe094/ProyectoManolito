/*  Usuario: manolito_db
    Password: manolito
    Conexión: manolito_db
*/


CREATE TABLE Empleado(das VARCHAR2 NOT NULL PRIMARY KEY,
                    password VARCHAR2 NOT NULL,
                    nombre VARCHAR2 NOT NULL,
                    apellido VARCHAR2,
                    email VARCHAR2 NULL,
                    estado CHAR NOT NULL);
                    
                    
CREATE TABLE Tarea(nombre VARCHAR2 NOT NULL PRIMARY KEY,
                    descripcion VARCHAR2 NOT NULL PRIMARY KEY,
                    estado BOOLEAN DEFAULT 0 NOT NULL);
                    
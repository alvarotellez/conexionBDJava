CREATE DATABASE ejemplo
GO
USE ejemplo
GO

CREATE TABLE EMPLEADOS(
		idEmpleado int identity(0,1),
		nombre VARCHAR(20),
		apellidos VARCHAR(30),
		fecha_nac DATE,
		CONSTRAINT PK_EMPLEADOS PRIMARY KEY(idEmpleado)
)

--DROP TABLE EMPLEADOS
--DROP DATABASE EJEMPLO
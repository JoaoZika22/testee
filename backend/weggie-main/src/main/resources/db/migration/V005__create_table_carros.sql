IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='carros' and xtype='U')

create table carros (
id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
km VARCHAR (50) NULL,
ano VARCHAR (5),
modelo VARCHAR (50),
nomeCarro VARCHAR (50),
marca VARCHAR (50),
cor VARCHAR (50),
placa VARCHAR (10),
tipoCombustivel VARCHAR (15),
)


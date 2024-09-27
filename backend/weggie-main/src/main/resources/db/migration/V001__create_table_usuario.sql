IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='usuarios' and xtype='U')

create table usuarios(
                         id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
                         nome VARCHAR(45) NOT NULL,
                         sobrenome VARCHAR(45) ,
                         email VARCHAR(45) ,
                         senha VARCHAR(250) ,
                         cod_status_usuario BIT NULL,
                         cpf VARCHAR (100) ,
                         cep VARCHAR (100) ,
                         rua VARCHAR (100) ,
                         bairro VARCHAR (100) ,
                         cidade VARCHAR (100) ,
                         estado VARCHAR (100) ,
                         numero VARCHAR (100) ,
                         complemento VARCHAR (100) ,
                         data_nascimento DATETIME,
                         telefone VARCHAR (100) ,
                         unique(email)
)

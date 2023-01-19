DROP TABLE IF EXISTS enderecos;
DROP TABLE IF EXISTS pessoas;

CREATE TABLE pessoas(
    id          BIGINT          AUTO_INCREMENT 	PRIMARY KEY  	,
    nome        VARCHAR(200)	NOT NULL                		,
    nascimento  DATE            NOT NULL
);

CREATE TABLE enderecos(
	id          BIGINT          AUTO_INCREMENT 	PRIMARY KEY  	,
    logradouro  VARCHAR(255)	NOT NULL    					,
    cep        	VARCHAR(8)    	NOT NULL               			,
    numero  	VARCHAR(30)     NULL							,
    cidade		VARCHAR(65)		NOT NULL						,
    principal	INT(1)		    NOT NULL						,
    id_pessoa	BIGINT			NOT NULL						,
    FOREIGN KEY	(id_pessoa)		REFERENCES pessoas (id)
);
DROP TABLE IF EXISTS enderecos;
DROP TABLE IF EXISTS pessoas;

CREATE TABLE pessoas(
    id          BIGINT          AUTO_INCREMENT 	PRIMARY KEY  	,
    nome        VARCHAR(255)	NOT NULL                		,
    nascimento  DATE            NOT NULL
);

CREATE TABLE enderecos(
	id          BIGINT          AUTO_INCREMENT 	PRIMARY KEY  	,
    logradouro  VARCHAR(255)	NOT NULL    					,
    cep        	VARCHAR(8)    	NOT NULL               			,
    numero  	VARCHAR(30)     NULL							,
    cidade		VARCHAR(65)		NOT NULL						,
    tipo		VARCHAR(30)		NULL							,
    id_pessoa	BIGINT			NOT NULL						,
    FOREIGN KEY	(id_pessoa)		REFERENCES pessoas (id)
);

INSERT INTO pessoas (nome, nascimento) VALUES('Erik Gonzaga de Souza', '1987-11-06');
INSERT INTO pessoas (nome, nascimento) VALUES('Vermelho Treze', '1959-05-15');


INSERT INTO enderecos (logradouro, cep, numero, cidade, tipo, id_pessoa)
VALUES('Rua Abura', '02542110', '641 A', 'São Paulo', 'Residencial', 1);

INSERT INTO enderecos (logradouro, cep, numero, cidade, tipo, id_pessoa)
VALUES('Avenida Paulista', '02900190', '5238', 'São Paulo', 'Comercial', 1);

INSERT INTO enderecos (logradouro, cep, numero, cidade, tipo, id_pessoa)
VALUES('Rua Jordanesia', '02850110', '2', 'São Pedro', 'Residencial', 2);

INSERT INTO enderecos (logradouro, cep, numero, cidade, tipo, id_pessoa)
VALUES('Avenida das Conchas', '05832010', '59', 'São Pedro', 'Comercial', 2);
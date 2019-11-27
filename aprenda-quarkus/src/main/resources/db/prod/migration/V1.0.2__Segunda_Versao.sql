
-- Drop table

-- DROP TABLE public.pessoa;

CREATE TABLE pessoa (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	tipo int4 NULL,
	CONSTRAINT pessoa_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.produto;

CREATE TABLE produto (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.usuario;

CREATE TABLE usuario (
	id int8 NOT NULL,
	dataatualizacaodados timestamp NULL,
	idade int8 NULL,
	nome varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

create TABLE autor (
	id int8 NOT NULL,
	nome varchar(255) NOT NULL,
	sobrenomes varchar(255) NOT NULL,
	CONSTRAINT autor_pkey PRIMARY KEY (id)

);

create TABLE livro (
	id int8 NOT NULL,
	titulo varchar(255) NOT NULL,
	conteudo varchar(1000) NOT NULL,
	autor int8 NOT NULL,
	CONSTRAINT livro_pkey PRIMARY KEY (id),
	FOREIGN KEY (autor) REFERENCES autor(id)

);


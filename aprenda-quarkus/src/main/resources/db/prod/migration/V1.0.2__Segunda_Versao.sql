
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

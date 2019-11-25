-- Drop table

-- DROP TABLE public.animal;

CREATE TABLE animal (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	peso int4 NULL,
	CONSTRAINT animal_pkey PRIMARY KEY (id)
);


-- Drop table

-- DROP TABLE public.municipio;

CREATE TABLE municipio (
	id int4 NOT NULL,
	iduf int4 NULL,
	nome varchar(255) NULL,
	CONSTRAINT municipio_pkey PRIMARY KEY (id)
);


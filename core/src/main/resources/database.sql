create database star_wars;

create extension "uuid-ossp";

CREATE TABLE IF NOT EXISTS localizacao(
	id bigserial unique,
	nome varchar(75),
	latitude decimal(5,5),
	longitude decimal(5,5)
);

CREATE TABLE IF NOT EXISTS rebelde(
	id bigserial unique,
	localizacao_id bigint NOT NULL REFERENCES localizacao(id),
	nome varchar(75),
	idade int,
	genero varchar (75),
	traidor boolean default false
);
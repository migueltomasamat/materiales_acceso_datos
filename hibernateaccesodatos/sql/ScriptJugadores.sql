DROP TABLE equipo CASCADE CONSTRAINTS;
DROP TABLE jugador CASCADE CONSTRAINTS;
DROP TABLE lesion  CASCADE CONSTRAINTS;
DROP TABLE entrenador  CASCADE CONSTRAINTS;
DROP TABLE jugador_lesion  CASCADE CONSTRAINTS;

CREATE TABLE equipo (
	codigo_eq NUMBER(2),
	nombre_eq varchar2(30),
	ciudad varchar2(30),
	division varchar2(9),
	conferencia varchar2(5),
	codigo_ent_eq NUMBER(5),
	CONSTRAINT pk_eq PRIMARY KEY (codigo_eq),
	CONSTRAINT uk_eq UNIQUE (codigo_ent_eq)
);

CREATE TABLE jugador (
	codigo_jug NUMBER(5),
	nombre varchar2(30),
	posicion NUMBER(2),
	peso NUMBER(4,1),
	fecha_nac date,
	codigo_eq_jug NUMBER(2),
	CONSTRAINT pk_jug PRIMARY KEY (codigo_jug)
);

CREATE TABLE lesion(
	codigo_les NUMBER(5),
	nombre varchar2(50),
	tiempo_rec NUMBER(5),
	CONSTRAINT pk_les PRIMARY KEY (codigo_les)
);

CREATE TABLE entrenador(
	codigo_ent NUMBER(5),
	nombre varchar2(30),
	edad NUMBER(3),
	CONSTRAINT pk_entrenador PRIMARY KEY (codigo_ent)
);

CREATE TABLE jugador_lesion(
	codigo_jug_jl NUMBER(5),
	codigo_les_jl NUMBER(5),
	CONSTRAINT pk_jl PRIMARY KEY (codigo_jug_jl,codigo_les_jl)
);

ALTER TABLE jugador ADD CONSTRAINT fk_jug_eq FOREIGN KEY (codigo_eq_jug) REFERENCES equipo(codigo_eq);
ALTER TABLE jugador_lesion ADD CONSTRAINT fk_jl_jug FOREIGN KEY (codigo_jug_jl) REFERENCES jugador(codigo_jug);
ALTER TABLE jugador_lesion ADD CONSTRAINT fk_jl_les FOREIGN KEY (codigo_les_jl) REFERENCES lesion(codigo_les);
ALTER TABLE equipo ADD CONSTRAINT fk_eq_ent FOREIGN KEY (codigo_ent_eq) REFERENCES entrenador(codigo_ent);

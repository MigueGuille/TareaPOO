 CREATE DATABASE Bd_Videojuegos;
 
 create table videojuego(
	id SERIAL not null primary key,
	Nombre varchar(50),
 	Genero varchar(50),
 	Año varchar(50)
  );

-- INSERTAR
INSERT INTO videojuego (Nombre, Genero, Año)  values ('Mario Kart 8 Deluxe', 'Carreras', '2017');

-- MOSTRAR 
SELECT * FROM videojuego;

-- ACTUALIZAR 
UPDATE videojuego SET Nombre='Pokemon', Genero= 'Aventura',Año='1994' WHERE videojuego.id = 1;

--ELIMINAR 
DELETE FROM videojuego WHERE videojuego.id = 1;
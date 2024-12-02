/*POSTGRES*/

/*Creamos la DB*/
/**CREATE DATABASE IF NOT EXISTS almacen;**/
/*Sustituimos el autoincrement por serial para trabajar en postgres*/
/*Orden de las tablas para su creación sin problemas con las foráneas*/


CREATE TABLE IF NOT EXISTS almacenes(

id_alamacen serial PRIMARY KEY,
nombre_almacen VARCHAR(200) NOT NULL,
ubicacion VARCHAR(200) NOT NULL

);

CREATE TABLE IF NOT EXISTS categorias(

id_categoria serial PRIMARY KEY,
nombre_categoria VARCHAR(200) NOT NULL

);

CREATE TYPE contacto AS(

nombre_contacto VARCHAR(73),
nif VARCHAR(73),
telefono INT,
email VARCHAR(73)

);

CREATE TABLE IF NOT EXISTS proveedores(

id_proveedor serial PRIMARY KEY,
nombre_proveedor VARCHAR(200) NOT NULL,
contacto contacto

);

CREATE TABLE IF NOT EXISTS productos(

id_producto serial PRIMARY KEY,
id_proveedor INT NOT NULL,
id_categoria INT NOT NULL,

FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);


CREATE TABLE IF NOT EXISTS almacenes_productos(

id_almacen INT NOT NULL,
id_producto INT NOT NULL,
cantidad INT NOT NULL,

PRIMARY KEY(id_almacen,id_producto),
FOREIGN KEY(id_almacen) REFERENCES almacenes(id_alamacen),
FOREIGN KEY(id_producto) REFERENCES productos(id_producto)

);


INSERT INTO almacenes (nombre_almacen, ubicacion) VALUES
('Almacen Cangas','Cangas'),
('Almacen Vigo','Vigo'),
('Alamacen Salceda','Porriño')
;


INSERT INTO categorias(nombre_categoria) VALUES
('Herramientas'),
('Hogar'),
('Utensilios');

INSERT INTO proveedores(nombre_proveedor, contacto) VALUES
('Jaime cosas de Hogar SL',ROW('Jaime Vazquez','12345678F',666111222,'jaimehogar@casas.org')),
('Ferramentas Daravelo',ROW('Carlos Iglesias','123487654I',612345678,'ferramentas@daravelo.gal')),
('Ultramarinos SA',ROW('Victor Perez','A12365478',698745155,'ultramarinos@ultramarinos.com')),
('Zelnovita',ROW('Valeria Romero','15478736R',986254258,'pedidos@zelnovita.es'))
;


INSERT INTO productos(id_proveedor, id_categoria) VALUES
(1,2),
(2,1),
(3,3),
(2,3),
(3,1)
;

INSERT INTO almacenes_productos VALUES
(2,2,2),
(3,1,3),
(2,1,1),
(1,2,3)
;

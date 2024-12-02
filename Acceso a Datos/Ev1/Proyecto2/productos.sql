CREATE DATABASE IF NOT EXISTS Productos;

use productos;

CREATE TABLE IF NOT EXISTS productos(

id_producto INT AUTO_INCREMENT PRIMARY KEY,
nombre_producto VARCHAR(200),
precio DOUBLE,
stock INT

);


CREATE TABLE IF NOT EXISTS usuarios(

id_usuario INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(200) NOT NULL,
email VARCHAR(200) NOT NULL,
ano_nac INT NOT NULL

);

CREATE TABLE IF NOT EXISTS pedidos(

id_pedido INT AUTO_INCREMENT NOT NULL,
id_usuario INT NOT NULL,
fecha_pedido DATE NOT NULL,

PRIMARY KEY (id_pedido),
FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)

);

CREATE TABLE IF NOT EXISTS pedidos_productos(

id_pedido INT NOT NULL,
id_producto INT NOT NULL,
cantidad INT NOT NULL,

PRIMARY KEY (id_pedido,id_producto),
FOREIGN KEY (id_producto) REFERENCES Productos(id_producto),
FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido)

);

/*Insertamos en las bases de datos*/

INSERT INTO productos (nombre_producto, precio, stock) VALUES 
('Sierras', 19, 10),
('Martillo', 12, 8),
('Mortero', 12, 5),
('Tijeras', 50,6),
('Clavos',3, 18),
('Ganzuas', 14,12)
;

INSERT INTO usuarios (nombre,email,ano_nac) VALUES 
('Paco','elloro@paco.gal',1955),
('Vicky','elvikingo@vicky.org',1985),
('Hugo','elmendrugo@hugo.es',1988),
('Matilde','peliculas@matilde.com',1977)
;

INSERT INTO pedidos (id_usuario, fecha_pedido) VALUES
(1,'2024-02-01'),
(2,'2024-09-10'),
(3,'2024-05-14'),
(4,'2024-06-21'),
(3,'2024-05-10'),
(3,'2024-05-29')
;

INSERT INTO pedidos_productos VALUES 
(1,6,3),
(1,2,5),
(4,5,4),
(2,2,1),
(3,4,1)
;


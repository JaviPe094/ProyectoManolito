-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-12-2018 a las 08:08:14
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_empresagamer`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `nombre` varchar(100) NOT NULL,
  `salario` int(11) NOT NULL,
  `departamento` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`nombre`, `salario`, `departamento`) VALUES
('admin', 2100, 'Direccion'),
('adminJuan', 1300, 'Informatica'),
('adminJulian', 1300, 'Informática'),
('silvia', 2000, 'Marketing');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nombre`, `descripcion`, `fecha_registro`) VALUES
('Alberto2', 'usuario basico no registrado', '2018-12-10 11:00:21'),
('Ana', 'Cliente premium', '2018-11-14 13:35:55'),
('Cliente 1', 'Cliente de prueba', '2018-12-12 12:44:36'),
('Juan', 'Cliente basico registrado', '2018-11-14 13:35:55'),
('Juan Carlos', 'Cliente Premium', '2018-11-15 12:10:30'),
('Juan Carlos Diaz Moruno', 'Cliente registrado premiun', '2018-12-16 19:04:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `departamento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`departamento`) VALUES
('Administracion'),
('Direccion'),
('Finanzas'),
('Informatica'),
('Marketing'),
('Recursos Humanos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenador`
--

CREATE TABLE `ordenador` (
  `cod_producto` int(100) NOT NULL,
  `ram` varchar(50) NOT NULL,
  `tarjeta_grafica` varchar(50) NOT NULL,
  `procesador` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ordenador`
--

INSERT INTO `ordenador` (`cod_producto`, `ram`, `tarjeta_grafica`, `procesador`) VALUES
(39, '8GB', '1050Ti', 'i5'),
(40, '4gb', '970gtx', 'i5'),
(41, '8gb', '1050Ti', 'i7'),
(67, '4gb', '1060gtx', 'i5'),
(69, '16gb', '1080gtx', 'i7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegios`
--

CREATE TABLE `privilegios` (
  `permisos` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `privilegios`
--

INSERT INTO `privilegios` (`permisos`) VALUES
('Admin'),
('Basic'),
('Register'),
('Super-user');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `cod_producto` int(100) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `precio` varchar(40) NOT NULL,
  `descripcion` text,
  `cod_proveedor` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`cod_producto`, `tipo`, `nombre`, `marca`, `precio`, `descripcion`, `cod_proveedor`) VALUES
(1, 'Teclados', 'Razer Blackwidow Tournament Edition Chroma V2 ', 'Racer', '120', 'Teclado Mecánico Gaming Retroiluminado Switch Yellow', 4),
(26, 'Teclados', 'Logitech Desktop MK1', 'Logitech', '20', 'Teclado clasico', 3),
(27, 'Teclados', 'HP Omen X7Z97AA', 'HP Enterprise', '40', 'Teclado gaming retroiluminado', 5),
(37, 'Ratones', 'Corsair ProX2', 'Corsair', '56', 'Raton gaming 4500dpi ', 6),
(38, 'Ratones', 'Asus Cerberus', 'Asus', '60', 'Raton gaming 4000dpi retroiluminado', 1),
(39, 'Pc', 'MSI GL62M', 'MSI', '780', 'Portatil procesador i7 ', 2),
(40, 'Pc', 'Asus GR8 II-T074Z', 'Asus', '1300', 'Ordenador sobremesa ', 1),
(41, 'Pc', 'Asus ROG 7500GTX', 'Asus', '1000', 'Ordenador sobremesa', 1),
(42, 'Videojuegos', 'God of War', 'Sony', '60', 'Videojuego accion Ps4', 8),
(43, 'Videojuegos', 'Far Cry 5', 'Microsoft', '45', 'Videojuego accion Xbox', 9),
(44, 'Videojuegos', 'Call of Duty', 'Sony', '34', 'Videojuego simulador belico Ps4', 8),
(45, 'Videojuegos', 'Horizon Zero Dawn', 'Sony', '50', 'Juego aventuras/accion ed. Mejor juego del año', 8),
(47, 'Teclados', 'Teclado Ergonomico Asus', 'Asus', '45', 'Teclado de oficina con almuadillas', 1),
(49, 'Teclados', 'Teclado Corsair', 'Corsair', '120', 'Teclado Retroiluminado Gaming', 6),
(51, 'Teclados', 'Teclado Logitech Gaming', 'Logitech', '58', 'Teclado de Alta Calidad Gaming', 3),
(52, 'Teclados', 'Teclado de Prueba', 'Corsair', '50', 'Teclado de Prueba', 6),
(64, 'Videojuegos', 'Red Death Redemption 2', 'Sony', '60', 'Juego ambientado en el salvaje oeste', 8),
(65, 'Ratones', 'Raton de prueba', 'Corsair', '45', 'Raton de prueba', 6),
(67, 'Pc', 'Ordenador Basico', 'HP Enterprise', '450', 'Ordenador sobremesa basico', 5),
(69, 'Pc', ' Portatil Gaming Corsair', 'Corsair', '1.450', 'Portatil Gaming Alta Calidad Corsair', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `cod_proveedor` int(100) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`cod_proveedor`, `nombre`, `descripcion`) VALUES
(1, 'Asus', 'Componentes y perifericos'),
(2, 'MSI', 'Componentes y perifericos'),
(3, 'Logitech', 'Proveedor de ordenadores'),
(4, 'Racer', 'Proveedor de perifericos'),
(5, 'HP Enterprise', 'Proveedor de ordenadores'),
(6, 'Corsair', 'Proveedor de perifericos'),
(7, 'Nvidia', 'Proveedor de componentes'),
(8, 'Sony', 'Proveedor de videojuegos'),
(9, 'Microsoft', 'Proveedor de videojuegos'),
(10, 'Intel', 'javax.swing.JTextField[,199,230,284x29,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.synth.SynthBorder@45ff6315,flags=288,maximumSize=,minimumSize=,preferredSize=,caretColor=,disabledTextColor=DerivedColor(color=142,143,145 parent=nimbusDisabledText offsets=0.0,0.0,0.0,0 pColor=142,143,145,editable=true,margin=javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0],selectedTextColor=DerivedColor(color=255,255,255 parent=nimbusSelectedText offsets=0.0,0.0,0.0,0 pColor=255,255,255,selectionColor=DerivedColor(color=57,105,138 parent=nimbusSelectionBackground offsets=0.0,0.0,0.0,0 pColor=57,105,138,columns=0,columnWidth=0,command=,horizontalAlignment=LEADING]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `raton`
--

CREATE TABLE `raton` (
  `cod_producto` int(100) NOT NULL,
  `num_botones` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `raton`
--

INSERT INTO `raton` (`cod_producto`, `num_botones`) VALUES
(37, '6'),
(38, '4'),
(65, '4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teclado`
--

CREATE TABLE `teclado` (
  `cod_producto` int(100) NOT NULL,
  `num_teclas` varchar(50) NOT NULL,
  `idioma_teclado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `teclado`
--

INSERT INTO `teclado` (`cod_producto`, `num_teclas`, `idioma_teclado`) VALUES
(1, '45', 'Esp'),
(26, '105', 'Español'),
(27, '105', 'Español'),
(47, '105', 'Español'),
(49, '105', 'Español'),
(51, '105', 'Español'),
(52, '105', 'Español(QWERTY)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_producto`
--

CREATE TABLE `tipo_producto` (
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_producto`
--

INSERT INTO `tipo_producto` (`tipo`) VALUES
('PC'),
('RATONES'),
('TECLADOS'),
('VIDEOJUEGOS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre_usuario` varchar(100) NOT NULL,
  `permisos` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre_usuario`, `permisos`, `correo`, `contrasena`) VALUES
('admin', 'Super-user', 'jcdiazmo93@gmail.com', 'admin123'),
('adminJuan', 'Admin', 'adminJuan@gmail.com', '1234admin'),
('adminJulian', 'Admin', 'adminjulian@gmail.com', 'adminjulian123'),
('Alberto2', 'Basic', 'alber@gmail.com', '123alber'),
('Ana', 'Register', 'ana1994@hotmail.com', 'ana112233'),
('Cliente 1', 'Register', 'cliente1@hotmail.com', '123cliente'),
('Juan', 'Register', 'juan@hotmail.com', 'juan93'),
('Juan Carlos', 'Register', 'jcdi56@gmail.com', 'jcadmin'),
('Juan Carlos Diaz Moruno', 'Register', 'juanka_dimo93@hotmail.com', 'pinpan93'),
('silvia', 'Admin', 'silviadmin@gmail.com', 'ad12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videojuegos`
--

CREATE TABLE `videojuegos` (
  `cod_producto` int(100) NOT NULL,
  `PEGI` varchar(20) NOT NULL,
  `plataformas` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `videojuegos`
--

INSERT INTO `videojuegos` (`cod_producto`, `PEGI`, `plataformas`) VALUES
(42, '16', 'Play Station, XBox, Pc'),
(43, '18', 'Play Satation 4'),
(44, '18', 'Play Satation 4'),
(45, '18', 'Play Satation 4'),
(64, '18', 'Play Satation 4');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `administradores_ibfk_2` (`departamento`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`departamento`);

--
-- Indices de la tabla `ordenador`
--
ALTER TABLE `ordenador`
  ADD PRIMARY KEY (`cod_producto`);

--
-- Indices de la tabla `privilegios`
--
ALTER TABLE `privilegios`
  ADD PRIMARY KEY (`permisos`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`cod_producto`),
  ADD KEY `productos_ibfk_1` (`marca`),
  ADD KEY `productos_ibfk_2` (`tipo`),
  ADD KEY `productos_ibfk_3` (`cod_proveedor`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`cod_proveedor`),
  ADD KEY `nombre` (`nombre`);

--
-- Indices de la tabla `raton`
--
ALTER TABLE `raton`
  ADD PRIMARY KEY (`cod_producto`);

--
-- Indices de la tabla `teclado`
--
ALTER TABLE `teclado`
  ADD PRIMARY KEY (`cod_producto`);

--
-- Indices de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  ADD PRIMARY KEY (`tipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nombre_usuario`),
  ADD KEY `usuarios_ibfk_1` (`permisos`);

--
-- Indices de la tabla `videojuegos`
--
ALTER TABLE `videojuegos`
  ADD PRIMARY KEY (`cod_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `cod_producto` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `cod_proveedor` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD CONSTRAINT `administradores_ibfk_1` FOREIGN KEY (`nombre`) REFERENCES `usuarios` (`nombre_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `administradores_ibfk_2` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`departamento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`nombre`) REFERENCES `usuarios` (`nombre_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ordenador`
--
ALTER TABLE `ordenador`
  ADD CONSTRAINT `ordenador_ibfk_1` FOREIGN KEY (`cod_producto`) REFERENCES `productos` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`marca`) REFERENCES `proveedores` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `tipo_producto` (`tipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productos_ibfk_3` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedores` (`cod_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `raton`
--
ALTER TABLE `raton`
  ADD CONSTRAINT `raton_ibfk_1` FOREIGN KEY (`cod_producto`) REFERENCES `productos` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `teclado`
--
ALTER TABLE `teclado`
  ADD CONSTRAINT `teclado_ibfk_1` FOREIGN KEY (`cod_producto`) REFERENCES `productos` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`permisos`) REFERENCES `privilegios` (`permisos`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `videojuegos`
--
ALTER TABLE `videojuegos`
  ADD CONSTRAINT `videojuegos_ibfk_1` FOREIGN KEY (`cod_producto`) REFERENCES `productos` (`cod_producto`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-11-2024 a las 22:02:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fikabd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `id_carrito` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carrito`
--

INSERT INTO `carrito` (`id_carrito`, `id_usuario`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `combos`
--

CREATE TABLE `combos` (
  `id_combo` int(11) NOT NULL,
  `id_comida` int(11) NOT NULL,
  `cantComida` int(11) NOT NULL,
  `id_bebida` int(11) NOT NULL,
  `cantBebida` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `visible` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `combos`
--

INSERT INTO `combos` (`id_combo`, `id_comida`, `cantComida`, `id_bebida`, `cantBebida`, `precio`, `descripcion`, `visible`) VALUES
(0, 0, 0, 2, 2, 69, 'combo', 'si'),
(0, 2, 1, 2, 2, 234, 'combox', 'si'),
(0, 2, 2, 2, 1, 234, 'asd', 'si'),
(0, 2, 11, 2, 22, 34, 'asde', 'si'),
(0, 5, 2, 4, 3, 4500, 'Un combo excelente para el calor', 'si'),
(0, 6, 3, 1, 1, 3000, 'usa', 'si'),
(0, 2, 3, 1, 2, 5000, '¿hola]?', 'si'),
(0, 2, 23, 1, 1, 293, '1111111111111111', 'si'),
(0, 2, 23, 1, 2, 293, '1111111111111111', 'si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepedido`
--

CREATE TABLE `detallepedido` (
  `nro_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallepedido`
--

INSERT INTO `detallepedido` (`nro_pedido`, `id_producto`, `cantidad_producto`) VALUES
(13, 2, 1),
(13, 3, 2),
(13, 1, 2),
(14, 3, 2),
(15, 5, 1),
(16, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados_pedidos`
--

CREATE TABLE `estados_pedidos` (
  `id_estado` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estados_pedidos`
--

INSERT INTO `estados_pedidos` (`id_estado`, `descripcion`) VALUES
(0, 'Pendiente'),
(1, 'En preparación'),
(2, 'Preparado'),
(3, 'Entregado'),
(5, 'Rechazado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itemcarrito`
--

CREATE TABLE `itemcarrito` (
  `id_carrito` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medios_pagos`
--

CREATE TABLE `medios_pagos` (
  `id_metodo` int(11) DEFAULT NULL,
  `descripcion` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medios_pagos`
--

INSERT INTO `medios_pagos` (`id_metodo`, `descripcion`) VALUES
(1, 'mercadopago'),
(2, 'credito'),
(3, 'debito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `nro_mesa` int(11) NOT NULL,
  `cant_sillas` int(11) DEFAULT NULL,
  `fecha_disponible` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`nro_mesa`, `cant_sillas`, `fecha_disponible`) VALUES
(1, 3, '2022-10-16'),
(2, 2, '2022-11-19'),
(3, 4, '2022-11-02'),
(4, 5, '2022-10-19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `nro_pedido` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha_pedido` varchar(20) DEFAULT NULL,
  `hora_pedido` varchar(10) DEFAULT NULL,
  `id_metodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`nro_pedido`, `estado`, `id_usuario`, `fecha_pedido`, `hora_pedido`, `id_metodo`) VALUES
(13, 'Rechazado', 0, '2024-10-01', '8:00', 1),
(14, 'entregado', 0, '2024-10-01', '8:00', 1),
(15, 'rechazado', 0, '2024-10-01', '8:00', 1),
(16, 'pendiente', 0, '2024-10-01', '8:00', 1),
(1001, 'pendiente', 0, '2024-10-01', '12:30:00', 1),
(1002, 'entregado', 0, '2024-10-02', '14:15:00', 2),
(1003, 'rechazado', 0, '2024-09-29', '09:45:00', 3),
(1004, 'en preparacion', 0, '2024-09-28', '10:20:00', 1),
(1005, 'entregado', 0, '2024-10-03', '11:10:00', 2),
(1006, 'rechazado', 0, '2024-09-27', '15:00:00', 3),
(1007, 'pendiente', 0, '2024-10-01', '13:50:00', 1),
(1008, 'entregado', 0, '2024-09-30', '16:20:00', 2),
(1009, 'rechazado', 0, '2024-09-29', '08:30:00', 3),
(1010, 'pendiente', 0, '2024-09-28', '17:00:00', 1),
(1011, 'entregado', 0, '2024-10-02', '14:45:00', 2),
(1012, 'rechazado', 0, '2024-09-27', '10:15:00', 3),
(1013, 'pendiente', 0, '2024-10-03', '09:50:00', 1),
(1014, 'entregado', 0, '2024-09-30', '12:40:00', 2),
(1015, 'rechazado', 0, '2024-09-29', '14:10:00', 3),
(1016, 'pendiente', 0, '2024-10-01', '11:35:00', 1),
(1017, 'entregado', 0, '2024-10-02', '15:25:00', 2),
(1018, 'rechazado', 0, '2024-09-28', '16:55:00', 3),
(1019, 'pendiente', 0, '2024-09-27', '13:15:00', 1),
(1020, 'entregado', 0, '2024-09-29', '09:00:00', 2),
(1021, 'rechazado', 0, '2024-10-01', '17:30:00', 3),
(1022, 'pendiente', 0, '2024-10-03', '10:25:00', 1),
(1023, 'entregado', 0, '2024-09-28', '12:50:00', 2),
(1024, 'rechazado', 0, '2024-09-27', '14:05:00', 3),
(1025, 'pendiente', 0, '2024-10-02', '08:20:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `CATEGORIA` varchar(30) DEFAULT NULL,
  `DESCRIPCION_PRODUCTO` varchar(50) DEFAULT NULL,
  `PRECIO_VTA` int(11) DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL,
  `FOTO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID`, `NOMBRE`, `CATEGORIA`, `DESCRIPCION_PRODUCTO`, `PRECIO_VTA`, `STOCK`, `FOTO`) VALUES
(1, 'cafe americano', 'bebidas', 'Cafe expresso tradicional americano', 340, 10, 'coffe.png'),
(2, 'avocado toast', 'comida', 'delicioso tostado', 500, 16, 'avocado toast.png'),
(3, 'licuado de arandanos', 'bebidas', 'delisioso licuado', 300, 9, 'licuado arandanos.png'),
(4, 'te frio', 'bebidas', 'delisioso te', 200, 18, 'tefrio.png'),
(5, 'biscochuelo Limon', 'comida', 'Lorem ipsum dolor sit amet cu, nvallis phasellus n', 250, 7, 'biscochueloLimon.png'),
(6, 'cookie chocolate', 'comida', 'si bla convallis phasellus nec mi sagittis arcu', 120, 15, 'cookieChocolate.png'),
(7, 'tarta frutal', 'comida', 'et facilisi blandit pulvinar suscipit, convallis p', 200, 5, 'tartafrutal.png'),
(8, 'torta maldita', 'comida', ' et facil casa papel csa dasd css convallis phasel', 280, 12, 'Torta Maldita.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `nro_reserva` int(11) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`nro_reserva`, `fecha_reserva`, `estado`) VALUES
(1, '2022-10-16', 'ocupado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `tipo_usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `email`, `pass`, `tipo_usuario`) VALUES
(1, 'admin', 'admin@gmail.com', 'admin', 'administrador'),
(2, 'cliente1', 'cliente@gmail.com', 'cliente', 'cliente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD KEY `nro_pedido` (`nro_pedido`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `estados_pedidos`
--
ALTER TABLE `estados_pedidos`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`nro_mesa`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`nro_pedido`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`nro_reserva`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `nro_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1026;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `nro_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`nro_pedido`) REFERENCES `pedidos` (`nro_pedido`),
  ADD CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`ID`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`nro_reserva`) REFERENCES `mesa` (`nro_mesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

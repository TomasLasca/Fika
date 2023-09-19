-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2022 a las 22:40:51
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carrito`
--

INSERT INTO `carrito` (`id_carrito`, `id_usuario`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepedido`
--

CREATE TABLE `detallepedido` (
  `nro_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallepedido`
--

INSERT INTO `detallepedido` (`nro_pedido`, `id_producto`, `cantidad_producto`) VALUES
(1000, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados_pedido`
--

CREATE TABLE `estados_pedido` (
  `id_estado` int(11) DEFAULT NULL,
  `descripcion` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estados_pedido`
--

INSERT INTO `estados_pedido` (`id_estado`, `descripcion`) VALUES
(1, 'en preparacion'),
(2, 'rechazado'),
(3, 'preparado'),
(3, 'entregado'),
(5, 'pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itemcarrito`
--

CREATE TABLE `itemcarrito` (
  `id_carrito` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medios_pagos`
--

CREATE TABLE `medios_pagos` (
  `id_metodo` int(11) DEFAULT NULL,
  `descripcion` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `id_estado` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha_pedido` varchar(20) DEFAULT NULL,
  `hora_pedido` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`nro_pedido`, `id_estado`, `id_usuario`, `fecha_pedido`, `hora_pedido`) VALUES
(0, 5, 0, '2022-11-22', '8:00'),
(1000, 5, 0, '2022-11-22', '8:00');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`nro_reserva`, `fecha_reserva`, `estado`) VALUES
(1, '2022-10-16', 'ocupado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`nro_mesa`);

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
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `nro_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`nro_reserva`) REFERENCES `mesa` (`nro_mesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

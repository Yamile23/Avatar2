-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2021 a las 02:56:59
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `avatar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accesorio`
--

CREATE TABLE `accesorio` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `color` varchar(50) NOT NULL,
  `pos_x` int(11) NOT NULL,
  `pos_y` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avatar_accesorio`
--

CREATE TABLE `avatar_accesorio` (
  `Id_personaje` int(11) NOT NULL,
  `id_accesorio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avatar_ropa`
--

CREATE TABLE `avatar_ropa` (
  `Id_personaje` int(11) NOT NULL,
  `id_ropa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `nombre` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`nombre`, `id`) VALUES
('Masculino', 1),
('Femenino', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personaje`
--

CREATE TABLE `personaje` (
  `Id_personaje` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `genero` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personaje`
--

INSERT INTO `personaje` (`Id_personaje`, `Nombre`, `genero`, `id_user`, `fecha`, `direccion`, `estado`) VALUES
(4, 'ycs', 2, 2, '2021-10-24 19:49:04', 'C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niña.png', 0),
(5, 'kcs', 2, 2, '2021-10-24 19:50:05', 'C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niña.png', 0),
(6, 'uno', 2, 2, '2021-10-24 20:07:57', 'C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niña.png', 0),
(7, 'mati', 2, 2, '2021-10-24 20:10:06', 'C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niña.png', 0),
(8, 'matias', 2, 2, '2021-10-24 20:11:40', 'C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niña.png', 0),
(9, 'matias', 1, 2, '2021-10-24 20:13:15', 'C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niño.png', 0),
(10, 'yari', 2, 2, '2021-10-24 20:13:43', 'C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niña.png', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id_user` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id_user`, `Nombre`, `Correo`, `pass`) VALUES
(1, 'yamile', 'yamile', 'jPasswordField1'),
(2, 'katy', 'yamile', '123'),
(3, 'yamil', 'yamile@gmail.com', 'jPasswordField1'),
(4, 'Matias', 'alguien@gmail.com', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vestimenta`
--

CREATE TABLE `vestimenta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `color` varchar(20) NOT NULL,
  `genero` int(11) NOT NULL,
  `pos_x` int(11) NOT NULL,
  `pos_y` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accesorio`
--
ALTER TABLE `accesorio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `avatar_accesorio`
--
ALTER TABLE `avatar_accesorio`
  ADD KEY `Id_personaje` (`Id_personaje`,`id_accesorio`),
  ADD KEY `Id_personaje_2` (`Id_personaje`,`id_accesorio`),
  ADD KEY `id_accesorio` (`id_accesorio`);

--
-- Indices de la tabla `avatar_ropa`
--
ALTER TABLE `avatar_ropa`
  ADD KEY `Id_personaje` (`Id_personaje`,`id_ropa`),
  ADD KEY `id_ropa` (`id_ropa`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indices de la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD PRIMARY KEY (`Id_personaje`),
  ADD KEY `genero` (`genero`) USING BTREE,
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_user`);

--
-- Indices de la tabla `vestimenta`
--
ALTER TABLE `vestimenta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `genero` (`genero`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accesorio`
--
ALTER TABLE `accesorio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `personaje`
--
ALTER TABLE `personaje`
  MODIFY `Id_personaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vestimenta`
--
ALTER TABLE `vestimenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `avatar_accesorio`
--
ALTER TABLE `avatar_accesorio`
  ADD CONSTRAINT `avatar_accesorio_ibfk_1` FOREIGN KEY (`Id_personaje`) REFERENCES `personaje` (`Id_personaje`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `avatar_accesorio_ibfk_2` FOREIGN KEY (`id_accesorio`) REFERENCES `accesorio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `avatar_ropa`
--
ALTER TABLE `avatar_ropa`
  ADD CONSTRAINT `avatar_ropa_ibfk_1` FOREIGN KEY (`Id_personaje`) REFERENCES `personaje` (`Id_personaje`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `avatar_ropa_ibfk_2` FOREIGN KEY (`id_ropa`) REFERENCES `vestimenta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD CONSTRAINT `personaje_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `genero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `personaje_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `usuario` (`Id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vestimenta`
--
ALTER TABLE `vestimenta`
  ADD CONSTRAINT `vestimenta_ibfk_1` FOREIGN KEY (`genero`) REFERENCES `genero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

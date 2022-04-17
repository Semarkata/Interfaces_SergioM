-- phpMyAdmin SQL Dump
-- version 5.0.4deb2ubuntu5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 17, 2022 at 04:13 PM
-- Server version: 8.0.28-0ubuntu0.21.10.3
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enviorapidito`
--

-- --------------------------------------------------------

--
-- Table structure for table `envio`
--

CREATE TABLE `envio` (
  `envioId` int NOT NULL,
  `userId` varchar(45) NOT NULL,
  `paqueteId` varchar(45) NOT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `cp` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `tipoEnvio` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paquete`
--

CREATE TABLE `paquete` (
  `paqueteId` int NOT NULL,
  `userId` varchar(45) NOT NULL,
  `peso` varchar(45) DEFAULT NULL,
  `unidadPeso` varchar(45) DEFAULT NULL,
  `largo` varchar(45) DEFAULT NULL,
  `ancho` varchar(45) DEFAULT NULL,
  `alto` varchar(45) DEFAULT NULL,
  `unidadMedida` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `userId` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `envio`
--
ALTER TABLE `envio`
  ADD PRIMARY KEY (`envioId`);

--
-- Indexes for table `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`paqueteId`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `userId_UNIQUE` (`userId`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `envio`
--
ALTER TABLE `envio`
  MODIFY `envioId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paquete`
--
ALTER TABLE `paquete`
  MODIFY `paqueteId` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `userId` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Mar-2019 às 02:56
-- Versão do servidor: 10.1.35-MariaDB
-- versão do PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `administrador`
--

CREATE TABLE `administrador` (
  `idAdministrador` int(11) NOT NULL,
  `UsuárioAdministrador` int(11) NOT NULL,
  `SenhaAdministrador` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `coordenador`
--

CREATE TABLE `coordenador` (
  `idCoordenador` int(11) NOT NULL,
  `UsuárioCoordenador` varchar(45) NOT NULL,
  `SenhaCoordenador` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horário`
--

CREATE TABLE `horário` (
  `idHorário` int(11) NOT NULL,
  `Horário` varchar(45) DEFAULT NULL,
  `Segunda` varchar(45) DEFAULT NULL,
  `Terça` varchar(45) DEFAULT NULL,
  `Quarta` varchar(45) DEFAULT NULL,
  `Quinta` varchar(45) DEFAULT NULL,
  `Sexta` varchar(45) DEFAULT NULL,
  `idLaboratório` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `laboratório`
--

CREATE TABLE `laboratório` (
  `idLaboratório` int(11) NOT NULL,
  `NúmeroLaboratório` int(11) NOT NULL,
  `NomeLaboratório` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idAdministrador`);

--
-- Indexes for table `coordenador`
--
ALTER TABLE `coordenador`
  ADD PRIMARY KEY (`idCoordenador`),
  ADD UNIQUE KEY `UsuCoordenador` (`UsuárioCoordenador`);

--
-- Indexes for table `horário`
--
ALTER TABLE `horário`
  ADD PRIMARY KEY (`idHorário`),
  ADD KEY `fk_idHorario` (`idLaboratório`);

--
-- Indexes for table `laboratório`
--
ALTER TABLE `laboratório`
  ADD PRIMARY KEY (`idLaboratório`),
  ADD UNIQUE KEY `NumLab` (`NúmeroLaboratório`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrador`
--
ALTER TABLE `administrador`
  MODIFY `idAdministrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `coordenador`
--
ALTER TABLE `coordenador`
  MODIFY `idCoordenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `horário`
--
ALTER TABLE `horário`
  MODIFY `idHorário` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `laboratório`
--
ALTER TABLE `laboratório`
  MODIFY `idLaboratório` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `horário`
--
ALTER TABLE `horário`
  ADD CONSTRAINT `fk_idHorario` FOREIGN KEY (`idLaboratório`) REFERENCES `laboratório` (`idLaboratório`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

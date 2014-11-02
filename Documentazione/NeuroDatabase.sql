-- phpMyAdmin SQL Dump
-- version 3.3.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 08, 2011 at 08:02 PM
-- PHP Version: 5.3.5-1ubuntu7.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `NeuroDatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `etnia`
--

CREATE TABLE IF NOT EXISTS `etnia` (
  `etnia` varchar(20) NOT NULL,
  PRIMARY KEY (`etnia`),
  KEY `etnia` (`etnia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etnia`
--

INSERT INTO `etnia` (`etnia`) VALUES
('Altro'),
('Caucasico'),
('Nero'),
('Sud Asiatico'),
('Sud-Est Asiatico');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `ruolo` varchar(15) NOT NULL,
  PRIMARY KEY (`username`,`ruolo`),
  KEY `ruolo` (`ruolo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--


-- --------------------------------------------------------

--
-- Table structure for table `malattia`
--

CREATE TABLE IF NOT EXISTS `malattia` (
  `nome` varchar(20) NOT NULL,
  `eta` int(10) unsigned NOT NULL,
  `descrizione` text NOT NULL,
  `sesso` enum('Maschio','Femmina') NOT NULL,
  `etnia` varchar(20) NOT NULL,
  `sintomi` varchar(25) NOT NULL,
  PRIMARY KEY (`nome`,`sesso`,`etnia`,`sintomi`),
  KEY `sesso` (`sesso`),
  KEY `nome` (`nome`),
  KEY `etnia` (`etnia`),
  KEY `sintomi` (`sintomi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `malattia`
--


-- --------------------------------------------------------

--
-- Table structure for table `ruolo`
--

CREATE TABLE IF NOT EXISTS `ruolo` (
  `ruolo` varchar(15) NOT NULL,
  PRIMARY KEY (`ruolo`),
  KEY `ruolo` (`ruolo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruolo`
--

INSERT INTO `ruolo` (`ruolo`) VALUES
('amministratore'),
('medico'),
('ricercatore');

-- --------------------------------------------------------

--
-- Table structure for table `sintomi`
--

CREATE TABLE IF NOT EXISTS `sintomi` (
  `sintomi` varchar(25) NOT NULL,
  PRIMARY KEY (`sintomi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sintomi`
--

INSERT INTO `sintomi` (`sintomi`) VALUES
('Agitazione'),
('Cefalee'),
('Convulsioni'),
('Emicrania'),
('Mal di Testa'),
('Nausea'),
('Poco Equilibro'),
('Schizofrenia'),
('Stress'),
('Vomito');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`ruolo`) REFERENCES `ruolo` (`ruolo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `malattia`
--
ALTER TABLE `malattia`
  ADD CONSTRAINT `malattia_ibfk_2` FOREIGN KEY (`etnia`) REFERENCES `etnia` (`etnia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `malattia_ibfk_3` FOREIGN KEY (`sintomi`) REFERENCES `sintomi` (`sintomi`) ON DELETE CASCADE ON UPDATE CASCADE;

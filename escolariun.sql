-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 14-Dez-2018 às 23:06
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `escolariun`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ano`
--

DROP TABLE IF EXISTS `ano`;
CREATE TABLE IF NOT EXISTS `ano` (
  `id_ano` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(2) NOT NULL,
  PRIMARY KEY (`id_ano`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id_curso`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id_curso`, `nome`) VALUES
(1, 'info'),
(2, 'nutri');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disponiblidade`
--

DROP TABLE IF EXISTS `disponiblidade`;
CREATE TABLE IF NOT EXISTS `disponiblidade` (
  `id_disponibilidade` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProfessor` varchar(20) NOT NULL,
  `dia` varchar(10) NOT NULL,
  `aula` varchar(10) NOT NULL,
  PRIMARY KEY (`id_disponibilidade`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disponiblidade`
--

INSERT INTO `disponiblidade` (`id_disponibilidade`, `nomeProfessor`, `dia`, `aula`) VALUES
(1, 'chioda', 'segunda', 'aula3'),
(2, 'vitor', 'segunda', 'aula6'),
(3, 'chioda', 'segunda', 'aula2'),
(4, 'vini', 'segunda', 'aula4'),
(5, 'chioda', 'terça', 'aula1'),
(6, 'vini', 'segunda', 'aula1'),
(7, 'chioda', 'quarta', 'aula6');

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE IF NOT EXISTS `perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `age` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `perfil`
--

INSERT INTO `perfil` (`id`, `nome`, `age`) VALUES
(22, 'vini', '20'),
(21, 'chioda', '12'),
(20, 'vitor', '14');

-- --------------------------------------------------------

--
-- Estrutura da tabela `quarta`
--

DROP TABLE IF EXISTS `quarta`;
CREATE TABLE IF NOT EXISTS `quarta` (
  `id_quarta` int(11) NOT NULL AUTO_INCREMENT,
  `aula1` varchar(10) NOT NULL,
  `aula2` varchar(10) NOT NULL,
  `aula3` varchar(10) NOT NULL,
  `aula4` varchar(10) NOT NULL,
  `aula5` varchar(10) NOT NULL,
  `aula6` varchar(10) NOT NULL,
  `aula7` varchar(10) NOT NULL,
  `aula8` varchar(10) NOT NULL,
  PRIMARY KEY (`id_quarta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `quinta`
--

DROP TABLE IF EXISTS `quinta`;
CREATE TABLE IF NOT EXISTS `quinta` (
  `id_quinta` int(11) NOT NULL AUTO_INCREMENT,
  `aula1` varchar(10) NOT NULL,
  `aula2` varchar(10) NOT NULL,
  `aula3` varchar(10) NOT NULL,
  `aula4` varchar(10) NOT NULL,
  `aula5` varchar(10) NOT NULL,
  `aula6` varchar(10) NOT NULL,
  `aula7` varchar(10) NOT NULL,
  `aula8` varchar(10) NOT NULL,
  PRIMARY KEY (`id_quinta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `segunda`
--

DROP TABLE IF EXISTS `segunda`;
CREATE TABLE IF NOT EXISTS `segunda` (
  `id_segunda` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCurso` varchar(30) NOT NULL,
  `ano` varchar(2) NOT NULL,
  `aula1` varchar(10) NOT NULL,
  `aula2` varchar(10) NOT NULL,
  `aula3` varchar(10) NOT NULL,
  `aula4` varchar(10) NOT NULL,
  `aula5` varchar(10) NOT NULL,
  `aula6` varchar(10) NOT NULL,
  `aula7` varchar(10) NOT NULL,
  `aula8` varchar(10) NOT NULL,
  PRIMARY KEY (`id_segunda`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `segunda`
--

INSERT INTO `segunda` (`id_segunda`, `nomeCurso`, `ano`, `aula1`, `aula2`, `aula3`, `aula4`, `aula5`, `aula6`, `aula7`, `aula8`) VALUES
(3, 'Info', '1', '', '', '', '', '', '', '', ''),
(4, 'info', '2', '', '', '', '', '', '', '', ''),
(5, 'info', '3', '', '', '', '', '', '', '', ''),
(6, 'nutri', '1', '', '', '', '', '', '', '', ''),
(7, 'nutri', '2', '', '', '', '', '', '', '', ''),
(8, 'nutri', '3', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sexta`
--

DROP TABLE IF EXISTS `sexta`;
CREATE TABLE IF NOT EXISTS `sexta` (
  `id_sexta` int(11) NOT NULL AUTO_INCREMENT,
  `aula1` varchar(10) NOT NULL,
  `aula2` varchar(10) NOT NULL,
  `aula3` varchar(10) NOT NULL,
  `aula4` varchar(10) NOT NULL,
  `aula5` varchar(10) NOT NULL,
  `aula6` varchar(10) NOT NULL,
  `aula7` varchar(10) NOT NULL,
  `aula8` varchar(10) NOT NULL,
  PRIMARY KEY (`id_sexta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `terca`
--

DROP TABLE IF EXISTS `terca`;
CREATE TABLE IF NOT EXISTS `terca` (
  `id_terca` int(11) NOT NULL AUTO_INCREMENT,
  `aula1` varchar(10) NOT NULL,
  `aula2` varchar(10) NOT NULL,
  `aula3` varchar(10) NOT NULL,
  `aula4` varchar(10) NOT NULL,
  `aula5` varchar(10) NOT NULL,
  `aula6` varchar(10) NOT NULL,
  `aula7` varchar(10) NOT NULL,
  `aula8` varchar(10) NOT NULL,
  PRIMARY KEY (`id_terca`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

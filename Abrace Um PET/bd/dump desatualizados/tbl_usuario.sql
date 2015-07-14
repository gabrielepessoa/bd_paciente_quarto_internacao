-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20-Nov-2014 às 18:17
-- Versão do servidor: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `abrace_um_pet`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuario`
--

CREATE TABLE IF NOT EXISTS `tbl_usuario` (
`id_usuario` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Extraindo dados da tabela `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`id_usuario`, `login`, `senha`, `email`) VALUES
(13, 'lais', '7c1ca643780d76f6d2a4d1a7cc3f2c3', 'lais@lais.com'),
(14, 'lisandra', '202447d5d44ce12531f7207cb33b6bf7', 'lisansouza@gmail.com'),
(15, 'lili', '2e3817293fc275dbee74bd71ce6eb056', 'sjdjd@rtwr.'),
(16, 'raissa', '202cb962ac59075b964b07152d234b70', 'raissa@dgd.com'),
(17, 'gabriel', '647431b5ca55b04fdf3c2fce31ef1915', 'gabriel@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
 ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

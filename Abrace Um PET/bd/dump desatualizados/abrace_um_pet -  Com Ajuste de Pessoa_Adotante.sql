-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Nov-2014 às 21:55
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
-- Estrutura da tabela `adocao`
--

CREATE TABLE IF NOT EXISTS `adocao` (
  `id` int(11) NOT NULL,
  `idAnimal` tinyint(1) DEFAULT NULL,
  `idAdotante` tinyint(11) DEFAULT NULL,
  `dataAdocao` timestamp NULL DEFAULT NULL,
  `dataDevolucao` timestamp NULL DEFAULT NULL,
  `idUsuario` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
`id` int(11) NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `estado`, `cidade`, `bairro`, `rua`, `numero`, `complemento`, `cep`) VALUES
(3, 'PERNAMBUCO', 'RECIFE', 'VARZEA', 'RUA DEPUTADO ADALBERTO GUERRA', '83', 'CASA A', '50980615'),
(4, 'PERNAMBUCO', 'RECIFE', 'CAXANGA', 'RUA 00', '2', '', '50987651');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `idEndereco` tinyint(1) DEFAULT NULL,
  `telefoneFixo` varchar(11) DEFAULT NULL,
  `telefoneCelular` varchar(11) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL,
  `impedimento` tinyint(1) DEFAULT NULL,
  `motivoImpedimeto` text
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `idEndereco`, `telefoneFixo`, `telefoneCelular`, `email`, `impedimento`, `motivoImpedimeto`) VALUES
(3, 'LISANDRA CRUZ', 3, '08132713515', '08195209881', 'lisansouza@gmail.com', NULL, NULL),
(4, 'LISA LTDA', 4, '08132713515', '08195209881', 'lisansouza@gmail.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoafisica`
--

CREATE TABLE IF NOT EXISTS `pessoafisica` (
`id` int(11) NOT NULL,
  `rg` varchar(11) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `idPessoa` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `pessoafisica`
--

INSERT INTO `pessoafisica` (`id`, `rg`, `cpf`, `genero`, `idPessoa`) VALUES
(3, '9771388', '09791366441', 'F', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoajuridica`
--

CREATE TABLE IF NOT EXISTS `pessoajuridica` (
`id` int(11) NOT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `idResponsavel` tinyint(11) DEFAULT NULL,
  `idPessoa` tinyint(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `pessoajuridica`
--

INSERT INTO `pessoajuridica` (`id`, `cnpj`, `idResponsavel`, `idPessoa`) VALUES
(1, '12345678901234', NULL, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id` int(11) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `senha`, `email`) VALUES
(11, 'Lili', '2cbe7f341eb6aca638a32b77ddedfd4c', 'lisansouza@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adocao`
--
ALTER TABLE `adocao`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pessoafisica`
--
ALTER TABLE `pessoafisica`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `pessoafisica`
--
ALTER TABLE `pessoafisica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 11-Dez-2014 às 02:33
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
  `idAnimal` int(11) DEFAULT NULL,
  `idAdotante` int(11) DEFAULT NULL,
  `dataAdocao` timestamp NULL DEFAULT NULL,
  `dataDevolucao` timestamp NULL DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `adocao`
--

INSERT INTO `adocao` (`id`, `idAnimal`, `idAdotante`, `dataAdocao`, `dataDevolucao`, `idUsuario`) VALUES
(1, 1, 18, NULL, NULL, NULL),
(2, 20, 45, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `adotante`
--

CREATE TABLE IF NOT EXISTS `adotante` (
`id` int(11) NOT NULL,
  `impedimento` tinyint(1) DEFAULT NULL,
  `motivoImpedimeto` text,
  `idPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- Extraindo dados da tabela `adotante`
--

INSERT INTO `adotante` (`id`, `impedimento`, `motivoImpedimeto`, `idPessoa`) VALUES
(18, NULL, NULL, 3),
(19, NULL, NULL, 4),
(20, NULL, NULL, 5),
(21, NULL, NULL, 6),
(22, NULL, NULL, 7),
(23, NULL, NULL, 8),
(24, NULL, NULL, -1),
(25, NULL, NULL, -1),
(26, NULL, NULL, 9),
(27, NULL, NULL, 10),
(28, NULL, NULL, 11),
(29, NULL, NULL, 12),
(30, NULL, NULL, 13),
(31, NULL, NULL, 14),
(32, NULL, NULL, 15),
(33, NULL, NULL, 16),
(34, NULL, NULL, 17),
(35, NULL, NULL, 18),
(36, NULL, NULL, 19),
(37, NULL, NULL, 20),
(38, NULL, NULL, 21),
(39, NULL, NULL, 22),
(40, NULL, NULL, 23),
(41, NULL, NULL, 24),
(42, NULL, NULL, 25),
(43, NULL, NULL, 26),
(44, NULL, NULL, 27),
(45, NULL, NULL, 28),
(46, NULL, NULL, 29),
(47, NULL, NULL, 30),
(48, NULL, NULL, 31);

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `rga` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(12) DEFAULT NULL,
  `idRaca` int(11) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `deficiencia` text,
  `vacinado` tinyint(1) DEFAULT NULL,
  `castrado` tinyint(1) DEFAULT NULL,
  `tamanho` double DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `temperamento` text,
  `observacao` text,
  `dataResgate` varchar(12) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`id`, `nome`, `tipo`, `rga`, `dataNascimento`, `idRaca`, `genero`, `deficiencia`, `vacinado`, `castrado`, `tamanho`, `peso`, `temperamento`, `observacao`, `dataResgate`) VALUES
(16, 'Juvenal', 'Gato', '12345', NULL, -1, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', 'Manhoso', NULL),
(17, 'Juvenal', 'Gato', '12345', '20/11/2222', -1, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', 'Manhoso', '77/44/4422'),
(18, 'alguem', 'Gato', '12345', '20/11/2222', -1, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(19, 'alguem', 'Gato', '12345', '20/11/2222', 0, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(20, 'alguem', 'Gato', '12345', '20/11/2222', 2, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(21, 'alguem', 'Gato', '12345', '20/11/2222', 3, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(22, 'alguem', 'Gato', '12345', '20/11/2222', 4, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(23, 'alguem', 'Gato', '12345', '20/11/2222', 5, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(24, 'alguem', 'Gato', '12345', '20/11/2222', 6, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(25, 'alguem', 'Gato', '12345', '20/11/2222', 7, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(26, 'JULIANA', 'DOG', '12345', '20/11/2222', 8, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(27, 'JANAINA', 'DOG', '12345', '20/11/2222', 11, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(28, 'JANAINA', 'DOG', '12345', '20/11/2222', 12, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(29, 'JANAINA', 'DOG', '12345', '20/11/2222', 13, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(30, 'wwwww', 'Gato', '989898', NULL, 0, 'Macho', 'Nenhuma', 0, 0, 0, 44.44, '22.22', '4', '44/44/4444'),
(31, 'wwwww', NULL, '222222222344', NULL, 0, NULL, NULL, 0, 0, 0, 0, NULL, NULL, NULL),
(32, 'JANAINA', 'DOG', '12345', '20/11/2222', 15, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(33, 'JANAINA', 'DOG', '12345', '20/11/2222', 16, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422'),
(34, 'julaiiaia', 'DOG', '12345', '20/11/2222', 17, 'Macho', 'Nenhuma deficiência', 1, 1, 1.7, 3, 'Manhoso', NULL, '77/44/4422');

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
  `cep` varchar(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=54 ;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `estado`, `cidade`, `bairro`, `rua`, `numero`, `complemento`, `cep`) VALUES
(47, 'f', 'f', '3s', 'sf', '3', '', '33.333-333'),
(48, 'fde', 'wef', 'fa', 'erfa', '3', 'wr', '33.333-333'),
(49, 'JNF', 'JV', 'JFJ', '3eidi', '33', '', '39.495-959'),
(50, 'rrrrrrrrrr', 'rrrrrrrrrrrr', 'rrrrr', 'rua', '2', '', '00.000-000'),
(51, 'aa', 'a', 'a', 'aaaaaaaaaaaaaaaaaaaaaaaa', '2', '', '22.222-222'),
(52, 'kk', 'kk', 'kk', '01', '00', 'kk', '00.000-000'),
(53, '222', '2222', '222', 'ssssss', '222', '222', '22.222-222');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
`id` int(11) NOT NULL,
  `nome` varchar(90) DEFAULT NULL,
  `idEndereco` int(11) DEFAULT NULL,
  `telefoneFixo` varchar(15) DEFAULT NULL,
  `telefoneCelular` varchar(15) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `idEndereco`, `telefoneFixo`, `telefoneCelular`, `email`) VALUES
(28, 'dsgsdgsagdgasgd', 50, '(11)1111-1111', '(11)1111-1111', '33@c.com'),
(29, 'florentina', 51, '(39)9999-9999', '(39)9999-9999', 'L@D.com'),
(30, 'MARIA JIL', 52, '(39)9292-9299', '(29)9292-9292', 'lisa@gmail.com'),
(31, 'jonas ltda', 53, '(24)2423-2323', '(23)2332-3232', 'ks!@fkf.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoafisica`
--

CREATE TABLE IF NOT EXISTS `pessoafisica` (
`id` int(11) NOT NULL,
  `rg` varchar(11) DEFAULT NULL,
  `cpf` varchar(20) NOT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `pessoafisica`
--

INSERT INTO `pessoafisica` (`id`, `rg`, `cpf`, `genero`, `idPessoa`) VALUES
(10, '7852413', '082.323.444-40', 'M', 3),
(11, '4444444', '', 'M', 13),
(12, '4333434', '', 'F', 16),
(13, '2030303', '082.323.444-40', 'M', 17),
(14, '3567554', '098.568.906-57', 'M', 18),
(15, '3446676', '082.232.444-40', 'F', 19),
(16, '9999393', '030.949.494-99', 'F', 20),
(17, '9999999', '889.387.382-32', 'M', 23),
(18, '0303030', '657.685.423-52', 'F', 27),
(19, '3434343', '083.243.524-54', 'F', 28),
(20, '9889898', '098.989.898-98', 'F', 30);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoajuridica`
--

CREATE TABLE IF NOT EXISTS `pessoajuridica` (
`id` int(11) NOT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  `idPessoaFisica` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Extraindo dados da tabela `pessoajuridica`
--

INSERT INTO `pessoajuridica` (`id`, `cnpj`, `idPessoa`, `idPessoaFisica`) VALUES
(2, '01234567899874', 4, NULL),
(3, '01234567891234', 8, 10),
(4, '88.888.888/8888-88', 12, 10),
(5, '90.909.090/9090-90', 14, 10),
(6, '88.888.888/8888-88', 15, 10),
(7, '99.999.999/9999-99', 21, 10),
(8, '67.878.777/7777-77', 22, 10),
(9, '__.___.___/____-__', 24, 10),
(10, '46.523.333/3333-33', 25, 10),
(11, '32.222.222/2222-22', 26, 10),
(12, '29.929.292/9299-29', 29, 0),
(13, '11.111.111/1111-11', 31, 19);

-- --------------------------------------------------------

--
-- Estrutura da tabela `racacachorro`
--

CREATE TABLE IF NOT EXISTS `racacachorro` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `origem` varchar(45) DEFAULT NULL,
  `tamanhoMax` double DEFAULT NULL,
  `tamanhoMin` double DEFAULT NULL,
  `expectativaVida` int(11) DEFAULT NULL,
  `temperamento` text
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Extraindo dados da tabela `racacachorro`
--

INSERT INTO `racacachorro` (`id`, `nome`, `origem`, `tamanhoMax`, `tamanhoMin`, `expectativaVida`, `temperamento`) VALUES
(2, 'Siames Branco', 'Coreano', 2, 1.5, 15, 'Variante'),
(9, 'PASTOR ALEMÃO', 'ALEMÃ', 10, 5, 8, 'Complicado'),
(14, 'SRD', 'BRASIL', 1.4, 1, 19, 'CALMO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `racagato`
--

CREATE TABLE IF NOT EXISTS `racagato` (
`id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `origem` varchar(45) NOT NULL,
  `tamanhoMax` double NOT NULL,
  `tamanhoMin` double NOT NULL,
  `expectativaVida` int(11) NOT NULL,
  `temperamento` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id` int(11) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `senha`, `email`) VALUES
(1, 'mushi', '202cb962ac59075b964b07152d234b70', NULL),
(2, 'mikaru', '123', NULL),
(3, 'paulo', '202cb962ac59075b964b07152d234b70', 'paulo@d.com'),
(4, 'paulo', '202cb962ac59075b964b07152d234b70', 'paulo@d.com'),
(5, 'cristoforetti', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'cristoforetti@nasa.com'),
(6, 'marcos', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'marcos@hotmail.com'),
(7, 'joel', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'joel@mail.com'),
(8, 'Charles', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'charles@mail.com'),
(9, 'paulao', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'paulao@mail.com'),
(10, 'jorginho', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'jorginho@mail.com'),
(11, 'jorge', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'jorge@mail.com'),
(12, 'lisansouza', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'l@m.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adocao`
--
ALTER TABLE `adocao`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adotante`
--
ALTER TABLE `adotante`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
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
-- Indexes for table `racacachorro`
--
ALTER TABLE `racacachorro`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `racagato`
--
ALTER TABLE `racagato`
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
-- AUTO_INCREMENT for table `adocao`
--
ALTER TABLE `adocao`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `adotante`
--
ALTER TABLE `adotante`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `pessoafisica`
--
ALTER TABLE `pessoafisica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `racacachorro`
--
ALTER TABLE `racacachorro`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `racagato`
--
ALTER TABLE `racagato`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

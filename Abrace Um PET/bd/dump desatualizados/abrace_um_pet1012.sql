-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 07-Dez-2014 às 17:46
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `adocao`
--

INSERT INTO `adocao` (`id`, `idAnimal`, `idAdotante`, `dataAdocao`, `dataDevolucao`, `idUsuario`) VALUES
(1, 1, 18, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `adotante`
--

CREATE TABLE IF NOT EXISTS `adotante` (
`id` int(11) NOT NULL,
  `impedimento` tinyint(1) DEFAULT NULL,
  `motivoImpedimeto` text,
  `idPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

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
(39, NULL, NULL, 22);

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `rga` varchar(45) DEFAULT NULL,
  `dataNascimento` timestamp NULL DEFAULT NULL,
  `idRaca` int(11) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `deficiencia` text,
  `vacinado` tinyint(1) DEFAULT NULL,
  `castrado` tinyint(1) DEFAULT NULL,
  `tamanho` double DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `temperamento` text,
  `observacao` text,
  `dataResgate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`id`, `nome`, `tipo`, `rga`, `dataNascimento`, `idRaca`, `genero`, `deficiencia`, `vacinado`, `castrado`, `tamanho`, `peso`, `temperamento`, `observacao`, `dataResgate`) VALUES
(1, 'Cat', 'gato', '7921', NULL, 1, 'M', NULL, 1, 1, 1, 20, NULL, NULL, NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `estado`, `cidade`, `bairro`, `rua`, `numero`, `complemento`, `cep`) VALUES
(3, 'PERNAMBUCO', 'RECIFE', 'VARZEA', 'RUA DEPUTADO ADALBERTO GUERRA', '83', 'CASA A', '50980615'),
(4, 'PERNAMBUCO', 'RECIFE', 'CAXANGA', 'RUA 00', '2', '', '50987651'),
(24, 'Kanto', 'Tokyo', 'Shibuya', 'chigachi', '87', 'BA', '52030100'),
(25, 'Kanto', 'Tokyo', 'Shinjuku', 'choujichi', '63', 'B2', '52030100'),
(26, 'PE', 'Recife', 'Arruda', 'Rua 3', '45', 'A33', '52030100'),
(27, 'fsdf', 'sdfsdf', 'fsd', 'sfsdfsdf', 'sdfsd', 'sdf', '52030100'),
(28, 'erw', 'wer', 'wer', 'rw', 'wer', 'ewr', '52030100'),
(29, 'London', 'London', 'Hammersmith', 'London street', '458', 'A34', '52030100'),
(30, 'iii', 'iii', 'iii', 'iiiii', '3', 'ii', '33.333-333'),
(31, 'iiii', 'iiiiiiii', 'iii', 'rr', '9', 'i', '99.999-999'),
(32, 'kh', 'ss', 'ggvccc', 'fff', '3', '', '44.444-444'),
(33, 'F', 'W', 'ffff', 'ff', '9', '', '33.333-333'),
(34, 'fvd', 'r', 'fff', 'sssss', '4', '', '44.444-444'),
(35, 'srg', 'dgg', 'gggg', 'eeeeeeeeeeeeeee', '3', 's', '44.444-444'),
(36, 'jjj', 'bee', 'vaa', 'dd', '9', '', '33.333-339'),
(37, 'k', 'k', 'r', 'jj', '3', '', '33.333-333'),
(38, 'hjkd', 'jhd', 'fjndb', '4', '3', '', '99.999-999'),
(39, 'jj', 'jj', 'jj', 'iwi', '99', '', '99.393-939'),
(40, 'dsg', 'wrg', 'eee', 'eeee', '2', '', '22.222-222'),
(41, 'sd', 'wed', 'e', '3re', '23', '', '32.222-222'),
(42, 'j', 'j', 'j', 'eki', '2', '', '00.000-000'),
(43, 'KL', 'JK', 'J', 'JKFKD', '0', '', '99.999-999'),
(44, 'f', 'gb', 'd', 'ef', '3', 'f', '33.333-333');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `idEndereco`, `telefoneFixo`, `telefoneCelular`, `email`) VALUES
(3, 'Yukito Ayatsuji', 24, '08199652341', '08134445678', 'ayatsuji@mail.com'),
(4, 'JBC', 25, '08134445896', '08134445896', 'contato@jbc.com'),
(5, 'Prorenc', 26, '08134446471', '08134446471', 'pro@mail.com'),
(6, 'dfafsd', 27, '08134446471', '08134446471', 'dfs@h.com'),
(7, 'qewqewreqw', 28, '08134446471', '08134446471', 'asd@dw.com'),
(8, 'Oxford', 29, '08134446471', '08134446471', 'oxford@oxford.com'),
(9, 'jajaj', 31, '(22)2222-2222', '(44)4444-4444', 'l@g.com'),
(10, 'ljkh', 32, '(33)3333-3333', '(50)0000-0000', 'L@g.com'),
(11, 'hahahahahhahaha', 33, '(20)9888-8888', '(20)3847-8299', 'f@f.com'),
(12, 'dddddd', 34, '(22)2222-2222', '(45)5555-5555', 'dd@g.com'),
(13, 'efwde', 35, '(22)2222-2222', '(45)5555-5555', 'lisansouz@gm.com'),
(14, 'lana ltda', 36, '(44)4443-3333', '(04)8483-8488', 'l@g.com'),
(15, 'lllalla', 37, '(33)3333-3333', '(55)5555-5555', 'K@gm.com'),
(16, 'florentina', 38, '(22)2455-5555', '(38)3333-3333', 'k@gmail.com'),
(17, 'paulao', 39, '(98)9898-9898', '(98)9898-9898', 'l@gmail.com'),
(18, 'hahah', 40, '(33)3333-3333', '(45)5555-5555', 'u2@f.com'),
(19, 'wr''r', 41, '(33)3333-3333', '(33)3555-5555', 'j@e.com'),
(20, 'ANA MARIA LOUCA', 42, '(44)4444-4444', '(99)9999-9999', 'L@c.com'),
(21, 'NA MA LTDA', 43, '(30)9888-8888', '(90)8888-8888', 'JD@g.com'),
(22, 'dsgafads', 44, '(42)2222-2222', '(24)4444-4444', 'l.@w.com');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

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
(16, '9999393', '030.949.494-99', 'F', 20);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoajuridica`
--

CREATE TABLE IF NOT EXISTS `pessoajuridica` (
`id` int(11) NOT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  `idPessoaFisica` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

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
(8, '67.878.777/7777-77', 22, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `raca`
--

CREATE TABLE IF NOT EXISTS `raca` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `origem` varchar(45) DEFAULT NULL,
  `tamanhoMax` double DEFAULT NULL,
  `tamanhoMin` double DEFAULT NULL,
  `expectativaVida` int(11) DEFAULT NULL,
  `temperamento` text
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `raca`
--

INSERT INTO `raca` (`id`, `nome`, `origem`, `tamanhoMax`, `tamanhoMin`, `expectativaVida`, `temperamento`) VALUES
(1, 'Persa', 'Oriente', 45, 30, 5, NULL);

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
-- Indexes for table `raca`
--
ALTER TABLE `raca`
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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `adotante`
--
ALTER TABLE `adotante`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `pessoafisica`
--
ALTER TABLE `pessoafisica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `raca`
--
ALTER TABLE `raca`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 24-Dez-2014 às 01:37
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `adocao`
--

INSERT INTO `adocao` (`id`, `idAnimal`, `idAdotante`, `dataAdocao`, `dataDevolucao`, `idUsuario`) VALUES
(1, 1, 18, NULL, '2014-12-17 16:09:05', NULL),
(2, 1, 19, NULL, NULL, NULL),
(3, 1, 19, NULL, NULL, NULL),
(4, 1, 23, NULL, NULL, NULL),
(5, 1, 23, NULL, NULL, NULL),
(6, 1, 23, NULL, NULL, NULL),
(7, 1, 32, '2014-12-18 12:51:51', NULL, 9);

-- --------------------------------------------------------

--
-- Estrutura da tabela `adotante`
--

CREATE TABLE IF NOT EXISTS `adotante` (
`id` int(11) NOT NULL,
  `impedimento` tinyint(1) DEFAULT NULL,
  `motivoImpedimeto` text,
  `idPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=37 ;

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
(24, NULL, NULL, 0),
(25, NULL, NULL, 0),
(26, NULL, NULL, 0),
(27, NULL, NULL, 0),
(28, NULL, NULL, 0),
(29, NULL, NULL, 0),
(30, NULL, NULL, 0),
(31, NULL, NULL, 0),
(32, NULL, NULL, 9),
(33, NULL, NULL, 10),
(34, NULL, NULL, 11),
(35, NULL, NULL, 12),
(36, NULL, NULL, 13);

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `tipo` varchar(120) DEFAULT NULL,
  `rga` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `idRaca` int(11) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `deficiencia` text,
  `vacinado` varchar(45) DEFAULT NULL,
  `castrado` varchar(45) DEFAULT NULL,
  `tamanho` double DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `temperamento` text,
  `observacao` text,
  `dataResgate` varchar(45) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`id`, `nome`, `tipo`, `rga`, `dataNascimento`, `idRaca`, `genero`, `deficiencia`, `vacinado`, `castrado`, `tamanho`, `peso`, `temperamento`, `observacao`, `dataResgate`) VALUES
(1, 'Cat', 'gato', '7921', NULL, 1, 'M', NULL, '1', '1', 1, 20, NULL, NULL, NULL),
(2, 'rwtretr', 'gato', 'rrrrr', '11/1111', NULL, '', '', '1', '1', 11.11, 1.22, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4d15aaeb,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@bb54828,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@bb54828}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4d15aaeb,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@668aca93,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@668aca93}]', '11/11/1111'),
(3, 'dsfsdf', 'Gato', 'dsfsdf', '22/2222', NULL, '', '', '1', '1', 22.22, 1.22, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@6c6c80f1,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@1a4764e,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@1a4764e}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@6c6c80f1,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@5eb4ee36,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@5eb4ee36}]', '22/22/2222'),
(4, 'adsff', 'Gato', '222222222222222', '22/2222', NULL, 'Macho', 'Auditiva', 'Sim', 'Sim', 22.22, 1.22, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@3692c09,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@2669822f,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@2669822f}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@3692c09,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@42963634,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@42963634}]', '22/22/2222'),
(5, 'asdsa', 'Gato', 'sadsadsa', '11/1111', NULL, 'Macho', 'Auditiva', 'Não', 'Sim', 11.11, 11.11, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4b3356a6,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@14738413,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@14738413}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4b3356a6,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@6e938623,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@6e938623}]', '11/11/1111'),
(6, 'wewqe', 'Cachorro', 'errrrrrrrrrrrr', '22/2222', NULL, 'Macho', 'Fisica', 'Não', 'Sim', 22.22, 22.22, NULL, 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@bd10581,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@33ab9440,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@33ab9440}]', '22/22/2222'),
(7, 'ewwrer', 'Gato', '111', '11/1111', NULL, 'Fêmea', 'Auditiva', 'Não', 'Sim', 11.11, 11.11, '1111111111111', '1111', '11/11/1111'),
(8, 'Gatinho', 'Gato', '4443', '11/1111', NULL, 'Macho', 'Auditiva', 'Sim', 'Sim', 11.11, 11.11, 'ruim', 'nenhuma', '11/11/1111'),
(9, 'ioooooooooo', 'Gato', '00000000000000', '33/3333', NULL, 'Macho', 'Nenhuma', 'Sim', 'Sim', 33.33, 33.33, '0000000000', '000000000000000000', '33/33/3333'),
(10, 'LULU', 'Cachorro', '3333', '09/2010', NULL, 'Fêmea', 'Nenhuma', 'Sim', 'Sim', 1, 22, 'CALMA', ' ', '21/10/2013');

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
  `cep` varchar(15) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

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
(30, 'Pernambuco', 'Recife', 'Pina', 'rua antonio feire', '99', '', '99.999-999'),
(31, 'pe', 'racife', 'pina', '001', '00', 's', '22.222-222'),
(32, '12121', '121212', '121212', '21212121212', '12', '', '12.121-212'),
(33, 'pernambuco', 'recife', 'varzea', 'doutor guilherme', '2', 'kkk', '93.939-399'),
(34, 'pernambuuco', 'recife', 'varzea', 'doutor pedro', '33', 'd', '34.543-575');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

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
(9, 'LISA CRUZ', 31, '(22)2222-2222', '(44)4444-4444', 'd@g.com'),
(10, 'AAAAAAA', 0, '(23)3333-3333', '(55)5555-5555', 'D@g.com'),
(11, '1212121212121', 32, '(56)6666-6666', '(12)1212-1212', '12@g.com'),
(12, 'LUCAS CRUZ', 33, '(92)8470-3294', '(28)8349-2730', 'lucas@g.com'),
(13, 'JONAS LTDA', 34, '(24)3543-6346', '(35)3456-3446', 'D#@df.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoafisica`
--

CREATE TABLE IF NOT EXISTS `pessoafisica` (
`id` int(11) NOT NULL,
  `rg` varchar(11) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `pessoafisica`
--

INSERT INTO `pessoafisica` (`id`, `rg`, `cpf`, `genero`, `idPessoa`) VALUES
(10, '7852413', '082.323.444-40', 'M', 3),
(11, '0000000', '000.000.000-00', 'M', 6),
(12, '9887654', '097.913.666-66', 'F', 0),
(13, '3333333', '333.333.333-33', 'M', 0),
(14, '3333333', '097.913.666-61', 'M', 0),
(15, '1212121', '121.212.121-21', 'M', 0),
(16, '2009877', '097.913.662-22', 'F', 0),
(17, '1223432', '098.888.888-88', 'M', 9),
(18, '6666666', '666.666.666-66', 'M', 10),
(19, '1212121', '321.321.321-32', 'M', 11),
(20, '0948583', '097.777.777-77', 'M', 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoajuridica`
--

CREATE TABLE IF NOT EXISTS `pessoajuridica` (
`id` int(11) NOT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  `idPessoaFisica` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `pessoajuridica`
--

INSERT INTO `pessoajuridica` (`id`, `cnpj`, `idPessoa`, `idPessoaFisica`) VALUES
(3, '01.234.567/8912-34', 8, 10),
(4, '29.299.999/9999-99', 0, 10),
(5, '11.111.111/1111-12', 13, 20);

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
  `temperamento` text,
  `tipo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `raca`
--

INSERT INTO `raca` (`id`, `nome`, `origem`, `tamanhoMax`, `tamanhoMin`, `expectativaVida`, `temperamento`, `tipo`) VALUES
(1, 'Persa', 'Oriente', 45, 30, 5, NULL, NULL),
(2, 'JUJU', 'BRASIL', 2.22, 2.22, 22, '', NULL),
(3, 'jiji', 'brasil', 2.11, 0, 33, 'e', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id` int(11) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

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
(12, 'usuario', '2cbe7f341eb6aca638a32b77ddedfd4c', 'usua@gmail.com'),
(13, 'lisandra', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'l@g.com'),
(14, 'rodolfo', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'l@g.com'),
(15, 'paulo', '98a9c12a85dc1dfe303bb0c000855e97', 'O\\W2!!@v.com'),
(16, 'juca', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'd@f.com');

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `adotante`
--
ALTER TABLE `adotante`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `pessoafisica`
--
ALTER TABLE `pessoafisica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `raca`
--
ALTER TABLE `raca`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

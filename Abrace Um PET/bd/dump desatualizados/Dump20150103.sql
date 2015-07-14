CREATE DATABASE  IF NOT EXISTS `abrace_um_pet` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `abrace_um_pet`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: abrace_um_pet
-- ------------------------------------------------------
-- Server version	5.6.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adocao`
--

DROP TABLE IF EXISTS `adocao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adocao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAnimal` int(11) DEFAULT NULL,
  `idAdotante` int(11) DEFAULT NULL,
  `dataAdocao` timestamp NULL DEFAULT NULL,
  `dataDevolucao` timestamp NULL DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adocao`
--

LOCK TABLES `adocao` WRITE;
/*!40000 ALTER TABLE `adocao` DISABLE KEYS */;
INSERT INTO `adocao` VALUES (9,1,18,'2014-12-17 15:00:50','2014-12-17 15:02:21',9,1),(14,7,23,'2014-12-17 15:43:35','2014-12-17 15:44:09',9,1),(15,7,18,'2014-12-17 15:51:18','2014-12-17 15:51:32',9,1);
/*!40000 ALTER TABLE `adocao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adotante`
--

DROP TABLE IF EXISTS `adotante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adotante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `impedimento` tinyint(1) DEFAULT NULL,
  `motivoImpedimeto` text,
  `idPessoa` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adotante`
--

LOCK TABLES `adotante` WRITE;
/*!40000 ALTER TABLE `adotante` DISABLE KEYS */;
INSERT INTO `adotante` VALUES (18,NULL,NULL,3,0),(19,NULL,NULL,4,1),(20,NULL,NULL,5,1),(21,NULL,NULL,6,1),(22,NULL,NULL,7,1),(23,NULL,NULL,8,1),(24,NULL,NULL,11,1),(25,NULL,NULL,12,1);
/*!40000 ALTER TABLE `adotante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `dataResgate` varchar(45) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'Cat','gato','7921',NULL,1,'M',NULL,'1','1',1,20,NULL,NULL,NULL,1),(2,'rwtretr','gato','rrrrr','11/1111',NULL,'','','1','1',11.11,1.22,'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4d15aaeb,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@bb54828,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@bb54828}]','javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4d15aaeb,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@668aca93,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@668aca93}]','11/11/1111',1),(3,'dsfsdf','Gato','dsfsdf','22/2222',NULL,'','','1','1',22.22,1.22,'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@6c6c80f1,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@1a4764e,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@1a4764e}]','javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@6c6c80f1,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@5eb4ee36,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@5eb4ee36}]','22/22/2222',1),(4,'adsff','Gato','222222222222222','22/2222',NULL,'Macho','Auditiva','Sim','Sim',22.22,1.22,'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@3692c09,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@2669822f,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@2669822f}]','javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@3692c09,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@42963634,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@42963634}]','22/22/2222',1),(5,'asdsa','Gato','sadsadsa','11/1111',NULL,'Macho','Auditiva','Não','Sim',11.11,11.11,'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4b3356a6,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@14738413,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@14738413}]','javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4b3356a6,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@6e938623,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@6e938623}]','11/11/1111',1),(6,'wewqe','Cachorro','errrrrrrrrrrrr','22/2222',NULL,'Macho','Fisica','Não','Sim',22.22,22.22,NULL,'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@bd10581,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@33ab9440,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@33ab9440}]','22/22/2222',1),(7,'Sr. Gato','Gato','111','11/1111',NULL,'Fêmea','Auditiva','Não','Sim',11.11,11.11,'1111111111111','1111','11/11/1111',1),(8,'Gatinho','Gato','4443','11/1111',NULL,'Macho','Auditiva','Sim','Sim',11.11,11.11,'ruim','nenhuma','11/11/1111',1);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (3,'PERNAMBUCO','RECIFE','VARZEA','RUA DEPUTADO ADALBERTO GUERRA','83','CASA A','50980615',1),(4,'PERNAMBUCO','RECIFE','CAXANGA','RUA 00','2','','50987651',1),(24,'Kanto','Tokyo','Shibuya','chigachi','87','BA','52030100',0),(25,'Kanto','Tokyo','Shinjuku','choujichi','63','B2','52030100',1),(26,'PE','Recife','Arruda','Rua 3','45','A33','52030100',1),(27,'fsdf','sdfsdf','fsd','sfsdfsdf','sdfsd','sdf','52030100',1),(28,'erw','wer','wer','rw','wer','ewr','52030100',1),(29,'London','London','Hammersmith','London street','458','A34','52030100',1),(30,'3223','33333333333333','3232','erewrrewewrewr','3232','','33.333-333',1),(31,'2222','2222','2222','2222222222','222','','22.222-222',1),(32,'222','22222222','22','22222222222222222222','222','','22.222-222',1),(33,'3','3','33','3333333333333','33','','33.333-333',1),(34,'222','222','222','222','222','','22.222-222',1),(35,'dsdssd','dsds','dsds','sddssd','sdds','','22.222-222',1);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) DEFAULT NULL,
  `idEndereco` int(11) DEFAULT NULL,
  `telefoneFixo` varchar(45) DEFAULT NULL,
  `telefoneCelular` varchar(45) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (3,'Yukito Ayatsuji',24,'08199652341','08134445678','ayatsuji@mail.com',0),(4,'JBC',25,'08134445896','08134445896','contato@jbc.com',1),(5,'Prorenc',26,'08134446471','08134446471','pro@mail.com',1),(6,'dfafsd',27,'08134446471','08134446471','dfs@h.com',1),(7,'qewqewreqw',28,'08134446471','08134446471','asd@dw.com',1),(8,'Oxford',29,'08134446471','08134446471','oxford@oxford.com',1),(9,'wqewqe',32,'(22)2222-2222','(22)2222-2222','222222222222222222222222',1),(10,'ewe',33,'(33)3333-3333','(33)3333-3333','e@f.vo',1),(11,'sdxdxd',34,'(55)5555-5555','(22)2222-2222','222222222222222',1),(12,'dsdsadsasda',35,'(22)2222-2222','(22)2222-2222','k@k.com',1);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoafisica`
--

DROP TABLE IF EXISTS `pessoafisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoafisica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rg` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoafisica`
--

LOCK TABLES `pessoafisica` WRITE;
/*!40000 ALTER TABLE `pessoafisica` DISABLE KEYS */;
INSERT INTO `pessoafisica` VALUES (10,'7852413','082.323.444-40','M',3,0),(11,'1234567','222.222.222-22','F',12,1);
/*!40000 ALTER TABLE `pessoafisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoajuridica`
--

DROP TABLE IF EXISTS `pessoajuridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoajuridica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  `idPessoaFisica` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoajuridica`
--

LOCK TABLES `pessoajuridica` WRITE;
/*!40000 ALTER TABLE `pessoajuridica` DISABLE KEYS */;
INSERT INTO `pessoajuridica` VALUES (2,'01.234.567/8998-74',4,NULL,1),(3,'01.234.567/8912-34',8,10,1),(4,'22.222.222/2222-22',11,10,1);
/*!40000 ALTER TABLE `pessoajuridica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raca`
--

DROP TABLE IF EXISTS `raca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `raca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `origem` varchar(45) DEFAULT NULL,
  `tamanhoMax` double DEFAULT NULL,
  `tamanhoMin` double DEFAULT NULL,
  `expectativaVida` int(11) DEFAULT NULL,
  `temperamento` text,
  `status` tinyint(1) DEFAULT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raca`
--

LOCK TABLES `raca` WRITE;
/*!40000 ALTER TABLE `raca` DISABLE KEYS */;
INSERT INTO `raca` VALUES (1,'Persa','Oriente',45,30,5,NULL,1);
/*!40000 ALTER TABLE `raca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0 - Inativo 1 - Ativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'mushi','202cb962ac59075b964b07152d234b70',NULL,1),(2,'mikaru','123',NULL,1),(3,'paulo','202cb962ac59075b964b07152d234b70','paulo@d.com',1),(4,'paulo','202cb962ac59075b964b07152d234b70','paulo@d.com',1),(5,'cristoforetti','a85d63d01bd61ccd5d2798bcb6bc4c99','cristoforetti@nasa.com',1),(6,'marcos','a85d63d01bd61ccd5d2798bcb6bc4c99','marcos@hotmail.com',1),(7,'joel','a85d63d01bd61ccd5d2798bcb6bc4c99','joel@mail.com',1),(8,'Charles','a85d63d01bd61ccd5d2798bcb6bc4c99','charles@mail.com',1),(9,'paulof','a85d63d01bd61ccd5d2798bcb6bc4c99','paulao@mail.com',1),(10,'jorginho','a85d63d01bd61ccd5d2798bcb6bc4c99','jorginho@mail.com',1),(11,'jorge','a85d63d01bd61ccd5d2798bcb6bc4c99','jorge@mail.com',1),(12,'paulor','a85d63d01bd61ccd5d2798bcb6bc4c99','paulor@mail.com',1),(13,'isabella ','a85d63d01bd61ccd5d2798bcb6bc4c99','isabella@mail.com',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-03  0:42:46

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
  `id` int(11) NOT NULL,
  `idAnimal` tinyint(1) DEFAULT NULL,
  `idAdotante` tinyint(11) DEFAULT NULL,
  `dataAdocao` timestamp NULL DEFAULT NULL,
  `dataDevolucao` timestamp NULL DEFAULT NULL,
  `idUsuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adocao`
--

LOCK TABLES `adocao` WRITE;
/*!40000 ALTER TABLE `adocao` DISABLE KEYS */;
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
  `nome` varchar(45) DEFAULT NULL,
  `idEndereco` tinyint(1) DEFAULT NULL,
  `telefoneFixo` varchar(11) DEFAULT NULL,
  `telefoneCelular` varchar(11) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL,
  `impedimento` tinyint(1) DEFAULT NULL,
  `motivoImpedimeto` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adotante`
--

LOCK TABLES `adotante` WRITE;
/*!40000 ALTER TABLE `adotante` DISABLE KEYS */;
INSERT INTO `adotante` VALUES (1,'Amigo',5,'32432432','432432','234324',NULL,NULL),(2,'Paulo Roberto França Filho',6,'8134446471','8199344308','paulao@mail.com',NULL,NULL),(3,'Fernando Freire',7,'8134567896','8199654732','ffreire@mail.com',NULL,NULL),(4,'Jose Ferreira',8,'8134446578','8199663548','ferreira@gmail.com',NULL,NULL),(6,'Ferdinando Moura',10,'8134569874','8199654732','moura@mail.com',NULL,NULL);
/*!40000 ALTER TABLE `adotante` ENABLE KEYS */;
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
  `cep` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'as','as','sas','as','null','asasa','asas'),(2,'asdas','dasda','asdasd','adsasd','null','sdasdasd','asdas'),(3,'zcxc','xzczxcx','zxczx','zxczx','null','zczxc','cxzc'),(4,'sdf','sdfsd','sdf','sdfsd','null','fdsfsdf','fsdf'),(5,'sadas','asdsad','asdad','Nova',NULL,'asdsadsad','sadasd'),(6,'279','Recife','Pernambuco','Rua 24 de Junho',NULL,'1004','52030100'),(7,'15','Rio de Janeiro','Rio de Janeiro','Rua 31 de Março','15','56','56210360'),(8,'45','Recife','Pernambuco','Rua do Machado','45','104','52120250'),(10,'41','Recife','Pernambuco','Rua das Moças','41','102','52010200');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoafisica`
--

DROP TABLE IF EXISTS `pessoafisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoafisica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rg` varchar(11) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `idAdotante` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoafisica`
--

LOCK TABLES `pessoafisica` WRITE;
/*!40000 ALTER TABLE `pessoafisica` DISABLE KEYS */;
INSERT INTO `pessoafisica` VALUES (1,'234','4324',NULL,1),(2,'7922711','08232344440',NULL,2),(3,'8654123','09245678910',NULL,3),(5,'7894521','05896977745','M',6);
/*!40000 ALTER TABLE `pessoafisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoajuridica`
--

DROP TABLE IF EXISTS `pessoajuridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoajuridica` (
  `id` int(11) NOT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `idResponsavel` tinyint(11) DEFAULT NULL,
  `idAdotante` tinyint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoajuridica`
--

LOCK TABLES `pessoajuridica` WRITE;
/*!40000 ALTER TABLE `pessoajuridica` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoajuridica` ENABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'mushi','202cb962ac59075b964b07152d234b70',NULL),(2,'mikaru','123',NULL),(3,'paulo','202cb962ac59075b964b07152d234b70','paulo@d.com'),(4,'paulo','202cb962ac59075b964b07152d234b70','paulo@d.com'),(5,'cristoforetti','a85d63d01bd61ccd5d2798bcb6bc4c99','cristoforetti@nasa.com'),(6,'marcos','a85d63d01bd61ccd5d2798bcb6bc4c99','marcos@hotmail.com'),(7,'joel','a85d63d01bd61ccd5d2798bcb6bc4c99','joel@mail.com'),(8,'Charles','a85d63d01bd61ccd5d2798bcb6bc4c99','charles@mail.com'),(9,'paulao','a85d63d01bd61ccd5d2798bcb6bc4c99','paulao@mail.com');
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

-- Dump completed on 2014-11-23 23:23:57

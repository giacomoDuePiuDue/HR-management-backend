-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: hrmanagement
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `competenze`
--

DROP TABLE IF EXISTS `competenze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competenze` (
  `id_competenze` int NOT NULL AUTO_INCREMENT,
  `id_curriculum` int NOT NULL,
  `id_tipskill` int DEFAULT NULL,
  `id_dipendente` int NOT NULL,
  PRIMARY KEY (`id_competenze`),
  KEY `id_curriculum_idx` (`id_curriculum`),
  KEY `id_tipskill_idx` (`id_tipskill`) /*!80000 INVISIBLE */,
  KEY `id_dipendente_idx` (`id_dipendente`),
  CONSTRAINT `id_curriculum` FOREIGN KEY (`id_curriculum`) REFERENCES `curriculum` (`id_curriculum`),
  CONSTRAINT `id_dipendente` FOREIGN KEY (`id_dipendente`) REFERENCES `dipendente` (`id_dipendente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_tipskill` FOREIGN KEY (`id_tipskill`) REFERENCES `tipskill` (`id_tipskill`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competenze`
--

LOCK TABLES `competenze` WRITE;
/*!40000 ALTER TABLE `competenze` DISABLE KEYS */;
INSERT INTO `competenze` VALUES (1,1,2,1),(2,2,1,2),(3,3,3,3),(4,4,7,4),(5,5,4,5),(6,6,5,6),(7,7,6,7),(8,8,10,8),(9,9,9,9),(10,10,8,10),(11,11,2,52),(12,12,3,54),(42,1,4,1),(43,2,2,2),(44,5,7,5),(45,2,3,2),(46,2,4,2),(47,131,9,77),(48,132,8,162),(49,133,5,163),(50,12,6,54),(51,11,7,52),(52,6,6,6),(53,3,1,3),(54,3,2,3),(55,3,4,3),(56,4,2,4),(57,4,3,4),(58,4,4,4),(59,134,8,185),(60,135,9,186),(61,134,7,185),(62,134,6,185),(63,136,3,136),(64,136,4,136),(65,136,5,136),(66,136,6,136),(74,149,2,217),(77,152,2,228),(78,153,2,229),(79,154,2,233),(80,155,1,233),(81,155,4,233),(82,155,2,233),(83,156,1,235),(84,157,2,235),(85,157,4,235),(86,157,1,235),(87,158,2,236),(88,158,1,236),(89,158,4,236),(90,159,5,235),(91,159,2,235),(92,159,1,235),(93,159,4,235),(94,158,4,236),(95,158,1,236),(96,158,2,236),(97,158,5,236);
/*!40000 ALTER TABLE `competenze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curriculum`
--

DROP TABLE IF EXISTS `curriculum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curriculum` (
  `id_curriculum` int NOT NULL AUTO_INCREMENT,
  `id_dipendente` int NOT NULL,
  `curriculum` mediumblob,
  PRIMARY KEY (`id_curriculum`),
  KEY `id_dipendente_idx` (`id_dipendente`),
  CONSTRAINT `id_di` FOREIGN KEY (`id_dipendente`) REFERENCES `dipendente` (`id_dipendente`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curriculum`
--

LOCK TABLES `curriculum` WRITE;
/*!40000 ALTER TABLE `curriculum` DISABLE KEYS */;
INSERT INTO `curriculum` VALUES (1,1,_binary 'Lillie Carter nata a \'Roma\' il 26/12/1972 specializzata in: \'Rust\', \'CSS\', \'HTML\'.'),(2,2,_binary 'Jennie Wills nata a \'Roma\' il 22/01/1976 specializzata in: \'C\', \'CSS\', \'React JS\'.'),(3,3,_binary 'Mark Hale nato a \'Roma\' il 01/12/1993 specializzato in: \'Angular\', \'C\', \'Python\'.'),(4,4,_binary 'Cristo Lowery nato a \'Roma\' il 16/09/1991 specializzato in: \'HTML\', \'JavaScript\', \'Python\'.'),(5,5,_binary 'Frank Smith nato a \'Roma\' il 11/10/1972 specializzato in: \'JavaScript\', \'Rust\', \'Lisp\'.'),(6,6,_binary 'Deborah Hayles nata a \'Roma\' il 26/02/1993 specializzata in: \'Java\', \'Lisp\', \'Rust\'.'),(7,7,_binary 'Jayne Dolan nata a \'Roma\' il 24/05/1977 specializzata in: \'Lisp\', \'CSS\', \'Python\'.'),(8,8,_binary 'Loran Dysart nata a \'Roma\' il 23/05/1976 specializzata in: \'Lisp\', \'CSS\', \'JavaScript\'.'),(9,9,_binary 'Tizio Caglio nata a \'Roma\' il 18/02/2018 specializzato in: \'C\'.'),(10,10,_binary 'Alaska Native nata a \'Roma\' il 17/01/1979 specializzata in: \'Rust\', \'HTML\', \'Angular JS\'.'),(11,52,_binary 'Paolo Felicani nato a Roma il 20/01/1999 specializzata in:  \'Java\'.'),(137,54,_binary 'Janae Jamison nata a \'Roma\' il 17/01/1979 specializzata in: \'CSS\'.'),(138,185,_binary 'Alfredo Niccolo nato a \'Roma\' il 12/02/2021 specializzata in: \'React JS\', \'Angular JS\', \'Rust\' .'),(139,186,_binary 'Tizio Caglio nata a \'Roma\' il 18/02/2021 specializzato in: \'C\'.'),(140,136,_binary 'Mario Balotelli nato a \'Roma\' il 05/02/2005  specializzata in: \'HTML\', \'CSS\', \'Javascript\',\'Angular JS\'.'),(148,217,_binary 'Euc Con nato a \'Roma\' il 22/04/1999 specializzato in: \'Java\'.'),(149,217,_binary 'Euc Con nato a \'Roma\' il 22/04/1999 specializzato in: \'Java\'.'),(152,228,_binary 'Euc Con nato a \'Roma\' il 2001-03-26 specializzato in: \'Java\'.'),(153,229,_binary 'Alfredo Niccolo nato a \'Roma\' il 12/02/2021 specializzata in: \'React JS\', \'Angular JS\', \'Rust\' .'),(154,233,_binary 'Euc Con nato a \'Roma\' il 2001-03-26 specializzato in: \'Java\'.'),(155,233,_binary 'Euc Con nato a \'Roma\' il 2001-03-26 specializzato in: \'Java\'.'),(156,235,_binary 'Euc Con nato a \'Roma\' il 2001-03-26 specializzato in: \'Java\'.'),(157,235,_binary 'Euc Con nato a \'Roma\' il 2001-03-26 specializzato in: \'Java\'.'),(158,236,_binary 'Euc Con nato a \'Roma\' il 2001-03-26 specializzato in: \'Java\'.'),(159,235,_binary 'Euc Con nato a \'Roma\' il 2001-03-26 specializzato in: \'Java\'.');
/*!40000 ALTER TABLE `curriculum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendente`
--

DROP TABLE IF EXISTS `dipendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dipendente` (
  `id_dipendente` int NOT NULL AUTO_INCREMENT,
  `matricola` varchar(10) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `id_ref_nazionalita` int NOT NULL,
  `citta` varchar(45) NOT NULL DEFAULT 'Roma',
  `indirizzo` varchar(45) NOT NULL DEFAULT 'Via Mosca, 52',
  `id_ref_skill` int NOT NULL DEFAULT '0',
  `row_exist` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_dipendente`),
  UNIQUE KEY `matricola_UNIQUE` (`matricola`),
  KEY `id_ref_nazionalita_idx` (`id_ref_nazionalita`),
  CONSTRAINT `id_ref_nazionalita` FOREIGN KEY (`id_ref_nazionalita`) REFERENCES `ref_nazionalita` (`id_ref_nazionalita`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendente`
--

LOCK TABLES `dipendente` WRITE;
/*!40000 ALTER TABLE `dipendente` DISABLE KEYS */;
INSERT INTO `dipendente` VALUES (1,'1844776','Lillie','Carter','1972-12-26',1,'Roma','Via Mosca, 52',0,0),(2,'1844777','Jennie','Wills','1976-01-22',1,'Roma','Via Mosca, 52',0,0),(3,'1844778','Mark','Hale','1993-12-01',3,'Roma','Via Mosca, 52',0,0),(4,'1844779','Cristo','Lowery','1991-09-16',1,'Roma','Via Mosca, 52',0,0),(5,'1844780','Frank','Smith','1972-10-11',3,'Roma','Via Mosca, 52',0,1),(6,'1844781','Deborah','Hayles','1993-02-26',1,'Romas','Via Mosca, 52',0,1),(7,'1844782','Jayne','Dolan','1977-05-24',1,'Roma','Via Mosca, 52',0,1),(8,'1844783','Loren','Dysart','1976-05-23',2,'Roma','Via Mosca, 52',0,1),(9,'1844784','Jenae','Jamison','1979-01-17',2,'Roma','Via Mosca, 52',0,0),(10,'1844785','Alaska','Native','1979-01-17',1,'Roma','Via Mosca, 52',0,1),(52,'PAOFEL50','paolo','Felicani','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(54,'ASDFEL50','asdaolo','Felicanis','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(55,'ASDFSD50','asdaolo','Fsdddlicanis','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(61,'123','asdaolo','Fsdddlicanis','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(62,'ASDFSD61','asdaolo','Fsdddlicanis','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(63,'2312','asdaolo','Fsdddlicanis','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(64,'ASDFSD63','asdaolo','Fsdddlicanis','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(69,'GIOTRO69','giorgio','tronchesi','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(70,'GIOTRO70','giorgio','tronchesi','1999-01-20',1,'Roma','Via Mosca, 52',0,1),(71,'ASDASD71','asdasd','asdasd','2021-02-13',6,'Roma','Via Mosca, 52',0,1),(72,'ASDASD72','asdasd','asdasdadsa','2021-02-13',3,'Roma','Via Mosca, 52',0,1),(73,'ASDASD73','asdadas','asdadsasdasd','2021-02-10',4,'Roma','Via Mosca, 52',0,1),(74,'MARPOL74','Marco','Polo','2021-02-18',1,'Roma','Via Mosca, 52',0,1),(75,'NICFEL75','Niccolo','Felicani','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(76,'ASDEGI76','asdasda','egiziano','2020-10-07',5,'Roma','Via Mosca, 52',0,1),(77,'ASDASD77','asdasd','asdasda','2021-02-07',2,'Roma','Via Mosca, 52',0,1),(78,'ASDASD78','asd','asd','2021-02-11',1,'Roma','Via Mosca, 52',0,1),(79,'ASDASD79','asd','asd','2021-02-06',1,'Roma','Via Mosca, 52',0,1),(80,'ASDASD80','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(81,'ASDASD81','asd','asd','2021-02-04',9,'Roma','Via Mosca, 52',0,1),(82,'ASDASD82','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(83,'ASDASD83','asd','asd','2021-02-04',2,'Roma','Via Mosca, 52',0,1),(84,'ASDASD84','asd','asd','2021-02-06',1,'Roma','Via Mosca, 52',0,1),(85,'ASDASD85','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(86,'ASDASD86','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(87,'ASDASD87','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(88,'ASDASD88','asd','asd','2021-02-12',1,'Roma','Via Mosca, 52',0,1),(89,'NOMCOG89','Nome','Cognome','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(90,'NOMCOG90','Nome','Cognome','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(91,'ASDASD91','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(92,'ASDASD92','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(93,'ASDASD93','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(94,'ASDASD94','asd','asd','2021-02-05',2,'Roma','Via Mosca, 52',0,1),(95,'ASDASD95','asd','asd','2021-02-03',1,'Roma','Via Mosca, 52',0,1),(96,'ASDASD96','asdf','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(97,'ASDASD97','asd','asd','2021-02-12',1,'Roma','Via Mosca, 52',0,1),(98,'ASDASD98','asd','asd','2021-02-06',1,'Roma','Via Mosca, 52',0,1),(99,'ASDASD99','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(100,'ASDASD100','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(101,'ASDASD101','asd','asd','2021-02-06',1,'Roma','Via Mosca, 52',0,1),(102,'ASDASD102','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(103,'ASDASD103','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(104,'ASDASD104','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(105,'ASDASD105','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(106,'ASDASD106','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(118,'sadlk231','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(122,'ASDASD122','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(123,'ASDASD123','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(124,'ASDASD124','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(125,'ASDASD125','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(126,'ASDASD126','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(127,'ASDASD127','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(128,'ASDASD128','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(129,'ASDADS129','asd','ads','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(130,'ASDASD130','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(131,'ASDASD131','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(132,'ASDASD132','asd','asd','2021-02-04',1,'Roma','Via Mosca, 52',0,1),(133,'ASDASD133','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(134,'ASDASD134','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(135,'ASDASD135','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(136,'MARBAL136','Mario','Balotelli','2021-02-05',2,'Roma','Via Mosca, 52',0,1),(137,'MARROS137','Mario','Rossi','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(138,'AASASD138','aasd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(139,'ASDASD139','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(140,'MARROS140','Mario','Rossi','2021-02-05',3,'Roma','Via Mosca, 52',0,1),(141,'MARROS141','mario','rossi','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(142,'ASDASD142','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(143,'ASDASD143','asd','asd','2021-02-05',2,'Roma','Via Mosca, 52',0,1),(144,'ASDASD144','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(145,'ASDASD145','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(146,'ASDASD146','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(147,'ASDASD147','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(148,'ASDASD148','asd','asd','2021-02-05',1,'Roma','Via Mosca, 52',0,1),(149,'ASDASD149','asd','asd','2021-02-13',1,'Roma','Via Mosca, 52',0,1),(162,'GIOTRO162','giorgio','tronchesi','1999-01-20',1,'Milano','Via di milano',0,1),(163,'MARGIO163','Marco','Giolitti','1996-11-15',7,'Torino','Via Roma',0,1),(172,'GIOTRO172','giorgio','tronchesi','1999-01-20',1,'Milano','Via di milano',0,1),(173,'ASDASD173','asd','asd','2021-02-07',2,'ads','asd',0,1),(174,'ASDASD174','asd','asd','2021-02-06',1,'asd','asd',0,1),(175,'ASDASD175','asd','asd','2021-02-06',1,'asd','asd',0,1),(176,'ASDASD176','asd','asd','2021-02-06',1,'asd','asdsss',0,1),(177,'ASDASD177','asd','asd','2021-02-07',1,'asd','asd',0,1),(178,'ASDASD178','asd','asd','2021-02-07',1,'asd','asd',0,1),(179,'GIOTRO179','giorgio','tronchesi','1999-01-20',1,'Milano','Via di milano',0,1),(180,'GIOTRO180','giorgio','tronchesi','1999-01-20',1,'Milano','Via di milano',0,1),(181,'ASDASD181','asd','asd','2021-02-07',1,'asd','asd',0,1),(183,'GIOTRO183','giorgio','tronchesi','1999-01-20',1,'Milano','Via di milano',0,1),(184,'GIOTRO184','giorgio','tronchesi','1999-01-20',1,'Milano','Via di milano',0,1),(185,'ALFNIC185','Alfredo','Niccolo','2021-02-12',9,'Roma','Via mosca 52',0,1),(186,'TIZCAG186','tizio','caglio','2021-02-18',7,'Roma','via mosca 52',0,0),(188,'ASDASD188','asd','asd','2021-02-27',5,'sdasdsadasdad','Via heinz',0,0),(189,'ASDASD189','asd','asd','2021-02-05',1,'asd','asd',0,1),(208,'MARHAL0','Mark','Hale','1923-12-01',3,'Roma','Via Mosca, 52',0,0),(209,'0','ASDASDASD','Hale','1923-12-01',3,'Roma','Via Mosca, 52',0,0),(217,'EUCCON217','Euc','Con','1999-04-21',2,'Roma','Via Ostiense',0,0),(228,'EUCCON228','Euc','Con','2001-03-26',9,'Roma','Via Matteucci',0,1),(229,'EUCCON229','Euc','Con','2001-03-26',9,'Roma','Via Matteucci',0,1),(233,'EUCCON333','Euc','Con','2001-03-26',9,'Roma','Via Matteucci',0,1),(235,'0000','Euc','Con','2001-03-26',9,'Roma','Via Matteucci',0,1),(236,'EUCCON236','Euc','Con','2001-03-26',9,'Roma','Via Matteucci',0,1);
/*!40000 ALTER TABLE `dipendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_nazionalita`
--

DROP TABLE IF EXISTS `ref_nazionalita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ref_nazionalita` (
  `id_ref_nazionalita` int NOT NULL,
  `nazionalita` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ref_nazionalita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_nazionalita`
--

LOCK TABLES `ref_nazionalita` WRITE;
/*!40000 ALTER TABLE `ref_nazionalita` DISABLE KEYS */;
INSERT INTO `ref_nazionalita` VALUES (1,'keniana'),(2,'macedone'),(3,'maldiviana'),(4,'cipriota'),(5,'egiziana'),(6,'dominicana'),(7,'cambogiana'),(8,'liberiana'),(9,'malgascia'),(10,'lesothiana');
/*!40000 ALTER TABLE `ref_nazionalita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruolo`
--

DROP TABLE IF EXISTS `ruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ruolo` (
  `id_ruolo` int NOT NULL AUTO_INCREMENT,
  `ruolo` varchar(45) DEFAULT NULL,
  `profilo` varchar(45) NOT NULL,
  `id_dipendente` int DEFAULT NULL,
  `mansione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ruolo`),
  KEY `id_dipe_idx` (`id_dipendente`),
  CONSTRAINT `id_dipe` FOREIGN KEY (`id_dipendente`) REFERENCES `dipendente` (`id_dipendente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruolo`
--

LOCK TABLES `ruolo` WRITE;
/*!40000 ALTER TABLE `ruolo` DISABLE KEYS */;
INSERT INTO `ruolo` VALUES (1,'recruiter','utente',1,'dirigente'),(2,'sistemista','amministratore',2,'impiegato'),(3,'amministratore delegato','utente',3,'amministratore delegato'),(4,'backend developer','amministratore',4,'impiegato'),(5,'fullstack developer','utente',5,'dirigente'),(6,'frontend developer','amministratore',6,'impiegato'),(7,'recruiter','utente',7,'dirigente'),(8,'sistemista','amministratore',8,'impiegato'),(9,'frontend developer','utente',9,'impiegato'),(10,'tecnico informatico','amministratore',10,'impiegato');
/*!40000 ALTER TABLE `ruolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storing`
--

DROP TABLE IF EXISTS `storing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storing` (
  `id_storing` int NOT NULL AUTO_INCREMENT,
  `anno` varchar(45) NOT NULL,
  `mese` varchar(45) NOT NULL,
  `data_inserimento` date NOT NULL,
  `data_inizio` date DEFAULT NULL,
  `data_fine` date DEFAULT NULL,
  `id_dipendente` int NOT NULL,
  PRIMARY KEY (`id_storing`),
  KEY `id_dip2_idx` (`id_dipendente`),
  CONSTRAINT `id_dip2` FOREIGN KEY (`id_dipendente`) REFERENCES `dipendente` (`id_dipendente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storing`
--

LOCK TABLES `storing` WRITE;
/*!40000 ALTER TABLE `storing` DISABLE KEYS */;
INSERT INTO `storing` VALUES (1,'2018','01','2018-01-08','2018-01-08','2018-03-08',1),(2,'2018','03','2018-03-08','2018-03-08','2018-05-08',2),(3,'2018','04','2018-04-08','2018-04-08','2018-05-08',3),(4,'2018','01','2018-01-08','2018-01-08','2018-03-08',4),(5,'2018','05','2018-05-08','2018-05-08','2018-06-08',5),(6,'2018','06','2018-06-08','2018-06-08','2018-08-08',6),(7,'2018','01','2018-01-08','2018-01-08','2018-03-08',7),(8,'2018','04','2018-04-08','2018-04-08','2018-07-08',8),(9,'2018','01','2018-01-08','2018-01-08','2018-03-08',9),(10,'2018','01','2018-01-08','2018-01-08','2018-03-08',1);
/*!40000 ALTER TABLE `storing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipassenza`
--

DROP TABLE IF EXISTS `tipassenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipassenza` (
  `id_tipassenza` int NOT NULL AUTO_INCREMENT,
  `tipologia_assenza` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipassenza`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipassenza`
--

LOCK TABLES `tipassenza` WRITE;
/*!40000 ALTER TABLE `tipassenza` DISABLE KEYS */;
INSERT INTO `tipassenza` VALUES (1,'ferie'),(2,'festivita soppresse'),(3,'permesso per lutto'),(4,'permesso per partecipare ai conorsi'),(5,'matrimonio'),(6,'motivi familiari'),(7,'104'),(8,'motivi di studio'),(9,'visita di leva'),(10,'mandato parlamentare');
/*!40000 ALTER TABLE `tipassenza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipmansione`
--

DROP TABLE IF EXISTS `tipmansione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipmansione` (
  `id_tipmansione` int NOT NULL AUTO_INCREMENT,
  `tipologia_mansione` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipmansione`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipmansione`
--

LOCK TABLES `tipmansione` WRITE;
/*!40000 ALTER TABLE `tipmansione` DISABLE KEYS */;
INSERT INTO `tipmansione` VALUES (1,'impiegato'),(2,'dirigente'),(3,'amministratore delegato');
/*!40000 ALTER TABLE `tipmansione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipruolo`
--

DROP TABLE IF EXISTS `tipruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipruolo` (
  `id_tipruolo` int NOT NULL AUTO_INCREMENT,
  `tipologia_ruolo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipruolo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipruolo`
--

LOCK TABLES `tipruolo` WRITE;
/*!40000 ALTER TABLE `tipruolo` DISABLE KEYS */;
INSERT INTO `tipruolo` VALUES (1,'sistemista'),(2,'front end developer'),(3,'fullstack developer'),(4,'amministratore delegato'),(5,'backend developer'),(6,'tecnico informatico'),(7,'barista'),(8,'recruiter'),(9,'addetto alle pulizie'),(10,'custode');
/*!40000 ALTER TABLE `tipruolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipskill`
--

DROP TABLE IF EXISTS `tipskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipskill` (
  `id_tipskill` int NOT NULL AUTO_INCREMENT,
  `tipologia_skill` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipskill`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipskill`
--

LOCK TABLES `tipskill` WRITE;
/*!40000 ALTER TABLE `tipskill` DISABLE KEYS */;
INSERT INTO `tipskill` VALUES (1,'Python'),(2,'Java'),(3,'CSS'),(4,'HTML'),(5,'Javascript'),(6,'Angular JS'),(7,'React JS'),(8,'Rust'),(9,'C'),(10,'Lisp');
/*!40000 ALTER TABLE `tipskill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  `id_dipendente` int DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_dipen_idx` (`id_dipendente`),
  CONSTRAINT `id_dipen` FOREIGN KEY (`id_dipendente`) REFERENCES `dipendente` (`id_dipendente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lillie.carter@rhuman.com','lillie','lillie.carter',1),(2,'jennie.wills@rhuman.com','jennie','jennie.wills',2),(3,'mark.hale@rhuman.com','mark','mark.hale',3),(4,'christopher.lowery@rhuman.com','christopher','christopher.lowery',4),(5,'steven.smith@rhuman.com','steven','steven.smith',5),(6,'deborah.hayles@rhuman.com','deborah','deborah.hayles',6),(7,'jayne.dolan@rhuman.com','jayne','jayne.dolan',7),(8,'loren.dysart@rhuman.com','loren','loren.dysart',8),(9,'jenae.jamison@rhuman.com','janae','janae.jamison',9),(10,'alaska.native@rhuman.com','alaska','alaska.native',10);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-07 20:35:58

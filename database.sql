-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: doctordatabase
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `doctor_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `surname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `jmbg` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `doctor_specialization_id` int unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`doctor_id`),
  UNIQUE KEY `uq_doctor_jmbg` (`jmbg`),
  KEY `fk_doctor_doctor_specialization_idx` (`doctor_specialization_id`),
  CONSTRAINT `fk_doctor_doctor_specialization` FOREIGN KEY (`doctor_specialization_id`) REFERENCES `doctor_specialization` (`doctor_specialization_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Vladimir','Tomasevic','3112000790504','2024-06-18 21:37:47','2024-06-18 23:41:36',NULL,7),(2,'Milan','Acimovic','2909793005678','2024-06-18 21:42:56','2024-06-18 23:27:56',NULL,2),(3,'Luka','Rakic','2709000156897','2024-06-18 21:43:22','2024-06-18 23:28:44',NULL,9),(4,'Marko','Pantic','2505989556600','2024-06-18 21:43:28','2024-06-18 23:28:50',NULL,8),(5,'Nadja','Pavlovic','3009001568907','2024-06-18 21:47:31','2024-06-18 23:28:55','2024-06-18 23:43:58',5),(6,'Milovan','Eric','2101000890013','2024-06-18 23:40:11','2024-06-18 23:40:32','2024-06-18 23:41:41',6);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_specialization`
--

DROP TABLE IF EXISTS `doctor_specialization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_specialization` (
  `doctor_specialization_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`doctor_specialization_id`),
  UNIQUE KEY `uq_ds_name` (`name`) /*!80000 INVISIBLE */
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_specialization`
--

LOCK TABLES `doctor_specialization` WRITE;
/*!40000 ALTER TABLE `doctor_specialization` DISABLE KEYS */;
INSERT INTO `doctor_specialization` VALUES (1,'Hirurg','2024-06-18 21:36:40','2024-06-18 21:44:51',NULL),(2,'Farmaceut','2024-06-18 21:43:47','2024-06-18 21:46:11',NULL),(3,'Deciji hirurg','2024-06-18 21:46:16',NULL,NULL),(4,'Stomatolog','2024-06-18 21:46:22',NULL,NULL),(5,'Radiolog','2024-06-18 21:46:28',NULL,NULL),(6,'Medicinski brat','2024-06-18 21:46:41',NULL,NULL),(7,'Medicinska sestra','2024-06-18 21:46:49',NULL,NULL),(8,'Internista','2024-06-18 21:46:58',NULL,NULL),(9,'Neurolog','2024-06-18 22:35:11',NULL,NULL);
/*!40000 ALTER TABLE `doctor_specialization` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-19  0:03:51

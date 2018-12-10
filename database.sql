-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: webdata
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `answers` (
  `AnswerID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `AnswerContent` text COLLATE utf8_unicode_ci NOT NULL,
  `CorrectAnswer` tinyint(1) NOT NULL,
  PRIMARY KEY (`AnswerID`,`QuestionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,1,'emphasis',0),(1,2,'rely',0),(1,3,'granted',0),(1,4,'purpose',0),(1,5,'in',0),(1,6,'until',0),(1,7,'unless',1),(1,8,'him',0),(1,9,'have you seen',0),(1,10,'that',0),(1,11,'that',1),(1,12,'is',1),(1,13,'exist',1),(1,14,'attend',0),(1,15,'although',0),(1,16,'on',0),(2,1,'emphasize',1),(2,2,'reliant',0),(2,3,'raised',0),(2,4,'hope',0),(2,5,'on',0),(2,6,'before',0),(2,7,'neither',0),(2,8,'himself',1),(2,9,'did you see',1),(2,10,'who',0),(2,11,'which',0),(2,12,'am',0),(2,13,'existence',0),(2,14,'attention',0),(2,15,'because of',0),(2,16,'at',1),(3,1,'emphatically',0),(3,2,'reliable',1),(3,3,'taken',0),(3,4,'thanks',0),(3,5,'to',0),(3,6,'in',1),(3,7,'because of',0),(3,8,'he',0),(3,9,'were you seeing',0),(3,10,'whom',1),(3,11,'whose',0),(3,12,'are',0),(3,13,'existed',0),(3,14,'attenders',1),(3,15,'but',1),(3,16,'back',0),(4,1,'emphatic',0),(4,2,'reliability',0),(4,3,'held',1),(4,4,'advice',1),(4,5,'by',1),(4,6,'during',0),(4,7,'despite',0),(4,8,'his',0),(4,9,'had you seen',0),(4,10,'whose',0),(4,11,'what',0),(4,12,'does',0),(4,13,'the exist',0),(4,14,'attentive',0),(4,15,'despite',0),(4,16,'from',0);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classes` (
  `ClassID` int(11) NOT NULL,
  `TeacherID` int(11) DEFAULT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `TestID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `CourseID` int(11) NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'C#'),(2,'C++'),(3,'English'),(4,'Math');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `questions` (
  `QuestionID` int(11) NOT NULL AUTO_INCREMENT,
  `CourseID` int(11) NOT NULL,
  `QuestionContent` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`QuestionID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,3,'I feel i must ... the risks involved in this dangerous experiment.'),(2,3,'The XF210 is our most ... vehicle yet.'),(3,3,'The closing ceremory will be ... in the stadium at 4:00 P.M.'),(4,3,'Do you mind if I give you some useful ... ?'),(5,3,'Please put my luggage ... the door, if you can.'),(6,3,'Hurry up! The bus leaves ... five minutes.'),(7,3,'Please do not touch the vase ... you want to buy it.'),(8,3,'John is going to try to repair the window ... rather than get a carpenter to do it.'),(9,3,'Which of your former coworkers ... at the reunion last night?'),(10,3,'The trainee with ... you will be working is inexperienced, but very enthusiatic.'),(11,3,'The shift supervisor ... spoke to you is called Mr. Hughes.'),(12,3,'What ... your name?'),(13,3,'We cannot ... without food or water.'),(14,3,'All the ... at today\'s seminar are invited for lunch.'),(15,3,'Some snakes are poisonous, __________ others are harmless.'),(16,3,'The people _________ the party were busy playing, dancing without noticing me.');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `records` (
  `UserID` int(11) NOT NULL,
  `TestID` int(11) NOT NULL,
  `Point` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserID`,`TestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
INSERT INTO `records` VALUES (1,1,5),(2,1,4);
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_info`
--

DROP TABLE IF EXISTS `test_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test_info` (
  `TestID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CourseID` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Period` int(11) DEFAULT NULL,
  `AuthorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`TestID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_info`
--

LOCK TABLES `test_info` WRITE;
/*!40000 ALTER TABLE `test_info` DISABLE KEYS */;
INSERT INTO `test_info` VALUES (1,'Test 1',3,10,1800000,1),(2,'Test 2',3,12,1800000,1);
/*!40000 ALTER TABLE `test_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tests` (
  `TestID` int(11) DEFAULT NULL,
  `STT` int(11) DEFAULT NULL,
  `CourseID` int(11) DEFAULT NULL,
  `QuestionID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
INSERT INTO `tests` VALUES (1,0,3,2),(1,1,3,3),(1,2,3,4),(1,3,3,5),(1,4,3,6),(1,5,3,9),(1,6,3,11),(1,7,3,12),(1,8,3,13),(1,9,3,14),(2,0,3,2),(2,1,3,5),(2,2,3,7),(2,3,3,8),(2,4,3,9),(2,5,3,10),(2,6,3,12),(2,7,3,13),(2,8,3,14),(2,9,3,15),(2,10,3,0),(2,11,3,1);
/*!40000 ALTER TABLE `tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_answers`
--

DROP TABLE IF EXISTS `user_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_answers` (
  `UserID` int(11) NOT NULL,
  `TestID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `AnswerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserID`,`TestID`,`QuestionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answers`
--

LOCK TABLES `user_answers` WRITE;
/*!40000 ALTER TABLE `user_answers` DISABLE KEYS */;
INSERT INTO `user_answers` VALUES (1,1,2,NULL),(1,1,3,NULL),(1,1,4,NULL),(1,1,5,NULL),(1,1,6,NULL),(1,1,9,NULL),(1,1,11,NULL),(1,1,12,NULL),(1,1,13,NULL),(1,1,14,NULL),(2,1,2,1),(2,1,3,3),(2,1,4,4),(2,1,5,2),(2,1,6,1),(2,1,9,1),(2,1,11,1),(2,1,12,1),(2,1,13,1),(2,1,14,2);
/*!40000 ALTER TABLE `user_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Level` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'cuongdeptrai','cuongdeptrai','cuongdeptrai@gmail.com',5),(2,'giaovien1','giaovien1','gv1@gamil.com',4),(3,'nguoirade1','nguoirade1','nrd1@gmail.com',3),(4,'nguoiracauhoi1','nguoiracauhoi1','nrch@gmail.com',2),(5,'sinhvien1','sinhvien1','sv1@gmail.com',1),(6,'sinhvien2','sinhvien2','sv2@gmail.com',1),(7,'sinhvien3','sinhvien3','sv3@gmail.com',1),(8,'sinhvien4','sinhvien4','sv4@gmail.com',1),(10,'sinhvien5','sinhvien5','sv5@gmail.com',1),(11,'sinhvien6','sinhvien6','sv6@gmail.com',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-01 20:18:58

-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: bike_rental
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `Bicycle`
--

DROP TABLE IF EXISTS `Bicycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bicycle` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_bicycle_bike` FOREIGN KEY (`id`) REFERENCES `Bike` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bicycle`
--

LOCK TABLES `Bicycle` WRITE;
/*!40000 ALTER TABLE `Bicycle` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bicycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bike`
--

DROP TABLE IF EXISTS `Bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Bike` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL COMMENT 'Has 3 type :(Bicycle, Electric Bicycle, Tandem)',
  `barcode` varchar(45) NOT NULL,
  `value` float NOT NULL,
  `status` tinyint NOT NULL COMMENT '0: in use\n1: available',
  `dockID` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `barcode_UNIQUE` (`barcode`),
  KEY `fk_bike_dock_idx` (`dockID`),
  CONSTRAINT `fk_bike_dock` FOREIGN KEY (`dockID`) REFERENCES `Dock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bike`
--

LOCK TABLES `Bike` WRITE;
/*!40000 ALTER TABLE `Bike` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Card`
--

DROP TABLE IF EXISTS `Card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Card` (
  `id` int NOT NULL,
  `cvv` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `method` varchar(45) NOT NULL,
  `dateExpiration` datetime NOT NULL,
  `userID` char(12) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_card_user_idx` (`userID`),
  CONSTRAINT `fk_card_user` FOREIGN KEY (`userID`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Card`
--

LOCK TABLES `Card` WRITE;
/*!40000 ALTER TABLE `Card` DISABLE KEYS */;
/*!40000 ALTER TABLE `Card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CreditCard`
--

DROP TABLE IF EXISTS `CreditCard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CreditCard` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_creditCard_card` FOREIGN KEY (`id`) REFERENCES `Card` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CreditCard`
--

LOCK TABLES `CreditCard` WRITE;
/*!40000 ALTER TABLE `CreditCard` DISABLE KEYS */;
/*!40000 ALTER TABLE `CreditCard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dock`
--

DROP TABLE IF EXISTS `Dock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Dock` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `area` float NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dock`
--

LOCK TABLES `Dock` WRITE;
/*!40000 ALTER TABLE `Dock` DISABLE KEYS */;
/*!40000 ALTER TABLE `Dock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ElectricBicycle`
--

DROP TABLE IF EXISTS `ElectricBicycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ElectricBicycle` (
  `id` int NOT NULL,
  `battery` int NOT NULL,
  `licensePlate` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_electricBicycle_bike` FOREIGN KEY (`id`) REFERENCES `Bike` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ElectricBicycle`
--

LOCK TABLES `ElectricBicycle` WRITE;
/*!40000 ALTER TABLE `ElectricBicycle` DISABLE KEYS */;
/*!40000 ALTER TABLE `ElectricBicycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Invoice`
--

DROP TABLE IF EXISTS `Invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Invoice` (
  `id` int NOT NULL,
  `paymentTransactionID` int NOT NULL,
  `transactionID` int NOT NULL,
  `returnDockID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_paymentTransaction_idx` (`paymentTransactionID`),
  KEY `fk_invoice_returnDock_idx` (`returnDockID`),
  CONSTRAINT `fk_invoice_paymentTransaction` FOREIGN KEY (`paymentTransactionID`) REFERENCES `PaymentTransaction` (`id`),
  CONSTRAINT `fk_invoice_returnDock` FOREIGN KEY (`returnDockID`) REFERENCES `Dock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invoice`
--

LOCK TABLES `Invoice` WRITE;
/*!40000 ALTER TABLE `Invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `Invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PaymentTransaction`
--

DROP TABLE IF EXISTS `PaymentTransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PaymentTransaction` (
  `id` int NOT NULL,
  `transactionID` int NOT NULL,
  `category` varchar(45) NOT NULL COMMENT '2 type: (pay, refund)',
  `cardID` int NOT NULL,
  `errorCode` varchar(45) DEFAULT NULL COMMENT 'errorCode = null',
  `content` varchar(45) DEFAULT NULL,
  `amount` float NOT NULL,
  `createAt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_paymentTransaction_transaction_idx` (`transactionID`),
  KEY `fx_paymentTransaction_card_idx` (`cardID`),
  CONSTRAINT `fk_paymentTransaction_transaction` FOREIGN KEY (`transactionID`) REFERENCES `Transaction` (`id`),
  CONSTRAINT `fx_paymentTransaction_card` FOREIGN KEY (`cardID`) REFERENCES `Card` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PaymentTransaction`
--

LOCK TABLES `PaymentTransaction` WRITE;
/*!40000 ALTER TABLE `PaymentTransaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `PaymentTransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tandem`
--

DROP TABLE IF EXISTS `Tandem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tandem` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tandem_bike` FOREIGN KEY (`id`) REFERENCES `Bike` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tandem`
--

LOCK TABLES `Tandem` WRITE;
/*!40000 ALTER TABLE `Tandem` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tandem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transaction`
--

DROP TABLE IF EXISTS `Transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Transaction` (
  `id` int NOT NULL,
  `userID` char(12) NOT NULL,
  `bikeID` int NOT NULL,
  `dateTime` datetime NOT NULL,
  `totalTime` float DEFAULT NULL,
  `status` tinyint NOT NULL COMMENT '0: renting\n1: finish renting\nStatus = 0 -> totalTime = null',
  PRIMARY KEY (`id`),
  KEY `fk_transaction_user_idx` (`userID`),
  KEY `fx_transaction_bike_idx` (`bikeID`),
  CONSTRAINT `fk_transaction_user` FOREIGN KEY (`userID`) REFERENCES `User` (`id`),
  CONSTRAINT `fx_transaction_bike` FOREIGN KEY (`bikeID`) REFERENCES `Bike` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transaction`
--

LOCK TABLES `Transaction` WRITE;
/*!40000 ALTER TABLE `Transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `Transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `id` char(12) NOT NULL COMMENT 'Căn cước công dân',
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-07 18:11:44

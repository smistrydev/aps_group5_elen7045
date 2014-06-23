CREATE DATABASE  IF NOT EXISTS `aps` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `aps`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: aps
-- ------------------------------------------------------
-- Server version	5.6.13

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(100) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `billing_company_id` int(11) DEFAULT NULL,
  `customer_login_name` varchar(100) DEFAULT NULL,
  `customer_login_password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `fk_account_statement_account_number_idx` (`account_number`),
  KEY `fk_account_customer_customer_id_idx` (`customer_id`),
  KEY `fk_account_billing_company_billing_company_id_idx` (`billing_company_id`),
  CONSTRAINT `fk_account_billing_company_billing_company_id` FOREIGN KEY (`billing_company_id`) REFERENCES `billing_company` (`billing_company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_customer_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'55554942222883',1,1,'user','password'),(2,'53111116011111',1,2,'user','password'),(3,'53666946068883',1,3,'user','password');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit_log`
--

DROP TABLE IF EXISTS `audit_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_log` (
  `audit_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_id` int(11) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `acknowledged` bit(1) DEFAULT NULL,
  PRIMARY KEY (`audit_log_id`),
  KEY `fk_audit_log_notification_notification_id_idx` (`notification_id`),
  KEY `fk_audit_log_customer_customer_id_idx` (`customer_id`),
  CONSTRAINT `fk_audit_log_customer_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_audit_log_notification_notification_id` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`notification_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_log`
--

LOCK TABLES `audit_log` WRITE;
/*!40000 ALTER TABLE `audit_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing_company`
--

DROP TABLE IF EXISTS `billing_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_company` (
  `billing_company_id` int(11) NOT NULL AUTO_INCREMENT,
  `billing_company_name` varchar(100) DEFAULT NULL,
  `retry_count` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `days_per_cycle` int(11) DEFAULT NULL,
  `retry_interval_minutes` int(11) DEFAULT NULL,
  `lead_time_days` int(11) DEFAULT NULL,
  PRIMARY KEY (`billing_company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing_company`
--

LOCK TABLES `billing_company` WRITE;
/*!40000 ALTER TABLE `billing_company` DISABLE KEYS */;
INSERT INTO `billing_company` VALUES (1,'Credit Card',1,'www.telkom.co.za',1,1,1),(2,'Municipality',1,'www.telkom.co.za',1,1,1),(3,'Telco',1,'www.telkom.co.za',1,1,1);
/*!40000 ALTER TABLE `billing_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card_provider`
--

DROP TABLE IF EXISTS `credit_card_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_card_provider` (
  `credit_card_provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `statement_id` int(11) DEFAULT NULL,
  `card_type` varchar(100) DEFAULT NULL,
  `interest_rate` decimal(10,2) DEFAULT NULL,
  `credit_limit` decimal(10,2) DEFAULT NULL,
  `minimum_amount_due` datetime DEFAULT NULL,
  `credit_available` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`credit_card_provider_id`),
  KEY `fk_credit_card_provider_statement_statement_id_idx` (`statement_id`),
  CONSTRAINT `fk_credit_card_provider_statement_statement_id` FOREIGN KEY (`statement_id`) REFERENCES `statement` (`statement_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card_provider`
--

LOCK TABLES `credit_card_provider` WRITE;
/*!40000 ALTER TABLE `credit_card_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit_card_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_address` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'test@me.com','test','Testing','User');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintance_window`
--

DROP TABLE IF EXISTS `maintance_window`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maintance_window` (
  `maintance_id` int(11) NOT NULL AUTO_INCREMENT,
  `minute` varchar(100) DEFAULT NULL,
  `hour` varchar(100) DEFAULT NULL,
  `day` varchar(100) DEFAULT NULL,
  `week_number` varchar(100) DEFAULT NULL,
  `month` varchar(100) DEFAULT NULL,
  `billing_company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`maintance_id`),
  KEY `fk_maintance_window_billing_company_billing_company_id_idx` (`billing_company_id`),
  CONSTRAINT `fk_maintance_window_billing_company_billing_company_id` FOREIGN KEY (`billing_company_id`) REFERENCES `billing_company` (`billing_company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintance_window`
--

LOCK TABLES `maintance_window` WRITE;
/*!40000 ALTER TABLE `maintance_window` DISABLE KEYS */;
/*!40000 ALTER TABLE `maintance_window` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipal_provider`
--

DROP TABLE IF EXISTS `municipal_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipal_provider` (
  `municipality_id` int(11) NOT NULL AUTO_INCREMENT,
  `statement_id` int(11) DEFAULT NULL,
  `instalment_notice` varchar(100) DEFAULT NULL,
  `electricity_used` decimal(10,2) DEFAULT NULL,
  `electricity_charges` decimal(10,2) DEFAULT NULL,
  `gas_used` decimal(10,2) DEFAULT NULL,
  `gas_charges` decimal(10,2) DEFAULT NULL,
  `water_used` decimal(10,2) DEFAULT NULL,
  `water_charges` decimal(10,2) DEFAULT NULL,
  `sewerage_charges` decimal(10,2) DEFAULT NULL,
  `refuse_charges` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`municipality_id`),
  KEY `fk_municipal_provider_statement_id_idx` (`statement_id`),
  CONSTRAINT `fk_municipal_provider_statement_statement_id` FOREIGN KEY (`statement_id`) REFERENCES `statement` (`statement_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipal_provider`
--

LOCK TABLES `municipal_provider` WRITE;
/*!40000 ALTER TABLE `municipal_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `municipal_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notification_id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,'Invalid Credential'),(2,'Not signed up for eBilling'),(3,'Actioned required to contiune eBilling'),(4,'Billing company under maintenance'),(5,'Billing company transient error encounted'),(6,'Broken script');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scrape_data`
--

DROP TABLE IF EXISTS `scrape_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scrape_data` (
  `scrape_data_id` int(11) NOT NULL AUTO_INCREMENT,
  `scrape_timestamp` datetime DEFAULT NULL,
  `status_code` int(11) DEFAULT NULL,
  `statement_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `xml_result` text,
  PRIMARY KEY (`scrape_data_id`),
  KEY `fk_scrape_data_statement_statement_id_idx` (`statement_id`),
  CONSTRAINT `fk_scrape_data_statement_statement_id` FOREIGN KEY (`statement_id`) REFERENCES `statement` (`statement_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scrape_data`
--

LOCK TABLES `scrape_data` WRITE;
/*!40000 ALTER TABLE `scrape_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `scrape_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statement`
--

DROP TABLE IF EXISTS `statement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statement` (
  `statement_id` int(11) NOT NULL AUTO_INCREMENT,
  `statement_provider_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `account_number` varchar(100) DEFAULT NULL,
  `account_holder_name` varchar(100) DEFAULT NULL,
  `statement_date` datetime DEFAULT NULL,
  `statement_number` int(11) DEFAULT NULL,
  `statement_month` int(11) DEFAULT NULL,
  `total_due` decimal(10,2) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `opening_balance` decimal(10,2) DEFAULT NULL,
  `closing_balance` decimal(10,2) DEFAULT NULL,
  `payment_recieved` decimal(10,2) DEFAULT NULL,
  `new_charges` decimal(10,2) DEFAULT NULL,
  `deductions` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `vat_amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`statement_id`),
  KEY `fk_statement_statement_provider_statement_provider_id_idx` (`statement_provider_id`),
  KEY `fk_statement_account_account_id_idx` (`account_id`),
  CONSTRAINT `fk_statement_account_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_statement_statement_provider_statement_provider_id` FOREIGN KEY (`statement_provider_id`) REFERENCES `statement_provider` (`statement_provider_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statement`
--

LOCK TABLES `statement` WRITE;
/*!40000 ALTER TABLE `statement` DISABLE KEYS */;
/*!40000 ALTER TABLE `statement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statement_provider`
--

DROP TABLE IF EXISTS `statement_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statement_provider` (
  `statement_provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `statement_provider_description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`statement_provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statement_provider`
--

LOCK TABLES `statement_provider` WRITE;
/*!40000 ALTER TABLE `statement_provider` DISABLE KEYS */;
INSERT INTO `statement_provider` VALUES (1,'Municipal Service Provider'),(2,'Telco Service Provider'),(3,'Credit Card Provider');
/*!40000 ALTER TABLE `statement_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telco_service_provider`
--

DROP TABLE IF EXISTS `telco_service_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telco_service_provider` (
  `telco_service_provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `statement_id` int(11) DEFAULT NULL,
  `telephone_number` varchar(100) DEFAULT NULL,
  `service_charges` decimal(10,2) DEFAULT NULL,
  `call_charges` decimal(10,2) DEFAULT NULL,
  `total_number_of_calls` int(11) DEFAULT NULL,
  `total_call_duration_seconds` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`telco_service_provider_id`),
  KEY `fk_telco_service_provider_statement_statement_id_idx` (`statement_id`),
  CONSTRAINT `fk_telco_service_provider_statement_statement_id` FOREIGN KEY (`statement_id`) REFERENCES `statement` (`statement_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telco_service_provider`
--

LOCK TABLES `telco_service_provider` WRITE;
/*!40000 ALTER TABLE `telco_service_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `telco_service_provider` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-23 23:56:57
grant all on `aps`.* to 'aps'@'localhost' identified by 'aps';
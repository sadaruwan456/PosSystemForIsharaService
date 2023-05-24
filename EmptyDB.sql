-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.19 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ishara_service
DROP DATABASE IF EXISTS `ishara_service`;
CREATE DATABASE IF NOT EXISTS `ishara_service` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ishara_service`;

-- Dumping structure for table ishara_service.attendance_log
DROP TABLE IF EXISTS `attendance_log`;
CREATE TABLE IF NOT EXISTS `attendance_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.attendance_log: ~2 rows (approximately)
DELETE FROM `attendance_log`;
/*!40000 ALTER TABLE `attendance_log` DISABLE KEYS */;
INSERT INTO `attendance_log` (`id`, `status`) VALUES
	(0, 'absent'),
	(1, 'prasent');
/*!40000 ALTER TABLE `attendance_log` ENABLE KEYS */;

-- Dumping structure for table ishara_service.attendence
DROP TABLE IF EXISTS `attendence`;
CREATE TABLE IF NOT EXISTS `attendence` (
  `employee_nic` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `Morning` int(11) NOT NULL DEFAULT '0',
  `Evening` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`employee_nic`,`date`),
  KEY `FK_attendence_employee` (`employee_nic`),
  KEY `FK_attendence_attendance_log` (`Morning`),
  KEY `FK_attendence_attendance_log_2` (`Evening`),
  CONSTRAINT `FK_attendence_attendance_log` FOREIGN KEY (`Morning`) REFERENCES `attendance_log` (`id`),
  CONSTRAINT `FK_attendence_attendance_log_2` FOREIGN KEY (`Evening`) REFERENCES `attendance_log` (`id`),
  CONSTRAINT `FK_attendence_employee` FOREIGN KEY (`employee_nic`) REFERENCES `employee` (`nic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.attendence: ~0 rows (approximately)
DELETE FROM `attendence`;
/*!40000 ALTER TABLE `attendence` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendence` ENABLE KEYS */;

-- Dumping structure for table ishara_service.company
DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `email` text,
  `contact` text NOT NULL,
  `web` text,
  `address` text NOT NULL,
  `due_amount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.company: ~0 rows (approximately)
DELETE FROM `company`;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

-- Dumping structure for table ishara_service.customer
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `mobile` varchar(50) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  PRIMARY KEY (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.customer: ~0 rows (approximately)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table ishara_service.customer_vehicle
DROP TABLE IF EXISTS `customer_vehicle`;
CREATE TABLE IF NOT EXISTS `customer_vehicle` (
  `licen_plate` varchar(45) NOT NULL,
  `vehicle_model_id` int(11) NOT NULL,
  `customer_mobile` varchar(50) NOT NULL,
  `due` double NOT NULL DEFAULT '0',
  `reg_date` date DEFAULT NULL,
  PRIMARY KEY (`licen_plate`),
  KEY `fk_customer_vehicle_vehicle_model1` (`vehicle_model_id`),
  KEY `FK_customer_vehicle_customer` (`customer_mobile`),
  CONSTRAINT `FK_customer_vehicle_customer` FOREIGN KEY (`customer_mobile`) REFERENCES `customer` (`mobile`),
  CONSTRAINT `fk_customer_vehicle_vehicle_model1` FOREIGN KEY (`vehicle_model_id`) REFERENCES `vehicle_model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.customer_vehicle: ~0 rows (approximately)
DELETE FROM `customer_vehicle`;
/*!40000 ALTER TABLE `customer_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_vehicle` ENABLE KEYS */;

-- Dumping structure for table ishara_service.employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `nic` varchar(45) NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL,
  `dob` text NOT NULL,
  `mobile` text,
  `photo` text NOT NULL,
  `employee_type_id` int(11) NOT NULL,
  `gender_id` int(11) NOT NULL,
  `date` text NOT NULL,
  `email` text,
  `address` text,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_employee_employee_type` (`employee_type_id`),
  KEY `fk_employee_gender1` (`gender_id`),
  KEY `FK_employee_status` (`status`),
  CONSTRAINT `FK_employee_employee_type` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`),
  CONSTRAINT `FK_employee_gender` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `FK_employee_status` FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.employee: ~0 rows (approximately)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table ishara_service.employee_type
DROP TABLE IF EXISTS `employee_type`;
CREATE TABLE IF NOT EXISTS `employee_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` text NOT NULL,
  `salary` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.employee_type: ~0 rows (approximately)
DELETE FROM `employee_type`;
/*!40000 ALTER TABLE `employee_type` DISABLE KEYS */;
INSERT INTO `employee_type` (`id`, `type`, `salary`) VALUES
	(0, 'Admin', '0');
/*!40000 ALTER TABLE `employee_type` ENABLE KEYS */;

-- Dumping structure for table ishara_service.gender
DROP TABLE IF EXISTS `gender`;
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.gender: ~2 rows (approximately)
DELETE FROM `gender`;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` (`id`, `type`) VALUES
	(1, 'Male\r\n'),
	(2, 'Female');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;

-- Dumping structure for table ishara_service.grn
DROP TABLE IF EXISTS `grn`;
CREATE TABLE IF NOT EXISTS `grn` (
  `id` int(11) NOT NULL,
  `payment_method_id` int(11) NOT NULL,
  `payment` text NOT NULL,
  `g_date` date NOT NULL,
  `time` time NOT NULL,
  `supplier_nic` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplyer1` (`supplier_nic`),
  KEY `FK_grn_payment_method` (`payment_method_id`),
  CONSTRAINT `FK_grn_payment_method` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`),
  CONSTRAINT `fk_grn_supplyer1` FOREIGN KEY (`supplier_nic`) REFERENCES `supplier` (`nic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.grn: ~0 rows (approximately)
DELETE FROM `grn`;
/*!40000 ALTER TABLE `grn` DISABLE KEYS */;
/*!40000 ALTER TABLE `grn` ENABLE KEYS */;

-- Dumping structure for table ishara_service.grn_item
DROP TABLE IF EXISTS `grn_item`;
CREATE TABLE IF NOT EXISTS `grn_item` (
  `grn_id` int(11) NOT NULL,
  `part_model_id` int(11) NOT NULL,
  `qty` double DEFAULT NULL,
  `buying_price` double DEFAULT NULL,
  PRIMARY KEY (`grn_id`,`part_model_id`),
  KEY `fk_grn_has_part_model_part_model1_idx` (`part_model_id`),
  CONSTRAINT `FK_grn_item_grn` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_has_part_model_part_model1` FOREIGN KEY (`part_model_id`) REFERENCES `part_model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.grn_item: ~0 rows (approximately)
DELETE FROM `grn_item`;
/*!40000 ALTER TABLE `grn_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `grn_item` ENABLE KEYS */;

-- Dumping structure for table ishara_service.invoice
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_licen_plate` varchar(45) NOT NULL,
  `datetime` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `service_id` int(11) NOT NULL,
  `mileage` double NOT NULL,
  `service_charge` double NOT NULL,
  `payment_method_id` int(11) DEFAULT NULL,
  `payment` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_customer_vehicle1_idx` (`vehicle_licen_plate`),
  KEY `FK_invoice_payment_method` (`payment_method_id`),
  KEY `FK_invoice_service` (`service_id`),
  CONSTRAINT `FK_invoice_payment_method` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`),
  CONSTRAINT `FK_invoice_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `fk_invoice_customer_vehicle1` FOREIGN KEY (`vehicle_licen_plate`) REFERENCES `customer_vehicle` (`licen_plate`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.invoice: ~0 rows (approximately)
DELETE FROM `invoice`;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;

-- Dumping structure for table ishara_service.invoice_item
DROP TABLE IF EXISTS `invoice_item`;
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `invoice_id` int(11) NOT NULL,
  `part_model_id` int(11) NOT NULL,
  `stock_id` int(11) NOT NULL,
  `qty` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`,`part_model_id`,`stock_id`),
  KEY `fk_invoice_has_part_model_part_model1_idx` (`part_model_id`),
  KEY `fk_invoice_has_part_model_invoice1_idx` (`invoice_id`),
  KEY `FK_invoice_item_stock` (`stock_id`),
  CONSTRAINT `FK_invoice_item_stock` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`),
  CONSTRAINT `fk_invoice_has_part_model_invoice1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_has_part_model_part_model1` FOREIGN KEY (`part_model_id`) REFERENCES `part_model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.invoice_item: ~0 rows (approximately)
DELETE FROM `invoice_item`;
/*!40000 ALTER TABLE `invoice_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_item` ENABLE KEYS */;

-- Dumping structure for table ishara_service.loan
DROP TABLE IF EXISTS `loan`;
CREATE TABLE IF NOT EXISTS `loan` (
  `nic` varchar(50) NOT NULL DEFAULT '0',
  `Loan` varchar(50) DEFAULT '0',
  `dueammount` varchar(50) DEFAULT '0',
  `date` date DEFAULT NULL,
  PRIMARY KEY (`nic`),
  CONSTRAINT `FK_Loan_employee` FOREIGN KEY (`nic`) REFERENCES `employee` (`nic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.loan: ~0 rows (approximately)
DELETE FROM `loan`;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;

-- Dumping structure for table ishara_service.notified_stock
DROP TABLE IF EXISTS `notified_stock`;
CREATE TABLE IF NOT EXISTS `notified_stock` (
  `ns_date` datetime DEFAULT NULL,
  `stock_id` int(11) NOT NULL,
  PRIMARY KEY (`stock_id`),
  CONSTRAINT `FK__stock` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.notified_stock: ~0 rows (approximately)
DELETE FROM `notified_stock`;
/*!40000 ALTER TABLE `notified_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `notified_stock` ENABLE KEYS */;

-- Dumping structure for table ishara_service.paid_cheque
DROP TABLE IF EXISTS `paid_cheque`;
CREATE TABLE IF NOT EXISTS `paid_cheque` (
  `supplier_nic` varchar(15) DEFAULT NULL,
  `issued_date` datetime DEFAULT NULL,
  `cheque_no` text,
  `bank_code` text,
  `branch_code` text,
  `cheque_date` tinytext,
  `amount` double DEFAULT NULL,
  KEY `FK_paid_cheque_supplier` (`supplier_nic`),
  CONSTRAINT `FK_paid_cheque_supplier` FOREIGN KEY (`supplier_nic`) REFERENCES `supplier` (`nic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.paid_cheque: ~0 rows (approximately)
DELETE FROM `paid_cheque`;
/*!40000 ALTER TABLE `paid_cheque` DISABLE KEYS */;
/*!40000 ALTER TABLE `paid_cheque` ENABLE KEYS */;

-- Dumping structure for table ishara_service.part
DROP TABLE IF EXISTS `part`;
CREATE TABLE IF NOT EXISTS `part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_category_id` int(11) NOT NULL,
  `part_brand_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_part_part_category` (`part_category_id`),
  KEY `fk_part_part_brand1_idx` (`part_brand_id`),
  CONSTRAINT `FK_part_part_category` FOREIGN KEY (`part_category_id`) REFERENCES `part_category` (`id`),
  CONSTRAINT `fk_part_part_brand1` FOREIGN KEY (`part_brand_id`) REFERENCES `part_brand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.part: ~0 rows (approximately)
DELETE FROM `part`;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
/*!40000 ALTER TABLE `part` ENABLE KEYS */;

-- Dumping structure for table ishara_service.part_brand
DROP TABLE IF EXISTS `part_brand`;
CREATE TABLE IF NOT EXISTS `part_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.part_brand: ~0 rows (approximately)
DELETE FROM `part_brand`;
/*!40000 ALTER TABLE `part_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `part_brand` ENABLE KEYS */;

-- Dumping structure for table ishara_service.part_category
DROP TABLE IF EXISTS `part_category`;
CREATE TABLE IF NOT EXISTS `part_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` text NOT NULL,
  `min_quota` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.part_category: ~0 rows (approximately)
DELETE FROM `part_category`;
/*!40000 ALTER TABLE `part_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `part_category` ENABLE KEYS */;

-- Dumping structure for table ishara_service.part_model
DROP TABLE IF EXISTS `part_model`;
CREATE TABLE IF NOT EXISTS `part_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_model` text,
  `part_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_part_type_part` (`part_id`),
  CONSTRAINT `FK_part_type_part` FOREIGN KEY (`part_id`) REFERENCES `part` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.part_model: ~0 rows (approximately)
DELETE FROM `part_model`;
/*!40000 ALTER TABLE `part_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `part_model` ENABLE KEYS */;

-- Dumping structure for table ishara_service.payment_method
DROP TABLE IF EXISTS `payment_method`;
CREATE TABLE IF NOT EXISTS `payment_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_method` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.payment_method: ~3 rows (approximately)
DELETE FROM `payment_method`;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` (`id`, `payment_method`) VALUES
	(0, 'Cash'),
	(1, 'Cheque'),
	(2, 'Cash & Cheque');
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;

-- Dumping structure for table ishara_service.received_cheque
DROP TABLE IF EXISTS `received_cheque`;
CREATE TABLE IF NOT EXISTS `received_cheque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_mobile` varchar(50) DEFAULT NULL,
  `issued_date` datetime DEFAULT NULL,
  `cheque_no` text,
  `bank_code` text,
  `branch_code` text,
  `cheque_date` text,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_received_cheque_customer` (`customer_mobile`),
  CONSTRAINT `FK_received_cheque_customer` FOREIGN KEY (`customer_mobile`) REFERENCES `customer` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.received_cheque: ~0 rows (approximately)
DELETE FROM `received_cheque`;
/*!40000 ALTER TABLE `received_cheque` DISABLE KEYS */;
/*!40000 ALTER TABLE `received_cheque` ENABLE KEYS */;

-- Dumping structure for table ishara_service.salary
DROP TABLE IF EXISTS `salary`;
CREATE TABLE IF NOT EXISTS `salary` (
  `employee_nic` varchar(45) NOT NULL,
  `Date` text,
  PRIMARY KEY (`employee_nic`),
  KEY `fk_salary_employee1` (`employee_nic`),
  CONSTRAINT `fk_salary_employee1` FOREIGN KEY (`employee_nic`) REFERENCES `employee` (`nic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.salary: ~0 rows (approximately)
DELETE FROM `salary`;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;

-- Dumping structure for table ishara_service.service
DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_type` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.service: ~0 rows (approximately)
DELETE FROM `service`;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
/*!40000 ALTER TABLE `service` ENABLE KEYS */;

-- Dumping structure for table ishara_service.service_price
DROP TABLE IF EXISTS `service_price`;
CREATE TABLE IF NOT EXISTS `service_price` (
  `service_id` int(11) NOT NULL,
  `vehicle_type_id` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`service_id`,`vehicle_type_id`),
  KEY `fk_service_price_services1` (`service_id`),
  KEY `fk_service_price_vehicle_type1` (`vehicle_type_id`),
  CONSTRAINT `fk_service_price_services1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_price_vehicle_type1` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.service_price: ~0 rows (approximately)
DELETE FROM `service_price`;
/*!40000 ALTER TABLE `service_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_price` ENABLE KEYS */;

-- Dumping structure for table ishara_service.status
DROP TABLE IF EXISTS `status`;
CREATE TABLE IF NOT EXISTS `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.status: ~2 rows (approximately)
DELETE FROM `status`;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`id`, `status`) VALUES
	(0, 'Deactive'),
	(1, 'Active');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;

-- Dumping structure for table ishara_service.stock
DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_model_id` int(11) NOT NULL,
  `qty` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT NULL,
  `status_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_stock_part_model1_idx` (`part_model_id`),
  KEY `FK_stock_status` (`status_id`),
  CONSTRAINT `FK_stock_status` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `fk_stock_part_model1` FOREIGN KEY (`part_model_id`) REFERENCES `part_model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.stock: ~0 rows (approximately)
DELETE FROM `stock`;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;

-- Dumping structure for table ishara_service.supplier
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `nic` varchar(15) NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL,
  `mobile` text NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_supplyer_company1` (`company_id`),
  CONSTRAINT `fk_supplyer_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.supplier: ~0 rows (approximately)
DELETE FROM `supplier`;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- Dumping structure for table ishara_service.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `user_type_id` int(11) NOT NULL,
  `employee_nic` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_user_type1` (`user_type_id`),
  KEY `fk_user_employee1` (`employee_nic`),
  CONSTRAINT `fk_user_employee1` FOREIGN KEY (`employee_nic`) REFERENCES `employee` (`nic`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_type1` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.user: ~0 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table ishara_service.user_type
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.user_type: ~2 rows (approximately)
DELETE FROM `user_type`;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` (`id`, `type`) VALUES
	(1, 'Admin'),
	(2, 'Cashier');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;

-- Dumping structure for table ishara_service.vehicle_brand
DROP TABLE IF EXISTS `vehicle_brand`;
CREATE TABLE IF NOT EXISTS `vehicle_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.vehicle_brand: ~0 rows (approximately)
DELETE FROM `vehicle_brand`;
/*!40000 ALTER TABLE `vehicle_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_brand` ENABLE KEYS */;

-- Dumping structure for table ishara_service.vehicle_model
DROP TABLE IF EXISTS `vehicle_model`;
CREATE TABLE IF NOT EXISTS `vehicle_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_name` text NOT NULL,
  `vehicle_brand_id` int(11) NOT NULL,
  `vehicle_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vehicle_model_vehicle_brand1` (`vehicle_brand_id`),
  KEY `fk_vehicle_model_vehicle_type1_idx` (`vehicle_type_id`),
  CONSTRAINT `fk_vehicle_model_vehicle_brand1` FOREIGN KEY (`vehicle_brand_id`) REFERENCES `vehicle_brand` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_model_vehicle_type1` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.vehicle_model: ~0 rows (approximately)
DELETE FROM `vehicle_model`;
/*!40000 ALTER TABLE `vehicle_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_model` ENABLE KEYS */;

-- Dumping structure for table ishara_service.vehicle_part_details
DROP TABLE IF EXISTS `vehicle_part_details`;
CREATE TABLE IF NOT EXISTS `vehicle_part_details` (
  `part_model_id` int(11) NOT NULL,
  `vehicle_model_id` int(11) NOT NULL,
  PRIMARY KEY (`part_model_id`,`vehicle_model_id`),
  KEY `fk_part_model_has_vehicle_model_vehicle_model1_idx` (`vehicle_model_id`),
  KEY `fk_part_model_has_vehicle_model_part_model1_idx` (`part_model_id`),
  CONSTRAINT `fk_part_model_has_vehicle_model_part_model1` FOREIGN KEY (`part_model_id`) REFERENCES `part_model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_part_model_has_vehicle_model_vehicle_model1` FOREIGN KEY (`vehicle_model_id`) REFERENCES `vehicle_model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.vehicle_part_details: ~0 rows (approximately)
DELETE FROM `vehicle_part_details`;
/*!40000 ALTER TABLE `vehicle_part_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_part_details` ENABLE KEYS */;

-- Dumping structure for table ishara_service.vehicle_type
DROP TABLE IF EXISTS `vehicle_type`;
CREATE TABLE IF NOT EXISTS `vehicle_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_type` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table ishara_service.vehicle_type: ~0 rows (approximately)
DELETE FROM `vehicle_type`;
/*!40000 ALTER TABLE `vehicle_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
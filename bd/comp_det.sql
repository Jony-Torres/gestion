/*
SQLyog Community v12.2.6 (32 bit)
MySQL - 5.7.14-log : Database - gestion
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gestion` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gestion`;

/*Table structure for table `comprobantes_detalle` */

DROP TABLE IF EXISTS `comprobantes_detalle`;

CREATE TABLE `comprobantes_detalle` (
  `identificador` int(10) NOT NULL AUTO_INCREMENT,
  `cod_comprob` int(10) NOT NULL,
  `cod_articulo` int(10) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `cantidad` decimal(10,2) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `gravada_10` decimal(10,2) DEFAULT NULL,
  `gravada_5` decimal(10,2) DEFAULT NULL,
  `importe_total` decimal(10,2) DEFAULT NULL,
  `total_iva10` decimal(10,2) DEFAULT NULL,
  `total_iva5` decimal(10,2) DEFAULT NULL,
  `porc_iva` decimal(10,2) DEFAULT NULL,
  `cod_iva` int(5) DEFAULT NULL,
  `porc_descuento` decimal(10,2) DEFAULT NULL,
  `numero_cuota` int(5) DEFAULT NULL,
  `porc_comision` decimal(10,2) DEFAULT NULL,
  `monto_comision` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`identificador`),
  KEY `fk_comp_detall_cod_comp_cab` (`cod_comprob`),
  KEY `fk_comp_detall_cod_art` (`cod_articulo`),
  KEY `fk_comp_detall_cod_iva` (`cod_iva`),
  CONSTRAINT `fk_comp_detall_cod_art` FOREIGN KEY (`cod_articulo`) REFERENCES `articulos` (`cod_articulo`),
  CONSTRAINT `fk_comp_detall_cod_comp_cab` FOREIGN KEY (`cod_comprob`) REFERENCES `comprobantes_cabecera` (`cod_compob`),
  CONSTRAINT `fk_comp_detall_cod_iva` FOREIGN KEY (`cod_iva`) REFERENCES `iva` (`cod_iva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comprobantes_detalle` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

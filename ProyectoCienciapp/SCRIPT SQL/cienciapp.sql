-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.3.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para cienciapp
DROP DATABASE IF EXISTS `cienciapp`;
CREATE DATABASE IF NOT EXISTS `cienciapp` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `cienciapp`;

-- Volcando estructura para tabla cienciapp.article
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `idArticle` int(100) NOT NULL,
  `name` varchar(55) COLLATE latin1_spanish_ci NOT NULL,
  `pages` int(10) DEFAULT 1,
  `magazine` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `typeName` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idArticle`),
  KEY `FK1_member_article` (`dni`),
  KEY `FK2_magazine_article` (`magazine`),
  KEY `FK3_type_article` (`typeName`),
  CONSTRAINT `FK1_member_article` FOREIGN KEY (`dni`) REFERENCES `member` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_magazine_article` FOREIGN KEY (`magazine`) REFERENCES `magazine` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK3_type_article` FOREIGN KEY (`typeName`) REFERENCES `articletype` (`typeName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.article: ~1 rows (aproximadamente)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`idArticle`, `name`, `pages`, `magazine`, `dni`, `typeName`) VALUES
	(1, 'Fuente del Conocimiento', 1, 'Fisicos por el Mundo', '28589926y', 'Estudio');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.articleratinguser
DROP TABLE IF EXISTS `articleratinguser`;
CREATE TABLE IF NOT EXISTS `articleratinguser` (
  `username` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `idArticle` int(100) NOT NULL,
  `comment` varchar(255) COLLATE latin1_spanish_ci DEFAULT 'Sin comentario',
  `rating` int(10) NOT NULL,
  PRIMARY KEY (`username`,`idArticle`) USING BTREE,
  KEY `FK1_article_user` (`idArticle`),
  CONSTRAINT `FK1_article_user` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_user_article` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.articleratinguser: ~1 rows (aproximadamente)
DELETE FROM `articleratinguser`;
/*!40000 ALTER TABLE `articleratinguser` DISABLE KEYS */;
INSERT INTO `articleratinguser` (`username`, `idArticle`, `comment`, `rating`) VALUES
	('tuGitanito', 1, 'Muy mejorable la verdad, estoy tremendamente decepcionado con el final de juego de tronos. Salu2', 3);
/*!40000 ALTER TABLE `articleratinguser` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.articletype
DROP TABLE IF EXISTS `articletype`;
CREATE TABLE IF NOT EXISTS `articletype` (
  `typeName` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(250) COLLATE latin1_spanish_ci DEFAULT 'No hay descripcion',
  PRIMARY KEY (`typeName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.articletype: ~1 rows (aproximadamente)
DELETE FROM `articletype`;
/*!40000 ALTER TABLE `articletype` DISABLE KEYS */;
INSERT INTO `articletype` (`typeName`, `description`) VALUES
	('Estudio', 'No hay descripcion');
/*!40000 ALTER TABLE `articletype` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.article_x_category
DROP TABLE IF EXISTS `article_x_category`;
CREATE TABLE IF NOT EXISTS `article_x_category` (
  `idArticle` int(100) NOT NULL,
  `categoryName` varchar(60) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`categoryName`,`idArticle`),
  KEY `FK1_article_category` (`idArticle`),
  CONSTRAINT `FK1_article_category` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2_category_article` FOREIGN KEY (`categoryName`) REFERENCES `category` (`categoryName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.article_x_category: ~2 rows (aproximadamente)
DELETE FROM `article_x_category`;
/*!40000 ALTER TABLE `article_x_category` DISABLE KEYS */;
INSERT INTO `article_x_category` (`idArticle`, `categoryName`) VALUES
	(1, 'Fesica Nucelar'),
	(1, 'Fesica Teorica');
/*!40000 ALTER TABLE `article_x_category` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `categoryName` varchar(60) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(200) COLLATE latin1_spanish_ci DEFAULT 'No hay descripcion',
  PRIMARY KEY (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.category: ~4 rows (aproximadamente)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`categoryName`, `description`) VALUES
	('Bioquimica', NULL),
	('Fesica Nucelar', 'No hay descripcion'),
	('Fesica Relativista', 'No hay descripcion'),
	('Fesica Teorica', 'No hay descripcion');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.country
DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `name` varchar(70) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.country: ~2 rows (aproximadamente)
DELETE FROM `country`;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`name`) VALUES
	('España'),
	('Francia');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.department
DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `idDepartment` int(30) NOT NULL,
  `faculName` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idDepartment`),
  KEY `FK1_dept_facul` (`faculName`),
  CONSTRAINT `FK1_dept_facul` FOREIGN KEY (`faculName`) REFERENCES `faculty` (`faculName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.department: ~2 rows (aproximadamente)
DELETE FROM `department`;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`idDepartment`, `faculName`, `name`) VALUES
	(1, 'Fesica', 'Acelerador de particulas'),
	(2, 'Fesica', 'Practicas');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.faculty
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE IF NOT EXISTS `faculty` (
  `faculName` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `uniName` varchar(65) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`faculName`),
  KEY `FK_universidad_de_la_facultad` (`uniName`) USING BTREE,
  CONSTRAINT `FK_faculty_university` FOREIGN KEY (`uniName`) REFERENCES `university` (`uniName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.faculty: ~2 rows (aproximadamente)
DELETE FROM `faculty`;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`faculName`, `uniName`) VALUES
	('Fesica', 'Universidad de Sevilla'),
	('Quemica', 'Universidad de Sevilla');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.headquarters
DROP TABLE IF EXISTS `headquarters`;
CREATE TABLE IF NOT EXISTS `headquarters` (
  `name` varchar(40) COLLATE latin1_spanish_ci NOT NULL,
  `addres` varchar(100) COLLATE latin1_spanish_ci DEFAULT 'No hay direccion',
  `locality` varchar(70) COLLATE latin1_spanish_ci NOT NULL,
  `country` varchar(70) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`name`),
  KEY `FK1_country_hq` (`country`),
  CONSTRAINT `FK1_country_hq` FOREIGN KEY (`country`) REFERENCES `country` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.headquarters: ~1 rows (aproximadamente)
DELETE FROM `headquarters`;
/*!40000 ALTER TABLE `headquarters` DISABLE KEYS */;
INSERT INTO `headquarters` (`name`, `addres`, `locality`, `country`) VALUES
	('PRISA', NULL, 'Madrid', 'España'),
	('Real Academia', NULL, 'Madrid', 'España');
/*!40000 ALTER TABLE `headquarters` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.magazine
DROP TABLE IF EXISTS `magazine`;
CREATE TABLE IF NOT EXISTS `magazine` (
  `name` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `headQuarters` varchar(40) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`name`),
  KEY `FK1_magazine_hq` (`headQuarters`),
  CONSTRAINT `FK1_magazine_hq` FOREIGN KEY (`headQuarters`) REFERENCES `headquarters` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.magazine: ~2 rows (aproximadamente)
DELETE FROM `magazine`;
/*!40000 ALTER TABLE `magazine` DISABLE KEYS */;
INSERT INTO `magazine` (`name`, `headQuarters`) VALUES
	('Quimica Diaria', 'PRISA'),
	('Fisicos por el Mundo', 'Real Academia');
/*!40000 ALTER TABLE `magazine` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.member
DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `birthDate` date DEFAULT NULL,
  `name` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `surname` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `specialization` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `idResearchTeam` int(30) NOT NULL,
  `user` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `FK_member_specialization` (`specialization`),
  KEY `FK_member_researchteam` (`idResearchTeam`),
  KEY `FK_member_user` (`user`),
  CONSTRAINT `FK_member_researchteam` FOREIGN KEY (`idResearchTeam`) REFERENCES `researchteam` (`idResearchTeam`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_member_specialization` FOREIGN KEY (`specialization`) REFERENCES `specialization` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_member_user` FOREIGN KEY (`user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.member: ~1 rows (aproximadamente)
DELETE FROM `member`;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`dni`, `birthDate`, `name`, `surname`, `specialization`, `idResearchTeam`, `user`) VALUES
	('28589926y', '1958-03-25', 'Alberto', 'Fernandez', 'Fesico Teorico', 1, 'xXAlbertitoXx');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.researchteam
DROP TABLE IF EXISTS `researchteam`;
CREATE TABLE IF NOT EXISTS `researchteam` (
  `idResearchTeam` int(30) NOT NULL,
  `name` varchar(40) COLLATE latin1_spanish_ci DEFAULT 'No hay nombre',
  `budget` int(50) NOT NULL,
  `idDepartment` int(30) NOT NULL,
  PRIMARY KEY (`idResearchTeam`),
  KEY `FK1_rsearch_dept` (`idDepartment`),
  CONSTRAINT `FK1_rsearch_dept` FOREIGN KEY (`idDepartment`) REFERENCES `department` (`idDepartment`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.researchteam: ~0 rows (aproximadamente)
DELETE FROM `researchteam`;
/*!40000 ALTER TABLE `researchteam` DISABLE KEYS */;
INSERT INTO `researchteam` (`idResearchTeam`, `name`, `budget`, `idDepartment`) VALUES
	(1, 'Equipo A', 2500, 1);
/*!40000 ALTER TABLE `researchteam` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.specialization
DROP TABLE IF EXISTS `specialization`;
CREATE TABLE IF NOT EXISTS `specialization` (
  `name` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(200) COLLATE latin1_spanish_ci DEFAULT 'No hay descripcion',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.specialization: ~2 rows (aproximadamente)
DELETE FROM `specialization`;
/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
INSERT INTO `specialization` (`name`, `description`) VALUES
	('Fesico Nucelar', NULL),
	('Fesico Teorico', 'No hay descripcion');
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.university
DROP TABLE IF EXISTS `university`;
CREATE TABLE IF NOT EXISTS `university` (
  `uniName` varchar(65) COLLATE latin1_spanish_ci NOT NULL,
  `locality` varchar(70) COLLATE latin1_spanish_ci NOT NULL,
  `addres` varchar(100) COLLATE latin1_spanish_ci DEFAULT 'No hay direccion',
  `country` varchar(70) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`uniName`),
  KEY `FK1_uni_country` (`country`),
  CONSTRAINT `FK1_uni_country` FOREIGN KEY (`country`) REFERENCES `country` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.university: ~2 rows (aproximadamente)
DELETE FROM `university`;
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
INSERT INTO `university` (`uniName`, `locality`, `addres`, `country`) VALUES
	('Pablo Olavide', 'Sevilla', NULL, 'España'),
	('Universidad de Sevilla', 'Sevilla', NULL, 'España');
/*!40000 ALTER TABLE `university` ENABLE KEYS */;

-- Volcando estructura para tabla cienciapp.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(1024) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(500) COLLATE latin1_spanish_ci DEFAULT 'Correo por establecer',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Volcando datos para la tabla cienciapp.user: ~3 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`username`, `password`, `email`) VALUES
	('fary69', 'd9e6762dd1c8eaf6d61b3c6192fc408d4d6d5f1176d0c29169bc24e71c3f274ad27fcd5811b313d681f7e55ec02d73d499c95455b6b5bb503acf574fba8ffe85', NULL),
	('tuGitanito', 'd9e6762dd1c8eaf6d61b3c6192fc408d4d6d5f1176d0c29169bc24e71c3f274ad27fcd5811b313d681f7e55ec02d73d499c95455b6b5bb503acf574fba8ffe85', NULL),
	('xXAlbertitoXx', 'd9e6762dd1c8eaf6d61b3c6192fc408d4d6d5f1176d0c29169bc24e71c3f274ad27fcd5811b313d681f7e55ec02d73d499c95455b6b5bb503acf574fba8ffe85', 'albertoeinstin@mail.fr');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

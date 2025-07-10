CREATE DATABASE  IF NOT EXISTS `servisalud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `servisalud`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: servisalud
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `cod_empleado` varchar(10) NOT NULL,
  `emple_nom` varchar(50) NOT NULL,
  `emple_ape` varchar(50) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `Especialidad` varchar(50) NOT NULL,
  `cod_sucursal` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cod_empleado`),
  KEY `cod_sucursal` (`cod_sucursal`),
  KEY `idx_emple_ape` (`emple_ape`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursales` (`cod_sucursal`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES ('E001','Carlos','Gonzales','12345678','Cardiología','S001'),('E002','Ana','Martínez','23456789','Pediatría','S002'),('E003','José','Pérez','34567890','Dermatología','S003'),('E004','María','Lopez','45678901','Ginecología','S004'),('E005','Luis','Sánchez','56789012','Odontología','S005'),('E006','Patricia','Ramírez','67890123','Oftalmología','S004'),('E007','Juan','Fernández','78901234','Neurología','S007'),('E008','Claudia','Morales','89012345','Urología','S008');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorios`
--

DROP TABLE IF EXISTS `laboratorios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratorios` (
  `cod_lab` varchar(10) NOT NULL,
  `nom_lab` varchar(50) NOT NULL,
  `ape_lab` varchar(50) NOT NULL,
  `ruc` varchar(11) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `cod_sucursal` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cod_lab`,`marca`),
  UNIQUE KEY `marca` (`marca`),
  KEY `cod_sucursal` (`cod_sucursal`),
  CONSTRAINT `laboratorios_ibfk_1` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursales` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorios`
--

LOCK TABLES `laboratorios` WRITE;
/*!40000 ALTER TABLE `laboratorios` DISABLE KEYS */;
INSERT INTO `laboratorios` VALUES ('LAB001','Laboratorio Lima','Perez','20456789123','BioTech','987654321','S001'),('LAB002','Laboratorio Surco','Garcia','20456789124','MediLab','987654322','S002'),('LAB003','Laboratorio Callao','Juanhci','20456789125','PharmaCare','987654323','S003'),('LAB004','Laboratorio Miraflores','Torres','20456789126','HealthPlus','987654324','S004'),('LAB005','Laboratorio San Isidro','Martinez','20456789127','WellnessLab','987654325','S005'),('LAB006','Laboratorio Barranco','Vargas','20456789128','BioInnovate','987654326','S006'),('LAB007','Laboratorio Chorrillos','Ramirez','20456789129','MediAdvance','987654327','S007'),('LAB008','Laboratorio La Molina','Castro','20456789130','PharmaPlus','987654328','S008'),('LAB009','Laboratorio Lince','Fernandez','20456789131','HealthFirst','987654329','S009'),('LAB010','Laboratorio San Miguel','Rojas','20456789132','BioSolutions','987654330','S010');
/*!40000 ALTER TABLE `laboratorios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `cod_pacientes` varchar(20) NOT NULL,
  `nom_paciente` varchar(50) NOT NULL,
  `ape_paciente` varchar(50) NOT NULL,
  `DNI` int NOT NULL,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `enfermedad` varchar(100) NOT NULL,
  `Nivel_Urgencia` varchar(20) NOT NULL,
  `Cod_Sucursal` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cod_pacientes`),
  KEY `fk_sucursal` (`Cod_Sucursal`),
  KEY `idx_paci_ape` (`ape_paciente`),
  CONSTRAINT `fk_sucursal` FOREIGN KEY (`Cod_Sucursal`) REFERENCES `sucursales` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES ('P001','Juan','Perez',12345678,70.5,1.75,'Gripe','Moderado','S001'),('P002','Jennifer','Lopez',87654321,65.3,1.6,'Asma','Bajo','S002'),('P003','Carlos','Garcia',45678912,80.3,1.8,'Hipertensión','Alto','S003'),('P004','Ana','Martinez',34567891,55,1.65,'Diabetes','Moderado','S004'),('P005','Pedro','Ramirez',56789123,90.1,1.85,'Obesidad','Alto','S005'),('P006','Luisa','Fernandez',67891234,50.5,1.55,'Migraña','Bajo','S006'),('P007','Roberto','Gomez',78912345,77.7,1.78,'Colesterol alto','Moderado','S007'),('P008','Claudia','Diaz',89123456,62.4,1.68,'Anemia','Moderado','S008');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `cod_products` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` int NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `cod_sucursal` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cod_products`),
  KEY `cod_sucursal` (`cod_sucursal`),
  KEY `marca` (`marca`),
  KEY `idx_nom_producto` (`nombre`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`cod_sucursal`) REFERENCES `sucursales` (`cod_sucursal`),
  CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`marca`) REFERENCES `laboratorios` (`marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('P001','Paracetamol 500mg',100,5.50,'BioTech','S001'),('P002','Ibuprofeno 400mg',200,3.80,'MediLab','S001'),('P003','Amoxicilina 500mg',150,5.20,'PharmaCare','S001'),('P004','Vitamina C 1000mg',300,2.50,'HealthPlus','S004'),('P005','Omeprazol 20mg',120,4.90,'WellnessLab','S005'),('P006','Loratadina 10mg',180,3.10,'BioInnovate','S006'),('P007','Clorhidrato de Metformina 850mg',90,6.45,'MediAdvance','S007'),('P008','Enalapril 10mg',250,5.25,'PharmaPlus','S008'),('P009','Atorvastatina 20mg',130,9.50,'HealthFirst','S009'),('P010','Levotiroxina 100mcg',110,8.60,'BioSolutions','S010'),('P011','Cetirizina',2,3.00,'BioSolutions','S004');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursales`
--

DROP TABLE IF EXISTS `sucursales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursales` (
  `cod_sucursal` varchar(20) NOT NULL,
  `RUC` varchar(11) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY (`cod_sucursal`),
  KEY `idx_cod_sede` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursales`
--

LOCK TABLES `sucursales` WRITE;
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` VALUES ('S001','20123456782','Huanuco','Av. Larco 123, Miraflores','2761224'),('S002','20123451234','Cajamarca','machupichu','123456789'),('S003','20567890123','Arequipa','Av. Ejército 789, Yanahuara','054123456'),('S004','20987654321','Trujillo','Jr. Pizarro 321, Centro','044987654'),('S005','20876543210','Piura','Av. Grau 654, Castilla','073456789'),('S006','20234567891','Madre de Dios','Av. Balta 111, por ahi','074567890'),('S007','20654321098','Iquitos','Calle Putumayo 987, Belén','065123456'),('S008','20765432109','Huancayo','Jr. Real 345, El Tambo','064987654'),('S009','20432109876','Tacna','Av. Bolognesi 567, Pocollay','052123456'),('S010','20345678901','Puno','Jr. Deustua 789, Juliaca','051456789');
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `DNI` int NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `genero` varchar(10) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (12345678,'Hernan','Trujillo','Masculino','hernan@usil.pe','juana/001'),(73255963,'Sergio Fabriccio','Burga Cespedes','Masculino','Burga@gmail.com','Shiro/2003'),(78945612,'Marco','Araujo','Masculino','marco@usil.pe','pollito/123'),(92871210,'Carola','Cespedes','Femenino','carola@gmail.com','checo/2003');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `cod_venta` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `emple_ape` varchar(50) DEFAULT NULL,
  `paci_ape` varchar(50) DEFAULT NULL,
  `nom_Producto` varchar(50) DEFAULT NULL,
  `nivel_urgencia` varchar(20) NOT NULL,
  `cod_sede` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cod_venta`),
  KEY `emple_ape` (`emple_ape`),
  KEY `paci_ape` (`paci_ape`),
  KEY `nom_Producto` (`nom_Producto`),
  KEY `cod_sede` (`cod_sede`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`emple_ape`) REFERENCES `empleados` (`emple_ape`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`paci_ape`) REFERENCES `pacientes` (`ape_paciente`),
  CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`nom_Producto`) REFERENCES `productos` (`nombre`),
  CONSTRAINT `ventas_ibfk_4` FOREIGN KEY (`cod_sede`) REFERENCES `sucursales` (`cod_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES ('V001','2024-10-11','Gonzales','Perez','Paracetamol 500mg','Moderado','S001'),('V002','2026-10-17','Gonzales','Perez','Ibuprofeno 400mg','Bajo','S002'),('V003','2024-10-09','Gonzales','Martinez','Amoxicilina 500mg','Alto','S003'),('V004','2024-10-08','Lopez','Martinez','Vitamina C 1000mg','Moderado','S004'),('V005','2024-10-08','Gonzales','Garcia','Omeprazol 20mg','Alto','S005'),('V006','2024-10-31','Sánchez','Diaz','Omeprazol 20mg','Moderado','S006'),('V008','2024-10-27','Ramírez','Ramirez','Enalapril 10mg','Bajo','S005'),('V009','2024-10-27','Lopez','Ramirez','Enalapril 10mg','Bajo','S004');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'servisalud'
--

--
-- Dumping routines for database 'servisalud'
--
/*!50003 DROP PROCEDURE IF EXISTS `obtenerReporteVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerReporteVenta`(IN codVenta VARCHAR(20))
BEGIN
    SELECT
        v.cod_venta AS 'Código de Venta',
        v.fecha AS 'Fecha de Venta',
        
        -- Datos del empleado
        e.emple_nom AS 'Nombre Empleado',
        e.emple_ape AS 'Apellido Empleado',
        e.DNI AS 'DNI Empleado',
        e.Especialidad AS 'Especialidad Empleado',
        
        -- Datos del paciente
        p.nom_paciente AS 'Nombre Paciente',
        p.ape_paciente AS 'Apellido Paciente',
        p.DNI AS 'DNI Paciente',
        p.peso AS 'Peso Paciente',
        p.altura AS 'Altura Paciente',
        (p.peso / (p.altura * p.altura)) AS 'IMC',
        p.enfermedad AS 'Enfermedad',
        p.Nivel_Urgencia AS 'Nivel de Urgencia Paciente',
        
        -- Datos del producto
        pr.nombre AS 'Nombre Producto',
        pr.cantidad AS 'Cantidad Vendida',
        pr.precio AS 'Precio Unitario',
        (pr.cantidad * pr.precio) AS 'Total Producto',
        
        -- Datos de la sucursal
        s.departamento AS 'Departamento Sucursal',
        s.Direccion AS 'Dirección Sucursal',
        s.telefono AS 'Teléfono Sucursal'
        
    FROM ventas v
    -- Join con empleados para obtener los datos del empleado
    JOIN empleados e ON v.emple_ape = e.emple_ape
    
    -- Join con pacientes para obtener los datos del paciente
    JOIN pacientes p ON v.paci_ape = p.ape_paciente
    
    -- Join con productos para obtener los datos del producto
    JOIN productos pr ON v.nom_Producto = pr.nombre
    
    -- Join con sucursales para obtener los datos de la sucursal
    JOIN sucursales s ON v.cod_sede = s.cod_sucursal
    
    WHERE v.cod_venta = codVenta;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Editar_Empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Editar_Empleado`(
    IN p_cod_empleado VARCHAR(10),
    IN p_emple_nom VARCHAR(50),
    IN p_emple_ape VARCHAR(50),
    IN p_DNI VARCHAR(8),
    IN p_Especialidad VARCHAR(50),
    IN p_cod_sucursal VARCHAR(20)
)
BEGIN
    UPDATE empleados
    SET emple_nom = p_emple_nom, emple_ape = p_emple_ape, DNI = p_DNI, Especialidad = p_Especialidad, cod_sucursal = p_cod_sucursal
    WHERE cod_empleado = p_cod_empleado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Editar_laboratorio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Editar_laboratorio`(
    IN p_cod_lab VARCHAR(10),
    IN p_nom_lab VARCHAR(50),
    IN p_ape_lab VARCHAR(50),
    IN p_ruc VARCHAR(11),
    IN p_marca VARCHAR(50),
    IN p_telefono VARCHAR(9),
    IN p_cod_sucursal VARCHAR(20)
)
BEGIN
    UPDATE laboratorios 
    SET nom_lab = p_nom_lab, 
        ape_lab = p_ape_lab,
        ruc = p_ruc,
        marca = p_marca,
        telefono = p_telefono,
        cod_sucursal = p_cod_sucursal
    WHERE cod_lab = p_cod_lab;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Editar_Paciente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Editar_Paciente`(
    IN p_cod_pacientes VARCHAR(20),
    IN p_nom_paciente VARCHAR(50),
    IN p_ape_paciente VARCHAR(50),
    IN p_DNI INT,
    IN p_peso DOUBLE,
    IN p_altura DOUBLE,
    IN p_enfermedad VARCHAR(100),
    IN p_Nivel_Urgencia VARCHAR(20),
    IN p_Cod_Sucursal VARCHAR(20)
)
BEGIN
    UPDATE pacientes
    SET nom_paciente = p_nom_paciente, 
        ape_paciente = p_ape_paciente,
        DNI = p_DNI,
        peso = p_peso,
        altura = p_altura,
        enfermedad = p_enfermedad,
        Nivel_Urgencia = p_Nivel_Urgencia,
        Cod_Sucursal = p_Cod_Sucursal
    WHERE cod_pacientes = p_cod_pacientes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Editar_Producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Editar_Producto`(
    IN p_cod_products VARCHAR(50),
    IN p_nombre VARCHAR(100),
    IN p_cantidad INT,
    IN p_precio DECIMAL(10, 2),
    IN p_marca VARCHAR(50),          -- Actualización para la clave foránea
    IN p_cod_sucursal VARCHAR(20)
)
BEGIN
    UPDATE productos
    SET nombre = p_nombre,
        cantidad = p_cantidad,
        precio = p_precio,
        marca = p_marca,
        cod_sucursal = p_cod_sucursal
    WHERE cod_products = p_cod_products;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Editar_Resultado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Editar_Resultado`(
    IN p_cod_venta VARCHAR(20),
    IN p_fecha DATE,
    IN p_emple_ape VARCHAR(50),
    IN p_paci_ape VARCHAR(50),
    IN p_nom_producto VARCHAR(50),
    IN p_nivel_urgencia VARCHAR(20),
    IN p_cod_sede VARCHAR(20)
)
BEGIN
    UPDATE ventas
    SET 
        fecha = p_fecha,
        emple_ape = p_emple_ape,
        paci_ape = p_paci_ape,
        nom_Producto = p_nom_producto,
        nivel_urgencia = p_nivel_urgencia,
        cod_sede = p_cod_sede
    WHERE cod_venta = p_cod_venta;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Editar_Sucursal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Editar_Sucursal`(
    IN p_cod_sucursal VARCHAR(20),
    IN p_RUC VARCHAR(11),
    IN p_departamento VARCHAR(50),
    IN p_direccion VARCHAR(100),
    IN p_telefono VARCHAR(15)
)
BEGIN
    UPDATE sucursales
    SET RUC = p_RUC,
        departamento = p_departamento,
        Direccion = p_direccion,
        telefono = p_telefono
    WHERE cod_sucursal = p_cod_sucursal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Eliminar_Empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Eliminar_Empleado`(
    IN p_cod_empleado VARCHAR(10)
)
BEGIN
    DELETE FROM empleados WHERE cod_empleado = p_cod_empleado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Eliminar_Laboratorio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Eliminar_Laboratorio`(
    IN p_cod_lab VARCHAR(10)
)
BEGIN
    DELETE FROM laboratorios WHERE cod_lab = p_cod_lab;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Eliminar_Paciente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Eliminar_Paciente`(
    IN p_cod_pacientes VARCHAR(20)
)
BEGIN
    DELETE FROM pacientes WHERE cod_pacientes = p_cod_pacientes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Eliminar_Producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Eliminar_Producto`(
    IN p_cod_products VARCHAR(50)
)
BEGIN
    DELETE FROM productos
    WHERE cod_products = p_cod_products;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Eliminar_Resultado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Eliminar_Resultado`(
    IN p_cod_venta VARCHAR(20)
)
BEGIN
    DELETE FROM ventas
    WHERE cod_venta = p_cod_venta;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Eliminar_Sucursal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Eliminar_Sucursal`(
    IN p_cod_sucursal VARCHAR(20)
)
BEGIN
    DELETE FROM sucursales WHERE cod_sucursal = p_cod_sucursal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Empleado_BuscarxEspecialidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Empleado_BuscarxEspecialidad`(
    IN p_Especialidad VARCHAR(50)
)
BEGIN
    SELECT * FROM empleados WHERE Especialidad = p_Especialidad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Empleado_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Empleado_insertar`(
    IN p_cod_empleado VARCHAR(10),
    IN p_emple_nom VARCHAR(50),
    IN p_emple_ape VARCHAR(50),
    IN p_DNI VARCHAR(8),
    IN p_Especialidad VARCHAR(50),
    IN p_cod_sucursal VARCHAR(20)
)
BEGIN
    INSERT INTO empleados (cod_empleado, emple_nom, emple_ape, DNI, Especialidad, cod_sucursal)
    VALUES (p_cod_empleado, p_emple_nom, p_emple_ape, p_DNI, p_Especialidad, p_cod_sucursal);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Insertar_Resultado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Insertar_Resultado`(
    IN p_cod_venta VARCHAR(20),
    IN p_fecha DATE,
    IN p_emple_ape VARCHAR(50),
    IN p_paci_ape VARCHAR(50),
    IN p_nom_producto VARCHAR(50),
    IN p_nivel_urgencia VARCHAR(20),
    IN p_cod_sede VARCHAR(20)
)
BEGIN
    INSERT INTO ventas (cod_venta, fecha, emple_ape, paci_ape, nom_Producto, nivel_urgencia, cod_sede)
    VALUES (p_cod_venta, p_fecha, p_emple_ape, p_paci_ape, p_nom_producto, p_nivel_urgencia, p_cod_sede);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Laboratorio_BuscarxMarca` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Laboratorio_BuscarxMarca`(
    IN p_marca VARCHAR(50)
)
BEGIN
    SELECT l.cod_lab, l.nom_lab, l.ape_lab, l.ruc, l.marca, l.telefono, s.cod_sucursal, s.departamento, s.direccion
    FROM laboratorios l
    INNER JOIN sucursales s ON l.cod_sucursal = s.cod_sucursal
    WHERE l.marca = p_marca;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Laboratorio_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Laboratorio_insertar`(
    IN p_cod_lab VARCHAR(10),
    IN p_nom_lab VARCHAR(50),
    IN p_ape_lab VARCHAR(50),
    IN p_ruc VARCHAR(11),
    IN p_marca VARCHAR(50),
    IN p_telefono VARCHAR(9),
    IN p_cod_sucursal VARCHAR(20)
)
BEGIN
    INSERT INTO laboratorios (cod_lab, nom_lab, ape_lab, ruc, marca, telefono, cod_sucursal)
    VALUES (p_cod_lab, p_nom_lab, p_ape_lab, p_ruc, p_marca, p_telefono, p_cod_sucursal);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Laboratorio_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Laboratorio_listar`()
BEGIN
    SELECT l.cod_lab, l.nom_lab, l.ape_lab, l.ruc, l.marca, l.telefono, s.cod_sucursal, s.departamento, s.direccion
    FROM laboratorios l
    INNER JOIN sucursales s ON l.cod_sucursal = s.cod_sucursal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Pacientes_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Pacientes_insertar`(
    IN p_cod_pacientes VARCHAR(20),
    IN p_nom_paciente VARCHAR(50),
    IN p_ape_paciente VARCHAR(50),
    IN p_DNI INT,
    IN p_peso DOUBLE,
    IN p_altura DOUBLE,
    IN p_enfermedad VARCHAR(100),
    IN p_Nivel_Urgencia VARCHAR(20),
    IN p_Cod_Sucursal VARCHAR(20)
)
BEGIN
    INSERT INTO pacientes(cod_pacientes, nom_paciente, ape_paciente, DNI, peso, altura, enfermedad, Nivel_Urgencia, Cod_Sucursal)
    VALUES (p_cod_pacientes, p_nom_paciente, p_ape_paciente, p_DNI, p_peso, p_altura, p_enfermedad, p_Nivel_Urgencia, p_Cod_Sucursal);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Paciente_BuscarxApellido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Paciente_BuscarxApellido`(
    IN p_ape_paciente VARCHAR(50)
)
BEGIN
    SELECT * FROM pacientes
    WHERE ape_paciente = p_ape_paciente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Productos_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Productos_insertar`(
    IN p_cod_products VARCHAR(50),
    IN p_nombre VARCHAR(100),
    IN p_cantidad INT,
    IN p_precio DECIMAL(10, 2),
    IN p_marca VARCHAR(50),          -- Ahora `p_marca` es la clave foránea
    IN p_cod_sucursal VARCHAR(20)
)
BEGIN
    INSERT INTO productos (cod_products, nombre, cantidad, precio, marca, cod_sucursal)
    VALUES (p_cod_products, p_nombre, p_cantidad, p_precio, p_marca, p_cod_sucursal);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Productos_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Productos_listar`()
BEGIN
    SELECT * FROM productos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Producto_BuscarxNombre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Producto_BuscarxNombre`(
    IN p_nombre VARCHAR(100)
)
BEGIN
    SELECT * FROM productos
    WHERE nombre LIKE CONCAT('%', p_nombre, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sucursal_BuscarxDepartamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_sucursal_BuscarxDepartamento`(
    IN p_departamento VARCHAR(50)
)
BEGIN
    SELECT * FROM sucursales WHERE departamento = p_departamento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sucursal_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_sucursal_insertar`(
    IN p_cod_sucursal VARCHAR(20),
    IN p_RUC VARCHAR(11),
    IN p_departamento VARCHAR(50),
    IN p_direccion VARCHAR(100),
    IN p_telefono VARCHAR(15)
)
BEGIN
    INSERT INTO sucursales (cod_sucursal, RUC, departamento, Direccion, telefono)
    VALUES (p_cod_sucursal, p_RUC, p_departamento, p_direccion, p_telefono);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sucursal_ResultadoxApellidoCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_sucursal_ResultadoxApellidoCliente`(
    IN p_paci_ape VARCHAR(50)
)
BEGIN
    SELECT v.cod_venta, v.fecha, v.emple_ape, v.paci_ape, v.nom_Producto, v.nivel_urgencia, v.cod_sede
    FROM ventas v
    WHERE v.paci_ape = p_paci_ape;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-10 11:47:08

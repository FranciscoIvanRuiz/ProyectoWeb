-- MySQL dump 10.13  Distrib 5.5.15, for Win32 (x86)
--
-- Host: localhost    Database: sistemajava
-- ------------------------------------------------------
-- Server version	5.5.17

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
-- Current Database: `sistemajava`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sistemajava` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sistemajava`;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `tiposdearticulos_id` int(11) NOT NULL,
  `empresas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_articulos_tiposdearticulos1_idx` (`tiposdearticulos_id`),
  KEY `fk_articulos_empresas1_idx` (`empresas_id`),
  CONSTRAINT `fk_articulos_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_articulos_tiposdearticulos1` FOREIGN KEY (`tiposdearticulos_id`) REFERENCES `tiposdearticulos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES (1,'001','CONSULTORIAS',1,5),(2,'002','MOVILIZACION',2,5);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centrosdecostos`
--

DROP TABLE IF EXISTS `centrosdecostos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centrosdecostos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `empresas_id` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_centrosdecostos_empresas1_idx` (`empresas_id`),
  CONSTRAINT `fk_centrosdecostos_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centrosdecostos`
--

LOCK TABLES `centrosdecostos` WRITE;
/*!40000 ALTER TABLE `centrosdecostos` DISABLE KEYS */;
INSERT INTO `centrosdecostos` VALUES (1,'001',2,'PROYECTO STRATUS'),(2,'002',5,'PROYECTO MINI'),(3,'003',4,'PROYECTO CONTABILIDADES');
/*!40000 ALTER TABLE `centrosdecostos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contadores`
--

DROP TABLE IF EXISTS `contadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `digitos` int(11) DEFAULT NULL,
  `desde` varchar(45) DEFAULT NULL,
  `hasta` varchar(45) DEFAULT NULL,
  `empresas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_contadores_empresas1_idx` (`empresas_id`),
  CONSTRAINT `fk_contadores_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contadores`
--

LOCK TABLES `contadores` WRITE;
/*!40000 ALTER TABLE `contadores` DISABLE KEYS */;
INSERT INTO `contadores` VALUES (1,'001','contador',4,'1','999',5);
/*!40000 ALTER TABLE `contadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcontadores`
--

DROP TABLE IF EXISTS `dcontadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcontadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `utilizado` varchar(1) DEFAULT NULL,
  `contadores_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dcontadores_contadores1_idx` (`contadores_id`),
  CONSTRAINT `fk_dcontadores_contadores1` FOREIGN KEY (`contadores_id`) REFERENCES `contadores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcontadores`
--

LOCK TABLES `dcontadores` WRITE;
/*!40000 ALTER TABLE `dcontadores` DISABLE KEYS */;
INSERT INTO `dcontadores` VALUES (1,'0001','N',1),(2,'0002','N',1),(3,'0003','N',1),(4,'0004','N',1),(5,'0005','N',1),(6,'0006','N',1),(7,'0007','N',1),(8,'0008','N',1),(9,'0009','N',1),(10,'0010','N',1),(11,'0011','N',1),(12,'0012','N',1),(13,'0013','N',1),(14,'0014','N',1),(15,'0015','N',1),(16,'0016','N',1),(17,'0017','N',1),(18,'0018','N',1),(19,'0019','N',1),(20,'0020','N',1),(21,'0021','N',1),(22,'0022','N',1),(23,'0023','N',1),(24,'0024','N',1),(25,'0025','N',1),(26,'0026','N',1),(27,'0027','N',1),(28,'0028','N',1),(29,'0029','N',1),(30,'0030','N',1),(31,'0031','N',1),(32,'0032','N',1),(33,'0033','N',1),(34,'0034','N',1),(35,'0035','N',1),(36,'0036','N',1),(37,'0037','N',1),(38,'0038','N',1),(39,'0039','N',1),(40,'0040','N',1),(41,'0041','N',1),(42,'0042','N',1),(43,'0043','N',1),(44,'0044','N',1),(45,'0045','N',1),(46,'0046','N',1),(47,'0047','N',1),(48,'0048','N',1),(49,'0049','N',1),(50,'0050','N',1),(51,'0051','N',1),(52,'0052','N',1),(53,'0053','N',1),(54,'0054','N',1),(55,'0055','N',1),(56,'0056','N',1),(57,'0057','N',1),(58,'0058','N',1),(59,'0059','N',1),(60,'0060','N',1),(61,'0061','N',1),(62,'0062','N',1),(63,'0063','N',1),(64,'0064','N',1),(65,'0065','N',1),(66,'0066','N',1),(67,'0067','N',1),(68,'0068','N',1),(69,'0069','N',1),(70,'0070','N',1),(71,'0071','N',1),(72,'0072','N',1),(73,'0073','N',1),(74,'0074','N',1),(75,'0075','N',1),(76,'0076','N',1),(77,'0077','N',1),(78,'0078','N',1),(79,'0079','N',1),(80,'0080','N',1),(81,'0081','N',1),(82,'0082','N',1),(83,'0083','N',1),(84,'0084','N',1),(85,'0085','N',1),(86,'0086','N',1),(87,'0087','N',1),(88,'0088','N',1),(89,'0089','N',1),(90,'0090','N',1),(91,'0091','N',1),(92,'0092','N',1),(93,'0093','N',1),(94,'0094','N',1),(95,'0095','N',1),(96,'0096','N',1),(97,'0097','N',1),(98,'0098','N',1),(99,'0099','N',1),(100,'0100','N',1),(101,'0101','N',1),(102,'0102','N',1),(103,'0103','N',1),(104,'0104','N',1),(105,'0105','N',1),(106,'0106','N',1),(107,'0107','N',1),(108,'0108','N',1),(109,'0109','N',1),(110,'0110','N',1),(111,'0111','N',1),(112,'0112','N',1),(113,'0113','N',1),(114,'0114','N',1),(115,'0115','N',1),(116,'0116','N',1),(117,'0117','N',1),(118,'0118','N',1),(119,'0119','N',1),(120,'0120','N',1),(121,'0121','N',1),(122,'0122','N',1),(123,'0123','N',1),(124,'0124','N',1),(125,'0125','N',1),(126,'0126','N',1),(127,'0127','N',1),(128,'0128','N',1),(129,'0129','N',1),(130,'0130','N',1),(131,'0131','N',1),(132,'0132','N',1),(133,'0133','N',1),(134,'0134','N',1),(135,'0135','N',1),(136,'0136','N',1),(137,'0137','N',1),(138,'0138','N',1),(139,'0139','N',1),(140,'0140','N',1),(141,'0141','N',1),(142,'0142','N',1),(143,'0143','N',1),(144,'0144','N',1),(145,'0145','N',1),(146,'0146','N',1),(147,'0147','N',1),(148,'0148','N',1),(149,'0149','N',1),(150,'0150','N',1),(151,'0151','N',1),(152,'0152','N',1),(153,'0153','N',1),(154,'0154','N',1),(155,'0155','N',1),(156,'0156','N',1),(157,'0157','N',1),(158,'0158','N',1),(159,'0159','N',1),(160,'0160','N',1),(161,'0161','N',1),(162,'0162','N',1),(163,'0163','N',1),(164,'0164','N',1),(165,'0165','N',1),(166,'0166','N',1),(167,'0167','N',1),(168,'0168','N',1),(169,'0169','N',1),(170,'0170','N',1),(171,'0171','N',1),(172,'0172','N',1),(173,'0173','N',1),(174,'0174','N',1),(175,'0175','N',1),(176,'0176','N',1),(177,'0177','N',1),(178,'0178','N',1),(179,'0179','N',1),(180,'0180','N',1),(181,'0181','N',1),(182,'0182','N',1),(183,'0183','N',1),(184,'0184','N',1),(185,'0185','N',1),(186,'0186','N',1),(187,'0187','N',1),(188,'0188','N',1),(189,'0189','N',1),(190,'0190','N',1),(191,'0191','N',1),(192,'0192','N',1),(193,'0193','N',1),(194,'0194','N',1),(195,'0195','N',1),(196,'0196','N',1),(197,'0197','N',1),(198,'0198','N',1),(199,'0199','N',1),(200,'0200','N',1),(201,'0201','N',1),(202,'0202','N',1),(203,'0203','N',1),(204,'0204','N',1),(205,'0205','N',1),(206,'0206','N',1),(207,'0207','N',1),(208,'0208','N',1),(209,'0209','N',1),(210,'0210','N',1),(211,'0211','N',1),(212,'0212','N',1),(213,'0213','N',1),(214,'0214','N',1),(215,'0215','N',1),(216,'0216','N',1),(217,'0217','N',1),(218,'0218','N',1),(219,'0219','N',1),(220,'0220','N',1),(221,'0221','N',1),(222,'0222','N',1),(223,'0223','N',1),(224,'0224','N',1),(225,'0225','N',1),(226,'0226','N',1),(227,'0227','N',1),(228,'0228','N',1),(229,'0229','N',1),(230,'0230','N',1),(231,'0231','N',1),(232,'0232','N',1),(233,'0233','N',1),(234,'0234','N',1),(235,'0235','N',1),(236,'0236','N',1),(237,'0237','N',1),(238,'0238','N',1),(239,'0239','N',1),(240,'0240','N',1),(241,'0241','N',1),(242,'0242','N',1),(243,'0243','N',1),(244,'0244','N',1),(245,'0245','N',1),(246,'0246','N',1),(247,'0247','N',1),(248,'0248','N',1),(249,'0249','N',1),(250,'0250','N',1),(251,'0251','N',1),(252,'0252','N',1),(253,'0253','N',1),(254,'0254','N',1),(255,'0255','N',1),(256,'0256','N',1),(257,'0257','N',1),(258,'0258','N',1),(259,'0259','N',1),(260,'0260','N',1),(261,'0261','N',1),(262,'0262','N',1),(263,'0263','N',1),(264,'0264','N',1),(265,'0265','N',1),(266,'0266','N',1),(267,'0267','N',1),(268,'0268','N',1),(269,'0269','N',1),(270,'0270','N',1),(271,'0271','N',1),(272,'0272','N',1),(273,'0273','N',1),(274,'0274','N',1),(275,'0275','N',1),(276,'0276','N',1),(277,'0277','N',1),(278,'0278','N',1),(279,'0279','N',1),(280,'0280','N',1),(281,'0281','N',1),(282,'0282','N',1),(283,'0283','N',1),(284,'0284','N',1),(285,'0285','N',1),(286,'0286','N',1),(287,'0287','N',1),(288,'0288','N',1),(289,'0289','N',1),(290,'0290','N',1),(291,'0291','N',1),(292,'0292','N',1),(293,'0293','N',1),(294,'0294','N',1),(295,'0295','N',1),(296,'0296','N',1),(297,'0297','N',1),(298,'0298','N',1),(299,'0299','N',1),(300,'0300','N',1),(301,'0301','N',1),(302,'0302','N',1),(303,'0303','N',1),(304,'0304','N',1),(305,'0305','N',1),(306,'0306','N',1),(307,'0307','N',1),(308,'0308','N',1),(309,'0309','N',1),(310,'0310','N',1),(311,'0311','N',1),(312,'0312','N',1),(313,'0313','N',1),(314,'0314','N',1),(315,'0315','N',1),(316,'0316','N',1),(317,'0317','N',1),(318,'0318','N',1),(319,'0319','N',1),(320,'0320','N',1),(321,'0321','N',1),(322,'0322','N',1),(323,'0323','N',1),(324,'0324','N',1),(325,'0325','N',1),(326,'0326','N',1),(327,'0327','N',1),(328,'0328','N',1),(329,'0329','N',1),(330,'0330','N',1),(331,'0331','N',1),(332,'0332','N',1),(333,'0333','N',1),(334,'0334','N',1),(335,'0335','N',1),(336,'0336','N',1),(337,'0337','N',1),(338,'0338','N',1),(339,'0339','N',1),(340,'0340','N',1),(341,'0341','N',1),(342,'0342','N',1),(343,'0343','N',1),(344,'0344','N',1),(345,'0345','N',1),(346,'0346','N',1),(347,'0347','N',1),(348,'0348','N',1),(349,'0349','N',1),(350,'0350','N',1),(351,'0351','N',1),(352,'0352','N',1),(353,'0353','N',1),(354,'0354','N',1),(355,'0355','N',1),(356,'0356','N',1),(357,'0357','N',1),(358,'0358','N',1),(359,'0359','N',1),(360,'0360','N',1),(361,'0361','N',1),(362,'0362','N',1),(363,'0363','N',1),(364,'0364','N',1),(365,'0365','N',1),(366,'0366','N',1),(367,'0367','N',1),(368,'0368','N',1),(369,'0369','N',1),(370,'0370','N',1),(371,'0371','N',1),(372,'0372','N',1),(373,'0373','N',1),(374,'0374','N',1),(375,'0375','N',1),(376,'0376','N',1),(377,'0377','N',1),(378,'0378','N',1),(379,'0379','N',1),(380,'0380','N',1),(381,'0381','N',1),(382,'0382','N',1),(383,'0383','N',1),(384,'0384','N',1),(385,'0385','N',1),(386,'0386','N',1),(387,'0387','N',1),(388,'0388','N',1),(389,'0389','N',1),(390,'0390','N',1),(391,'0391','N',1),(392,'0392','N',1),(393,'0393','N',1),(394,'0394','N',1),(395,'0395','N',1),(396,'0396','N',1),(397,'0397','N',1),(398,'0398','N',1),(399,'0399','N',1),(400,'0400','N',1),(401,'0401','N',1),(402,'0402','N',1),(403,'0403','N',1),(404,'0404','N',1),(405,'0405','N',1),(406,'0406','N',1),(407,'0407','N',1),(408,'0408','N',1),(409,'0409','N',1),(410,'0410','N',1),(411,'0411','N',1),(412,'0412','N',1),(413,'0413','N',1),(414,'0414','N',1),(415,'0415','N',1),(416,'0416','N',1),(417,'0417','N',1),(418,'0418','N',1),(419,'0419','N',1),(420,'0420','N',1),(421,'0421','N',1),(422,'0422','N',1),(423,'0423','N',1),(424,'0424','N',1),(425,'0425','N',1),(426,'0426','N',1),(427,'0427','N',1),(428,'0428','N',1),(429,'0429','N',1),(430,'0430','N',1),(431,'0431','N',1),(432,'0432','N',1),(433,'0433','N',1),(434,'0434','N',1),(435,'0435','N',1),(436,'0436','N',1),(437,'0437','N',1),(438,'0438','N',1),(439,'0439','N',1),(440,'0440','N',1),(441,'0441','N',1),(442,'0442','N',1),(443,'0443','N',1),(444,'0444','N',1),(445,'0445','N',1),(446,'0446','N',1),(447,'0447','N',1),(448,'0448','N',1),(449,'0449','N',1),(450,'0450','N',1),(451,'0451','N',1),(452,'0452','N',1),(453,'0453','N',1),(454,'0454','N',1),(455,'0455','N',1),(456,'0456','N',1),(457,'0457','N',1),(458,'0458','N',1),(459,'0459','N',1),(460,'0460','N',1),(461,'0461','N',1),(462,'0462','N',1),(463,'0463','N',1),(464,'0464','N',1),(465,'0465','N',1),(466,'0466','N',1),(467,'0467','N',1),(468,'0468','N',1),(469,'0469','N',1),(470,'0470','N',1),(471,'0471','N',1),(472,'0472','N',1),(473,'0473','N',1),(474,'0474','N',1),(475,'0475','N',1),(476,'0476','N',1),(477,'0477','N',1),(478,'0478','N',1),(479,'0479','N',1),(480,'0480','N',1),(481,'0481','N',1),(482,'0482','N',1),(483,'0483','N',1),(484,'0484','N',1),(485,'0485','N',1),(486,'0486','N',1),(487,'0487','N',1),(488,'0488','N',1),(489,'0489','N',1),(490,'0490','N',1),(491,'0491','N',1),(492,'0492','N',1),(493,'0493','N',1),(494,'0494','N',1),(495,'0495','N',1),(496,'0496','N',1),(497,'0497','N',1),(498,'0498','N',1),(499,'0499','N',1),(500,'0500','N',1),(501,'0501','N',1),(502,'0502','N',1),(503,'0503','N',1),(504,'0504','N',1),(505,'0505','N',1),(506,'0506','N',1),(507,'0507','N',1),(508,'0508','N',1),(509,'0509','N',1),(510,'0510','N',1),(511,'0511','N',1),(512,'0512','N',1),(513,'0513','N',1),(514,'0514','N',1),(515,'0515','N',1),(516,'0516','N',1),(517,'0517','N',1),(518,'0518','N',1),(519,'0519','N',1),(520,'0520','N',1),(521,'0521','N',1),(522,'0522','N',1),(523,'0523','N',1),(524,'0524','N',1),(525,'0525','N',1),(526,'0526','N',1),(527,'0527','N',1),(528,'0528','N',1),(529,'0529','N',1),(530,'0530','N',1),(531,'0531','N',1),(532,'0532','N',1),(533,'0533','N',1),(534,'0534','N',1),(535,'0535','N',1),(536,'0536','N',1),(537,'0537','N',1),(538,'0538','N',1),(539,'0539','N',1),(540,'0540','N',1),(541,'0541','N',1),(542,'0542','N',1),(543,'0543','N',1),(544,'0544','N',1),(545,'0545','N',1),(546,'0546','N',1),(547,'0547','N',1),(548,'0548','N',1),(549,'0549','N',1),(550,'0550','N',1),(551,'0551','N',1),(552,'0552','N',1),(553,'0553','N',1),(554,'0554','N',1),(555,'0555','N',1),(556,'0556','N',1),(557,'0557','N',1),(558,'0558','N',1),(559,'0559','N',1),(560,'0560','N',1),(561,'0561','N',1),(562,'0562','N',1),(563,'0563','N',1),(564,'0564','N',1),(565,'0565','N',1),(566,'0566','N',1),(567,'0567','N',1),(568,'0568','N',1),(569,'0569','N',1),(570,'0570','N',1),(571,'0571','N',1),(572,'0572','N',1),(573,'0573','N',1),(574,'0574','N',1),(575,'0575','N',1),(576,'0576','N',1),(577,'0577','N',1),(578,'0578','N',1),(579,'0579','N',1),(580,'0580','N',1),(581,'0581','N',1),(582,'0582','N',1),(583,'0583','N',1),(584,'0584','N',1),(585,'0585','N',1),(586,'0586','N',1),(587,'0587','N',1),(588,'0588','N',1),(589,'0589','N',1),(590,'0590','N',1),(591,'0591','N',1),(592,'0592','N',1),(593,'0593','N',1),(594,'0594','N',1),(595,'0595','N',1),(596,'0596','N',1),(597,'0597','N',1),(598,'0598','N',1),(599,'0599','N',1),(600,'0600','N',1),(601,'0601','N',1),(602,'0602','N',1),(603,'0603','N',1),(604,'0604','N',1),(605,'0605','N',1),(606,'0606','N',1),(607,'0607','N',1),(608,'0608','N',1),(609,'0609','N',1),(610,'0610','N',1),(611,'0611','N',1),(612,'0612','N',1),(613,'0613','N',1),(614,'0614','N',1),(615,'0615','N',1),(616,'0616','N',1),(617,'0617','N',1),(618,'0618','N',1),(619,'0619','N',1),(620,'0620','N',1),(621,'0621','N',1),(622,'0622','N',1),(623,'0623','N',1),(624,'0624','N',1),(625,'0625','N',1),(626,'0626','N',1),(627,'0627','N',1),(628,'0628','N',1),(629,'0629','N',1),(630,'0630','N',1),(631,'0631','N',1),(632,'0632','N',1),(633,'0633','N',1),(634,'0634','N',1),(635,'0635','N',1),(636,'0636','N',1),(637,'0637','N',1),(638,'0638','N',1),(639,'0639','N',1),(640,'0640','N',1),(641,'0641','N',1),(642,'0642','N',1),(643,'0643','N',1),(644,'0644','N',1),(645,'0645','N',1),(646,'0646','N',1),(647,'0647','N',1),(648,'0648','N',1),(649,'0649','N',1),(650,'0650','N',1),(651,'0651','N',1),(652,'0652','N',1),(653,'0653','N',1),(654,'0654','N',1),(655,'0655','N',1),(656,'0656','N',1),(657,'0657','N',1),(658,'0658','N',1),(659,'0659','N',1),(660,'0660','N',1),(661,'0661','N',1),(662,'0662','N',1),(663,'0663','N',1),(664,'0664','N',1),(665,'0665','N',1),(666,'0666','N',1),(667,'0667','N',1),(668,'0668','N',1),(669,'0669','N',1),(670,'0670','N',1),(671,'0671','N',1),(672,'0672','N',1),(673,'0673','N',1),(674,'0674','N',1),(675,'0675','N',1),(676,'0676','N',1),(677,'0677','N',1),(678,'0678','N',1),(679,'0679','N',1),(680,'0680','N',1),(681,'0681','N',1),(682,'0682','N',1),(683,'0683','N',1),(684,'0684','N',1),(685,'0685','N',1),(686,'0686','N',1),(687,'0687','N',1),(688,'0688','N',1),(689,'0689','N',1),(690,'0690','N',1),(691,'0691','N',1),(692,'0692','N',1),(693,'0693','N',1),(694,'0694','N',1),(695,'0695','N',1),(696,'0696','N',1),(697,'0697','N',1),(698,'0698','N',1),(699,'0699','N',1),(700,'0700','N',1),(701,'0701','N',1),(702,'0702','N',1),(703,'0703','N',1),(704,'0704','N',1),(705,'0705','N',1),(706,'0706','N',1),(707,'0707','N',1),(708,'0708','N',1),(709,'0709','N',1),(710,'0710','N',1),(711,'0711','N',1),(712,'0712','N',1),(713,'0713','N',1),(714,'0714','N',1),(715,'0715','N',1),(716,'0716','N',1),(717,'0717','N',1),(718,'0718','N',1),(719,'0719','N',1),(720,'0720','N',1),(721,'0721','N',1),(722,'0722','N',1),(723,'0723','N',1),(724,'0724','N',1),(725,'0725','N',1),(726,'0726','N',1),(727,'0727','N',1),(728,'0728','N',1),(729,'0729','N',1),(730,'0730','N',1),(731,'0731','N',1),(732,'0732','N',1),(733,'0733','N',1),(734,'0734','N',1),(735,'0735','N',1),(736,'0736','N',1),(737,'0737','N',1),(738,'0738','N',1),(739,'0739','N',1),(740,'0740','N',1),(741,'0741','N',1),(742,'0742','N',1),(743,'0743','N',1),(744,'0744','N',1),(745,'0745','N',1),(746,'0746','N',1),(747,'0747','N',1),(748,'0748','N',1),(749,'0749','N',1),(750,'0750','N',1),(751,'0751','N',1),(752,'0752','N',1),(753,'0753','N',1),(754,'0754','N',1),(755,'0755','N',1),(756,'0756','N',1),(757,'0757','N',1),(758,'0758','N',1),(759,'0759','N',1),(760,'0760','N',1),(761,'0761','N',1),(762,'0762','N',1),(763,'0763','N',1),(764,'0764','N',1),(765,'0765','N',1),(766,'0766','N',1),(767,'0767','N',1),(768,'0768','N',1),(769,'0769','N',1),(770,'0770','N',1),(771,'0771','N',1),(772,'0772','N',1),(773,'0773','N',1),(774,'0774','N',1),(775,'0775','N',1),(776,'0776','N',1),(777,'0777','N',1),(778,'0778','N',1),(779,'0779','N',1),(780,'0780','N',1),(781,'0781','N',1),(782,'0782','N',1),(783,'0783','N',1),(784,'0784','N',1),(785,'0785','N',1),(786,'0786','N',1),(787,'0787','N',1),(788,'0788','N',1),(789,'0789','N',1),(790,'0790','N',1),(791,'0791','N',1),(792,'0792','N',1),(793,'0793','N',1),(794,'0794','N',1),(795,'0795','N',1),(796,'0796','N',1),(797,'0797','N',1),(798,'0798','N',1),(799,'0799','N',1),(800,'0800','N',1),(801,'0801','N',1),(802,'0802','N',1),(803,'0803','N',1),(804,'0804','N',1),(805,'0805','N',1),(806,'0806','N',1),(807,'0807','N',1),(808,'0808','N',1),(809,'0809','N',1),(810,'0810','N',1),(811,'0811','N',1),(812,'0812','N',1),(813,'0813','N',1),(814,'0814','N',1),(815,'0815','N',1),(816,'0816','N',1),(817,'0817','N',1),(818,'0818','N',1),(819,'0819','N',1),(820,'0820','N',1),(821,'0821','N',1),(822,'0822','N',1),(823,'0823','N',1),(824,'0824','N',1),(825,'0825','N',1),(826,'0826','N',1),(827,'0827','N',1),(828,'0828','N',1),(829,'0829','N',1),(830,'0830','N',1),(831,'0831','N',1),(832,'0832','N',1),(833,'0833','N',1),(834,'0834','N',1),(835,'0835','N',1),(836,'0836','N',1),(837,'0837','N',1),(838,'0838','N',1),(839,'0839','N',1),(840,'0840','N',1),(841,'0841','N',1),(842,'0842','N',1),(843,'0843','N',1),(844,'0844','N',1),(845,'0845','N',1),(846,'0846','N',1),(847,'0847','N',1),(848,'0848','N',1),(849,'0849','N',1),(850,'0850','N',1),(851,'0851','N',1),(852,'0852','N',1),(853,'0853','N',1),(854,'0854','N',1),(855,'0855','N',1),(856,'0856','N',1),(857,'0857','N',1),(858,'0858','N',1),(859,'0859','N',1),(860,'0860','N',1),(861,'0861','N',1),(862,'0862','N',1),(863,'0863','N',1),(864,'0864','N',1),(865,'0865','N',1),(866,'0866','N',1),(867,'0867','N',1),(868,'0868','N',1),(869,'0869','N',1),(870,'0870','N',1),(871,'0871','N',1),(872,'0872','N',1),(873,'0873','N',1),(874,'0874','N',1),(875,'0875','N',1),(876,'0876','N',1),(877,'0877','N',1),(878,'0878','N',1),(879,'0879','N',1),(880,'0880','N',1),(881,'0881','N',1),(882,'0882','N',1),(883,'0883','N',1),(884,'0884','N',1),(885,'0885','N',1),(886,'0886','N',1),(887,'0887','N',1),(888,'0888','N',1),(889,'0889','N',1),(890,'0890','N',1),(891,'0891','N',1),(892,'0892','N',1),(893,'0893','N',1),(894,'0894','N',1),(895,'0895','N',1),(896,'0896','N',1),(897,'0897','N',1),(898,'0898','N',1),(899,'0899','N',1),(900,'0900','N',1),(901,'0901','N',1),(902,'0902','N',1),(903,'0903','N',1),(904,'0904','N',1),(905,'0905','N',1),(906,'0906','N',1),(907,'0907','N',1),(908,'0908','N',1),(909,'0909','N',1),(910,'0910','N',1),(911,'0911','N',1),(912,'0912','N',1),(913,'0913','N',1),(914,'0914','N',1),(915,'0915','N',1),(916,'0916','N',1),(917,'0917','N',1),(918,'0918','N',1),(919,'0919','N',1),(920,'0920','N',1),(921,'0921','N',1),(922,'0922','N',1),(923,'0923','N',1),(924,'0924','N',1),(925,'0925','N',1),(926,'0926','N',1),(927,'0927','N',1),(928,'0928','N',1),(929,'0929','N',1),(930,'0930','N',1),(931,'0931','N',1),(932,'0932','N',1),(933,'0933','N',1),(934,'0934','N',1),(935,'0935','N',1),(936,'0936','N',1),(937,'0937','N',1),(938,'0938','N',1),(939,'0939','N',1),(940,'0940','N',1),(941,'0941','N',1),(942,'0942','N',1),(943,'0943','N',1),(944,'0944','N',1),(945,'0945','N',1),(946,'0946','N',1),(947,'0947','N',1),(948,'0948','N',1),(949,'0949','N',1),(950,'0950','N',1),(951,'0951','N',1),(952,'0952','N',1),(953,'0953','N',1),(954,'0954','N',1),(955,'0955','N',1),(956,'0956','N',1),(957,'0957','N',1),(958,'0958','N',1),(959,'0959','N',1),(960,'0960','N',1),(961,'0961','N',1),(962,'0962','N',1),(963,'0963','N',1),(964,'0964','N',1),(965,'0965','N',1),(966,'0966','N',1),(967,'0967','N',1),(968,'0968','N',1),(969,'0969','N',1),(970,'0970','N',1),(971,'0971','N',1),(972,'0972','N',1),(973,'0973','N',1),(974,'0974','N',1),(975,'0975','N',1),(976,'0976','N',1),(977,'0977','N',1),(978,'0978','N',1),(979,'0979','N',1),(980,'0980','N',1),(981,'0981','N',1),(982,'0982','N',1),(983,'0983','N',1),(984,'0984','N',1),(985,'0985','N',1),(986,'0986','N',1),(987,'0987','N',1),(988,'0988','N',1),(989,'0989','N',1),(990,'0990','N',1),(991,'0991','N',1),(992,'0992','N',1),(993,'0993','N',1),(994,'0994','N',1),(995,'0995','N',1),(996,'0996','N',1),(997,'0997','N',1),(998,'0998','N',1),(999,'0999','N',1);
/*!40000 ALTER TABLE `dcontadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmovimientos`
--

DROP TABLE IF EXISTS `dmovimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dmovimientos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movimientos_id` int(11) NOT NULL,
  `articulos_id` int(11) NOT NULL,
  `cantidad` decimal(18,6) DEFAULT NULL,
  `precio` decimal(18,6) DEFAULT NULL,
  `iva` decimal(18,6) DEFAULT NULL,
  `descuento` decimal(18,6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dmovimiento_movimiento1` (`movimientos_id`),
  KEY `fk_dmovimientos_articulos1` (`articulos_id`),
  CONSTRAINT `fk_dmovimiento_movimiento1` FOREIGN KEY (`movimientos_id`) REFERENCES `movimientos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dmovimientos_articulos1` FOREIGN KEY (`articulos_id`) REFERENCES `articulos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dmovimientos`
--

LOCK TABLES `dmovimientos` WRITE;
/*!40000 ALTER TABLE `dmovimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `dmovimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `ruc` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `web` varchar(45) DEFAULT NULL,
  `personas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ruc_UNIQUE` (`ruc`),
  KEY `fk_empresas_personas_idx` (`personas_id`),
  CONSTRAINT `fk_empresas_personas` FOREIGN KEY (`personas_id`) REFERENCES `personas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (2,'SISTEMAS INFORMATICOS','1714688213001','022866316','022866316','francisco.ivan.ruiz@gmail.com','VALLE DE LOS CHILLOS','www.sistemas.com',1),(4,'CONTABILIDADES RUIZ','1714688212001','0984495050','0984495050','francisco.ivan.ruiz@icloud.com','CAPELO','WWW',1),(5,'MINI RUIZ','1714688213003','2866360','2866360','mini.com','mini.com','mini.com',1);
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos`
--

LOCK TABLES `modulos` WRITE;
/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
INSERT INTO `modulos` VALUES (1,'Configuraciones'),(3,'Contabilidad'),(2,'Logistica');
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empresas_id` int(11) NOT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  `proveedoresclientes_id` int(11) NOT NULL,
  `transacciones_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movimiento_empresas1` (`empresas_id`),
  KEY `fk_movimientos_proveedoresclientes1` (`proveedoresclientes_id`),
  KEY `fk_movimientos_transacciones1` (`transacciones_id`),
  CONSTRAINT `fk_movimiento_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimientos_proveedoresclientes1` FOREIGN KEY (`proveedoresclientes_id`) REFERENCES `proveedoresclientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimientos_transacciones1` FOREIGN KEY (`transacciones_id`) REFERENCES `transacciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros` (
  `ventas` int(11) DEFAULT NULL,
  `compras` int(11) DEFAULT NULL,
  `nventas` int(11) DEFAULT NULL,
  `ncompras` int(11) DEFAULT NULL,
  `empresas_id` int(11) NOT NULL,
  PRIMARY KEY (`empresas_id`),
  CONSTRAINT `fk_parametros_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(45) DEFAULT NULL,
  `nombre1` varchar(45) DEFAULT NULL,
  `nombre2` varchar(45) DEFAULT NULL,
  `apellido1` varchar(45) DEFAULT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'1714688213','FRANCISCO','IVAN','RUIZ','SIMBANA');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedoresclientes`
--

DROP TABLE IF EXISTS `proveedoresclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedoresclientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `ruc` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono1` varchar(45) DEFAULT NULL,
  `telefono2` varchar(45) DEFAULT NULL,
  `telefono3` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `representante` varchar(45) DEFAULT NULL,
  `empresas_id` int(11) NOT NULL,
  `renta` int(11) DEFAULT NULL,
  `rentaservicio` int(11) DEFAULT NULL,
  `rentatransporte` int(11) DEFAULT NULL,
  `iva` int(11) DEFAULT NULL,
  `ivaservicios` int(11) DEFAULT NULL,
  `ivatransporte` int(11) DEFAULT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_proveedores_empresas1` (`empresas_id`),
  CONSTRAINT `fk_proveedores_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedoresclientes`
--

LOCK TABLES `proveedoresclientes` WRITE;
/*!40000 ALTER TABLE `proveedoresclientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedoresclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retenciones`
--

DROP TABLE IF EXISTS `retenciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retenciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movimientos_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_retenciones_movimientos1` (`movimientos_id`),
  CONSTRAINT `fk_retenciones_movimientos1` FOREIGN KEY (`movimientos_id`) REFERENCES `movimientos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retenciones`
--

LOCK TABLES `retenciones` WRITE;
/*!40000 ALTER TABLE `retenciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `retenciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposdearticulos`
--

DROP TABLE IF EXISTS `tiposdearticulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposdearticulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  `empresas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_tiposdearticulos_empresas1_idx` (`empresas_id`),
  CONSTRAINT `fk_tiposdearticulos_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposdearticulos`
--

LOCK TABLES `tiposdearticulos` WRITE;
/*!40000 ALTER TABLE `tiposdearticulos` DISABLE KEYS */;
INSERT INTO `tiposdearticulos` VALUES (1,'001','COMPUTADORAS','01',5),(2,'002','TAXIS FRANCISCO RUIZ','02',5),(3,'003','CONTABILIDADES','02',4),(4,'004','TRASNPORTES','03',4);
/*!40000 ALTER TABLE `tiposdearticulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposderetenciones`
--

DROP TABLE IF EXISTS `tiposderetenciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposderetenciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `porcentaje` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposderetenciones`
--

LOCK TABLES `tiposderetenciones` WRITE;
/*!40000 ALTER TABLE `tiposderetenciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiposderetenciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacciones`
--

DROP TABLE IF EXISTS `transacciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transacciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `empresas_id` int(11) NOT NULL,
  `tipo` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_transacciones_empresas1_idx` (`empresas_id`),
  CONSTRAINT `fk_transacciones_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacciones`
--

LOCK TABLES `transacciones` WRITE;
/*!40000 ALTER TABLE `transacciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(10) DEFAULT NULL,
  `clave` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'ADMIN','ADMIN');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-23 22:05:35

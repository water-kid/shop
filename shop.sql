-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.9

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
-- Table structure for table `t_sku`
--

DROP TABLE IF EXISTS `t_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sku` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spu_id` int(10) unsigned NOT NULL COMMENT '产品id',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `images` json DEFAULT NULL COMMENT '商品图片',
  `price` decimal(10,2) unsigned NOT NULL COMMENT '价格',
  `param` json NOT NULL COMMENT '参数',
  `valid` tinyint(1) NOT NULL COMMENT '是否有效',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sku`
--

LOCK TABLES `t_sku` WRITE;
/*!40000 ALTER TABLE `t_sku` DISABLE KEYS */;
INSERT INTO `t_sku` VALUES (2,1,'1 Xiaomi[小米小米9 6GB+128GB深空灰移动联通电信全网通4G手机','[\"http://localhost:8090/img/2023/03/16/4cfc6712b9a7400ebbc0422ec253b196.jpg\", \"http://localhost:8090/img/2023/03/16/6de1cd2d3267401f8c1c01158986d4f7.png\"]',3299.00,'{\"CPU\": \"xxxCPU\", \"内存\": \"4G\", \"屏幕尺寸\": \"6.39\"}',1,'2023-03-16 02:35:27','2023-03-16 10:02:37'),(3,1,'1 Xiaomi[小米小米9 6GB+128GB深空灰移动联通电信全网通4G手机','[\"http://localhost:8090/img/2023/03/16/4cfc6712b9a7400ebbc0422ec253b196.jpg\", \"http://localhost:8090/img/2023/03/16/6de1cd2d3267401f8c1c01158986d4f7.png\"]',3299.00,'{\"CPU\": \"晓龙985\", \"内存\": \"16G\", \"屏幕尺寸\": \"11\"}',1,'2023-03-16 02:35:27','2023-03-16 10:02:37'),(4,1,'1 Xiaomi[小米小米9 6GB+128GB深空灰移动联通电信全网通4G手机','[\"http://localhost:8090/img/2023/03/16/4cfc6712b9a7400ebbc0422ec253b196.jpg\", \"http://localhost:8090/img/2023/03/16/6de1cd2d3267401f8c1c01158986d4f7.png\"]',3111.00,'{\"CPU\": \"晓龙985\", \"内存\": \"8G\", \"屏幕尺寸\": \"22\"}',1,'2023-03-16 02:35:27','2023-03-16 06:20:45'),(6,2,'华为','{}',123.00,'{\"CPU\": \"晓龙985\", \"内存\": \"4G\", \"屏幕尺寸\": \"6.39\"}',1,'2023-03-16 10:21:44','2023-03-16 10:21:44'),(8,2,'444','[\"http://localhost:8090/img/2023/03/17/1def005dff674e9585e7c703742f304c.ico\", \"http://localhost:8090/img/2023/03/17/6db19cca48904f8fbeb06db6e3e65089.png\"]',1.00,'{\"CPU\": \"晓龙985\", \"内存\": \"4G\", \"屏幕尺寸\": \"6.39\"}',1,'2023-03-16 10:38:08','2023-03-16 10:38:08'),(9,3,'444','[\"http://localhost:8090/img/2023/03/16/fb25b91f825f4f3e9034d8c7fddc9c2c.jpg\", \"http://localhost:8090/img/2023/03/16/3a248773b85b48219e5b648bc1750226.jpg\"]',111.00,'{\"CPU\": \"晓龙855\", \"内存\": \"4G\", \"屏幕尺寸\": \"6.39\"}',1,'2023-03-16 10:38:37','2023-03-16 10:38:37'),(14,1,'111','[\"http://localhost:8090/img/2023/03/16/01d52283593744d2a09dac744837be96.jpg\"]',123112.00,'{\"CPU\": \"晓龙855\", \"内存\": \"4G\", \"屏幕尺寸\": \"22\"}',1,'2023-03-16 11:16:00','2023-03-16 11:16:00'),(17,5,'zzz1','[\"http://localhost:8090/img/2023/03/17/710782be8669485385bc5593f06402ac.ico\", \"http://localhost:8090/img/2023/03/17/11b98a43ed514fc899fc7e72a8d01866.f7bcabc5.jpg\"]',11111.00,'{\"CPU\": \"amd\", \"颜色\": \"白色\"}',1,'2023-03-17 05:50:56','2023-03-17 05:50:56'),(18,5,'2131','[\"http://localhost:8090/img/2023/03/17/0adbd33a55874840b5bcee2c402ff315.jpg\"]',121.00,'{\"CPU\": \"i7\", \"颜色\": \"黑色\"}',1,'2023-03-17 06:05:50','2023-03-17 06:05:50'),(19,1,'1231','{}',111.00,'{\"CPU\": \"晓龙855\", \"内存\": \"8G\", \"屏幕尺寸\": \"22\"}',1,'2023-03-17 08:17:53','2023-03-17 08:17:53'),(20,3,'123','[\"http://localhost:8090/img/2023/03/17/1c02859e4f3b496a94c9085bdc78b8ce.jpg\"]',11.00,'{\"CPU\": \"晓龙855\", \"内存\": \"4G\", \"屏幕尺寸\": \"22\"}',1,'2023-03-17 08:18:20','2023-03-17 08:18:20'),(21,4,'11','{}',11.00,'{\"CPU\": \"晓龙855\", \"屏幕尺寸\": \"22\"}',1,'2023-03-17 09:25:12','2023-03-17 09:25:12'),(22,6,'111','{}',21.00,'{}',1,'2023-03-17 09:27:59','2023-03-17 09:27:59'),(23,6,'11','{}',11.00,'{}',1,'2023-03-16 10:38:37','2023-03-16 10:38:37'),(24,5,'1','{}',1.00,'{\"CPU\": \"i5\", \"颜色\": \"白色\"}',1,'2023-03-17 05:50:56','2023-03-17 05:50:56'),(25,5,'1','{}',1.00,'{\"颜色\": \"黑色\"}',1,'2023-03-17 05:50:56','2023-03-17 05:50:56');
/*!40000 ALTER TABLE `t_sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_spec_group`
--

DROP TABLE IF EXISTS `t_spec_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_spec_group` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spg_id` int(10) unsigned NOT NULL COMMENT '品类编号',
  `name` varchar(200) NOT NULL COMMENT '品类名字',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_spg_id` (`spg_id`),
  UNIQUE KEY `unq_name` (`name`),
  KEY `idx_spg_id` (`spg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='品类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_spec_group`
--

LOCK TABLES `t_spec_group` WRITE;
/*!40000 ALTER TABLE `t_spec_group` DISABLE KEYS */;
INSERT INTO `t_spec_group` VALUES (1,10001,'手机'),(2,10002,'手机线'),(3,10003,'电视'),(4,10004,'衣服'),(5,20001,'电脑');
/*!40000 ALTER TABLE `t_spec_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_spec_param`
--

DROP TABLE IF EXISTS `t_spec_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_spec_param` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spg_id` int(10) unsigned NOT NULL COMMENT '品类编号',
  `spp_id` int(10) unsigned NOT NULL COMMENT '参数编号',
  `name` varchar(200) NOT NULL COMMENT '参数名称',
  `numeric` tinyint(1) NOT NULL COMMENT '是否为数字参数',
  `unit` varchar(200) DEFAULT NULL COMMENT '单位(量词)',
  `generic` tinyint(1) NOT NULL COMMENT '是否为通用参数',
  `searching` tinyint(1) NOT NULL COMMENT '是否用于通用搜索',
  `segements` varchar(500) DEFAULT NULL COMMENT '参数值',
  `details` json DEFAULT NULL COMMENT '参数属性',
  PRIMARY KEY (`id`),
  KEY `idx_spg_id` (`spg_id`),
  KEY `idx_spp_id` (`spp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='参数表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_spec_param`
--

LOCK TABLES `t_spec_param` WRITE;
/*!40000 ALTER TABLE `t_spec_param` DISABLE KEYS */;
INSERT INTO `t_spec_param` VALUES (1,10001,1,'CPU',0,NULL,1,0,NULL,'{\"desc\": [\"晓龙855\", \"xxxCPU\"], \"imgs\": [\"111.jpg\", \"22.jpg\"]}'),(2,10001,2,'内存',1,'GB',1,1,NULL,'{\"desc\": [\"4G\", \"8G\", \"16G\"]}'),(3,10001,3,'屏幕尺寸',1,'英寸',1,1,NULL,'{\"desc\": [\"11\", \"22\", \"6.39\"]}'),(4,20001,1,'颜色',0,NULL,0,0,NULL,'{\"desc\": [\"白色\", \"黑色\", \"银色\"]}'),(5,20001,2,'CPU',0,NULL,0,0,NULL,'{\"desc\": [\"i5\", \"i7\", \"amd\"]}');
/*!40000 ALTER TABLE `t_spec_param` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_spu`
--

DROP TABLE IF EXISTS `t_spu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_spu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `sub_title` varchar(200) DEFAULT NULL COMMENT '副标题',
  `category_id` int(10) unsigned NOT NULL COMMENT '分类id',
  `spg_id` int(10) unsigned NOT NULL COMMENT '品类id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `brand_id` int(10) unsigned DEFAULT NULL COMMENT '品牌id',
  `valid` tinyint(1) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='产品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_spu`
--

LOCK TABLES `t_spu` WRITE;
/*!40000 ALTER TABLE `t_spu` DISABLE KEYS */;
INSERT INTO `t_spu` VALUES (1,'小米9',NULL,1,10001,'2023-03-16 02:25:08','2023-03-16 02:27:11',1,1),(2,'华为meta10',NULL,1,10001,'2023-03-16 03:33:02','2023-03-16 03:33:02',NULL,NULL),(3,'redmi note11',NULL,1,10001,'2023-03-16 03:33:48','2023-03-16 03:33:48',NULL,NULL),(4,'荣耀30',NULL,1,10001,'2023-03-16 03:34:05','2023-03-16 03:34:05',NULL,NULL),(5,'拯救者',NULL,2,20001,'2023-03-16 10:15:39','2023-03-16 10:15:39',NULL,NULL),(6,'衣服spu',NULL,3,10004,'2023-03-17 08:58:09','2023-03-17 08:58:09',NULL,NULL);
/*!40000 ALTER TABLE `t_spu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-17 17:50:28

/*
MySQL Data Transfer
Source Host: localhost
Source Database: shop
Target Host: localhost
Target Database: shop
Date: 2013/6/14 17:24:38
*/
-- ----------------------------
-- Table structure for cart_item_sx
-- ----------------------------
CREATE TABLE `cart_item` (
  `id` int(11) NOT NULL,
  `amount` int(11) default NULL,
  `cost` float default NULL,
  `book_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_order_sx
-- ----------------------------
CREATE TABLE `cart_order` (
  `id` int(11) NOT NULL,
  `status` varchar(12) default NULL,
  `odate` varchar(30) default NULL,
  `user_id` int(11) NOT NULL,
  `cost` double(10,2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_product_sx
-- ----------------------------
CREATE TABLE `cart_book` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `description` varchar(500) default NULL,
  `price` float default NULL,
  `img` varchar(50) default NULL,
  `book_type_id` int(11) NOT NULL ,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_product_type
-- ----------------------------
CREATE TABLE `book_type` (
  `book_type_name` varchar(50) default NULL,
  `id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cart_user_sx
-- ----------------------------
CREATE TABLE `cart_user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `address` varchar(512) default NULL,
  `postcode` varchar(10) default NULL,
  `email` varchar(32) default NULL,
  `phone` varchar(32) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;


-- ----------------------------
-- Table structure for order_id
-- ----------------------------
CREATE TABLE `order_id` (
  `oid` int(10) NOT NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for orderitem_id
-- ----------------------------
CREATE TABLE `orderitem_id` (
  `oid` int(10) NOT NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `cart_item` VALUES ('1', '1', '50.500000', '1', '5');
INSERT INTO `cart_item` VALUES ('2', '1', '35.000000', '4', '5');
INSERT INTO `cart_item` VALUES ('3', '2', '68.000000', '2', '5');
INSERT INTO `cart_item` VALUES ('4', '1', '50.500000', '1', '6');
INSERT INTO `cart_item` VALUES ('5', '1', '34.000000', '2', '6');
INSERT INTO `cart_item` VALUES ('6', '1', '35.000000', '5', '6');
INSERT INTO `cart_item` VALUES ('7', '1', '35.000000', '5', '7');
INSERT INTO `cart_item` VALUES ('8', '1', '50.500000', '1', '7');
INSERT INTO `cart_item` VALUES ('9', '2', '70.000000', '4', '7');
INSERT INTO `cart_item` VALUES ('10', '1', '34.000000', '2', '7');
INSERT INTO `cart_item` VALUES ('11', '1', '35.000000', '5', '8');
INSERT INTO `cart_item` VALUES ('12', '1', '50.500000', '1', '8');
INSERT INTO `cart_item` VALUES ('13', '2', '70.000000', '4', '8');
INSERT INTO `cart_item` VALUES ('14', '1', '34.000000', '2', '8');
INSERT INTO `cart_item` VALUES ('15', '1', '35.000000', '5', '9');
INSERT INTO `cart_item` VALUES ('16', '1', '50.500000', '1', '9');
INSERT INTO `cart_item` VALUES ('17', '2', '70.000000', '4', '9');
INSERT INTO `cart_item` VALUES ('18', '1', '34.000000', '2', '9');
INSERT INTO `cart_item` VALUES ('19', '1', '50.500000', '1', '10');
INSERT INTO `cart_item` VALUES ('20', '1', '34.000000', '2', '10');
INSERT INTO `cart_item` VALUES ('21', '1', '50.500000', '1', '11');
INSERT INTO `cart_item` VALUES ('22', '1', '34.000000', '2', '11');
INSERT INTO `cart_item` VALUES ('23', '2', '70.000000', '5', '12');
INSERT INTO `cart_item` VALUES ('25', '1', '35.000000', '4', '13');
INSERT INTO `cart_item` VALUES ('26', '2', '68.000000', '2', '13');
INSERT INTO `cart_item` VALUES ('27', '1', '50.500000', '1', '13');
INSERT INTO `cart_order` VALUES ('1', 'δ����', '2013-59-17  13:59:43', '1', '4.00');
INSERT INTO `cart_order` VALUES ('2', 'δ����', '2013-35-03  22:35:30', '1', '41.00');
INSERT INTO `cart_order` VALUES ('3', 'δ����', '2013-34-04  09:34:43', '1', '12.00');
INSERT INTO `cart_order` VALUES ('4', 'δ����', '2013-57-13  14:57:16', '1', '190.50');
INSERT INTO `cart_order` VALUES ('5', 'δ����', '2013-13-13  16:13:39', '1', '153.50');
INSERT INTO `cart_order` VALUES ('6', 'δ����', '2013-26-13  16:26:53', '1', '119.50');
INSERT INTO `cart_order` VALUES ('7', 'δ����', '2013-46-14  10:46:41', '1', '189.50');
INSERT INTO `cart_order` VALUES ('8', 'δ����', '2013-50-14  10:50:42', '1', '189.50');
INSERT INTO `cart_order` VALUES ('9', 'δ����', '2013-52-14  10:52:41', '1', '189.50');
INSERT INTO `cart_order` VALUES ('10', 'δ����', '2013-54-14  10:54:44', '1', '84.50');
INSERT INTO `cart_order` VALUES ('11', 'δ����', '2013-57-14  10:57:35', '1', '84.50');
INSERT INTO `cart_order` VALUES ('12', 'δ����', '2013-59-14  10:59:41', '1', '307.00');
INSERT INTO `cart_order` VALUES ('13', 'δ����', '2013-27-14  15:27:31', '1', '153.50');
INSERT INTO `cart_book` VALUES ('1', 'j2ee', 'J2EEָ�϶��ڹ���Java����Ա��˵��һ�ݲ��ɻ�ȱ�������ˡ���ƪ���۶��ڳ�������J2EE�ĳ���Ա��˵����ͬ�������á�����Javaָ��һ������һ����Ϊ���ġ� ��ƪָ����Ϊ���ÿ����Ͳ���J2EEӦ�ó���ĳ���Ա׼���ġ������������J2EEƽ̨�ļ����Լ�������ο���J2EE�����������J2EE����������ϡ� ', '50.5', 'j2ee.jpg','1');
INSERT INTO `cart_book` VALUES ('2', 'javaWeb', '���齫���������뿪���������ϣ���Ҫ����Web��ƵĹ��̣���Ҫͻ��Eclipse�������߶�Web��Ƶ�֧�֣����Դ�ȫ�鲼�����������������˼·������ϤEclipse ��������������Web��ƻ��������Ļ����ϣ���һ����ǿ��ѧϰWeb�ܹ�����ƣ�ѧϰ�������ۺͲ��Է����������ڿ��������н��а汾���Ƶ������ʵ���ֶΡ�����Eclipse���߱��ķḻ�Ŀ����ں�����Web�����һ��ѭ�򽥽�������ѧϰ�Ĺ��̣����Ա��������ݵ�ѡȡ�Ͱ����ϣ��������ǽ�ѧҪ�󣬸���ѭ�Ի���Ϊ�ء�������չ��ԭ��.', '34', 'java Web.jpg','1');
INSERT INTO `cart_book` VALUES ('3', 'MySqlʵ�ý̳�', '�����Ե�ǰ�����е�MySQL5.1��Ϊƽ̨����Ϊ�Ĳ��֣�MySQL����ϰ�⣩��ʵ�顢�ͻ���/MySQL�ۺ�Ӧ��ʵϰ�͸�¼���Ƚ�ϵͳ�ؽ���MySQL�Ĺ��ܣ�ͬʱϵͳ����Linux��PHP��Windows��ASP.NET��C�٣���JSP��JavaBean����Visualc++��MySQL��Ӧ�÷�����', '35', 'mySql.jpg','1');
INSERT INTO `cart_book` VALUES ('4', 'Javaʵ�ý̳�', '���̳̰�����ʵ�ý̡̳�ϰ�⡢ʵ�顢�ۺ�Ӧ��ʵϰ�ȼ������֡�������Ҫ����Java����������ơ�Javaͼ�ν�����ơ�JBuilder���ݿ�Ͷ�ý��Ӧ�ó�����ơ�ʵ�ý̳�һ���ڽ������ݺ����ʵ��,����ʵ������һ����ϻ�����ͨ��,ʵ�鲿��ͨ��ʵ����һ��һ���������߽��в���,Ȼ����������ö���˼������ԭ���������Լ����в����ͱ����ϰ;ʵϰ�������ۺ�ѵ��ʵ�ʽ����������������̸̳����ֲ�����,�����ݽ�ѧ�ص���о��ı���,�����û������Լ���Ҫ����ѡ��', '35', 'javasy.jpg','1');
INSERT INTO `book_type` VALUES ('�ߵ���ѧ', '1');
INSERT INTO `book_type` VALUES ('�����', '2');
INSERT INTO `book_type` VALUES ('Ӣ��', '3');
INSERT INTO `cart_user` VALUES ('6', 'lgt', '123', '�ɶ��и������������    ', '611743    ', '114721311@qq.com    ', '123456789    ');
INSERT INTO `cart_user` VALUES ('7', 'test', '123', 'test  ', '123456  ', 'test@qq.com  ', '12345678  ');
INSERT INTO `order_id` VALUES ('13');
INSERT INTO `orderitem_id` VALUES ('27');



DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` bigint(25) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `stock` int(5) DEFAULT NULL,
  `price` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO products(id,NAME,description,stock,price)
VALUES(1,'Pocophone','Pocophone All the best',100,8000000),
(2,'Galaxy Tab','Galaxy Tab All the best',75,5000000),
(3,'Realme','Realme All the best',25,6000000);
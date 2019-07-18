DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` bigint(25) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(50) DEFAULT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `quantity` int(5) DEFAULT NULL,
  `product_id` bigint(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_id_to_id` (`product_id`),
  CONSTRAINT `FK_product_id_to_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO orders(id,order_code,notes,quantity,product_id)
VALUES(1,'CX-001','Buy Pocophone All the best',2,1),
(2,'CX-002','Buy Galaxy Tab All the best',1,2),
(3,'CX-003','Buy Realme All the best',3,3);
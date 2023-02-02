/*--Per ekzekutimin e kesaj detyre eshte perdorur MySQL WorkBench 8.0*/
/*--Eshte punuar ne database-n  menaxhimi_i_dyereve*/
/*-- Krijimi i tabelave */
CREATE TABLE `punonjesit` (
  `id_punonjesit` varchar(7) NOT NULL,
  `emri` varchar(20) NOT NULL,
  `mbiemri` varchar(20) DEFAULT NULL,
 
 `hyrja_e_fundit` datetime DEFAULT NULL,
  `dalja_e_fundit` datetime DEFAULT NULL,
 
 `krijimi_i_kartes` datetime DEFAULT NULL,
  `skadimi_i_kartes` datetime DEFAULT NULL,

  `udf_1` varchar(15) DEFAULT NULL,
  `udf_2` varchar(15) DEFAULT NULL,
 
 PRIMARY KEY (`id_punonjesit`)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `dyeret` (
  `id_dere` varchar(7) NOT NULL,
  `emri_i_ndertese` varchar(20) NOT NULL,

  `udf_1` int DEFAULT NULL,
  `udf_2` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_dere`)
)
 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `dera_1` (
  `id_punonjesit` varchar(7) NOT NULL,
  `udf_1` varchar(15) DEFAULT NULL,
 
 PRIMARY KEY (`id_punonjesit`)
)
 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `dera_2` (
  `id_punonjesit` varchar(7) NOT NULL,
  `udf_1` varchar(15) DEFAULT NULL,
 
 PRIMARY KEY (`id_punonjesit`)
)
 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci




/*
-- Query: SELECT * FROM menaxhimi_i_dyereve.punonjesit 
LIMIT 0, 1000

-- Date: 2023-01-29 18:32
*/

INSERT INTO `menaxhimi_i_dyereve.punonjesit` (`id_punonjesit`,`emri`,`mbiemri`,`hyrja_e_fundit`,`dalja_e_fundit`,`krijimi_i_kartes`,`skadimi_i_kartes`,`udf_1`,`udf_2`) VALUES ('1','Andrea','Stefi','2023-01-15 13:23:04',NULL,'2020-01-01 00:00:00','2021-01-01 00:00:00',NULL,NULL);

INSERT INTO `menaxhimi_i_dyereve.punonjesit` (`id_punonjesit`,`emri`,`mbiemri`,`hyrja_e_fundit`,`dalja_e_fundit`,`krijimi_i_kartes`,`skadimi_i_kartes`,`udf_1`,`udf_2`) VALUES ('2','Alex','Benjamin','2023-01-15 14:44:27','2023-01-15 14:44:37','2023-01-01 00:00:00','2024-01-01 00:00:00',NULL,NULL);

INSERT INTO `menaxhimi_i_dyereve.punonjesit` (`id_punonjesit`,`emri`,`mbiemri`,`hyrja_e_fundit`,`dalja_e_fundit`,`krijimi_i_kartes`,`skadimi_i_kartes`,`udf_1`,`udf_2`) VALUES ('3','Hermes','Saja','2023-01-26 17:45:24','2023-01-22 13:41:45','2023-01-01 00:00:00','2024-01-01 00:00:00',NULL,NULL);

INSERT INTO `menaxhimi_i_dyereve.punonjesit` (`id_punonjesit`,`emri`,`mbiemri`,`hyrja_e_fundit`,`dalja_e_fundit`,`krijimi_i_kartes`,`skadimi_i_kartes`,`udf_1`,`udf_2`) VALUES ('4','Alex','Stafa','2023-01-15 14:41:50','2023-01-15 14:44:04','2023-01-01 00:00:00','2024-01-01 00:00:00',NULL,NULL);


/*
-- Query: SELECT * FROM menaxhimi_i_dyereve.dyeret 
LIMIT 0, 1000

-- Date: 2023-01-29 18:40
*/

INSERT INTO `` (`id_dere`,`emri_i_ndertese`,`udf_1`,`udf_2`) VALUES ('1','godina_a',NULL,NULL);

INSERT INTO `` (`id_dere`,`emri_i_ndertese`,`udf_1`,`udf_2`) VALUES ('2','godina_b',NULL,NULL);

INSERT INTO `` (`id_dere`,`emri_i_ndertese`,`udf_1`,`udf_2`) VALUES ('3','godina_c',NULL,NULL);


/*
-- Query: SELECT * FROM menaxhimi_i_dyereve.dera_1
LIMIT 0, 1000

-- Date: 2023-01-29 18:43
*/

INSERT INTO `` (`id_punonjesit`,`udf_1`) VALUES ('1',NULL);

INSERT INTO `` (`id_punonjesit`,`udf_1`) VALUES ('2',NULL);

INSERT INTO `` (`id_punonjesit`,`udf_1`) VALUES ('4',NULL);


/*
-- Query: SELECT * FROM menaxhimi_i_dyereve.dera_2 
LIMIT 0, 1000

-- Date: 2023-01-29 18:41
*/
INSERT INTO `` (`id_punonjesit`,`udf_1`) VALUES ('3',NULL);

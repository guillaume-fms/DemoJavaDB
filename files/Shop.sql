-- Mardi 28/02/2023 à Vendredi 3/03/2023
-- Exercices sur les bases de données : ExBdd


/** Exercices sur les bases de données : ExBdd **/
	-- Exercice 1 : [Répertorier vos requêtes dans un script].
	
	-- 1.1 Générer votre base de données à l’aide du script Shop.sql

-- -----------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                           ---
-- -----------------------------------------------------------------------------------

DROP DATABASE IF EXISTS  Shop;
CREATE DATABASE Shop;
USE Shop;

-- -----------------------------------------------------------------------------------
-- - Construction de la Table des articles en vente                                ---
-- -----------------------------------------------------------------------------------

CREATE TABLE T_Articles (
	 IdArticle           int(4)      PRIMARY KEY AUTO_INCREMENT,
	 Description         varchar(30) NOT NULL,
	 Brand               varchar(30) NOT NULL,
	 UnitaryPrice          float (8) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Clavier', 'Microchard', 49.5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Systeme d''exploitation', 'Fenetres Vistouille', 150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Tapis souris', 'Chapeau Bleu', 5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Cle USB 8 To', 'Syno', 8);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Laptop', 'PH', 1199);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('CD x 500', 'CETME', 250);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD-R x 100', 'CETME', 99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('DVD+R x 100', 'CETME', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Batterie Laptop', 'PH', 80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Casque Audio', 'Syno', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Webcam', 'Logitoch', 755);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('S10', 'Samsung', 2000);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Macbook', 'Apple', 2000);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Iphone50', 'Apple', 20000);
INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES ('PC_Laptot', 'DELL', 1380.55);
INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES ('PC', 'Hewlett Packard', 2380.45);
INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES('Imprimante', 'Epson', 95);


SELECT * FROM T_Articles;



-- exo1.2 ------------------
 show tables;

 
-- exo 1.3 ------------------
 describe t_articles;

 
-- exo 1.4 ------------------
INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES('Ecran', 'DELL', 380.45);
INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES('Imprimante', 'Epson', 95);

-- exo 1.5 ------------------
UPDATE t_articles SET description ='Joystick', brand='Nintendo', UnitaryPrice='135.65' WHERE IdArticle=1;


-- exo 1.6 -------------------------------
DELETE FROM t_articles WHERE IdArticle=13;


-- exo 1.7 ------------------
SELECT Description FROM t_articles WHERE UnitaryPrice > 100;


-- exo 1.8 ------------------
SELECT * FROM t_articles WHERE UnitaryPrice BETWEEN '50' AND '150';


-- exo 1.9 ------------------
SELECT Description Brand FROM t_articles ORDER BY UnitaryPrice ASC;


-- exo 1.10 ------------------
SELECT Description FROM t_articles;


-- exo1.11 ------------------
SELECT * FROM t_articles ORDER BY brand;


-- exo 1.12 ------------------
CREATE TABLE T_Categories (
	 IdCategory          int(4)      PRIMARY KEY AUTO_INCREMENT,
	 CatName             varchar(100) NOT NULL,
	 Description         varchar(100) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (1, 'PC', 'ordinateur portable ou pas');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (2, 'Smartphone', 'téléphone avec écran tactile + applis');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (3, 'Materiel info', 'materiel informatique physique en lien avec un ordinateur');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (4, 'Smartphone', 'téléphone avec écran pliable');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (5, 'Materiel info', 'clavier sans fil');
INSERT INTO T_Categories (IdCategory, CatName, Description) VALUES (6, 'PC', 'ordinateur gaming, tour transparente et joystick');

SELECT * FROM T_Categories;


-- exo 1.13 ------------------

ALTER TABLE t_articles ADD COLUMN IdCategory INT(4);
ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

SELECT idarticle,t_articles.description,brand,unitaryprice,catname FROM t_articles INNER JOIN t_categories WHERE t_articles.idcategory = t_categories.idcategory  ORDER BY UnitaryPrice ASC;

-- Fin des exos [Répertorier vos requêtes dans un script] --------------------------------------------------------------



-- Création de la table utilisateurs

-- -----------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                           ---
-- -----------------------------------------------------------------------------------

DROP DATABASE IF EXISTS  Shop;
CREATE DATABASE Shop;
USE Shop;

-- -----------------------------------------------------------------------------------
-- - Construction de la Table des utilisateurs                               		---
-- -----------------------------------------------------------------------------------
CREATE TABLE T_Users(
 	 IdUser           int(4)      PRIMARY KEY AUTO_INCREMENT,
	 Login        	  varchar(30) NOT NULL,
	 Password         varchar(30) NOT NULL	
) ENGINE = InnoDB;

INSERT INTO T_Users (IdUser, Login, Password) VALUES (1, 'Anderson', 'Neo');
INSERT INTO T_Users (IdUser, Login, Password) VALUES (2, 'Macron', 'Manu');
INSERT INTO T_Users (IdUser, Login, Password) VALUES (3, 'Skywalker', 'Luke');
INSERT INTO T_Users (IdUser, Login, Password) VALUES (4, 'Ripley', 'Ellen');
INSERT INTO T_Users (IdUser, Login, Password) VALUES (5, 'Biden', 'Joe');
INSERT INTO T_Users (IdUser, Login, Password) VALUES (6, 'fms2023', 'Guillaume');
INSERT INTO T_Users (IdUser, Login, Password) VALUES (7, 'Jean', 'Robert');
INSERT INTO T_Users (IdUser, Login, Password) VALUES (8, 'Borne', 'Elizabeth');

SELECT * FROM T_Users;

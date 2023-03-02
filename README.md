# DemoJavaDB
Exercices sur les bases de données : ExBdd
Mardi 28/02/2023 à Vendredi 3/03/2023


Exercices sur les bases de données : ExBdd

  • Exercice 1 : [Répertorier vos requêtes dans un script]
  
  • 1.1 Générer votre base de données à l’aide du script Shop.sql
  
  • 1.2 Effectuer les requêtes permettant d’afficher toutes les tables en base
  
  • 1.3 Trouver un moyen pour décrire une table
  
  • 1.4 Ajouter à la table des articles des occurrences de votre choix
  
  • 1.5 Modifier un article avant de vérifier si c’est pris en compte
  
  • 1.6 Supprimer un article puis vérifier
  
  • 1.7 Sélectionner tous les articles dont le prix est supérieur à 100
  
  • 1.8 Sélectionner les articles dont le prix est compris entre 50 et 150
  
  • 1.9 Afficher les articles dans l'ordre croissant des prix
  
  • 1.10 Afficher uniquement la description des articles
  
  • 1.11 Choisissez une requête particulièrement intéressante à présenter
  
  • 1.12 Ajouter la table des catégories à votre base de données et insérez-en
  
  • 1.13 Trouver la requête qui permet d’obtenir le résultat suivant.
  
  • Exercice 2 : Il s’agit maintenant d’afficher le contenu de votre table des articles sous
Eclipse aussi reprenez l’exemple vu en cours sans omettre d’ajouter le driver de mariaDB*
puis exécuter votre programme. La classe Article contient les mêmes données que la table
des articles en base, à savoir : identifiant, description, brand, price
(*) : Comment ajouter une librairie à un projet dans Eclipse une fois le bon JAR téléchargé,
contenant donc les pilotes jdbc appropriés (copier-coller dans un rep lib par ex) :
→ Sur la perspective « project explorer », clic droit sur le jar « add to build path ».

  • Exercice 3 : Nous souhaitons maintenant, toujours sous Eclipse, réaliser une requête
d’insertion d’un article, une autre de mise à jour, une autre qui supprime un article et une
dernière qui nous renvoi toutes les infos d’un article. Vous devez afficher tous vos articles
sous Eclipse ou vérifier en ligne de commande que cela a fonctionné en base.

• Exercice 4 : Nous souhaitons dorénavant utiliser un fichier de configuration unique
contenant toutes les informations de connexion. En effet, afin de rendre notre application
ouverte aux évolutions notamment lorsqu’il s’agit de migrer d’un SGBD à un autre sans
avoir à toucher au code source, un fichier de configuration contiendra toutes les
informations nécessaires comme ici :

                db.driver.class = org.mariadb.jdbc.Driver
                db.url = jdbc:mariadb://localhost:3306/Shop
                db.login = le votre
                db.password = le vôtre
                
Dans un premier temps, il faudra le créer/générer à l’aide d’une classe CreateConfigFile
puis dans un second temps l’utiliser pour exploiter votre base de données, vérifier que le
tout fonctionne parfaitement. Pour vous aider, voir l’exemple ici.
https://www.tutorialspoint.com/how-to-read-the-data-from-a-properties-file-in-java

  • Exercice 5 : LE CODE DEVIENT ILLISIBLE, N’EST-CE PAS ?
  
Reprenons donc nos bonnes habitudes et découpons notre appli à l’aide des packages :

  - 5.1 Ajouter le package fr.fms.entities et ajoutez-y la classe Article
  
  - 5.2 Ajouter le package fr.fms.dao qui va faire le lien entre notre application et la base de
données, ajoutez-y l’interface générique Dao (ci-dessous) contenant les méthodes dites
CRUD pour Create, Read, Update et Delete, puis ajouter la classe ArticleDao qui
implémente l’interface générique Dao : public class ArticleDao implements Dao<Article>
{...}

  - 5.3 Capturer et relayer les exceptions avec des messages explicites (Privilégier le try with
ressources). Puis dans votre programme principal tester votre implémentation ArticleDao.

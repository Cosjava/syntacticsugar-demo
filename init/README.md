#Plugins
Installer les plugins lombok, mapstruct et sonarlint.

#Swagger
Url du swagger autogénéré: http://localhost:8080/swagger-ui.html

#H2
Accès à la console h2: http://localhost:8080/h2-console en utilisant pour le champ JDBC url:
>jdbc:h2:mem:db;DB_CLOSE_DELAY=-1

#Contrat d'interface
Pour concevoir le contrat d'interface, suivez la "norme OCTO":
https://blog.octo.com/wp-content/uploads/2014/12/OCTO-Refcard_API_Design_EN_3.0.pdf

#A développer:

-	Créer les entities correspondantes aux deux tables.
-	Créer le repository.
-	Créer les routes pour récupérer/supprimer/modifier un utilisateur.
-	Créer la route pour mettre à jour l’adresse email de l’utilisateur.
-	Créer la route pour faire une recherche sur la liste des utilisateurs.
-	Faire les tests Junits.
     
Si temps:
-	Faire les tests postmans (voir ici https://learning.postman.com/docs/writing-scripts/test-scripts/)


# microservice
Projet Réalisé par:
-Mohamed Khalil Bousrih
-Mohamed Aymen Khlil
-Mohamed Malek Ben Gharbia


Ce projet consiste d'une application de gestion gestion d'un établissement scolaire

Il existe 4 microservices: Étudiant, Enseignent, Matiere et Classe.

- Etudiant : Spring Boot + H2 réalisé par Mohamed Aymen Khlil
- Matiere: Spring Boot + H2 réalisé par Mohamed Malek Ben Gharbia
- Enseignant: Spring Boot + MySql réalisé par Mohamed Khalil Bousrih
- Classe : Nodejs + MongoDb : travail de groupe

On a utilisé le serveur Eureka pour la découverte des service et Zuul comme gateway.

Chaque microservice contient un dockerfile pour la creation d'une image docker basée sur une image principale java:8.

Pour la gestion de tous les conteneurs et assurer la communication on a utiliser docker-compose.


--Projet Microservices avec Spring Boot--

Ce projet illustre une architecture microservices basée sur Spring Boot. Il comprend les services suivants :

Customer Service : Gère les informations des clients.

Inventory Service : Gère les informations d'inventaire.

Billing Service : Gère la facturation et dépend des services Customer et Inventory.

Gateway Service : Fournit une passerelle API pour acheminer les requêtes.

Discovery Service : Service de découverte des microservices.

Config Service : Centralise la configuration des microservices.

Config Repo : Dépôt local contenant les fichiers de configuration centralisée.

--Prérequis--

Java JDK 17 ou plus récent

Maven

Un IDE compatible (IntelliJ IDEA )
--Architecture--

L’architecture de ce projet est basée sur des microservices indépendants, chacun ayant une responsabilité spécifique. Les services communiquent entre eux via REST et sont enregistrés dans le Discovery Service (Eureka).

Config Service : Fournit les configurations centralisées à partir du dépôt Config Repo.

Gateway Service : Simplifie l’accès aux services en centralisant les appels via une seule URL.

Discovery Service : Fournit la découverte des services dynamiques.

Chaque service implémente sa propre logique métier et utilise la configuration centralisée.
![image](https://github.com/user-attachments/assets/300bd082-987c-42fc-93ff-092858975f3e)
![image](https://github.com/user-attachments/assets/834d9402-f542-4cdd-99d6-41e2d75c2ba2)
![image](https://github.com/user-attachments/assets/76189d2c-d4e9-400d-8f8d-f6015a1edb8e)
![image](https://github.com/user-attachments/assets/fe9e2caf-504f-44a2-aba0-b8c6787a5fd4)




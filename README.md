# 📦 Microservice-project

Une courte description du projet, par exemple :

> Application web pour la gestion de changement de nom de bénéficiaire d'une police d'assurance

---

## 🚀 Fonctionnalités principales

- Authentification sécurisée avec Keycloak
- Création et gestion des polices d'assurance
- le processus de changement de nom du nouveau béneficiare
- API RESTful exposée via Spring Boot des plusieurs services

---

## 🏗️ Architecture

- **Backend** : Spring Boot + Spring Security(quelques services)
- **Discovery service** : permettre aux services de se découvrir dynamiquement les uns les autres (*eureka server*)
- **Base de données** : PostgreSQL, mysql
- **Sécurité** : Keycloak (OAuth2 / OpenID Connect)
- **Configuration smtp** : smtp.gmail.com

---

## 🔧 Prérequis

- Java 21
- Maven 
- PostgreSQL
- Mysql
- Docker(pour le lancement du keycloak)
- Keycloak (local)

---

## ⚙️ Installation

### Cloner le projet

```bash
git clone https://github.com/votre-utilisateur/microservice-project.git
cd microservice-project

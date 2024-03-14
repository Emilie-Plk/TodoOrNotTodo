# TodoOrNotTodo 📝

`TodoOrNotTodo` est une application Android moderne 🚀 conçue pour gérer facilement vos tâches quotidiennes. Avec une interface utilisateur épurée et intuitive, vous pouvez ajouter 📥, modifier ✏️ et supprimer ❌ des tâches, tout en organisant votre journée de manière plus productive.

## Caractéristiques ✨

- Ajouter de nouvelles tâches avec titre, description, priorité et échéance. 🔖
- Modifier les détails des tâches existantes. 📝
- Marquer les tâches comme terminées. ✅
- Supprimer les tâches de la liste. 🗑️
- Filtrer et trier les tâches par statut ou priorité. 🔍

## Technologies Utilisées 🧰

- **Kotlin** : Le projet est entièrement écrit en Kotlin, profitant de ses caractéristiques modernes et de sa sécurité de type. 💻
- **Jetpack Compose** : Pour une UI réactive et performante, nous utilisons Jetpack Compose, le toolkit moderne de Google pour la création d'interfaces natives. 🖌️
- **Room** : La persistance des données est gérée via Room, une couche d'abstraction qui permet une manipulation fluide de la base de données SQLite. 📦
- **Flow** et **Coroutines** : Pour une programmation asynchrone et réactive, nous utilisons les Flows et les Coroutines de Kotlin, permettant de gérer efficacement les opérations en arrière-plan et les mises à jour de l'UI. 🌊
- **Hilt** : Pour l'injection de dépendances, nous avons intégré Hilt pour un couplage faible et une meilleure testabilité. 🛠️

## Architecture 🏛️

`TodoOrNotTodo` est construite en suivant les principes de la <b>Clean Architecture</b> pour une séparation claire des préoccupations et une meilleure maintenabilité du code. L'architecture se divise en plusieurs couches :

- **Couche Domaine** : Contient la logique métier et les modèles de l'application, ainsi que les interfaces de répositories. 🧩
- **Couche Data** : Gère l'accès aux données (base de données et préférences utilisateur), et contient les implémentations des répositories. 💾
- **Couche Présentation** : Comprend les écrans (screens) et les composants (components) réutilisables de l'interface utilisateur, ainsi que les `ViewModels` qui s'occupent de la logique de présentation. 🎨

## Version Actuelle 🏷️

La version actuelle est la v1.0.0, une première version qui implémente les fonctionnalités de base d'une todoliste. Cette version pose les fondations de l'application et sera améliorée au fil du temps avec des fonctionnalités supplémentaires et des améliorations d'UX/UI. 🌟

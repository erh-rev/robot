# Guide Git & GitHub - ERH-Paris

Bienvenue dans ce guide destiné à l'équipe de robotique ERH-Paris. Vous apprendrez ici les bases de Git et GitHub ainsi que les commandes essentielles pour gérer votre code efficacement.

## 1. Introduction à Git et GitHub

### Git
Git est un système de gestion de versions décentralisé permettant de suivre les modifications du code et de travailler en équipe de manière efficace.

### GitHub
GitHub est une plateforme d'hébergement de dépôts Git qui facilite la collaboration entre développeurs.

## 2. Installation de Git
Si Git n'est pas encore installé, téléchargez-le et installez-le depuis : [https://git-scm.com/](https://git-scm.com/)

Après installation, configurez votre identité :
```sh
git config --global user.name "Votre Nom"
git config --global user.email "votre.email@example.com"
```

## 3. Cloner un dépôt GitHub
Cloner un dépôt signifie récupérer une copie locale d'un projet stocké sur GitHub.
```sh
git clone https://github.com/ERH-Pars/nom-du-repo.git
```
Remplacez `nom-du-repo` par le nom réel du dépôt.

## 4. Mettre à jour votre dépôt local (Pull)
Avant de travailler, synchronisez votre copie locale avec la version la plus récente sur GitHub :
```sh
git pull origin main
```
(Si la branche principale est `master`, remplacez `main` par `master`.)

## 5. Ajouter et envoyer des modifications (Push)
Après avoir modifié ou ajouté des fichiers :
```sh
git add .      # Ajoute tous les fichiers modifiés
```
Validez les changements avec un message explicatif :
```sh
git commit -m "Description des modifications"
```
Enfin, envoyez les modifications sur GitHub :
```sh
git push origin +branche
```
Pour synchronyser une autre branche dans votre exporateur de  fichiers: 
```sh
git checkout +branche
```

## 6. Bonnes pratiques
- Faites toujours un `git pull` avant de commencer à travailler.
- Utilisez des messages de commit clairs et descriptifs.
- Ne poussez pas de fichiers inutiles (logs, fichiers temporaires, etc.).

## 7. Apprendre à programmer Le robot
*Les formations first*
  1. [Lien pour java/blocks](https://ftc-docs.firstinspires.org/en/latest/programming_resources/tutorial_specific/onbot_java/creating_op_modes/Creating-and-Running-an-Op-Mode-(OnBot-Java).html#modifying-your-op-mode-to-control-a-motor)
  2. [Guide de survie FTC](https://teamcenter.robotiquefirstfrance.org/wp-content/uploads/2024/09/Guide-Survie-FTC-Master-REV-2024-2025.pdf)

Bonne collaboration avec Git et GitHub ! 🚀

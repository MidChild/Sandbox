# Sandbox, évaluation ANDROID P5 DIIAGE1

## Présentation
Ce projet est une application Android qui permet de sélectionner un personnage de série puis voir les épisodes dans lesquels il apparaît.

## Structure du projet

Le projet est organisé en plusieurs modules :

- `app`: Le module principal de l'application.
  - `manifests`: Contient :
    - Les caractéristiques nécessaires à l'utilisation de l'application.
    - Le nom de l'application.
    - Les permissions dont l'application a besoin.
  - `kotlin+java`: C'est ici que se trouvent les éléments principaux de l'application.
    - `org.mathieu.sandbox`:
      - `data`: Contient les sources de données (locales ici) et les repositories qui implémentent les différentes fonctions de leurs interfaces respectives.
      - `domain`:
        - `models`: Contient les schémas de données pour les objets `Character` et `Episode` de notre application.
        - `repositories`: C'est là qu'on définit les fonctions à utiliser dans les implémentations.
      - `ui`:
        - `components`: Contient les composants visuels qui sont utilisés plusieurs fois dans l'application afin d'éviter un code dupliqué.
        - `core.theme`: Contient les fichiers qui définissent les couleurs, les thèmes et les polices utilisées dans toute l'application.
        - `screens`: 
          - `Screen`: Les screens sont rangés avec leurs ViewModels respectifs, ils contiennent tout les éléments visuels permettant de composer des pages.
          - `ViewModels`: Les ViewModel sont utilisés pour préparer et gérer les données pour leurs screens respectifs.
        - `utils`: Contient les fonctionnalités de son et de vibration afin qu'elles soient appelées par les vues.
      - `MainActivity`: Point d'entrée principal d'une application, c'est l'`Activity` qui est lancée lorsqu'elle démarre. Elle contient les composables qui définissent l'interface utilisateur. Ici, elle est utilisée pour définir les différentes routes de la navigation au sein de l'application.
  - `res`: Contient les ressources statiques de l'application telles que des images, des chaînes de caractères, des couleurs etc...
  - `Gradle Scripts`: Rassemble les fichiers de configuration servant au build de l'application.

## Compilation et exécution
1. Clonez le dépôt GitHub.
2. Ouvrez le projet dans Android Studio.
3. Exécutez l'application sur un émulateur ou un appareil Android.

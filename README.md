# Hopital_Activité
Dans la première partie de ce projet de developpement d'une appli de gestions de patients avec  Spring MVC, Thylemeaf et Spring Data JPA.On a fait en sorte que l'appli ait ces différentes fonctionnalités:
- Afficher les patients
- Faire la pagination
- Chercher les patients
- Supprimer un patient
Par suite je donne quelques croquis de l'appli ainsi que du code.
# <img width="878" alt="image" src="https://github.com/user-attachments/assets/3b196527-d454-4d58-af8f-a8aad70ec172" />
# Avec mySQL
# <img width="775" alt="image" src="https://github.com/user-attachments/assets/f122b36f-bc2c-4797-a8b9-c1029426b0b1" />
# Avec h2 aussi au tout début pour la base de données
# <img width="722" alt="image" src="https://github.com/user-attachments/assets/4f6f7d79-3755-4ffd-9182-61eeefc6d621" />
# Capture du code de la classe PatientController est la suivante :
# <img width="580" alt="image" src="https://github.com/user-attachments/assets/fda7b8a7-d840-4e19-9012-1bccac893feb" />
Voici image de fin de la partie 1.
# <img width="923" alt="image" src="https://github.com/user-attachments/assets/a9a40a96-1d19-48e0-a63a-6da8c93f84f4" />
Avec l'ajout des boutons en haut de page.
# <img width="952" alt="image" src="https://github.com/user-attachments/assets/4cb7d631-32a6-4d09-bf5c-49cfb93c288f" />
Ici on ajoute un nouveau patient en cas de besoin
# <img width="950" alt="image" src="https://github.com/user-attachments/assets/2be74a18-90af-4bd0-a142-3eff91d208d9" />
Pour la pagination on a eu à utiliser ce code:
# <img width="721" alt="image" src="https://github.com/user-attachments/assets/3bce75fd-3aea-44d1-8256-ab3d4a037565" />
Et par suite : 
# <img width="841" alt="image" src="https://github.com/user-attachments/assets/167786a9-4d0e-4681-8bf2-b75808f27a4a" />
Puis lorqsqu'on clique sur le bouton modifier on attérit sur la page suivante:
# <img width="949" alt="image" src="https://github.com/user-attachments/assets/cc0ef272-b715-4a4c-bcd1-c4b9065b2a40" />
Un bloc de code pour editPatients:
# <img width="519" alt="image" src="https://github.com/user-attachments/assets/45c03090-c9c5-439e-b794-64499aea38bb" />
Par suite avec spring security, on a eu à faire une authentification pour les deifférents users du système:
# <img width="480" alt="image" src="https://github.com/user-attachments/assets/174b236b-01bd-4f90-a79f-bcac10a1177b" />
Voici des morceaux de code qui ont permis à faire l'authentification:
# <img width="877" alt="image" src="https://github.com/user-attachments/assets/7030174e-8e38-455a-831c-61594012e0af" />






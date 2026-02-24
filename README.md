# l2s4-projet-2026

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
Un unique fork doit être réalisé par équipe.

Une fois cela réalisé, supprimer ces premières lignes et remplir les noms des membres de votre équipe.
N'oubliez pas d'ajouter les autres membres de votre équipe aux membres du projet, ainsi que votre enseignant·e (statut Maintainer).

# Equipe

- Sylla Mariama Séré
- SOW Farmata Sall
- Beye Khadim 
- SOW Mamadou Baïllo

# Sujet

[Le sujet 2026](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2026.pdf)

# Livrables

Les paragraphes concernant les livrables doivent être remplis avant la date de rendu du livrable. A chaque fois on décrira l'état du projet par rapport aux objectifs du livrable. Il est attendu un texte de plusieurs lignes qui explique la modélisation choisie, et/ou les algorithmes choisis et/ou les modifications apportées à la modélisation du livrable précédent.

Un lien vers une image de l'UML doit être fourni (une photo d'un diagramme UML fait à la main est suffisant).

## Livrable 1

🔗 **Diagramme UML** : [Voir le PDF](./uml/uml.pdf)

Le premier livrable une nouvelle branche **livrable1** a été créée. Avec une approche objet pour ce projet, les concepts utilisés sont entre autres l'encapsulation, des exceptions pour quand des valeurs négatives sont saisies ou qu'une position donnée n'est dans le plateau et l'héritage notamment une classe abstraite **Board** qui concentre toutes les méthodes communes aux deux plateaux **ClassicalBoard** et **RandomBoard**. En plus d'une certaine méthode abstraite qui sont définit dans les deux classes correspondantes aux deux plateaux, puisque chacun des plateaux a des choses en plus que l'autre n'a pas c'est-à-dire dans le **ClassicalBoard** un chemin est défini d'avance selon les critères du sujet où les ballons suivront ce chemin definit jusqu'à la sortie et aucune tour ne sera posée sur les cellules traversées par ce chemin. le second plateau le **RandomBoard** est différent, chaque ballon définit sa trajectoire suivant où il est positionné au départ, de ce fait aucun chemin n'est definit d'avance car ce chemin dépendra du ballon (donc le prochain livrable) selon le sujet vue que potentiellement pour ce jeu tout le plateau est un chemin c'est-à-dire chaque cellule peut être traversée par un chemin suivant le ballon sans compter qu'elle peut contenir à la fois un ballon et une tour.

Différentes classes ont été implémenté afin de construire les deux plateaux. Un plateau contient plusieurs cellules donc une classe **Cell**, une cellule a une position dans un plateau donc une cellule depend d'une position d'où, une classe **Position** qui contient juste deux attributs et sourtout l'on a vérifié si deux positions sont égales qui est très important pour la suite du jeu.

Pour lancer le projet, générer la documentation, et lancer les tests... il faut se mettre dans le dossier l2s4-projet-2026 et utilisez les commandes suivantes:

**Générer la documentation**

```bash
make docs
```

**Compiler l'ensemble des classes .java en .class**

```bash
make build
```

**Lancer les tests avec junit**

```bash
make tests
```

**Lancer le programme MainLivrable1** ou **Lancer le MainLivrable1 avec les arguments (2 args)**

```bash
make run
```

```bash
java -classpath classes bloons.MainLivrable1 val1 val2
```

**Supprimer les .class et la doc, nettoyage complet**

```bash
make clean-all
```

**Générer le jar**

```bash
jar cvfm mainLivrable1.jar manifest -C classes .
```

**Lancer le jar**

```bash
java -jar mainLivrable1.jar
```

### Atteinte des objectifs

- Deux plateaux générés en fonction des hauteur et largeur renseignées sur le console, 
  au cas où l'une de ces deux valeurs est négative ou les deux, une exception est déclenchée. 

- Calcul d'un chemin et affichage de ce chemin après que le plateau ait été générer, de ce fait on voit toutes les cellules traversées par le chemin.

- Ajout d'un makefile afin de simplifier ou d'automatiser certaines commandes.

- Ajout des tests pour toutes les méthodes publiques qui sont très importantes qui sont nécessaires pour la logique du jeu.

- Avec un fichier **manifest** on a jugé utile de générer .jar, le fichier **mainLivrable1.jar** propre au livrable1.

- Concernant le groupe, l'entente est globalement très bonne et chacun a donné du sien pour assurer le bon déroulement de ce livrable.

### Difficultés restant à résoudre

## Livrable 2

🔗 **Diagramme UML** : [Voir le PDF](./uml/uml2.pdf)

Une nouvelle branche **livrable2** a été créée. Pour ce livrable l'objectif principal est: assurer la création d'un ballon avec la classe **Balloon**, de faire deplacer ce ballon sur un chemin, générer une vitesse aléatoire pour chaque ballon.

Pour le bon fonctionne de ce livrable différentes classes ont été créée, une classe **Level** une énumeration qui spécifie le type du ballon notamment sa résistance. Deux classes de plus ont été ajouté **Livrable2a** pour le classical board notamment afficher et faire déplacer le ballon en fonction d'un tic d'horloge et **Livrable2b** pour le random board qui génère le ballon ou les ballons correspondant au nombre de chemin passé en argument, les faire déplacer jusqu'à ce qu'ils sortent du plateau.

Modification apportée par rapport au livrable1: ajout d'une quatrieme direction dans l'énumeration **Direction** notamment une constante LEFT avec deux coordonnées afin d'être exploitée par les autres classes, le **RandomBoard** implémentation de nouvelles méthodes notamment une methode pour créer un ballon pour un chemin, qui est une methode abstraite de la super classe, le **ClassicalBoard** différentes méthodes chooseValidNeighborPosition comme son nom l'indique et d'autres méthode facilitant le bon fonctionnement de son programme principal, le **Board** des attributs son déclarés, de nouvelles methodes abstraites ajoutées.

### Atteinte des objectifs
Dans ce livrable differents aspect intervenant pour le bon deroulement de la progression du ballon dans les plateaux ont été effectués.

- Le Deplacement d'un ballon  dans un plateau en suivant un chemin specifique

- Analyse et réévaluation des décisions antérieures dans le but d’améliorer et d’affiner les choix de modélisation, elle  vise à optimiser la structure du code, la cohérence des classes.

- Organisation efficace du temps de travail pour respecter les délais du projet et la participation équitable des differents membres du groupe.

Pour lancer le projet, générer la documentation, et lancer les tests... il faut se mettre dans le dossier l2s4-projet-2026 et utilisez les commandes suivantes:

**Lancer les tests avec junit**

```bash
make tests
```

**Compiler l'ensemble des classes .java en .class**

```bash
make build
```

**lancer tous les fichiers livrable2a et livrable2b**

```bash
java -classpath classes bloons.Livrable2a arg1 arg2 arg3
```

```bash
java -classpath classes bloons.Livrable2b arg1 arg2 arg3
```

**Générer le jar**

```bash
jar cvfm livrable2a.jar manifest -C classes .
```

```bash
jar cvfm livrable2b.jar manifest-2b -C classes .
```

**Lancer les jar**

```bash
java -jar livrable2a.jar arg1 arg2 arg3
```
```bash
java -jar livrable2b.jar arg1 arg2 arg3
```
**Générer la documentation**

```bash
make docs
```
### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 5

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 6

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

Le journal de bord doit être rempli à la fin de chaque séance encadrée, et **avant** de quitter la salle. 

Pour chaque semaine on y trouvera :
- ce qui a été réalisé, les difficultés rencontrées et comment elles ont été surmontées (on attend du contenu, pas uniquement une phrase du type "tous les objectifs ont été atteints")
- la liste des objectifs à réaliser d'ici à la prochaine séance encadrée

## Semaine 1

Une réflexion sur le sujet, choix des classes pour pouvoir faire un UML cohérent.
Cet UML évoluera selon si l'on introduit une nouvelle classe ou non.

### Ce qui a été réalisé
 
 Voici ce qui a été réalisé pour la semaine:
 - Conception des diagrammes UML: avec différentes classes soient le **Board** une classe abstraite qui aura deux dérivés une classe **ClassicalBoard** et **RandomBoard**, une classe **Cell** pour les cellules, une classe **Position** pour obtenir la position exacte de tout type qui sera implémenté dans le plateau.

 - L'architecture du projet: des paquetages et sous paquetages ajoutés, l'implémentation minimal des différentes classes, de nouvelles informations y seront ajoutées plus tard selon le besoin. Notre approche est de réflechir de telle sorte à fournir du code optimal, et compréhensible. 

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre
Après une réfexion commune sur le sujet et les diagrammes UML faites: 
- L'objectif est de fournir un algorithme permettant de calculer un chemin pour les deux plateaux l'un étant un chemin prédefinie et l'autre un chemin qui n'est pas definie il peut être horizontale ou verticale. Faire les tests sur les méthode les plus importantes avec Junit5.

- La répartition du travail pour la semaine:
  
**Mariama Séré SYLLA** : elle s'est assure de faire les tests, et améliorer les diagrammes UML

**Farmata Sall SOW** : elle s'assure de fournir le code de la classe ClassicalBoard surtout l'algorithme de calcul du chemin lié à cette classe et améliorer les algorithmes existants des autres classes ou ajouter des algorithmes si cela est nécessaire.

**Khadim BEYE** : il fournit le code minimal des différentes classes(Board, ClassicalBoard, RandomBoard, Cell, Position) ansi que la documentation de chaque méthode. En plus d'aider pour les tests.

**Mamadou Baïllo SOW** : il s'assure de fournir le code de la classe RandomBoard surtout l'algorithme de calcul du chemin lié à cette classe et améliorer les algorithmes exitants des autres classes ou ajouter des algorithmes si cela est nécessaire.

## Semaine 2

### Ce qui a été réalisé
Voici ce qui a été réalisé pour la semaine:
Pour cette semaine on a ou amélioerer les diagrammes uml des differentes entités du livrable. Nous avons pu implementer les methodes de calcule de chemin des differents palateau de jeu ainsi que leurs methodes de test bien sùr. on a aussi modelisé un premier programme permettant d'afficher un plateau de jeu ainsi que son chemin.

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre
- L'objectif pour cette semaine est de terminer le premier livrable en implementant un programme optimisé qui génére un plateau de jeu ainsi que son chemin (selon le type de plateau) difini de mainere aléatoire.

-Le travail est répartit comme suit : 
**Mariama Séré SYLLA** : elle s'assurée d'implémenter les diffèrentes methodes de teste pour les methodes de chaque classe

**Farmata Sall SOW** : elle s'est assurée de fournir le code de la mehode permettant de calculer un chemin pour la classe ClassicalBoard tout en implementant une nouvelle enum **Direction** qui modélise les trois directions qu'un chemin peut s'orienter.

**Khadim BEYE** : il s'est chargé de d'ameliorer les diagrammes uml en y ajoutant diffèrent attributs et methodes pour une decomposition du travail.

**Mamadou Baïllo SOW** : il s'est assuré de fournir le code de la methode permettant de calculer un chemin pour la classe RandomBoard et l'implementation d'un programme permettant d'afficher un plateau de jeu ainsi que son chemin.

## Semaine 3

### Ce qui a été réalisé
Pour cette semaine qui est le debut du livrable 2, on a eu une reflexion sur les nouvelles classes à implémenter, un UML qui répond au cahier de charges. On s'est convenu que pour ce livrable, il faut une classe **Balloon** qui représente les ballons qui se deplaceront sur les deux plateaux, une classe **Level** représentant les trois types de ballons, ajouter les diférentes methodes que la personne en charge du développement d'une classe jugera nécessaire pour le bon fonctionnement du ce livrable.

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre
Avancer au maximum afin de fournir des algorithmes assurant le bon fonctionnement du livrable.

Voici comment les taches ont été distribuées:

**Mariama Séré Sylla** : assure l'implémentation de la classe balloon ainsi que toute méthode qu'elle jugera utile dans cette classe pouvant facilité aux autres l'utilisation de cette classe, en plus de l'énumeration Level.

**Farmata Sall Sow** : s'occupe de faire le diagramme UML, en plus des analyses des autres membres du groupe... Elle s'assure de fournir une classe player, si possible améliorer classical board.

**Khadim Beye** : il fournit les tests junit, de toutes methodes public dès lors qu'elles sont pertinente.

**Mamadou Baïllo SOW** : s'assure d'intégrer les ballons sur le random board suivant un chemin pour chaque.

## Semaine 4
Pour cette semaine on a proceder a la finalisations du livrable2 avec ajout de methode et ameloriation des classes random et classical board.

### Ce qui a été réalisé
- la creation et le deplacement d'un ballons suivant son chemin.

- Placement de ballon dans Le chemein d'un classical board et s'assurer de leur deplacement dans le plateau.

-  Pour randomBoard :generations de chemin aleatoire  dans le pateau ,ajout d'un ballon dans ce dernier.

-  Livrable2a et 2b servent a mettre en euvre le deplacement du ballon selon un tic d'horloge.

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

**Farmata Sall Sow**elle chargée de complete l'uml et le readme et de completer classicalBoard afin d'y ajouter des methodes permettant le placement des ballon mais aussi l'amélioration de certains algorithmes si nécessaire.

**Mamadou Baïllo Sow** il complete le Random Board afin d'y Placer des Ballons mais aussi de générer les différents chemins .Il donne aussi le code complet de Livrable2b.java et fourni un algorithme de l'ajout d'un ballon dans un plateau.

**khadim Beye** il est  chargé de tester les fonctionnalitées de  balloon et le code de la classe Livrable2a.java.

**Mairama Serre Sylla** Elle  s'est chargé  founir le code complet de ballon et le code de l'enum des differents niveau d'un ballon .Elle s'est aussi charger de faire certaines choix jugés necessaire pour la bonne progression des ballons.

## Semaine 5

Pour le livrable 3, l'objectif est de fournir créations des tours, la gestion des tirs pour chaque tour, intégration dans la gestion du temps. Après une réfexion de la part de chacun dans le groupe on s'est convenu d'utiliser une classe abstraite Tour que pourront hériter les autres classes pour chacune des tours. En plus de deux énumérations.

### Ce qui a été réalisé

- création des deux énumerations: **Projectile** pour gérer les projectiles, et **Effect** pour gérer les effets.

- Amélioration de la classe **RandomBoard** pour faire de telle sorte que le nombre de chemin n'excède pas la hauteur x la largeur.

- partage des taches par membre de groupes qui seront detailées un peu plus bas.

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

**Mariama Séré Sylla**: créée les classes suivantes ainsi que les algorithmes nécessaire: **Projectile**, **Effect** et quelques tours si besoin ou aider les autres dans leurs taches.

**Farmata Sall Sow**: teste l'ensemble des méthodes public avec junit qui seront créées pour ce livrable, aide les autres dans leurs taches.

**Khadim Beye**: créé quelques classes tours ainsi que des méthodes qui leurs sont associées. Si nécessaire aider les autres membres du groupe dans les taches.

**Mamadou Baïllo Sow**: crées quelques classes tours ainsi que des méthodes qui leurs sont associées. Si nécessaire aider les autres membres du groupe dans les taches.

## Semaine 6

### Ce qui a été réalisé

Création de différentes classes tours ainsi que deux programmes principaux (main).

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre
l'objectif est de finaliser le livrable avant le délai imparti, pour ce faire voilà comment
les taches ont été partagées.

**Mariama Séré Sylla**: Elle donne l'implémentation de la ou des méthodes nécessaires dans l'un des plateaux afin qu'une tour soit construite, elle fait également un mainLivrable entre les deux mains. En plus de finalisé le diagramme UML.

**Farmata Sall Sow**: Elle doit fournir la classe abstraite **Tower** ainsi que les méthodes abstraites pour les autres tours héritantes et elle fournit également les méthodes de tests pour l'ensmble des méthodes publiques du package.

**Khadim Beye**: Doit fournir plusieurs classes (ProjectileTower, SniperMonkeyTower, SuperMonkeyTower, TackShooterTower, DartMonkeyTower), il s'assure de corriger des erreurs si besoin aux différents algorithmes implémentés par les autres membres du groupe. 

**Mamadou Baïllo Sow**: Doit fournir différentes classes du package tour (IceTower, SlowDownTower, BombeTower), il s'assure de corriger des erreurs si besoin aux différents algorithmes implémentés par les autres membres du groupe. Ainsi qu'un des mainLivrable !

## Semaine 7

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 8

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 9

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 10

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 11

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 12

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour finaliser le projet et répartition du travail par membre
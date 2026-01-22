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

Le premier livrable, avec une approche objet les concepts utilisés sont entre autres l'encapsulation, l'héritage notamment une classe abstraite **Board** qui concentre toutes les méthodes communes aux deux plateaux **ClassicalBoard** et **RandomBoard**. En plus d'une certaine méthode abstraite qui sont définit dans les deux classes correspondantes aux deux plateaux, puisque chacun des plateaux à des choses en plus que l'autre n'a pas c'est-à-dire dans le **ClassicalBoard** un chemin est défini d'avance selon les critères du sujet où les ballons suivront ce chemin defini jusqu'à la sortie et aucune tour ne sera posée sur les cellules traversées par ce chemin. le second plateau est différent, chaque ballon définit sa trajectoire suivant où il est positionné au départ, de ce fait aucun chemin n'est definit d'avance car ce chemin dépendra du ballon (donc le prochain livrable) selon le sujet.

Différentes classes ont été implémenté afin de construire les deux plateaux. Un plateau contient plusieurs cellules donc une classe **Cell**, une cellule à une position dans un plateau donc une cellule depend d'une position d'où, une classe **Position** qui contient juste deux attributs et sourtout vérifiée si deux positions sont égales très important.

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

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 2

### Atteinte des objectifs

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
  
**Mariama Séré SYLLA** : elle s'assure de faire les tests, et améliorer les diagrammes UML

**Farmata Sall SOW** : elle s'assure de fournir le code de la classe ClassicalBoard surtout l'algorithme de calcul du chemin lié à cette classe et améliorer les algorithmes existants des autres classes ou ajouter des algorithmes si cela est nécessaire.

**Khadim BEYE** : il fournit le code minimal des différentes classes(Board, ClassicalBoard, RandomBoard, Cell, Position) ansi que la documentation de chaque méthode. En plus d'aider pour les tests.

**Mamadou Baïllo SOW** : il s'assure de fournir le code de la classe RandomBoard surtout l'algorithme de calcul du chemin lié à cette classe et améliorer les algorithmes exitants des autres classes ou ajouter des algorithmes si cela est nécessaire.

## Semaine 2

### Ce qui a été réalisé
Voici ce qui a été réalisé pour la semaine:
Pour cette semaine on a ou amélioerer les diagrammes uml des differentes entités du livrable. Nous avons pu implementer les methodes de calcule de chemin des differentes palateau de jeu ainsi que leurs methodes de test bien sùr. on a aussi modelisé un premier programme permettant d'afficher un plateau de jeu ainsi que son chemin.

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

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 4

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 5

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 6

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

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
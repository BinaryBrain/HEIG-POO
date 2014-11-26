Labo 06 Hanoï - Rapport
=======================

Sacha Bron - Valentin Minder // HEIG-VD // POO // 20.11.2014

Introduction
------------

Le but de ce laboratoire est de créer un programme capable de résoudre le fameux problème des tours de Hanoï. De plus, les structures de données seront recrées à la main afin de mieux comprendre les méchanismes utilisés par la bibliothèque standard.

Méthodologie et implémentation
------------------------------

### Structure de données

Comme les disques disques tours de Hanoï ne peuvent être mis ou enlevé que s'ils sont tout en haut, les piles (_stack_) semblent être la structure de données la plus favorable à ce problème.

### Algorithme

Il existe plusieurs façons optimales de résoudre ce problème. Nous avons choisi une méthode récursive pour la facilité et la clarté de son implémentation.  
Ainsi, le problème consistant à déplacer la tour d'une aiguille à l'autre peut se généraliser en un problème consistant à déplacer une pile de taille quelconque d'une aiguille à l'autre. 
Ainsi, le problème peut être décomposé. En effet, si nous devons déplacer une tour de _n_ disques, cela revient à déplacer une tour de _n-1_ disques, de déplacer le plus gros disque, puis de replacer les disques plus petits dessus.

### Classes principales

Notre programme est constitué de plusieurs classes ayant des buts précis.

- `Pile`: structure de donée représentant une pile d'objets quelconques (`Object`).
- `Iterateur`: un itérateur permettant de traverser une pile.
- `ObjectContainer`: un conteneur (_wrapper_) englobant un objet quelconque (`Object`) ainsi que le (`ObjectContainer`) précédant dans la pile-mère.

### Tests

Des classes dédiées aux tests ont été créées. Il s'agit des classes `TestHanoi` (permettant de résoudre le problème des tours de Hanoi en console), `TestHanoiGUI` (permettant de tester l'interface graphique), et `TestPile` (qui contient des tests unitaires vérifiant le bon fonctionnement de la pile).  
Ces trois classes contiennent une méthode `main` afin de pouvoir être lancée une à une, selon les besoins.

Schéma des classes
------------------

**TODO inclure le schéma Slyum**

Pour aller plus loin
--------------------

Selon la légende, des moines déplacent sans arrêt de lourds disques de métal d'une aiguille à l'autre.

### Question
En supposant des moines surentraînés capables de déplacer un disque à la seconde, combien de temps reste-t-il avant que l’univers disparaisse (celui-ci a actuellement 13,7 milliards d’années)?

### Réponse

Le nombre de coups à jouer pour déplacer n disques est _2^n - 1_. Ceci peut être facilement montré par une preuve par induction et vérifié à la main pour des petits nombres. Intuitivement, il faut déplacer _n-1_ disques du départ à l'intermédiaire, le dernier disque du départ à l'arrivée, puis _n-1_ disques de l'intermédiaire à l'arrivée.
Donc itérativement:
_K(0) = 0_
_K(n) = 2 K(n-1) + 1_
donc la formule générale est: _K(n) = 2^n - 1_

Pour 64 disques à raison d'un mouvement par seconde, il faut donc _2^64 - 1_ secondes, soit _1.8446744e+19_ secondes.

Dans un milliard d'années, il y a _10^9 * 365 * 24 * 60 * 60 = 3.1536e+16_ secondes.

Il faudra donc _(2^64 - 1) / 3.1536e+16 = 584.94 milliards d'années_ aux moins pour déplacer tous les disques.

En soustrayant les 13.7 milliards d'années s'étant déjà écoulés depuis le Big Bang, il reste donc a priori 571.24 milliards d'années à l'univers, selon cette tradition.

Conclusion
----------

Nous pouvons constaté que la résolution de ce problème est de plus en plus longue.  
**TODO de combien? Suite de la conclusion**

Annexes
-------

Le code imprimé est annexé.

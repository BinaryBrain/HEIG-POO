Labo 08 Calculatrice - Rapport
=======================

Sacha Bron - Valentin Minder // HEIG-VD // POO // 12.12.2014

Introduction
------------

Le but de ce laboratoire est de créer un programme capable de gérer une calculatrice fonctionnant en notation polonaise inverse (Reverse Polish Notation).
Dans ce mode de calcul, les opérateurs sont postfixés, c'est-à-dire placés après leur(s) opérande(s)). 

Exemples: pour effectuer `(1 + 2) * 3` en notation classique, on note `1 2 + 3 *` en notation polonaise. L'avantage est l'absence d'ambiguité sans utilisation de parenthèses.

Méthodologie et implémentation
------------------------------

Comme pour beaucoup de problèmes en informatique, il y a plusieurs manière d'aborder ce problème. Voici comment nous avons raisonné et procédé.

### Classes principales

Notre programme est constitué de plusieurs classes ayant des buts précis. Ce programme illustre le modèle de conception réutilisable MVC (Model-View-Controler design pattern).

- le modèle `State` : structure de donée représentant l'état interne de la calculatrice.
- les contrôlleurs `Operator` : une hiérarchie de différents opérateurs interagissant avec le modèle.
- les vues `JCalculator` (mode graphique) et `Calculator` (mode console) : fournissent une interaction avec l'utilisateur, et appellent les contrôlleurs lors d'actions utilisateurs.

Par ailleurs, la classe `Pile` est reprise telle quelle du labo 7 pour représenter la pile (stack) du modèle.

### Structure de données interne (modèle)

L'état de la calculatrice peut être défini comme suit: la valeur actuelle, l'état de la pile des valeurs, la valeur en mémoire, la présence d'une éventuelle erreur, et le caractère mutable de la valeur actuelle.

La valeur actuelle est manipulée sous forme de `String` afin d'en faciliter la modification (ajout et retrait en fin de chaine). Elle est transformée en `double` pour calcul au moment d'une opération.
La valeur actuelle est modifiable lors d'une insertion avec des digits, par exemple. En revanche, elle ne l'est pas lors qu'il s'agit d'un résultat calculé ou provenant de la mémoire. Dans ce cas, une tentative de modification placera la valeur actuelle sur la pile et l'utilisateur travaillera avec une nouvelle valeur.

Comme les valeurs des opérandes en attente ne peuvent être mises ou enlevées que si elles sont les dernières entrées, les piles (stack) semblent être la structure de données la plus favorable à cette donnée.

La mémoire est une simple `String` qui peut être chargée (`MS` _Memory Store_, la valeur actuelle reste en copie) et déchargée (`MR` _Memory Recall_, la valeur actuelle est écrasée et devient immutable).

### Gestion d'erreurs

Les erreurs arithmétiques possibles sont:

- division par 0 (lors de "division" de `x/y` avec `y = 0` ou lors de `1/x` avec `x = 0`)
- racine carrée d'un nombre inférieur à 0 (`sqrt(-x)` avec `x > 0`)
- valeurs `+/- Infinity` (dépassement de capacité, lorsqu'il n'est plus possible de représenter le nombre)
- valeurs `NaN` (Not a Number). Toutefois cela ne devrait se présenter qu'en cas d'opération avec de très grand nombre, car les cas sont déjà présents avant (p.ex. `0/0`, `0 * Inf`, `Inf-Inf`, `sqrt(-x)`, etc. sont déjà arrêtés par les cas précédent)

De plus, lors de l'appel à un opérateur utilisant deux opérandes, la pile doit contenir au moins un élément (le premier opérande, le deuxième étant la valeur courante). Dans le cas contraire, une erreur est produite.

Dans ces cas, la valeur courante est inutilisable et les seules touches valides sont `CE` (clear error) et `C` (clear) afin de nettoyer l'erreur sur la valeur courante. Toutes les autres sont sans effet.
_Toutefois, notre implémentation tolère le rappel d'une valeur avec MR pour remplacer l'erreur (car cela efface la valeur courante en erreur)._

### Hiérarchie d'opérateurs

La hiérarchie complète est disponible dans le diagrammes des classes en fin de rapport. La logique est de regrouper les operateurs similaires.

Exemples:

- les opérateurs à 2 opérandes peuvent être éxécutés aux mêmes conditions (valeur courante valide et une valeur sur la pile).
- les opérateurs à 1 opérande peuvent être éxécutés aux mêmes conditions (valeur courante valide).
- les digit sont regroupés en un seul opérateur qui contient sa valeur à utiliser lors de son utilisation.
- les number operateurs (digit et point), avant de s'éxécuter, doivent sauver la valeur courante dans la stack si elle est immutable (c'est-à-dire le résultat d'un précédent calcul).

`Operator` est la racine et est la seule à posséder une méthode `execute()`. Elle teste si l'opérateur peut être executé (méthode `check()`) avant de l'executer (méthode `exec()`). 
Ces méthodes sont définies dans les sous-classes, au besoin. En fait, `exec()` est défini pour chaque opérateur (chaque feuille de la hiérarchie) alors que `check()` est défini à des niveaux supérieurs (par groupe d'opérateurs, lorsque la condition de validité est la même).

### Programmes et Tests

Les classes `JCalculator` et `Calculator` contiennent une méthode `main` et permettent de lancer la calculatrice respectivement en mode graphique ou console.

Exemple d'exécution
------------------

En mode graphique.

![graphique](http://i.imgur.com/cswKKg8.png)

En mode console.

![console](http://i.imgur.com/ElIjI4h.png)

Conclusion
----------

Il a été observé que la Notation Polonaise Inverse nécessite moins de touches et d'opérations pour effectuer les mêmes calculs.

Ce laboratoire illustre de plus les notions d'héritage, de liaison dynamique des liens et de pile.

Annexes
-------

Le code imprimé est annexé. Pour simplifier, les sous-classes de la classe `Operator` ont été imprimées sur les mêmes feuilles, les unes à la suite des autres.

Schéma des classes
------------------

Voici le schéma UML des classes.

![UML](http://i.imgur.com/IgXsx7w.png)

_Note: le nom de plusieurs classes (notamment les opérateurs) a été modifié pour plus de lisibilité._

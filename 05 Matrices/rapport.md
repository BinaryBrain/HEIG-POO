Labo 05 Matrices - Rapport
==========================

Sacha Bron - Valentin Minder
HEIG-VD // POO // 29.10.2014

Introduction
-------
Le but de ce labo est d'implémenter des opérations sur les matrices. Pour cela, nous avons créé un objet `Matrix` qui stocke le tableau de tableau de `boolean`, permet d'accéder aux éléments et de les modifier par leur position. Par ailleurs, la méthode `toString()` est redéfinie pour afficher correctement la matrice comme demandé.

Liaison Dynamique des Liens
-------
Afin de bénéficier du principe de liaison dynamique des liens, nous avons créé une classe abstraite opération et trois sous-classes concrètes pour les opérations en elle-mêmes, selon le schéma ci-dessous. La classe abstraite contient une méthode abstraite `execute(a, b)` qui sera implémentée différement par les sous-classes. Elle contient de plus une méthode concrète qui créé la matrice pour stocker le résultat et gère le parcours des matrices opérandes.

![schéma](https://raw.githubusercontent.com/BinaryBrain/POO/master/05%20Matrices/operationstruct.png?token=AFPQ795F6Jw9y2gTZM2guJEDlYIB4yNcks5UV58SwA%3D%3D "Schéma d'héritage des opérations")

Ainsi, le code `execute(a, b)` fonctionne toujours depuis la classe abstraite, et va appeler automatiquement la bonne méthode dans la bonne sous-classe à l'éxécution, en fonction du type réel de `op` dans le main (`op.executeOperation(m1, m2)`). En effet, on peut librement réaffecter `op = new Or();` sans affecter le comportement.

Conclusion
-----
Nous constatons qu'au moment de l'execution, la bonne méthode est appelée en fonction du type réel de l'objet `Operation`, bien que celui-ci soit de type abstrait. Ainsi, aucun test sur le type des objets et aucune structure de contrôle n'est nécessaire.


Exemple
=======

Titre 1
=======

Titre 2
-------

### Titre 3

La commande `ls` permet de lister les fichiers.

Voici mon code:

```
int main(int argc, char* argv) {
    printf("Hello World!\n");
}
```

Je suis un texte en **gras**.

Je suis un texte en _italique_.

Je suis un [lien](http://google.com).

- Je
- suis
- une
- liste


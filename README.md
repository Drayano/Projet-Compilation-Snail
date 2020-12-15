# CompilationSnail

L3 - S5 - Section 1 - Groupe 1

# Noms et Prènoms :
Rezk-kallah Houari.

ZERNADJI Taha.

# Outils

Language utilisé: Java.

Version: Java 8.

IDE: Netbeans IDE 11.0.


# Description :
Le programme contient les 3 types d'analyses, pour l'analyse lexicale nous avons créé un tableau (vecteur) ou nous enregistrons tous les mots ou caractères présents dans le fichier (.compila), puis en utilisant nos fonctions (isNumeric, isInt,isIdent, etc.) pour identifier chaque mot, que ce soit (identificateur, opérateurs, entier, réel, etc...).

Pour l'analyse syntaxique nous avons pris une approche similaire à l'analyse lexical, sauf que cette fois on enregistre chaque ligne dans une case d'un tableau déclaré, afin de détécter les erreurs de syntaxe, nous avons enregistré la syntaxe de tous types d'instruction, si une des instructions est erronée alors une erreur détectée.Le programme garde un fichier texte où il enregistre l'historique d'erreur de la dernière utilisation.

Enfin, au niveau de l'analyse sémantique le programme vérifié si la disposition des instructions est correcte (début par une start_Progam et se termine par un End_Program), et aussi l'utilisation correcte des instructions (même nombre de if que de else par exemple), il compte le nombre d'erreurs trouver et il affiche le montant à la fin de l'analyse. Comme l'analyse syntaxique, on garde un historique de la dernière utilisation.

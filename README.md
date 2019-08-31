# TP-cero-Taller-de-programacion
Primer proyecto del taller de programación

Ejercicio:
Se solicita que escriba un programa en Java que reciba como parámetro por línea
de comando el nombre de un archivo de texto que contiene en cada línea una tira de
números enteros separadas por “;” (punto y coma).
Ej: 8;9;-123;-125;0;132;145;2.4;-1.2;91;unpaz;34;taller;-21
El programa debe producir un archivo de salida por cada tira de números del
archivo de entrada. El nombre del archivo de salida debe ser
"<archivo_entrada>_salida_<i>.txt” donde i es el número de tira o línea dentro del
archivo de entrada (inicie con i = 1)
El archivo de salida debe contener distintas líneas con los siguientes resultados
obtenidos a partir del procesamiento de la tira:
a) la tira de números o línea leída del archivo de entrada.
b) sólo los números enteros válidos separados por “;”.
c) los valores inválidos de la línea de entrada separados por “;”.
d) el valor máximo de la tira de números enteros válidos
e) el valor mínimo de la tira de números enteros válidos.
f) el factorial del valor máximo, 0 en caso que no pueda implementarse.
f) la secuencia de números enteros válidos ordenada de menor a mayor.
g) la secuencia de números enteros válidos ordenada de mayor a menor.
h) los valores repetidos en la tira si los hubiera, línea vacía en otro caso.
i) la media aritmética de la tira válida: la media es el valor promedio de los
valores.
j) la mediana, es el valor central de todos los datos cuando éstos están ordenados
de menor a mayor. Si la serie tiene una cantidad impar de valores, la mediana es el valor
central; si la cantidad en la serie es par, la mediana es el valor promedio de los dos
valores centrales.
k) la moda, si la hubiera, en otro caso una línea vacía: la moda es el valor que se
repite más veces en la tira de números, si hay dos o más valores con la misma cantidad
de repeticiones máxima la secuencia es multimodal y esos valores representan la moda;
por último, si todos los valores se repiten todos la misma cantidad de veces, no hay
moda.
l) los números pares de la secuencia válida
m) los números impares de la secuencia válida
n) los números primos presentes en la secuencia válida
o) los números de la secuencia sin repetidos si los hubiera
Para la realización de la solución de este trabajo tenga en cuenta que:
• Debe hacer uso de arreglos y recorrerlos.
• Debe hacer uso de funciones y/o métodos para resolver los desafíos.
• El nombre del archivo de entrada es recibido por la aplicación por
parámetro desde la línea de comando.
• Para procesar los archivos de textos sólo pueden utilizarse las clases
BufferedReader y BufferedWriter (y las clases que a partir de su uso sean
necesarias).
• Se espera que la función que calcula el factorial sea recursiva.

Enjoy!

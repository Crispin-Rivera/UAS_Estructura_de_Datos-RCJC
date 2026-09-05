#Implementación en python mapeo por columnas
r = 3; c = 3 
arr = [0]*r*c
#matriz inicializacda y luego se le asigna un valor
TwoDArr  = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]]; #almancenar los elementos en un array unidimensional ordenados por fila
k = 0
for x in range(r):
    for y in range(c):
        k = x*r+y
        arr[k] = TwoDArr[x][y]
        k = k + 1
print("Los elementos del array bidimensional son: ")
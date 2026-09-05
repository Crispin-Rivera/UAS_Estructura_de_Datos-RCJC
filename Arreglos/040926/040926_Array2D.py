#implementación en python

TwoDimensionlArray = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
print("Los elementos de la matriz son: ")
for row in TwoDimensionlArray:
    for element in row:
        print(element, end=" ")#mostrando los elementos de la fila separandos por espacios
    print() #ir a la siguiente linea después de mostrar una  fila
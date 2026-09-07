#implementación en python

TrheeDimensionlArray = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
],
[    [10, 11, 12],
    [13, 14, 15],
    [16, 17, 18]
]

print("Los elementos de la matriz son: ")
for TwoDimensionalArray in TrheeDimensionlArray:
    for row in TwoDimensionalArray:
        for element in row:
            print(element, end=" ")#mostrando los elementos de la fila separandos por espacios
    print() #ir a la siguiente linea después de mostrar una  fila
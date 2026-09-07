# Aplanamiento de Matriz 2D a 1D por COLUMNAS en Python
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

r = 3; c = 3
arr = [0] * r * c

# Matriz inicializada
TwoDArr = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

# Almacenar elementos en un array unidimensional ordenados por COLUMNAS
for x in range(r):
    for y in range(c):
        k = y * r + x  # Fórmula por columnas
        arr[k] = TwoDArr[x][y]

print("Los elementos del array bidimensional son: ")
for row in TwoDArr:
    for ele in row:
        print(ele, end=" ")
    print()

print("\nLos elementos del array unidimensional (por columnas) son: ")
# Imprimir los elementos recorriendo en orden por columnas
for y in range(c):
    for x in range(r):
        print(arr[y * r + x], end=" ")
print()
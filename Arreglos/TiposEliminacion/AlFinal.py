# Programa para eliminar un elemento al final en Python
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

# Declaración e inicialización del arreglo
inputArr = [11, 21, 31, 41, 51, 61]

# Imprimir el arreglo antes de eliminar
print("Antes de eliminar, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")

# Eliminando el elemento al final con pop()
inputArr.pop()

# Imprimir el arreglo después de eliminar
print("\nDespués de eliminar, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
print()
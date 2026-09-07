# Programa para eliminar un elemento en un índice específico en Python
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

# Declaración e inicialización del arreglo
inputArr = [11, 21, 31, 41, 51, 61]
position = 3  # Índice desde el que se realizará la eliminación

# Imprimir el arreglo antes de la eliminación
print("Antes de la eliminación, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")

# Eliminación del elemento en el índice indicado (posición 3)
inputArr.pop(position)

# Imprimir el arreglo después de la eliminación
print("\nDespués de la eliminación, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
print()
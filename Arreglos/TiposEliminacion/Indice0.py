#Programa para eliminar un elemento al principio del array
#Autor: Rivera Cota Jesús Crispín
#FACULTAD DE INGENIERÍA LOS MOCHIS
#Ing. de Software 201
inputArr=[11,21,31,41,51,61]
print("Antes de la eliminación, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
inputArr.pop(0)
#eliminando el primer elemento del inputArr[]
print("\nDespués de la eliminación, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
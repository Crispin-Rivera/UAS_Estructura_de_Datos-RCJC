#Inserción de un elemento al final del array
#Autor: Rivera Cota Jesús Crispín
#FACULTAD DE INGENIERÍA LOS MOCHIS
#Ing. de Software 201

inputArr = [11, 21, 31, 41, 51, 61]
ele = 52
print("Antes de la inserción, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
#Inserción del elemento al final
inputArr.append(ele)
print("\nDespués de la inserción, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
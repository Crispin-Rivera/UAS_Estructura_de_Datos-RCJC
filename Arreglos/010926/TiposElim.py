#implementacion en python
inputArr=[11,21,31,41,51,61]
#Programa para elminar un elemento al principio del array
print("Antes de la eliminación, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
inputArr.pop(0)
#eliminnando el primer elemento del inputArr[]
print("\nDespués de la eliminación, el array es: ")
for j in range(len(inputArr)):
    print(inputArr[j], end=" ")
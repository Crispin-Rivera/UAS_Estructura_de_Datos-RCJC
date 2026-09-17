# Ordenamiento por selección
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

def selectionSort(a): #funcion para implementar el algoritmo de selección
    for i in range(len(a)):#recorre todo el arreglo
        small = i #indice del elemento mas pequeño
        for j in range(i+1, len(a)): #encuentra el elemento mas pequeño en el arreglo
            if a[small] > a[j]:#compara el elemento mas pequeño con el siguiente elemento
                small = j #actualiza el indice del elemento mas pequeño
                #intercambia el elemento mas pequeño con el primer elemento del arreglo
                a[i], a[small] = a[small], a[i] #intercambio de elementos
def printArray(a): #funcion para imprimir el arreglo
    for i in range(len(a)):#recorre todo el arreglo
        print(a[i], end=" ")
a=[65, 26, 13, 23, 12]
print("El arreglo antes de ser ordenado es: ")
printArray(a)
selectionSort(a)
print("\nEl arreglo después de ser ordenado es: ")
selectionSort(a)
printArray(a)
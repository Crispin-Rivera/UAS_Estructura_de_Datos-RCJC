# Ordenamiento Burbuja
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

def bubbleSort(a):
    s = len(a)
    #Iterando sobre todos los elementos del arreglo
    for i in range(s):
        isSwapped = False
        #Los ultimos j elementos ya están en su lugar
        for j in range(0, s - i - 1):
            # Intercambiando si el elemento encontrado es mayor que el siguiente elemento
            if a[j] > a[j + 1]:
                a[j], a[j + 1] = a[j + 1], a[j]
                isSwapped = True
        # Si no se realizó ningún intercambio, el arreglo ya está ordenado
        if(isSwapped == False):
            break

#Código del controlador para la prueba anterior
if __name__ == '__main__':
    a = [15, 16, 11, 13, 14]
    print("Antes de ordenar los elementos del array son: ")
    for j in a:
        print(j, end=" ")

    bubbleSort(a)
    print("\nDespués de ordenar los elementos del array son: ")
    for j in range(len(a)):
        print(j, end=" ")
        print("%d" % a[j], end=" ")

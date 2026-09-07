# Búsqueda Binaria de un Arreglo en Python
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

def findEle(arr, l, h, targetValue):
    while l <= h:
        mid = l + (h - l) // 2

        # Verificar si targetValue está presente en mid
        if arr[mid] == targetValue:
            return mid

        # Si targetValue es mayor que el elemento mid, considerar la segunda mitad del array
        elif arr[mid] < targetValue:
            l = mid + 1

        # Si targetValue es menor que el elemento mid, considerar la primera mitad del array
        else:
            h = mid - 1

    # Si el control llega hasta aquí, significa que el elemento buscado no está presente en el array
    return -1

if __name__ == '__main__':
    inputArr = [6, 10, 12, 19, 34, 40, 57, 69, 89, 98] # Arreglo ordenado de entrada
    targetElement = 40 # Elemento objetivo a encontrar
    s = len(inputArr) # Tamaño del array

    # Operación de búsqueda
    idx = findEle(inputArr, 0, s - 1, targetElement)
    if idx != -1:
        print("El elemento se encuentra en la posición: " + str(idx + 1))
    else:
        print("El elemento no se encuentra.")
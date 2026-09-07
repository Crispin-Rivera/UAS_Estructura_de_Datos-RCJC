# Búsqueda Lineal de un Arreglo en Python
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

# Función para realizar la búsqueda lineal
def findEle(inputArr, s, targetEle):
    for j in range(s):
        if (inputArr[j] == targetEle): # Aplicando búsqueda lineal
            return j # Elemento encontrado en el índice j
    # No se encuentra el elemento objetivo
    return -1

if __name__ == '__main__':
    # Declaración del arreglo y definición del objetivo
    inputArr = [12, 34, 10, 6, 40, 89, 98, 57, 19, 69]
    targetElement = 40
    s = len(inputArr)

    # Operación de búsqueda
    idx = findEle(inputArr, s, targetElement)
    if idx != -1:
        print("El elemento se encuentra en la posición: " + str(idx + 1))
    else:
        print("No se encuentra el elemento.")

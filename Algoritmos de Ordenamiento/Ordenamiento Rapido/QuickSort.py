# Ordenamiento Rapido (quicksort)
# Autor: Rivera Cota Jesús Crispín
# FACULTAD DE INGENIERÍA LOS MOCHIS
# Ing. de Software 201

def partition(a, l, h):
    pvt = a[h]
    j = l - 1
    for k in range(l, h):
        if a[k] < pvt:
            j += 1
            swap(a, j, k)
    swap(a, j + 1, h)
    return j + 1

def swap(a, j, k):
    a[j], a[k] = a[k], a[j]

def qcksort(a, l, h):
    if l < h:
        pi = partition(a, l, h)
        qcksort(a, l, pi - 1)
        qcksort(a, pi + 1, h)

if __name__ == "__main__":
    a = [10, 7, 8, 9, 1, 5]
    size = len(a)
    
    print("El arreglo antes de ordenarlo es: ")
    for v in a:
        print(v, end=" ")
    print()
    
    qcksort(a, 0, size - 1)
    
    print("El arreglo despues de ordenarlo: ")
    for v in a:
        print(v, end=" ")
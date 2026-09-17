// Ordenamiento Rapido (quicksort)
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>

void swap(std::vector<int>& a, int j, int k) {
    int temp = a[j];
    a[j] = a[k];
    a[k] = temp;
}

int partition(std::vector<int>& a, int l, int h) {
    int pvt = a[h];
    int j = l - 1;
    for (int k = l; k < h; k++) {
        if (a[k] < pvt) {
            j++;
            swap(a, j, k);
        }
    }
    swap(a, j + 1, h);
    return j + 1;
}

void qcksort(std::vector<int>& a, int l, int h) {
    if (l < h) {
        int pi = partition(a, l, h);
        qcksort(a, l, pi - 1);
        qcksort(a, pi + 1, h);
    }
}

int main() {
    std::vector<int> a = {10, 7, 8, 9, 1, 5};
    int size = a.size();

    std::cout << "El arreglo antes de ordenarlo es:\n";
    for (int v : a) {
        std::cout << v << " ";
    }
    std::cout << "\n";

    qcksort(a, 0, size - 1);

    std::cout << "El arreglo despues de ordenarlo:\n";
    for (int v : a) {
        std::cout << v << " ";
    }
    std::cout << "\n";

    return 0;
}
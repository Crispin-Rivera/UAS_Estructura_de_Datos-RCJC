// Búsqueda Binaria de un Arreglo en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

// Función para realizar la búsqueda binaria
int findEle(const vector<int>& arr, int l, int h, int targetValue) {
    while (l <= h) {
        int mid = l + (h - l) / 2;

        // Verificar si targetValue está presente en mid
        if (arr[mid] == targetValue) {
            return mid;
        }

        // Si targetValue es mayor que el elemento mid, considerar la segunda mitad del array
        if (arr[mid] < targetValue) {
            l = mid + 1;
        } 
        // Si targetValue es menor que el elemento mid, considerar la primera mitad del array
        else {
            h = mid - 1;
        }
    }

    // Si el control llega hasta aquí, significa que el elemento buscado no está presente en el array
    return -1;
}

int main() {
    vector<int> inputArr = {6, 10, 12, 19, 34, 40, 57, 69, 89, 98}; // Arreglo ordenado de entrada
    int targetElement = 40; // Elemento objetivo a encontrar
    int s = inputArr.size(); // Tamaño del array

    // Operación de búsqueda
    int idx = findEle(inputArr, 0, s - 1, targetElement);
    if (idx != -1) {
        cout << "El elemento se encuentra en la posición: " << (idx + 1) << endl;
    } else {
        cout << "El elemento no se encuentra." << endl;
    }

    return 0;
}
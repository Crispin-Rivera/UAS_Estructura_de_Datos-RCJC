// Recorrido Inverso de un Arreglo en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
using namespace std;

int main() {
    int arr[] = {40, 50, 60, 70, 80, 90};
    int size = sizeof(arr) / sizeof(arr[0]);

    cout << "Recorrido inverso del array: ";
    cout << "\nLos elementos del array son: ";
    for (int idx = size - 1; idx >= 0; idx--) {
        cout << arr[idx] << " ";
    }
    cout << endl;

    return 0;
}
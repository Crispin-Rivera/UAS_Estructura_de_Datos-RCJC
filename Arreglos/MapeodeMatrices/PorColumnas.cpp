// Aplanamiento de Matriz 2D a 1D por COLUMNAS en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int r = 3, c = 3;
    vector<int> arr(r * c, 0);

    // Matriz inicializada
    vector<vector<int>> TwoDArr = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    // Almacenar elementos en un array unidimensional ordenados por COLUMNAS
    for (int x = 0; x < r; x++) {
        for (int y = 0; y < c; y++) {
            int k = y * r + x; // Fórmula por columnas
            arr[k] = TwoDArr[x][y];
        }
    }

    cout << "Los elementos del array bidimensional son: " << endl;
    for (const auto& row : TwoDArr) {
        for (int ele : row) {
            cout << ele << " ";
        }
        cout << endl;
    }

    cout << "\nLos elementos del array unidimensional (por columnas) son: " << endl;
    // Imprimir los elementos recorriendo en orden por columnas
    for (int y = 0; y < c; y++) {
        for (int x = 0; x < r; x++) {
            cout << arr[y * r + x] << " ";
        }
    }
    cout << endl;

    return 0;
}
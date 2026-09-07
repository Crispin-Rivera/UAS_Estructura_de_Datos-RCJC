// Aplanamiento de Matriz Bidimensional a Unidimensional en C++
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
    }; // Almacenar elementos en un array unidimensional ordenados por filas

    int k = 0;
    for (int x = 0; x < r; x++) {
        for (int y = 0; y < c; y++) {
            k = x * r + y;
            arr[k] = TwoDArr[x][y];
            k = k + 1;
        }
    }

    cout << "Los elementos del array bidimensional son: " << endl;
    for (const auto& row : TwoDArr) {
        for (int ele : row) {
            cout << ele << " "; // Mostrar los elementos de la fila separados por espacios
        }
        cout << endl; // Ir a la siguiente línea después de mostrar una fila
    }

    cout << "\nLos elementos del array unidimensional son: " << endl;
    // Imprimir los elementos del array unidimensional
    for (int x = 0; x < r; x++) {
        for (int y = 0; y < c; y++) {
            cout << arr[x * r + y] << " ";
        }
    }
    cout << endl;

    return 0;
}
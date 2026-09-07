// Implementación en C++ de una matriz tridimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

int main() {
    // Declaración e inicialización de la matriz tridimensional (3D)
    vector<vector<vector<int>>> ThreeDimensionalArray = {
        {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        },
        {
            {10, 11, 12},
            {13, 14, 15},
            {16, 17, 18}
        }
    };

    cout << "Los elementos de la matriz son: " << endl;
    // Recorrido por matrices bidimensionales (capas)
    for (const auto& TwoDimensionalArray : ThreeDimensionalArray) {
        // Recorrido por filas
        for (const auto& row : TwoDimensionalArray) {
            // Recorrido por elementos individuales
            for (int element : row) {
                cout << element << " "; // Mostrando los elementos de la fila separados por espacios
            }
            cout << endl; // Ir a la siguiente línea después de mostrar una fila
        }
        cout << endl; // Espacio entre capas/matrices bidimensionales
    }

    return 0;
}
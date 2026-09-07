// Implementación en C++ de una matriz bidimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

int main() {
    // Declaración e inicialización de la matriz bidimensional
    vector<vector<int>> TwoDimensionlArray = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    cout << "Los elementos de la matriz son: " << endl;
    // Recorrido por filas
    for (const auto& row : TwoDimensionlArray) {
        // Recorrido por elementos dentro de la fila
        for (int element : row) {
            cout << element << " "; // Mostrando los elementos de la fila separados por espacios
        }
        cout << endl; // Ir a la siguiente línea después de mostrar una fila
    }

    return 0;
}
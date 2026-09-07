// Programa para eliminar un elemento al final en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

int main() {
    // Declaración e inicialización del arreglo (vector)
    vector<int> inputArr = {11, 21, 31, 41, 51, 61};

    // Imprimir el arreglo antes de eliminar
    cout << "Antes de eliminar, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }

    // Eliminando el elemento al final con pop_back()
    inputArr.pop_back();

    // Imprimir el arreglo después de eliminar
    cout << "\nDespués de eliminar, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }
    cout << endl;

    return 0;
}
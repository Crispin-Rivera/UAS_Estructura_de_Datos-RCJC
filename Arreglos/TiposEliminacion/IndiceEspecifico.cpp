// Programa para eliminar un elemento en un índice específico en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

int main() {
    // Declaración e inicialización del arreglo (vector)
    vector<int> inputArr = {11, 21, 31, 41, 51, 61};
    int position = 3; // Índice desde el que se realizará la eliminación

    // Imprimir el arreglo antes de la eliminación
    cout << "Antes de la eliminación, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }

    // Eliminación del elemento en el índice indicado (posición 3)
    inputArr.erase(inputArr.begin() + position);

    // Imprimir el arreglo después de la eliminación
    cout << "\nDespués de la eliminación, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }
    cout << endl;

    return 0;
}
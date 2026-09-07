// Programa para eliminar un elemento al principio del array en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> inputArr = {11, 21, 31, 41, 51, 61};

    cout << "Antes de la eliminación, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }

    // eliminando el primer elemento del inputArr[]
    inputArr.erase(inputArr.begin());

    cout << "\nDespués de la eliminación, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }
    cout << endl;

    return 0;
}
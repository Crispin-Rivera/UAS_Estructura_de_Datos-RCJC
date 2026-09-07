// Inserción en el índice 0 de un Arreglo en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> inputArr = {11, 21, 31, 41, 51, 61};
    int ele = 52;

    cout << "Antes de la inserción, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }

    // Inserción del elemento en el índice 0
    inputArr.insert(inputArr.begin(), ele);

    cout << "\nDespués de la inserción, el array es: " << endl;
    for (size_t j = 0; j < inputArr.size(); j++) {
        cout << inputArr[j] << " ";
    }
    cout << endl;

    return 0;
}
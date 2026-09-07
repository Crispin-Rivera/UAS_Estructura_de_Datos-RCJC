// Búsqueda Lineal de un Arreglo en C++
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
#include <vector>
using namespace std;

// Función para realizar la búsqueda lineal
int findEle(const vector<int>& inputArr, int s, int targetEle) {
    for (int j = 0; j < s; j++) {
        if (inputArr[j] == targetEle) { // Aplicando búsqueda lineal
            return j; // Elemento encontrado en el índice j
        }
    }
    // No se encuentra el elemento objetivo
    return -1;
}

int main() {
    // Declaración del arreglo y definición del objetivo
    vector<int> inputArr = {12, 34, 10, 6, 40, 89, 98, 57, 19, 69};
    int targetElement = 40;
    int s = inputArr.size();

    // Operación de búsqueda
    int idx = findEle(inputArr, s, targetElement);
    if (idx != -1) {
        cout << "El elemento se encuentra en la posición: " << (idx + 1) << endl;
    } else {
        cout << "No se encuentra el elemento." << endl;
    }

    return 0;
}

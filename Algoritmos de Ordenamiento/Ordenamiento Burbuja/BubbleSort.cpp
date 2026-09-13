// Ordenamiento Burbuja
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
using namespace std;

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++){
        for (int j = 0; j < n-i-1; j++){
            if (arr[j] > arr[j+1]){
                // Intercambiar arr[j] y arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

int main(){
    int arr[] = {15, 16, 11, 13, 14};
    // Calculamos el tamaño del arreglo
    int n = sizeof(arr)/sizeof(arr[0]);
    cout << "Antes de ordenar los elementos del array son: " << endl;
    for (int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    bubbleSort(arr, n);
    cout << "\nDespués de ordenar los elementos del array son: " << endl;
    for (int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    return 0;
}
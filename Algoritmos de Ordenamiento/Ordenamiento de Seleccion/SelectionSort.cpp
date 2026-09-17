// Ordenamiento por selección
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

#include <iostream>
using namespace std;

void selectionsort(int arr[], int n){
    for (int i = 0; i < n - 1; i++){
        int small = i;
        for (int j = i + 1; j < n; j++){
            if (arr[j] < arr[small]){
                small = j;
            }
        }
        if (small != i){
            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
    }
}

int main(){
    int arr[] = {65, 26, 13, 23, 12};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout << "El aray antes de ordenar es: " << endl;
    for (int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    selectionsort(arr,n);
    cout << "\nEl array despuúes de ordenar es: " << endl;
    for (int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
}
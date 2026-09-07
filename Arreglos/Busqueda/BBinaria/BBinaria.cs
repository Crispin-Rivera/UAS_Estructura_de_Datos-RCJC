// Búsqueda Binaria de un Arreglo en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program {
    // Función para realizar la búsqueda binaria
    static int FindEle(List<int> arr, int l, int h, int targetValue) {
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Verificar si targetValue está presente en mid
            if (arr[mid] == targetValue) {
                return mid;
            }

            // Si targetValue es mayor que el elemento mid, considerar la segunda mitad del array
            if (arr[mid] < targetValue) {
                l = mid + 1;
            }
            // Si targetValue es menor que el elemento mid, considerar la primera mitad del array
            else {
                h = mid - 1;
            }
        }

        // Si el control llega hasta aquí, significa que el elemento buscado no está presente en el array
        return -1;
    }

    static void Main() {
        List<int> inputArr = new List<int> { 6, 10, 12, 19, 34, 40, 57, 69, 89, 98 }; // Arreglo ordenado
        int targetElement = 40; // Elemento objetivo a encontrar
        int s = inputArr.Count; // Tamaño del array

        // Operación de búsqueda
        int idx = FindEle(inputArr, 0, s - 1, targetElement);
        if (idx != -1) {
            Console.WriteLine("El elemento se encuentra en la posición: " + (idx + 1));
        } else {
            Console.WriteLine("El elemento no se encuentra.");
        }
    }
}
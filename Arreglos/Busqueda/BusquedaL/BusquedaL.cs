// Búsqueda Lineal de un Arreglo en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program {
    // Función para realizar la búsqueda lineal
    static int FindEle(List<int> inputArr, int s, int targetEle) {
        for (int j = 0; j < s; j++) {
            if (inputArr[j] == targetEle) { // Aplicando búsqueda lineal
                return j; // Elemento encontrado en el índice j
            }
        }
        // No se encuentra el elemento objetivo
        return -1;
    }

    static void Main() {
        // Declaración del arreglo y definición del objetivo
        List<int> inputArr = new List<int> { 12, 34, 10, 6, 40, 89, 98, 57, 19, 69 };
        int targetElement = 40;
        int s = inputArr.Count;

        // Operación de búsqueda
        int idx = FindEle(inputArr, s, targetElement);
        if (idx != -1) {
            Console.WriteLine("El elemento se encuentra en la posición: " + (idx + 1));
        } else {
            Console.WriteLine("No se encuentra el elemento.");
        }
    }
}
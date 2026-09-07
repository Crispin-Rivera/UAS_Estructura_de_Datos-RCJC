// Programa para eliminar un elemento en un índice específico en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program {
    static void Main() {
        // Declaración e inicialización de la lista
        List<int> inputArr = new List<int> { 11, 21, 31, 41, 51, 61 };
        int position = 3; // Índice desde el que se realizará la eliminación

        // Imprimir el arreglo antes de la eliminación
        Console.WriteLine("Antes de la eliminación, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }

        // Eliminación del elemento en el índice indicado (posición 3)
        inputArr.RemoveAt(position);

        // Imprimir el arreglo después de la eliminación
        Console.WriteLine("\nDespués de la eliminación, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }
        Console.WriteLine();
    }
}
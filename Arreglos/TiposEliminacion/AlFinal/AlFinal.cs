// Programa para eliminar un elemento al final en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program {
    static void Main() {
        // Declaración e inicialización de la lista
        List<int> inputArr = new List<int> { 11, 21, 31, 41, 51, 61 };

        // Imprimir el arreglo antes de eliminar
        Console.WriteLine("Antes de eliminar, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }

        // Eliminando el último elemento según el último índice disponible
        inputArr.RemoveAt(inputArr.Count - 1);

        // Imprimir el arreglo después de eliminar
        Console.WriteLine("\nDespués de eliminar, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }
        Console.WriteLine();
    }
}
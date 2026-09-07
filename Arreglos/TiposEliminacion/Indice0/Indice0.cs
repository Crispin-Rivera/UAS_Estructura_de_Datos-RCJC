// Programa para eliminar un elemento al principio del array en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program {
    static void Main() {
        List<int> inputArr = new List<int> { 11, 21, 31, 41, 51, 61 };

        Console.WriteLine("Antes de la eliminación, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }

        // eliminando el primer elemento del inputArr[]
        inputArr.RemoveAt(0);

        Console.WriteLine("\nDespués de la eliminación, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }
        Console.WriteLine();
    }
}

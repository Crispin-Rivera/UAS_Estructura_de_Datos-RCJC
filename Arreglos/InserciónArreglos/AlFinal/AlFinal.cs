// Inserción de un elemento al final del array en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program {
    static void Main() {
        List<int> inputArr = new List<int> { 11, 21, 31, 41, 51, 61 };
        int ele = 52;

        Console.WriteLine("Antes de la inserción, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }

        // Inserción del elemento al final
        inputArr.Add(ele);

        Console.WriteLine("\nDespués de la inserción, el array es: ");
        for (int j = 0; j < inputArr.Count; j++) {
            Console.Write(inputArr[j] + " ");
        }
        Console.WriteLine();
    }
}
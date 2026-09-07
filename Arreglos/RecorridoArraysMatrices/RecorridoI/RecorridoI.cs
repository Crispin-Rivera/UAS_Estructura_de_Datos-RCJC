// Recorrido Inverso de un Arreglo en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;

class Program {
    static void Main() {
        int[] arr = { 40, 50, 60, 70, 80, 90 };

        Console.Write("Recorrido inverso del array: ");
        Console.Write("\nLos elementos del array son: ");
        for (int idx = arr.Length - 1; idx >= 0; idx--) {
            Console.Write(arr[idx] + " ");
        }
        Console.WriteLine();
    }
}
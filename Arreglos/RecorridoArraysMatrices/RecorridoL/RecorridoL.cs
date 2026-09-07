// Recorrido Lineal de un Arreglo en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;

class Program {
    static void Main() {
        int[] arr = { 40, 50, 60, 70, 80, 90 };

        Console.Write("Recorrido lineal (secuencial): ");
        Console.Write("\nLos elementos del array son: ");
        foreach (int idx in arr) {
            Console.Write(idx + " ");
        }
        Console.WriteLine();
    }
}
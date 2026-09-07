// Aplanamiento de Matriz 2D a 1D por COLUMNAS en C#
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;

class Program {
    static void Main() {
        int r = 3, c = 3;
        int[] arr = new int[r * c];

        // Matriz inicializada
        int[,] TwoDArr = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        // Almacenar elementos en un array unidimensional ordenados por COLUMNAS
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                int k = y * r + x; // Fórmula por columnas
                arr[k] = TwoDArr[x, y];
            }
        }

        Console.WriteLine("Los elementos del array bidimensional son: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Console.Write(TwoDArr[i, j] + " ");
            }
            Console.WriteLine();
        }

        Console.WriteLine("\nLos elementos del array unidimensional (por columnas) son: ");
        // Imprimir los elementos recorriendo en orden por columnas
        for (int y = 0; y < c; y++) {
            for (int x = 0; x < r; x++) {
                Console.Write(arr[y * r + x] + " ");
            }
        }
        Console.WriteLine();
    }
}
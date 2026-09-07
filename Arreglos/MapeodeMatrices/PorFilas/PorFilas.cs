// Aplanamiento de Matriz Bidimensional a Unidimensional en C#
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
        }; // Almacenar elementos en un array unidimensional ordenados por filas

        int k = 0;
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                k = x * r + y;
                arr[k] = TwoDArr[x, y];
                k = k + 1;
            }
        }

        Console.WriteLine("Los elementos del array bidimensional son: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Console.Write(TwoDArr[i, j] + " "); // Mostrar los elementos de la fila separados por espacios
            }
            Console.WriteLine(); // Ir a la siguiente línea después de mostrar una fila
        }

        Console.WriteLine("\nLos elementos del array unidimensional son: ");
        // Imprimir los elementos del array unidimensional
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                Console.Write(arr[x * r + y] + " ");
            }
        }
        Console.WriteLine();
    }
}
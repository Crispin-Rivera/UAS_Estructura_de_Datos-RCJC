// Implementación en C# de una matriz bidimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;

class Program {
    static void Main() {
        // Declaración e inicialización de la matriz bidimensional
        int[,] TwoDimensionlArray = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        Console.WriteLine("Los elementos de la matriz son: ");
        // Recorrido por filas y columnas usando indices
        for (int i = 0; i < TwoDimensionlArray.GetLength(0); i++) {
            for (int j = 0; j < TwoDimensionlArray.GetLength(1); j++) {
                Console.Write(TwoDimensionlArray[i, j] + " "); // Mostrando los elementos de la fila separados por espacios
            }
            Console.WriteLine(); // Ir a la siguiente línea después de mostrar una fila
        }
    }
}
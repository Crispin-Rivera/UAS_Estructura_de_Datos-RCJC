// Implementación en C# de una matriz tridimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;

class Program {
    static void Main() {
        // Declaración e inicialización de la matriz tridimensional (3D)
        int[,,] ThreeDimensionalArray = {
            {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
            },
            {
                { 10, 11, 12 },
                { 13, 14, 15 },
                { 16, 17, 18 }
            }
        };

        Console.WriteLine("Los elementos de la matriz son: ");
        // Recorrido por capas, filas y columnas mediante índices
        for (int i = 0; i < ThreeDimensionalArray.GetLength(0); i++) {
            for (int j = 0; j < ThreeDimensionalArray.GetLength(1); j++) {
                for (int k = 0; k < ThreeDimensionalArray.GetLength(2); k++) {
                    Console.Write(ThreeDimensionalArray[i, j, k] + " "); // Mostrando los elementos separados por espacios
                }
                Console.WriteLine(); // Ir a la siguiente línea después de mostrar una fila
            }
            Console.WriteLine(); // Espacio entre capas/matrices bidimensionales
        }
    }
}
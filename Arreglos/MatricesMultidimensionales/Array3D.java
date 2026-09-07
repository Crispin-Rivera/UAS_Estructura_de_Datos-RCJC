// Implementación en Java de una matriz tridimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

public class Array3D {
    public static void main(String[] args) {
        // Declaración e inicialización de la matriz tridimensional (3D)
        int[][][] ThreeDimensionalArray = {
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            {
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}
            }
        };

        System.out.println("Los elementos de la matriz son: ");
        // Recorrido por matrices bidimensionales (capas)
        for (int[][] TwoDimensionalArray : ThreeDimensionalArray) {
            // Recorrido por filas
            for (int[] row : TwoDimensionalArray) {
                // Recorrido por elementos individuales
                for (int element : row) {
                    System.out.print(element + " "); // Mostrando los elementos de la fila separados por espacios
                }
                System.out.println(); // Ir a la siguiente línea después de mostrar una fila
            }
            System.out.println(); // Espacio entre capas/matrices bidimensionales
        }
    }
}
// Implementación en Java de una matriz bidimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

public class Array2D {
    public static void main(String[] args) {
        // Declaración e inicialización de la matriz bidimensional
        int[][] TwoDimensionlArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Los elementos de la matriz son: ");
        // Recorrido por filas
        for (int[] row : TwoDimensionlArray) {
            // Recorrido por elementos dentro de la fila
            for (int element : row) {
                System.out.print(element + " "); // Mostrando los elementos de la fila separados por espacios
            }
            System.out.println(); // Ir a la siguiente línea después de mostrar una fila
        }
    }
}
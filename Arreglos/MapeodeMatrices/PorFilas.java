// Aplanamiento de Matriz Bidimensional a Unidimensional en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

public class PorFilas {
    public static void main(String[] args) {
        int r = 3, c = 3;
        int[] arr = new int[r * c];

        // Matriz inicializada
        int[][] TwoDArr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }; // Almacenar elementos en un array unidimensional ordenados por filas

        int k = 0;
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                k = x * r + y;
                arr[k] = TwoDArr[x][y];
                k = k + 1;
            }
        }

        System.out.println("Los elementos del array bidimensional son: ");
        for (int[] row : TwoDArr) {
            for (int ele : row) {
                System.out.print(ele + " "); // Mostrar los elementos de la fila separados por espacios
            }
            System.out.println(); // Ir a la siguiente línea después de mostrar una fila
        }

        System.out.println("\nLos elementos del array unidimensional son: ");
        // Imprimir los elementos del array unidimensional
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                System.out.print(arr[x * r + y] + " ");
            }
        }
        System.out.println();
    }
}
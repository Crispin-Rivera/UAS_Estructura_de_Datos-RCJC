// Recorrido Inverso de un Arreglo en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

public class RecorridoI {
    public static void main(String[] args) {
        int[] arr = {40, 50, 60, 70, 80, 90};

        System.out.print("Recorrido inverso del array: ");
        System.out.print("\nLos elementos del array son: ");
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            System.out.print(arr[idx] + " ");
        }
        System.out.println();
    }
}
// Programa para eliminar un elemento al final en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;
import java.util.Arrays;

public class AlFinal {
    public static void main(String[] args) {
        // Declaración e inicialización del ArrayList
        ArrayList<Integer> inputArr = new ArrayList<>(Arrays.asList(11, 21, 31, 41, 51, 61));

        // Imprimir el arreglo antes de eliminar
        System.out.println("Antes de eliminar, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }

        // Eliminando el último elemento con remove pasándole la última posición
        inputArr.remove(inputArr.size() - 1);

        // Imprimir el arreglo después de eliminar
        System.out.println("\nDespués de eliminar, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }
        System.out.println();
    }
}
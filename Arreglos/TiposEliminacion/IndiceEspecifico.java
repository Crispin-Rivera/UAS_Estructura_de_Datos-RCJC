// Programa para eliminar un elemento en un índice específico en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;
import java.util.Arrays;

public class IndiceEspecifico {
    public static void main(String[] args) {
        // Declaración e inicialización del ArrayList
        ArrayList<Integer> inputArr = new ArrayList<>(Arrays.asList(11, 21, 31, 41, 51, 61));
        int position = 3; // Índice desde el que se realizará la eliminación

        // Imprimir el arreglo antes de la eliminación
        System.out.println("Antes de la eliminación, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }

        // Eliminación del elemento en el índice indicado (posición 3)
        inputArr.remove(position);

        // Imprimir el arreglo después de la eliminación
        System.out.println("\nDespués de la eliminación, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }
        System.out.println();
    }
}
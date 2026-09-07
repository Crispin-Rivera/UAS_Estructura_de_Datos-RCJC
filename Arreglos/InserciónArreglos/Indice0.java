// Inserción en el índice 0 de un Arreglo en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;
import java.util.Arrays;

public class Indice0 {
    public static void main(String[] args) {
        ArrayList<Integer> inputArr = new ArrayList<>(Arrays.asList(11, 21, 31, 41, 51, 61));
        int ele = 52;

        System.out.println("Antes de la inserción, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }

        // Inserción del elemento en el índice 0
        inputArr.add(0, ele);

        System.out.println("\nDespués de la inserción, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }
        System.out.println();
    }
}
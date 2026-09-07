// Inserción de un elemento al final del array en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;
import java.util.Arrays;

public class AlFinal {
    public static void main(String[] args) {
        ArrayList<Integer> inputArr = new ArrayList<>(Arrays.asList(11, 21, 31, 41, 51, 61));
        int ele = 52;

        System.out.println("Antes de la inserción, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }

        // Inserción del elemento al final
        inputArr.add(ele);

        System.out.println("\nDespués de la inserción, el array es: ");
        for (int j = 0; j < inputArr.size(); j++) {
            System.out.print(inputArr.get(j) + " ");
        }
        System.out.println();
    }
}
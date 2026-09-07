//Programa para eliminar un elemento al principio del array
//Autor: Rivera Cota Jesús Crispín
//FACULTAD DE INGENIERÍA LOS MOCHIS
//Ing. de Software 201

import java.util.Arrays;

public class TiposElim {
    public static void main(String[] args) {
        int[] array = {11, 21, 31, 41, 51, 61};
        System.out.println("El array antes de eliminar el elemento es: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        array = Arrays.copyOfRange(array, 1, array.length);
        System.out.println("\nDespúes de la eliminación, el array es: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


// Búsqueda Lineal de un Arreglo en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;
import java.util.Arrays;

public class BusquedaL {
    // Función para realizar la búsqueda lineal
    public static int findEle(ArrayList<Integer> inputArr, int s, int targetEle) {
        for (int j = 0; j < s; j++) {
            if (inputArr.get(j) == targetEle) { // Aplicando búsqueda lineal
                return j; // Elemento encontrado en el índice j
            }
        }
        // No se encuentra el elemento objetivo
        return -1;
    }

    public static void main(String[] args) {
        // Declaración del arreglo y definición del objetivo
        ArrayList<Integer> inputArr = new ArrayList<>(Arrays.asList(12, 34, 10, 6, 40, 89, 98, 57, 19, 69));
        int targetElement = 40;
        int s = inputArr.size();

        // Operación de búsqueda
        int idx = findEle(inputArr, s, targetElement);
        if (idx != -1) {
            System.out.println("El elemento se encuentra en la posición: " + (idx + 1));
        } else {
            System.out.println("No se encuentra el elemento.");
        }
    }
}

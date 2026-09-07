// Búsqueda Binaria de un Arreglo en Java
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;
import java.util.Arrays;

public class BBinaria {
    // Función para realizar la búsqueda binaria
    public static int findEle(ArrayList<Integer> arr, int l, int h, int targetValue) {
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Verificar si targetValue está presente en mid
            if (arr.get(mid) == targetValue) {
                return mid;
            }

            // Si targetValue es mayor que el elemento mid, considerar la segunda mitad del array
            if (arr.get(mid) < targetValue) {
                l = mid + 1;
            } 
            // Si targetValue es menor que el elemento mid, considerar la primera mitad del array
            else {
                h = mid - 1;
            }
        }

        // Si el control llega hasta aquí, significa que el elemento buscado no está presente en el array
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inputArr = new ArrayList<>(Arrays.asList(6, 10, 12, 19, 34, 40, 57, 69, 89, 98)); // Arreglo ordenado
        int targetElement = 40; // Elemento objetivo a encontrar
        int s = inputArr.size(); // Tamaño del array

        // Operación de búsqueda
        int idx = findEle(inputArr, 0, s - 1, targetElement);
        if (idx != -1) {
            System.out.println("El elemento se encuentra en la posición: " + (idx + 1));
        } else {
            System.out.println("El elemento no se encuentra.");
        }
    }
}
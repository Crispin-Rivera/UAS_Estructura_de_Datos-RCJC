// Ordenamiento Burbuja
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;

public class BubbleSort {
    //Definimos la Función para el ordenamiento burbuja
    public static void bubblesort (ArrayList<Integer> inputArr, int s){
        for (int i = 0; i < s-1; i++){
            for (int j = 0; j < s-i-1; j++){
                if (inputArr.get(j) > inputArr.get(j+1)){
                    // Intercambiamos los elementos
                    int temp = inputArr.get(j);
                    inputArr.set(j, inputArr.get(j+1));
                    inputArr.set(j+1, temp);
                }
            }
        }
    }
    //Función Prinicipal
    public static void main(String[]args){
        //Declaramos el arreglo
        ArrayList<Integer> inputArr = new ArrayList<>();
        inputArr.add(15);
        inputArr.add(16);
        inputArr.add(11);
        inputArr.add(13);
        inputArr.add(14);
        int s = inputArr.size();
        //Imprimimos el arreglo original
        System.out.println("Antes de ordenar los elementos el arreglo es: " + inputArr);
        bubblesort(inputArr, s);
        //Imprimimos el arreglo ordenado
        System.out.println("Y despues de usar el algoritmo de ordenamiento burbuja: " + inputArr);
    }

}
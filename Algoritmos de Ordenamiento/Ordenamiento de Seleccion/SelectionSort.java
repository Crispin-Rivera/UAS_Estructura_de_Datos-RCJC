// Ordenamiento por selección
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;

public class SelectionSort{
    //Definimos la Función para el ordenamiento por selección
    public static void SelectionSort(ArrayList<Integer> inputArrayList, int s){
        for (int i = 0; i < s-1; i++){
            for (int j = i+1; j < s; j++){
                if (inputArrayList.get(i) > inputArrayList.get(j)){
                    // Intercambiamos los elementos
                    int temp = inputArrayList.get(i);
                    inputArrayList.set(i, inputArrayList.get(j));
                    inputArrayList.set(j, temp);
                }
            }
        }
    }
    //Función Prinicipal
    public static void main(String[]args){
        //Declaramos el arreglo
        ArrayList<Integer> inputArrayList = new ArrayList<>();
        inputArrayList.add(65);
        inputArrayList.add(26);
        inputArrayList.add(13);
        inputArrayList.add(23);
        inputArrayList.add(12);
        int s = inputArrayList.size();
        //Imprimimos el arreglo original
        System.out.println("Antes de ordenar los elementos el arreglo es: " + inputArrayList);
        SelectionSort(inputArrayList, s);
        //Imprimimos el arreglo ordenado
        System.out.println("Y despues de usar el algoritmo de ordenamiento por selección: " + inputArrayList);
    }
}
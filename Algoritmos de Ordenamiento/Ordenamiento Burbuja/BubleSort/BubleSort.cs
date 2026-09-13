// Ordenamiento Burbuja
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program
{
    // Función para realizar el ordenamiento burbuja
    static void BubbleSort(int[] arr)
    {
        int n = arr.Length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // Intercambiar arr[j] y arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Cuerpo principal del programa
    static void Main()
    {
        //declaracion del arreglo
        int[] arr = {15, 16, 11, 13, 14};
        Console.WriteLine("Antes de ordenar los elementos del array son: " + string.Join(", ", arr));
        //llamada a la funcion de ordenamiento burbuja
        BubbleSort(arr);
        Console.WriteLine("\nDespués de ordenar los elementos del array son: " + string.Join(", ", arr));
    }

}
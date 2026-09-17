// Ordenamiento por selección
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;
using System.Collections.Generic;

class Program
{
    static void selectionsort(int[] arr)
    {
        int s = arr.Length;
        for (int i = 0; i < s-1; i++)
        {
            for (int j = 0; j < s-1; j++)
            {
                int small = i;
                for (j = i + 1; j < s; j++)
                {
                    if (arr[j] < arr[small])
                    {
                        small = j;  
                    }
                }
                if (small != i)
                {
                    int temp = arr[small];
                    arr[small] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
        // Cuerpo principal del programa
    static void Main()
    {
        //declaracion del arreglo
        int[] arr = {65, 26, 13, 23, 12};
        Console.WriteLine("Antes de ordenar los elementos del array son: " + string.Join(", ", arr));
        //llamada a la funcion de ordenamiento burbuja
        selectionsort(arr);
        Console.WriteLine("\nDespués de ordenar los elementos del array son: " + string.Join(", ", arr));
    }
}
// Ordenamiento Rapido (quicksort)
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

using System;

class Program {
    static void Swap(int[] a, int j, int k) {
        int temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    static int Partition(int[] a, int l, int h) {
        int pvt = a[h];
        int j = l - 1;
        for (int k = l; k < h; k++) {
            if (a[k] < pvt) {
                j++;
                Swap(a, j, k);
            }
        }
        Swap(a, j + 1, h);
        return j + 1;
    }

    static void Qcksort(int[] a, int l, int h) {
        if (l < h) {
            int pi = Partition(a, l, h);
            Qcksort(a, l, pi - 1);
            Qcksort(a, pi + 1, h);
        }
    }

    static void Main() {
        int[] a = {10, 7, 8, 9, 1, 5};
        int size = a.Length;

        Console.WriteLine("El arreglo antes de ordenarlo es: ");
        foreach (int v in a) {
            Console.Write(v + " ");
        }
        Console.WriteLine();

        Qcksort(a, 0, size - 1);

        Console.WriteLine("El arreglo despues de ordenarlo: ");
        foreach (int v in a) {
            Console.Write(v + " ");
        }
        Console.WriteLine();
    }
}
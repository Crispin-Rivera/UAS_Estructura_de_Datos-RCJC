// Ordenamiento Rapido (quicksort)
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

public class QuickSort {

    static void swap(int[] a, int j, int k) {
        int temp = a[j];
        a[j] = a[k];
        a[k] = temp;
    }

    static int partition(int[] a, int l, int h) {
        int pvt = a[h];
        int j = l - 1;
        for (int k = l; k < h; k++) {
            if (a[k] < pvt) {
                j++;
                swap(a, j, k);
            }
        }
        swap(a, j + 1, h);
        return j + 1;
    }

    static void qcksort(int[] a, int l, int h) {
        if (l < h) {
            int pi = partition(a, l, h);
            qcksort(a, l, pi - 1);
            qcksort(a, pi + 1, h);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 7, 8, 9, 1, 5};
        int size = a.length;

        System.out.println("El arreglo antes de ordenarlo es: ");
        for (int v : a) {
            System.out.print(v + " ");
        }
        System.out.println();

        qcksort(a, 0, size - 1);

        System.out.println("El arreglo despues de ordenarlo: ");
        for (int v : a) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
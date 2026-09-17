// Ordenamiento Rapido (quicksort)
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

function swap(a, j, k) {
    let temp = a[j];
    a[j] = a[k];
    a[k] = temp;
}

function partition(a, l, h) {
    let pvt = a[h];
    let j = l - 1;
    for (let k = l; k < h; k++) {
        if (a[k] < pvt) {
            j++;
            swap(a, j, k);
        }
    }
    swap(a, j + 1, h);
    return j + 1;
}

function qcksort(a, l, h) {
    if (l < h) {
        let pi = partition(a, l, h);
        qcksort(a, l, pi - 1);
        qcksort(a, pi + 1, h);
    }
}

function main() {
    let a = [10, 7, 8, 9, 1, 5];
    let size = a.length;

    console.log("El arreglo antes de ordenarlo es: ");
    console.log(a.join(" "));

    qcksort(a, 0, size - 1);

    console.log("El arreglo despues de ordenarlo: ");
    console.log(a.join(" "));
}

main();
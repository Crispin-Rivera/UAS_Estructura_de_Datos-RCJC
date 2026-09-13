// Ordenamiento Burbuja
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

let arr = [15, 16, 11, 13, 14];

// Función para realizar el ordenamiento burbuja
function bubbleSort(arr) {
    let n = arr.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Intercambiar arr[j] y arr[j + 1]
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
}

console.log("Antes de ordenar los elementos del array son: " + arr);
let sortedArr = bubbleSort(arr);
console.log("\nDespués de ordenar los elementos del array son: " + sortedArr);
// Ordenamiento por selección
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

let arr = [65, 26, 13, 23, 12]
//Definimos la función para el ordenamiento por selección
function selectionSort(arr) {
    let n = arr.length;
    for (let i = 0; i < n - 1; i++){
        let minIndex = i;
        for (let j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        // Intercambiar el elemento mínimo con el primer elemento
        [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
    }
    return arr;
}

console.log("Antes de ordenar los elementos del array son: " + arr);
const sortedArr = selectionSort(arr);
console.log("\nDespués de ordenar los elementos del array son: " + sortedArr);
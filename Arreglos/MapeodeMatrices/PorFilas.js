// Aplanamiento de Matriz Bidimensional a Unidimensional en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

let r = 3, c = 3;
let arr = new Array(r * c).fill(0);

// Matriz inicializada
let TwoDArr = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]; // Almacenar elementos en un array unidimensional ordenados por filas

let k = 0;
for (let x = 0; x < r; x++) {
    for (let y = 0; y < c; y++) {
        k = x * r + y;
        arr[k] = TwoDArr[x][y];
        k = k + 1;
    }
}

console.log("Los elementos del array bidimensional son: ");
for (let row of TwoDArr) {
    for (let ele of row) {
        process.stdout.write(ele + " "); // Mostrar los elementos de la fila separados por espacios
    }
    console.log(); // Ir a la siguiente línea después de mostrar una fila
}

console.log("\nLos elementos del array unidimensional son: ");
// Imprimir los elementos del array unidimensional
for (let x = 0; x < r; x++) {
    for (let y = 0; y < c; y++) {
        process.stdout.write(arr[x * r + y] + " ");
    }
}
console.log();
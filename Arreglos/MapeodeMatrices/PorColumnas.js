// Aplanamiento de Matriz 2D a 1D por COLUMNAS en JavaScript
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
];

// Almacenar elementos en un array unidimensional ordenados por COLUMNAS
for (let x = 0; x < r; x++) {
    for (let y = 0; y < c; y++) {
        let k = y * r + x; // Fórmula por columnas
        arr[k] = TwoDArr[x][y];
    }
}

console.log("Los elementos del array bidimensional son: ");
for (let row of TwoDArr) {
    for (let ele of row) {
        process.stdout.write(ele + " ");
    }
    console.log();
}

console.log("\nLos elementos del array unidimensional (por columnas) son: ");
// Imprimir los elementos recorriendo en orden por columnas
for (let y = 0; y < c; y++) {
    for (let x = 0; x < r; x++) {
        process.stdout.write(arr[y * r + x] + " ");
    }
}
console.log();
// Implementación en JavaScript de una matriz bidimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

// Declaración e inicialización de la matriz bidimensional
let TwoDimensionlArray = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];

console.log("Los elementos de la matriz son: ");
// Recorrido por filas
for (let row of TwoDimensionlArray) {
    // Recorrido por elementos dentro de la fila
    for (let element of row) {
        process.stdout.write(element + " "); // Mostrando los elementos de la fila separados por espacios
    }
    console.log(); // Ir a la siguiente línea después de mostrar una fila
}
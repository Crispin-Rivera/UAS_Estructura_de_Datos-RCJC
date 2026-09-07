// Implementación en JavaScript de una matriz tridimensional
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

// Declaración e inicialización de la matriz tridimensional (3D)
let ThreeDimensionalArray = [
    [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ],
    [
        [10, 11, 12],
        [13, 14, 15],
        [16, 17, 18]
    ]
];

console.log("Los elementos de la matriz son: ");
// Recorrido por matrices bidimensionales (capas)
for (let TwoDimensionalArray of ThreeDimensionalArray) {
    // Recorrido por filas
    for (let row of TwoDimensionalArray) {
        // Recorrido por elementos individuales
        for (let element of row) {
            process.stdout.write(element + " "); // Mostrando los elementos de la fila separados por espacios
        }
        console.log(); // Ir a la siguiente línea después de mostrar una fila
    }
    console.log(); // Espacio entre capas/matrices bidimensionales
}
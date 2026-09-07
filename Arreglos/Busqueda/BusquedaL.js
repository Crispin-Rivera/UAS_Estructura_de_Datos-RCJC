// Búsqueda Lineal de un Arreglo en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

// Función para realizar la búsqueda lineal
function findEle(inputArr, s, targetEle) {
    for (let j = 0; j < s; j++) {
        if (inputArr[j] === targetEle) { // Aplicando búsqueda lineal
            return j; // Elemento encontrado en el índice j
        }
    }
    // No se encuentra el elemento objetivo
    return -1;
}

// Declaración del arreglo y definición del objetivo
let inputArr = [12, 34, 10, 6, 40, 89, 98, 57, 19, 69];
let targetElement = 40;
let s = inputArr.length;

// Operación de búsqueda
let idx = findEle(inputArr, s, targetElement);
if (idx !== -1) {
    console.log("El elemento se encuentra en la posición: " + (idx + 1));
} else {
    console.log("No se encuentra el elemento.");
}

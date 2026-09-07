// Búsqueda Binaria de un Arreglo en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

// Función para realizar la búsqueda binaria
function findEle(arr, l, h, targetValue) {
    while (l <= h) {
        let mid = Math.floor(l + (h - l) / 2);

        // Verificar si targetValue está presente en mid
        if (arr[mid] === targetValue) {
            return mid;
        }

        // Si targetValue es mayor que el elemento mid, considerar la segunda mitad del array
        if (arr[mid] < targetValue) {
            l = mid + 1;
        } 
        // Si targetValue es menor que el elemento mid, considerar la primera mitad del array
        else {
            h = mid - 1;
        }
    }

    // Si el control llega hasta aquí, significa que el elemento buscado no está presente en el array
    return -1;
}

// Arreglo ordenado de entrada
let inputArr = [6, 10, 12, 19, 34, 40, 57, 69, 89, 98]; 
let targetElement = 40; // Elemento objetivo a encontrar
let s = inputArr.length; // Tamaño del array

// Operación de búsqueda
let idx = findEle(inputArr, 0, s - 1, targetElement);
if (idx !== -1) {
    console.log("El elemento se encuentra en la posición: " + (idx + 1));
} else {
    console.log("El elemento no se encuentra.");
}
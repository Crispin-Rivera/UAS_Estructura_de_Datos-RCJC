// Programa para eliminar un elemento al final en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

// Declaración e inicialización del arreglo
let inputArr = [11, 21, 31, 41, 51, 61];

// Imprimir el arreglo antes de eliminar
console.log("Antes de eliminar, el array es: ");
for (let j = 0; j < inputArr.length; j++) {
    process.stdout.write(inputArr[j] + " ");
}

// Eliminando el elemento al final con pop()
inputArr.pop();

// Imprimir el arreglo después de eliminar
console.log("\nDespués de eliminar, el array es: ");
for (let j = 0; j < inputArr.length; j++) {
    process.stdout.write(inputArr[j] + " ");
}
console.log();
// Programa para eliminar un elemento en un índice específico en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

// Declaración e inicialización del arreglo
let inputArr = [11, 21, 31, 41, 51, 61];
let position = 3; // Índice desde el que se realizará la eliminación

// Imprimir el arreglo antes de la eliminación
console.log("Antes de la eliminación, el array es: ");
for (let j = 0; j < inputArr.length; j++) {
    process.stdout.write(inputArr[j] + " ");
}

// Eliminación del elemento en el índice indicado (elimina 1 elemento en el índice position)
inputArr.splice(position, 1);

// Imprimir el arreglo después de la eliminación
console.log("\nDespués de la eliminación, el array es: ");
for (let j = 0; j < inputArr.length; j++) {
    process.stdout.write(inputArr[j] + " ");
}
console.log();
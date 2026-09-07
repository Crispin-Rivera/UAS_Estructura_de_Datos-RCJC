// Inserción de un elemento en un índice específico en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

let inputArr = [11, 21, 31, 41, 51, 61];
let ele = 52;

console.log("Antes de la inserción, el array es: ");
for (let j = 0; j < inputArr.length; j++) {
    process.stdout.write(inputArr[j] + " ");
}

// Inserción del elemento en el tercer índice
inputArr.splice(3, 0, ele);

console.log("\nDespués de la inserción, el array es: ");
for (let j = 0; j < inputArr.length; j++) {
    process.stdout.write(inputArr[j] + " ");
}
console.log();
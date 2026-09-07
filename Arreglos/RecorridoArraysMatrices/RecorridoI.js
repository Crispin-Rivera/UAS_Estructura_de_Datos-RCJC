// Recorrido Inverso de un Arreglo en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

const arr = [40, 50, 60, 70, 80, 90];

process.stdout.write("Recorrido inverso del array: ");
process.stdout.write("\nLos elementos del array son: ");
for (let idx = arr.length - 1; idx >= 0; idx--) {
    process.stdout.write(arr[idx] + " ");
}
console.log();
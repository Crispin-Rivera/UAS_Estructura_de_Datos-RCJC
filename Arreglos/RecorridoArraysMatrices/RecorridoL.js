// Recorrido Lineal de un Arreglo en JavaScript
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

const arr = [40, 50, 60, 70, 80, 90];

process.stdout.write("Recorrido lineal (secuencial): ");
process.stdout.write("\nLos elementos del array son: ");
for (let idx of arr) {
    process.stdout.write(idx + " ");
}
console.log();
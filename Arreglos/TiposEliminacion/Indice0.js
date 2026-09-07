//Programa para eliminar un elemento al principio del array
//Autor: Rivera Cota Jesús Crispín
//FACULTAD DE INGENIERÍA LOS MOCHIS
//Ing. de Software 201

const array = [11, 21, 31, 41, 51, 61]
//console.log("Antes de la eliminación, el array es: ", array)
//array.splice(0, 1) // Elimina el elemento en el índice 1
//console.log("Después de la eliminación, el array es: ", array)
console.log("Antes de la eliminación, el array es: ")
for (let i = 0; i < array.length; i++){
    console.log(array[i])
}
array = array.slice(0, 1); // Elimina el elemento en el índice 1
console.log("Después de la eliminación, el array es: ")
for (let i = 0; i < array.length; i++){
    console.log(array[i])
}
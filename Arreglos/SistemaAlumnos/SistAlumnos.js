// Arreglo de arreglos (matriz de 5x3)
const alumnos = [
    ["Ana", "101", "9.5"],
    ["Carlos", "102", "8.0"],
    ["Elena", "101", "10.0"],
    ["David", "103", "7.5"],
    ["Sofia", "102", "9.1"]
];

console.log("--- SISTEMA ESCOLAR (JavaScript) ---");
alumnos.forEach(alumno => {
    console.log(`Alumno: ${alumno[0]} | Salon: ${alumno[1]} | Promedio: ${alumno[2]}`);
});
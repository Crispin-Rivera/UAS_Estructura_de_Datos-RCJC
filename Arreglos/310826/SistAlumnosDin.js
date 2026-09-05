const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const alumnos = [];
let i = 0;

console.log("--- INGRESO DE DATOS (JavaScript) ---");

function pedirDatos() {
    if (i < 5) {
        console.log(`\nAlumno ${i + 1}:`);
        rl.question("  Nombre: ", (nombre) => {
            rl.question("  Salon: ", (salon) => {
                rl.question("  Promedio: ", (promedio) => {
                    alumnos.push([nombre, salon, promedio]);
                    i++;
                    pedirDatos();
                });
            });
        });
    } else {
        console.log("\n--- DATOS REGISTRADOS ---");
        alumnos.forEach(alumno => {
            console.log(`Alumno: ${alumno[0]} | Salon: ${alumno[1]} | Promedio: ${alumno[2]}`);
        });
        rl.close();
    }
}

pedirDatos();
#include <iostream>
#include <string>

int main() {
    // Matriz de 5 filas por 3 columnas
    std::string alumnos[5][3] = {
        {"Ana", "101", "9.5"},
        {"Carlos", "102", "8.0"},
        {"Elena", "101", "10.0"},
        {"David", "103", "7.5"},
        {"Sofia", "102", "9.1"}
    };

    std::cout << "--- SISTEMA ESCOLAR (C++) ---\n";
    for (int i = 0; i < 5; i++) {
        std::cout << "Alumno: " << alumnos[i][0] 
                  << " | Salon: " << alumnos[i][1] 
                  << " | Promedio: " << alumnos[i][2] << std::endl;
    }

    return 0;
}
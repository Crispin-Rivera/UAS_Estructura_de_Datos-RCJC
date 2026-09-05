#include <iostream>
#include <string>

int main() {
    std::string alumnos[5][3];

    std::cout << "--- INGRESO DE DATOS (C++) ---\n";
    for (int i = 0; i < 5; i++) {
        std::cout << "Alumno " << (i + 1) << ":\n";
        std::cout << "  Nombre: ";
        std::cin >> alumnos[i][0];
        std::cout << "  Salon: ";
        std::cin >> alumnos[i][1];
        std::cout << "  Promedio: ";
        std::cin >> alumnos[i][2];
    }

    std::cout << "\n--- DATOS REGISTRADOS ---\n";
    for (int i = 0; i < 5; i++) {
        std::cout << "Alumno: " << alumnos[i][0] 
                  << " | Salon: " << alumnos[i][1] 
                  << " | Promedio: " << alumnos[i][2] << std::endl;
    }

    return 0;
}
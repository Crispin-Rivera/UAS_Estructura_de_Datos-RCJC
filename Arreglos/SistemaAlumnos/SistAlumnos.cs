using System;

class SistAlumnos {
        static void Main() {
        // Matriz bidimensional de 5x3 en C#
        string[,] alumnos = new string[5, 3] {
            {"Ana", "101", "9.5"},
            {"Carlos", "102", "8.0"},
            {"Elena", "101", "10.0"},
            {"David", "103", "7.5"},
            {"Sofia", "102", "9.1"}
        };

        Console.WriteLine("--- SISTEMA ESCOLAR (C#) ---");
        for (int i = 0; i < 5; i++) {
            Console.WriteLine($"Alumno: {alumnos[i, 0]} | Salon: {alumnos[i, 1]} | Promedio: {alumnos[i, 2]}");
        }
    }
}
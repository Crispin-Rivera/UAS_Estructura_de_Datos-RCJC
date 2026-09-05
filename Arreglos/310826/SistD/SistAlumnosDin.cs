using System;

class SistAlumnosDin {
    static void Main() {
        string[,] alumnos = new string[5, 3];

        Console.WriteLine("--- INGRESO DE DATOS (C#) ---");
        for (int i = 0; i < 5; i++) {
            Console.WriteLine($"Alumno {i + 1}:");
            Console.Write("  Nombre: ");
            alumnos[i, 0] = Console.ReadLine();
            Console.Write("  Salon: ");
            alumnos[i, 1] = Console.ReadLine();
            Console.Write("  Promedio: ");
            alumnos[i, 2] = Console.ReadLine();
        }

        Console.WriteLine("\n--- DATOS REGISTRADOS ---");
        for (int i = 0; i < 5; i++) {
            Console.WriteLine($"Alumno: {alumnos[i, 0]} | Salon: {alumnos[i, 1]} | Promedio: {alumnos[i, 2]}");
        }
    }
}
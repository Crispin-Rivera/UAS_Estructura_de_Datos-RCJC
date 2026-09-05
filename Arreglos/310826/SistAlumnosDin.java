import java.util.Scanner;

public class SistAlumnosDin{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] alumnos = new String[5][3];

        System.out.println("--- INGRESO DE DATOS (Java) ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Alumno " + (i + 1) + ":");
            System.out.print("  Nombre: ");
            alumnos[i][0] = scanner.nextLine();
            System.out.print("  Salon: ");
            alumnos[i][1] = scanner.nextLine();
            System.out.print("  Promedio: ");
            alumnos[i][2] = scanner.nextLine();
        }

        System.out.println("\n--- DATOS REGISTRADOS ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Alumno: " + alumnos[i][0] + 
                               " | Salon: " + alumnos[i][1] + 
                               " | Promedio: " + alumnos[i][2]);
        }
        
        scanner.close();
    }
}
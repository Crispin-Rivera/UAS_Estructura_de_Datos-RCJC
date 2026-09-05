public class SistAlumn {
    public static void main(String[] args) {
        // Matriz de 5 filas por 3 columnas
        String[][] alumnos = {
            {"Ana", "101", "9.5"},
            {"Carlos", "102", "8.0"},
            {"Elena", "101", "10.0"},
            {"David", "103", "7.5"},
            {"Sofia", "102", "9.1"}
        };

        System.out.println("--- SISTEMA ESCOLAR (Java) ---");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Alumno: " + alumnos[i][0] + 
                               " | Salon: " + alumnos[i][1] + 
                               " | Promedio: " + alumnos[i][2]);
        }
    }
}
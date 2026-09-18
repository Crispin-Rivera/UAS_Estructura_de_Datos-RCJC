// Juego de Damas
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.ArrayList;
import java.util.Scanner;

public class P1_Damas {

    // Tablero 8x8
    static String[][] tablero = new String[8][8];
    
    // Control de turno (1 = Jugador X, 2 = Jugador O)
    static int turno = 1;

    // Lista dinámica para guardar el historial de la partida de forma ilimitada
    static ArrayList<String> historial = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner escaner = new Scanner(System.in)) {
            // Prepara las fichas en el tablero
            resetTablero();
            
            boolean jugando = true;
            
            // BUCLE PRINCIPAL DE LA PARTIDA
            while (jugando) {
                imprimirTablero();
                
                // 1. Validar condición de victoria / derrota antes de solicitar turno
                if (verificarFinPartida()) {
                    break; // Termina la partida si un jugador perdió o no tiene movimientos
                }
                
                System.out.println("\nTurno del Jugador " + (turno == 1 ? "X" : "O"));
                System.out.println("Escribe 0 en la Fila de origen para ir al MENÚ.");
                
                // Pedir coordenadas de forma segura (valida números y rango de 0 a 8)
                int filaOrigen = leerCoordenada(escaner, "Fila origen (1-8): ") - 1;
                if (filaOrigen == -1) break; // Terminar partida si escribe 0 para ir al menú
                
                int colOrigen = leerCoordenada(escaner, "Columna origen (1-8): ") - 1;
                int filaDestino = leerCoordenada(escaner, "Fila destino (1-8): ") - 1;
                int colDestino = leerCoordenada(escaner, "Columna destino (1-8): ") - 1;
                
                // Validar e intentar realizar el movimiento
                if (mover(filaOrigen, colOrigen, filaDestino, colDestino)) {
                    // Registrar el movimiento exitoso en la lista del historial
                    String registro = "Jugador " + (turno == 1 ? "X" : "O") + ": (" + (filaOrigen + 1) + "," + (colOrigen + 1) + ") -> (" + (filaDestino + 1) + "," + (colDestino + 1) + ")";
                    historial.add(registro);
                    
                    // Cambiar el turno entre Jugador 1 (X) y Jugador 2 (O)
                    turno = (turno == 1) ? 2 : 1;
                } else {
                    System.out.println(">> ¡Movimiento no válido! Intenta de nuevo.");
                }
            }
            
            // MENÚ FINAL
            boolean enMenu = true;
            while (enMenu) {
                System.out.println("\n==============================");
                System.out.println("        MENÚ PRINCIPAL        ");
                System.out.println("==============================");
                System.out.println("1. Ver reproducción de la partida");
                System.out.println("2. Salir del juego");
                
                int opcion = leerCoordenada(escaner, "Selecciona una opción (1-2): ");
                
                switch (opcion) {
                    case 1 -> reproducirPartida();
                    case 2 -> {
                        System.out.println("\n¡Gracias por jugar! Saliendo del programa...");
                        enMenu = false; // Sale del ciclo del menú
                    }
                    default -> System.out.println(">> Opción no válida. Ingresa 1 o 2.");
                }
            }
        }
    }

    // Método para validar que la entrada sea numérica y esté dentro del rango permitido (0 a 8)
    public static int leerCoordenada(Scanner escaner, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (!escaner.hasNextInt()) {
                System.out.println(">> ¡Entrada no válida! Debes ingresar solo números.");
                escaner.next(); // Descarta el carácter no válido
                continue;
            }
            valor = escaner.nextInt();
            if (valor < 0 || valor > 8) {
                System.out.println(">> ¡Número fuera de rango! Ingresa un valor entre 1 y 8 (o 0 para salir al menú).");
                continue;
            }
            break;
        }
        return valor;
    }

    // Llenar el tablero con casillas jugables ('x', 'o', ' ') e inválidas ('■')
    public static void resetTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                if ((fila + col) % 2 == 1) {
                    if (fila < 3) {
                        tablero[fila][col] = "o"; // Fichas del Jugador 2
                    } else if (fila > 4) {
                        tablero[fila][col] = "x"; // Fichas del Jugador 1
                    } else {
                        tablero[fila][col] = " "; // Casilla libre jugable
                    }
                } else {
                    tablero[fila][col] = "■"; // Casilla no jugable
                }
            }
        }
    }

    // Mostrar el tablero en consola con formato de corchetes
    public static void imprimirTablero() {
        System.out.println("\n    1  2  3  4  5  6  7  8");
        for (int fila = 0; fila < 8; fila++) {
            System.out.print(" " + (fila + 1) + " ");
            for (int col = 0; col < 8; col++) {
                System.out.print("[" + tablero[fila][col] + "]");
            }
            System.out.println();
        }
    }

    // Valida y ejecuta el desplazamiento o captura de fichas
    public static boolean mover(int fila1, int col1, int fila2, int col2) {
        if (fila1 < 0 || fila1 > 7 || col1 < 0 || col1 > 7 || fila2 < 0 || fila2 > 7 || col2 < 0 || col2 > 7) {
            return false;
        }

        String ficha = tablero[fila1][col1];

        if (turno == 1 && !ficha.equals("x") && !ficha.equals("R")) return false;
        if (turno == 2 && !ficha.equals("o") && !ficha.equals("Q")) return false;

        if (!tablero[fila2][col2].equals(" ")) return false;

        int dFila = fila2 - fila1;
        int dCol = col2 - col1;

        boolean esReyna = ficha.equals("R") || ficha.equals("Q");

        if (!esReyna) {
            if (Math.abs(dFila) == 1 && Math.abs(dCol) == 1) {
                if (ficha.equals("x") && dFila != -1) return false;
                if (ficha.equals("o") && dFila != 1) return false;

                tablero[fila2][col2] = ficha;
                tablero[fila1][col1] = " ";
                revisarCoronacion(fila2, col2);
                return true;
            }

            if (Math.abs(dFila) == 2 && Math.abs(dCol) == 2) {
                if (ficha.equals("x") && dFila != -2) return false;
                if (ficha.equals("o") && dFila != 2) return false;

                int filaMedio = (fila1 + fila2) / 2;
                int colMedio = (col1 + col2) / 2;
                String intermedia = tablero[filaMedio][colMedio];

                boolean esEnemigo = false;
                if (turno == 1 && (intermedia.equals("o") || intermedia.equals("Q"))) esEnemigo = true;
                if (turno == 2 && (intermedia.equals("x") || intermedia.equals("R"))) esEnemigo = true;

                if (esEnemigo) {
                    tablero[fila2][col2] = ficha;
                    tablero[fila1][col1] = " ";
                    tablero[filaMedio][colMedio] = " ";
                    System.out.println(">> ¡Pieza capturada!");
                    revisarCoronacion(fila2, col2);
                    return true;
                }
            }
            return false;
        }

        if (Math.abs(dFila) != Math.abs(dCol)) return false;

        int pasoFila = (dFila > 0) ? 1 : -1;
        int pasoCol = (dCol > 0) ? 1 : -1;

        int filaActual = fila1 + pasoFila;
        int colActual = col1 + pasoCol;

        int enemigosEnCamino = 0;
        int filaEnemigo = -1;
        int colEnemigo = -1;

        while (filaActual != fila2 && colActual != col2) {
            String casilla = tablero[filaActual][colActual];

            if (!casilla.equals(" ")) {
                boolean esEnemigo = false;
                if (turno == 1 && (casilla.equals("o") || casilla.equals("Q"))) esEnemigo = true;
                if (turno == 2 && (casilla.equals("x") || casilla.equals("R"))) esEnemigo = true;

                if (!esEnemigo || enemigosEnCamino > 0) {
                    return false;
                }

                enemigosEnCamino++;
                filaEnemigo = filaActual;
                colEnemigo = colActual;
            }

            filaActual += pasoFila;
            colActual += pasoCol;
        }

        if (enemigosEnCamino == 0) {
            tablero[fila2][col2] = ficha;
            tablero[fila1][col1] = " ";
            return true;
        }

        if (enemigosEnCamino == 1) {
            tablero[fila2][col2] = ficha;
            tablero[fila1][col1] = " ";
            tablero[filaEnemigo][colEnemigo] = " ";
            System.out.println(">> ¡La Reyna capturó una pieza enemiga!");
            return true;
        }

        return false;
    }

    public static void revisarCoronacion(int fila, int col) {
        if (tablero[fila][col].equals("x") && fila == 0) {
            tablero[fila][col] = "R";
            System.out.println(">> ¡Ficha X coronada como Reyna ('R')!");
        }
        if (tablero[fila][col].equals("o") && fila == 7) {
            tablero[fila][col] = "Q";
            System.out.println(">> ¡Ficha O coronada como Reyna ('Q')!");
        }
    }

    public static boolean verificarFinPartida() {
        int contadorPiezas = 0;
        boolean tieneMovimientosDisponibles = false;

        String normal = (turno == 1) ? "x" : "o";
        String reyna = (turno == 1) ? "R" : "Q";

        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                if (tablero[fila][col].equals(normal) || tablero[fila][col].equals(reyna)) {
                    contadorPiezas++;

                    if (puedeMoverse(fila, col)) {
                        tieneMovimientosDisponibles = true;
                    }
                }
            }
        }

        if (contadorPiezas == 0) {
            System.out.println("\n=======================================================");
            System.out.println(" ¡EL JUGADOR " + (turno == 1 ? "O" : "X") + " HA GANADO! (El rival no tiene fichas)");
            System.out.println("=======================================================");
            return true;
        }

        if (!tieneMovimientosDisponibles) {
            System.out.println("\n=======================================================");
            System.out.println(" ¡EL JUGADOR " + (turno == 1 ? "O" : "X") + " HA GANADO! (El rival no tiene movimientos válidos)");
            System.out.println("=======================================================");
            return true;
        }

        return false;
    }

    public static boolean puedeMoverse(int fila, int col) {
        int[] deltasFila = {-2, -1, 1, 2};
        int[] deltasCol = {-2, -1, 1, 2};

        for (int dFila : deltasFila) {
            for (int dCol : deltasCol) {
                int filaDestino = fila + dFila;
                int colDestino = col + dCol;

                if (filaDestino >= 0 && filaDestino <= 7 && colDestino >= 0 && colDestino <= 7) {
                    if (tablero[filaDestino][colDestino].equals(" ")) {
                        if (esMovimientoValidoSinEjecutar(fila, col, filaDestino, colDestino)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean esMovimientoValidoSinEjecutar(int fila1, int col1, int fila2, int col2) {
        String ficha = tablero[fila1][col1];
        int dFila = fila2 - fila1;
        int dCol = col2 - col1;

        if (Math.abs(dFila) != Math.abs(dCol)) return false;

        boolean esReyna = ficha.equals("R") || ficha.equals("Q");

        if (!esReyna) {
            if (Math.abs(dFila) == 1) {
                if (ficha.equals("x") && dFila == -1) return true;
                if (ficha.equals("o") && dFila == 1) return true;
            }
            if (Math.abs(dFila) == 2) {
                if (ficha.equals("x") && dFila != -2) return false;
                if (ficha.equals("o") && dFila != 2) return false;

                int filaMedio = (fila1 + fila2) / 2;
                int colMedio = (col1 + col2) / 2;
                String intermedia = tablero[filaMedio][colMedio];

                if (turno == 1 && (intermedia.equals("o") || intermedia.equals("Q"))) return true;
                if (turno == 2 && (intermedia.equals("x") || intermedia.equals("R"))) return true;
            }
            return false;
        } else {
            return true;
        }
    }

    public static void reproducirPartida() {
        System.out.println("\n--- REPRODUCCIÓN PASO A PASO DE LA PARTIDA ---");
        if (historial.isEmpty()) {
            System.out.println("No se realizaron movimientos en esta partida.");
            return;
        }

        resetTablero();
        imprimirTablero();

        for (int i = 0; i < historial.size(); i++) {
            String registro = historial.get(i);
            System.out.println("\nMovimiento " + (i + 1) + ": " + registro);

            int fila1 = Character.getNumericValue(registro.charAt(registro.indexOf('(') + 1)) - 1;
            int col1 = Character.getNumericValue(registro.charAt(registro.indexOf('(') + 3)) - 1;
            int fila2 = Character.getNumericValue(registro.charAt(registro.indexOf('>') + 3)) - 1;
            int col2 = Character.getNumericValue(registro.charAt(registro.indexOf('>') + 5)) - 1;

            turno = registro.contains("Jugador X") ? 1 : 2;

            mover(fila1, col1, fila2, col2);
            imprimirTablero();
        }
    }
}
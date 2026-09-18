// Juego de Damas
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201
import java.util.Scanner;

public class Damas {

    // Tablero 8x8
    static String[][] tablero = new String[8][8];
    
    // Contadores y control de turno (1 = Jugador X, 2 = Jugador O)
    static int turno = 1;

    // Arreglo para guardar el historial de la partida (hasta 100 movimientos)
    static String[] historial = new String[100];
    static int totalMovimientos = 0;

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        // Prepara las fichas en el tablero
        resetTablero();

        boolean jugando = true;

        // BUCLE PRINCIPAL DE LA PARTIDA
        while (jugando) {
            imprimirTablero();

            System.out.println("\nTurno del Jugador " + (turno == 1 ? "X" : "O"));
            System.out.println("Escribe 0 en la Fila de origen para ir al MENÚ.");

            // Pedir la coordenada de origen (convertida a índice 0-7)
            System.out.print("Fila origen (1-8): ");
            int f1 = escaner.nextInt() - 1;
            if (f1 == -1) break; // Terminar partida si escribe 0 para ir al menú

            System.out.print("Columna origen (1-8): ");
            int c1 = escaner.nextInt() - 1;

            // Pedir la coordenada de destino (convertida a índice 0-7)
            System.out.print("Fila destino (1-8): ");
            int f2 = escaner.nextInt() - 1;

            System.out.print("Columna destino (1-8): ");
            int c2 = escaner.nextInt() - 1;

            // Validar e intentar realizar el movimiento
            if (mover(f1, c1, f2, c2)) {
                // Registrar el movimiento exitoso en el arreglo del historial
                historial[totalMovimientos] = "Jugador " + (turno == 1 ? "X" : "O") + ": (" + (f1 + 1) + "," + (c1 + 1) + ") -> (" + (f2 + 1) + "," + (c2 + 1) + ")";
                totalMovimientos++;

                // Cambiar el turno entre Jugador 1 (X) y Jugador 2 (O)
                if (turno == 1) {
                    turno = 2;
                } else {
                    turno = 1;
                }
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
            System.out.print("Selecciona una opción (1-2): ");
            
            int opcion = escaner.nextInt();

            switch (opcion) {
                case 1:
                    reproducirPartida();
                    break;
                case 2:
                    System.out.println("\n¡Gracias por jugar! Saliendo del programa...");
                    enMenu = false; // Sale del ciclo del menú
                    break;
                default:
                    System.out.println(">> Opción no válida. Ingresa 1 o 2.");
                    break;
            }
        }

        escaner.close();
    }

    // Llenar el tablero con casillas jugables ('x', 'o', ' ') e inválidas ('+')
    public static void resetTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Si la suma de indices es impar, la casilla es jugable
                if ((i + j) % 2 == 1) {
                    if (i < 3) {
                        tablero[i][j] = "o"; // Fichas del Jugador 2
                    } else if (i > 4) {
                        tablero[i][j] = "x"; // Fichas del Jugador 1
                    } else {
                        tablero[i][j] = " "; // Casilla libre jugable
                    }
                } else {
                    tablero[i][j] = "+"; // Casilla no jugable
                }
            }
        }
    }

    // Mostrar el tablero en consola con formato de corchetes
    public static void imprimirTablero() {
        System.out.println("\n    1  2  3  4  5  6  7  8");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Valida y ejecuta el desplazamiento o captura de fichas
    public static boolean mover(int f1, int c1, int f2, int c2) {
        // 1. Validar que las coordenadas estén dentro del arreglo 8x8
        if (f1 < 0 || f1 > 7 || c1 < 0 || c1 > 7 || f2 < 0 || f2 > 7 || c2 < 0 || c2 > 7) {
            return false;
        }

        String ficha = tablero[f1][c1];

        // 2. Validar que la ficha corresponda al jugador actual
        if (turno == 1 && !ficha.equals("x") && !ficha.equals("R")) return false;
        if (turno == 2 && !ficha.equals("o") && !ficha.equals("Q")) return false;

        // 3. La casilla de destino debe estar vacía
        if (!tablero[f2][c2].equals(" ")) return false;

        int df = f2 - f1; // Distancia en filas
        int dc = c2 - c1; // Distancia en columnas

        boolean esReyna = ficha.equals("R") || ficha.equals("Q");

        // --- MOVIMIENTO DE FICHAS NORMALES ('x' / 'o') ---
        if (!esReyna) {
            // Movimiento simple (1 casilla en diagonal hacia adelante)
            if (Math.abs(df) == 1 && Math.abs(dc) == 1) {
                if (ficha.equals("x") && df != -1) return false; // 'x' solo puede subir (-1)
                if (ficha.equals("o") && df != 1) return false;  // 'o' solo puede bajar (+1)

                tablero[f2][c2] = ficha;
                tablero[f1][c1] = " ";
                revisarCoronacion(f2, c2);
                return true;
            }

            // Captura simple (2 casillas en diagonal hacia adelante saltando al enemigo)
            if (Math.abs(df) == 2 && Math.abs(dc) == 2) {
                if (ficha.equals("x") && df != -2) return false;
                if (ficha.equals("o") && df != 2) return false;

                int fMedio = (f1 + f2) / 2;
                int cMedio = (c1 + c2) / 2;
                String intermedia = tablero[fMedio][cMedio];

                // Comprobar si la ficha intermedia es enemiga
                boolean esEnemigo = false;
                if (turno == 1 && (intermedia.equals("o") || intermedia.equals("Q"))) esEnemigo = true;
                if (turno == 2 && (intermedia.equals("x") || intermedia.equals("R"))) esEnemigo = true;

                if (esEnemigo) {
                    tablero[f2][c2] = ficha;
                    tablero[f1][c1] = " ";
                    tablero[fMedio][cMedio] = " "; // Eliminar la ficha comida
                    System.out.println(">> ¡Pieza capturada!");
                    revisarCoronacion(f2, c2);
                    return true;
                }
            }
            return false;
        }

        // --- MOVIMIENTO DE REYNAS ('R' / 'Q') - CUALQUIER DIRECCIÓN Y DISTANCIA ---
        // Deben moverse obligatoriamente en diagonal
        if (Math.abs(df) != Math.abs(dc)) return false;

        // Obtener el sentido del paso (-1 o 1) para filas y columnas
        int pasoFila = (df > 0) ? 1 : -1;
        int pasoCol = (dc > 0) ? 1 : -1;

        int fActual = f1 + pasoFila;
        int cActual = c1 + pasoCol;

        int enemigosEnCamino = 0;
        int fEnemigo = -1;
        int cEnemigo = -1;

        // Recorrer casilla por casilla la diagonal
        while (fActual != f2 && cActual != c2) {
            String casilla = tablero[fActual][cActual];

            if (!casilla.equals(" ")) {
                boolean esEnemigo = false;
                if (turno == 1 && (casilla.equals("o") || casilla.equals("Q"))) esEnemigo = true;
                if (turno == 2 && (casilla.equals("x") || casilla.equals("R"))) esEnemigo = true;

                // Si se topa con una ficha propia o con más de un enemigo, no se puede mover
                if (!esEnemigo || enemigosEnCamino > 0) {
                    return false;
                }

                enemigosEnCamino++;
                fEnemigo = fActual;
                cEnemigo = cActual;
            }

            fActual += pasoFila;
            cActual += pasoCol;
        }

        // Caso 1: Movimiento libre por la diagonal sin obstáculos
        if (enemigosEnCamino == 0) {
            tablero[f2][c2] = ficha;
            tablero[f1][c1] = " ";
            return true;
        }

        // Caso 2: Captura a distancia (salta exactamente 1 enemigo)
        if (enemigosEnCamino == 1) {
            tablero[f2][c2] = ficha;
            tablero[f1][c1] = " ";
            tablero[fEnemigo][cEnemigo] = " "; // Elimina la ficha comida a distancia
            System.out.println(">> ¡La Reyna capturó una pieza enemiga!");
            return true;
        }

        return false;
    }

    // Promueve las fichas a Reyna ('R' o 'Q') al llegar a los extremos
    public static void revisarCoronacion(int f, int c) {
        if (tablero[f][c].equals("x") && f == 0) {
            tablero[f][c] = "R"; // Reyna para Jugador 1 (X)
            System.out.println(">> ¡Ficha X coronada como Reyna ('R')!");
        }
        if (tablero[f][c].equals("o") && f == 7) {
            tablero[f][c] = "Q"; // Reyna para Jugador 2 (O)
            System.out.println(">> ¡Ficha O coronada como Reyna ('Q')!");
        }
    }

    // Muestra la repetición de la partida
    public static void reproducirPartida() {
        System.out.println("\n--- REPRODUCCIÓN DE LA PARTIDA ---");
        if (totalMovimientos == 0) {
            System.out.println("No se realizaron movimientos.");
            return;
        }

        // Reinicia el tablero para simular desde el principio
        resetTablero();

        for (int i = 0; i < totalMovimientos; i++) {
            System.out.println("\nMovimiento " + (i + 1) + ": " + historial[i]);
            imprimirTablero();
        }
    }
}
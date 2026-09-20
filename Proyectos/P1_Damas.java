// ==========================================
// Juego de Damas
// AUTOR: Rivera Cota Jesús Crispín
// Ing. de Software 201
// Espero sea la versión final 🥲
// ==========================================

import java.io.PrintStream;                 // Manejo de salida con codificación
import java.nio.charset.StandardCharsets;    // Soporte para caracteres UTF-8
import java.util.ArrayList;                // Lista dinámica para el historial
import java.util.Scanner;                  // Lectura de datos por consola

public class P1_Damas {

    // =========================================================================
    // 1. CONSTANTES VISUALES (SÍMBOLOS UNICODE Y CÓDIGOS DE COLOR ANSI)
    // =========================================================================
    
    // Iconos de las fichas
    public static final String FICHA_CIRCULO = "●";     // Ficha estándar
    public static final String REINA_BLANCA = "\u2655"; // Corona Reina J1 (♕)
    public static final String REINA_NEGRA = "\u265B";  // Corona Reina J2 (♛)

    // Formato de colores ANSI para la consola
    public static final String RESET = "\u001B[0m";                  
    public static final String CYAN_TEXT = "\u001B[96m\u001B[1m";      
    public static final String YELLOW_TEXT = "\u001B[93m\u001B[1m";    
    public static final String BG_LIGHT = "\u001B[48;5;223m";          
    public static final String BG_DARK = "\u001B[48;5;94m";            
    public static final String BG_BORDER = "\u001B[48;5;238m";          
    public static final String WHITE_TEXT = "\u001B[97m\u001B[1m";     

    // =========================================================================
    // 2. VARIABLES DE ESTADO GLOBAL
    // =========================================================================
    
    // Matriz de 8x8 que representa las posiciones del tablero
    static String[][] tablero = new String[8][8];
    
    // Control del turno activo (1 = Cyan / 2 = Amarillo)
    static int turno = 1; 
    
    // Almacena las jugadas registradas durante la partida para el replay
    static ArrayList<String> historial = new ArrayList<>();

    // =========================================================================
    // 3. MÓDULO PRINCIPAL DE EJECUCIÓN (MAIN)
    // =========================================================================
    public static void main(String[] args) {        
        // Configuración de la salida para soportar caracteres UTF-8 (emojis/fichas)
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {}

        // Inicialización del escáner de entrada del usuario
        try (Scanner escaner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            resetTablero(); // Carga las posiciones iniciales
            boolean jugando = true; 
            
            // Bucle principal de la partida
            while (jugando) {
                imprimirTablero(); // Dibuja la consola
                
                // Verifica si algún jugador se quedó sin fichas o movimientos
                if (verificarFinPartida()) {
                    break; 
                }
                
                System.out.println("\nTurno del Jugador " + (turno == 1 ? "1 (Cyan - " + FICHA_CIRCULO + ")" : "2 (Amarillo - " + FICHA_CIRCULO + ")"));
                System.out.println("Escribe 0 en la Fila de origen para ir al MENÚ.");
                
                // Regla de captura obligatoria
                boolean hayCapturas = hayCapturaObligatoriaGlobal();
                if (hayCapturas) {
                    System.out.println(">> ¡ATENCIÓN! Tienes que comer la ficha enemiga obligatoriamente.");
                }
                
                // Captura de coordenadas de origen
                int filaOrigen = leerCoordenada(escaner, "Fila origen (1-8): ") - 1;
                if (filaOrigen == -1) break; // Opción para ir al menú
                
                int colOrigen = leerCoordenada(escaner, "Columna origen (1-8): ") - 1;
                
                // Detección del tipo de ficha seleccionada
                String fichaSel = esCasillaValida(filaOrigen, colOrigen) ? tablero[filaOrigen][colOrigen] : " ";
                boolean esReina = fichaSel.equals("R") || fichaSel.equals("Q");

                String sentidoFila = "A"; // "A" = Adelante por defecto
                int casillasAMover = 1;

                // Preguntas adicionales exclusivas para la Reina
                if (esReina) {
                    sentidoFila = leerOpcion(escaner, "Sentido de la Reina [A = Adelante / R = Retroceso]: ", "A", "R");
                    casillasAMover = leerNumeroRango(escaner, "¿Cuántas casillas deseas moverte? (1-7): ", 1, 7);
                }

                String direccionCol = leerOpcion(escaner, "Dirección [I = Izquierda / D = Derecha]: ", "I", "D");
                
                // Procesamiento de la jugada
                if (procesarMovimiento(filaOrigen, colOrigen, sentidoFila, direccionCol, casillasAMover, hayCapturas)) {
                    turno = (turno == 1) ? 2 : 1; // Cambia de turno al tener éxito
                } else {
                    System.out.println(">> Intenta de nuevo seleccionando una jugada válida.");
                }
            }
            
            // Sub-bucle para gestionar el Menú Post-Juego
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
                        enMenu = false; 
                    }
                    default -> System.out.println(">> Opción no válida. Ingresa 1 o 2.");
                }
            }
        }
    }

    // =========================================================================
    // 4. MÓDULO DE LECTURA Y VALIDACIÓN DE ENTRADAS (INPUT HANDLERS)
    // =========================================================================

    // Lee números enteros garantizando que estén en el rango de coordenadas (0 a 8)
    public static int leerCoordenada(Scanner escaner, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (!escaner.hasNextInt()) {
                System.out.println(">> ¡Solo ingresa números!");
                escaner.next(); 
                continue;
            }
            valor = escaner.nextInt();
            if (valor < 0 || valor > 8) {
                System.out.println(">> Número fuera de rango (1-8 o 0 para menú).");
                continue;
            }
            break;
        }
        return valor;
    }

    // Lee enteros dentro de un rango numérico dinámico [min, max]
    public static int leerNumeroRango(Scanner escaner, String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (!escaner.hasNextInt()) {
                System.out.println(">> ¡Solo ingresa números!");
                escaner.next();
                continue;
            }
            valor = escaner.nextInt();
            if (valor < min || valor > max) {
                System.out.println(">> Cantidad fuera de rango (" + min + "-" + max + ").");
                continue;
            }
            break;
        }
        return valor;
    }

    // Valida respuestas de texto entre dos opciones fijas (Ejemplo: 'A' o 'R', 'I' o 'D')
    public static String leerOpcion(Scanner escaner, String mensaje, String opc1, String opc2) {
        String entrada;
        while (true) {
            System.out.print(mensaje);
            entrada = escaner.next().trim();
            if (entrada.equalsIgnoreCase(opc1) || entrada.equalsIgnoreCase(opc2)) {
                return entrada.toUpperCase();
            }
            System.out.println(">> Opción no válida. Ingresa '" + opc1 + "' o '" + opc2 + "'.");
        }
    }

    // =========================================================================
    // 5. MÓDULO DE GESTIÓN Y RENDERIZADO DEL TABLERO
    // =========================================================================

    // Restablece la matriz a la configuración inicial de un juego de damas
    public static void resetTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                if ((fila + col) % 2 == 1) { // Solo en casillas oscuras
                    if (fila < 3) {
                        tablero[fila][col] = "o"; // Jugador 2 (Amarillo)
                    } else if (fila > 4) {
                        tablero[fila][col] = "x"; // Jugador 1 (Cyan)
                    } else {
                        tablero[fila][col] = " "; // Casilla vacía jugable
                    }
                } else {
                    tablero[fila][col] = " "; // Casillas claras no jugables
                }
            }
        }
    }

    // Renderiza el tablero aplicando secuencias de escape ANSI para dar colores
    public static void imprimirTablero() {
        System.out.println();
        System.out.print(BG_BORDER + WHITE_TEXT + "    1  2  3  4  5  6  7  8 " + RESET + "\n");
        
        for (int fila = 0; fila < 8; fila++) {
            System.out.print(BG_BORDER + WHITE_TEXT + " " + (fila + 1) + " " + RESET);
            
            for (int col = 0; col < 8; col++) {
                String contenido = tablero[fila][col];
                String fondo = ((fila + col) % 2 == 1) ? BG_DARK : BG_LIGHT;
                String fichaColor;

                switch (contenido) {
                    case "x" -> fichaColor = CYAN_TEXT + FICHA_CIRCULO + RESET + fondo;
                    case "R" -> fichaColor = CYAN_TEXT + REINA_BLANCA + RESET + fondo;
                    case "o" -> fichaColor = YELLOW_TEXT + FICHA_CIRCULO + RESET + fondo;
                    case "Q" -> fichaColor = YELLOW_TEXT + REINA_NEGRA + RESET + fondo;
                    default -> fichaColor = " "; 
                }

                System.out.print(fondo + " " + fichaColor + " " + RESET);
            }
            System.out.println(); 
        }
    }

    // =========================================================================
    // 6. MÓDULO LÓGICO DE REGULACIÓN DE REGLAS Y MOVIMIENTOS
    // =========================================================================

    // Filtro principal de jugadas (Diferencia si es ficha normal o reina)
    public static boolean procesarMovimiento(int fOrigen, int cOrigen, String sentidoFila, String direccionCol, int casillas, boolean obligacionCaptura) {
        if (!esCasillaValida(fOrigen, cOrigen)) return false;

        String ficha = tablero[fOrigen][cOrigen];

        if (ficha.equals(" ")) {
            System.out.println(">> No hay ninguna ficha en la posición seleccionada.");
            return false;
        }

        // Validación de pertenencia de pieza
        if (turno == 1 && !ficha.equals("x") && !ficha.equals("R")) {
            System.out.println(">> Esa ficha pertenece al Jugador 2.");
            return false;
        }
        if (turno == 2 && !ficha.equals("o") && !ficha.equals("Q")) {
            System.out.println(">> Esa ficha pertenece al Jugador 1.");
            return false;
        }

        boolean esReina = ficha.equals("R") || ficha.equals("Q");

        // Cálculo del vector de movimiento (Direcciones en ejes X, Y)
        int pasoFila = (turno == 1) ? -1 : 1;
        if (esReina && sentidoFila.equals("R")) {
            pasoFila *= -1; // Invierte el sentido si retrocede
        }
        int pasoCol = direccionCol.equals("I") ? -1 : 1;

        // Derivación a la lógica de la Reina
        if (esReina) {
            return procesarMovimientoReinaDistancia(fOrigen, cOrigen, pasoFila, pasoCol, casillas, obligacionCaptura);
        }

        // Lógica para Ficha Normal
        int fDestino1 = fOrigen + pasoFila, cDestino1 = cOrigen + pasoCol;
        int fDestino2 = fOrigen + (pasoFila * 2), cDestino2 = cOrigen + (pasoCol * 2);

        if (obligacionCaptura) {
            if (puedeCapturarFichaNormal(fOrigen, cOrigen, fDestino2, cDestino2)) {
                ejecutarMovimiento(fOrigen, cOrigen, fDestino2, cDestino2, (fOrigen + fDestino2)/2, (cOrigen + cDestino2)/2);
                return true;
            }
            System.out.println(">> Debes realizar una captura obligatoria.");
            return false;
        }

        if (puedeCapturarFichaNormal(fOrigen, cOrigen, fDestino2, cDestino2)) {
            ejecutarMovimiento(fOrigen, cOrigen, fDestino2, cDestino2, (fOrigen + fDestino2)/2, (cOrigen + cDestino2)/2);
            return true;
        } else if (esCasillaValida(fDestino1, cDestino1) && tablero[fDestino1][cDestino1].equals(" ")) {
            ejecutarMovimiento(fOrigen, cOrigen, fDestino1, cDestino1, -1, -1);
            return true;
        }

        return false;
    }

    // Algoritmo de exploración para Reina (Comprueba desplazamientos largos)
    public static boolean procesarMovimientoReinaDistancia(int fOrigen, int cOrigen, int pasoFila, int pasoCol, int casillas, boolean obligacionCaptura) {
        int fDestino = fOrigen + (pasoFila * casillas);
        int cDestino = cOrigen + (pasoCol * casillas);

        if (!esCasillaValida(fDestino, cDestino)) {
            System.out.println(">> El destino cae fuera del tablero.");
            return false;
        }

        if (!tablero[fDestino][cDestino].equals(" ")) {
            System.out.println(">> La casilla de destino no está libre.");
            return false;
        }

        int fRastreo = fOrigen + pasoFila;
        int cRastreo = cOrigen + pasoCol;

        int fEnemigo = -1, cEnemigo = -1;
        int enemigasEncontradas = 0;

        // Rastrea casilla por casilla toda la diagonal indicada
        while (fRastreo != fDestino || cRastreo != cDestino) {
            String piezaActual = tablero[fRastreo][cRastreo];

            if (!piezaActual.equals(" ")) {
                boolean esPropia = (turno == 1 && (piezaActual.equals("x") || piezaActual.equals("R"))) ||
                                    (turno == 2 && (piezaActual.equals("o") || piezaActual.equals("Q")));

                if (esPropia) {
                    System.out.println(">> El camino está bloqueado por una de tus piezas.");
                    return false;
                }

                enemigasEncontradas++;
                fEnemigo = fRastreo;
                cEnemigo = cRastreo;

                if (enemigasEncontradas > 1) {
                    System.out.println(">> No puedes saltar más de una ficha enemiga en un solo movimiento.");
                    return false;
                }
            }

            fRastreo += pasoFila;
            cRastreo += pasoCol;
        }

        if (obligacionCaptura && enemigasEncontradas == 0) {
            System.out.println(">> Hay una captura obligatoria en el tablero y no la estás realizando.");
            return false;
        }

        ejecutarMovimiento(fOrigen, cOrigen, fDestino, cDestino, fEnemigo, cEnemigo);
        return true;
    }

    // Evalúa si una ficha normal puede comer a un enemigo en un movimiento de 2 casillas
    public static boolean puedeCapturarFichaNormal(int fOrigen, int cOrigen, int fDestino, int cDestino) {
        if (!esCasillaValida(fDestino, cDestino)) return false;
        if (!tablero[fDestino][cDestino].equals(" ")) return false;

        int fMedio = (fOrigen + fDestino) / 2;
        int cMedio = (cOrigen + cDestino) / 2;
        String intermedia = tablero[fMedio][cMedio];

        if (turno == 1 && (intermedia.equals("o") || intermedia.equals("Q"))) return true;
        if (turno == 2 && (intermedia.equals("x") || intermedia.equals("R"))) return true;

        return false;
    }

    // Actualiza la matriz realizando el desplazamiento y eliminando piezas comidas
    public static void ejecutarMovimiento(int f1, int c1, int f2, int c2, int fComida, int cComida) {
        String ficha = tablero[f1][c1];
        tablero[f2][c2] = ficha; 
        tablero[f1][c1] = " ";   

        if (fComida != -1 && cComida != -1) {
            tablero[fComida][cComida] = " ";
            System.out.println(">> ¡Te comiste una ficha!");
        }

        revisarCoronacion(f2, c2);

        // Registro de historial para el replay
        String registro = "Jugador " + (turno == 1 ? "1" : "2") + ": (" + (f1 + 1) + "," + (c1 + 1) + ") -> (" + (f2 + 1) + "," + (c2 + 1) + ")";
        historial.add(registro);
    }

    // Escanea todo el tablero para verificar si el jugador activo tiene capturas obligatorias
    public static boolean hayCapturaObligatoriaGlobal() {
        String normal = (turno == 1) ? "x" : "o";
        String reyna = (turno == 1) ? "R" : "Q";
        int pasoFila = (turno == 1) ? -1 : 1;

        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                String pieza = tablero[fila][col];
                if (pieza.equals(normal)) {
                    if (puedeCapturarFichaNormal(fila, col, fila + (pasoFila * 2), col - 2) ||
                        puedeCapturarFichaNormal(fila, col, fila + (pasoFila * 2), col + 2)) {
                        return true;
                    }
                } else if (pieza.equals(reyna)) {
                    int[][] dir = {{-1,-1}, {-1,1}, {1,-1}, {1,1}};
                    for (int[] d : dir) {
                        int f = fila + d[0], c = col + d[1];
                        boolean enemigo = false;
                        while (esCasillaValida(f, c)) {
                            if (!tablero[f][c].equals(" ")) {
                                String p = tablero[f][c];
                                boolean esEnemigo = (turno == 1 && (p.equals("o")||p.equals("Q"))) ||
                                                    (turno == 2 && (p.equals("x")||p.equals("R")));
                                if (esEnemigo && !enemigo) {
                                    enemigo = true;
                                } else {
                                    break; 
                                }
                            } else if (enemigo) {
                                return true; 
                            }
                            f += d[0]; c += d[1];
                        }
                    }
                }
            }
        }
        return false;
    }

    // Promociona fichas normales a Reinas si alcanzan la fila final del rival
    public static void revisarCoronacion(int fila, int col) {
        if (tablero[fila][col].equals("x") && fila == 0) {
            tablero[fila][col] = "R";
            System.out.println(">> ¡Ficha coronada a Reina " + REINA_BLANCA + "!");
        }
        if (tablero[fila][col].equals("o") && fila == 7) {
            tablero[fila][col] = "Q";
            System.out.println(">> ¡Ficha coronada a Reina " + REINA_NEGRA + "!");
        }
    }

    // Evalúa si la partida terminó (por falta de piezas o por bloqueo de movimientos)
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
            System.out.println("\n ¡GANÓ EL JUGADOR " + (turno == 1 ? "2" : "1") + "! (El rival se quedó sin fichas)");
            return true;
        }

        if (!tieneMovimientosDisponibles) {
            System.out.println("\n ¡GANÓ EL JUGADOR " + (turno == 1 ? "2" : "1") + "! (El rival se quedó sin movimientos)");
            return true;
        }

        return false;
    }

    // Valida si una ficha específica tiene casillas contiguas o saltos libres para moverse
    public static boolean puedeMoverse(int fila, int col) {
        int pasoFila = (turno == 1) ? -1 : 1;
        String pieza = tablero[fila][col];

        if (pieza.equals("x") || pieza.equals("o")) {
            return (esCasillaValida(fila + pasoFila, col - 1) && tablero[fila + pasoFila][col - 1].equals(" ")) ||
                   (esCasillaValida(fila + pasoFila, col + 1) && tablero[fila + pasoFila][col + 1].equals(" ")) ||
                   puedeCapturarFichaNormal(fila, col, fila + (pasoFila * 2), col - 2) ||
                   puedeCapturarFichaNormal(fila, col, fila + (pasoFila * 2), col + 2);
        } else {
            int[][] dir = {{-1,-1}, {-1,1}, {1,-1}, {1,1}};
            for (int[] d : dir) {
                int f = fila + d[0], c = col + d[1];
                if (esCasillaValida(f, c) && tablero[f][c].equals(" ")) return true;
            }
        }

        return false;
    }

    // Helper básico que confirma si la coordenada en la matriz se encuentra de [0 a 7]
    public static boolean esCasillaValida(int fila, int col) {
        return fila >= 0 && fila <= 7 && col >= 0 && col <= 7;
    }

    // =========================================================================
    // 7. MÓDULO DE REPRODUCCIÓN (REPLAY / HISTORIAL)
    // =========================================================================

    // Lee el historial guardado y simula la partida desde cero
    public static void reproducirPartida() {
        System.out.println("\n--- REPRODUCCIÓN DE LA PARTIDA ---");
        if (historial.isEmpty()) {
            System.out.println("No hay jugadas guardadas.");
            return;
        }

        resetTablero();
        imprimirTablero();

        for (int i = 0; i < historial.size(); i++) {
            String registro = historial.get(i);
            System.out.println("\nMovimiento " + (i + 1) + ": " + registro);

            int f1 = Character.getNumericValue(registro.charAt(registro.indexOf('(') + 1)) - 1;
            int c1 = Character.getNumericValue(registro.charAt(registro.indexOf('(') + 3)) - 1;
            int f2 = Character.getNumericValue(registro.charAt(registro.indexOf('>') + 3)) - 1;
            int c2 = Character.getNumericValue(registro.charAt(registro.indexOf('>') + 5)) - 1;

            turno = registro.contains("Jugador 1") ? 1 : 2;

            int fComida = (Math.abs(f2 - f1) > 1) ? (f1 + f2) / 2 : -1;
            int cComida = (Math.abs(c2 - c1) > 1) ? (c1 + c2) / 2 : -1;

            ejecutarMovimiento(f1, c1, f2, c2, fComida, cComida);
            
            imprimirTablero();
        }
    }
}
// Juego de Damas (Checkers) para 2 Jugadores
// Autor: Rivera Cota Jesús Crispín
// FACULTAD DE INGENIERÍA LOS MOCHIS
// Ing. de Software 201

import java.util.Scanner;

public class P1_Damas {
    private static final int SIZE = 8;
    private static char[][] board = new char[SIZE][SIZE];
    // Jugador 1: 'X' (mueve hacia arriba) | Jugador 2: 'O' (mueve hacia abajo)
    private static char turn = 'X'; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();

        boolean gameOver = false;
        while (!gameOver) {
            printBoard();
            System.out.println("\nTurno del Jugador: " + turn);
            System.out.print("Ingresa fila y columna de la pieza a mover (ejemplo: 5 2): ");
            int r1 = scanner.nextInt();
            int c1 = scanner.nextInt();

            System.out.print("Ingresa fila y columna de destino (ejemplo: 4 3): ");
            int r2 = scanner.nextInt();
            int c2 = scanner.nextInt();

            if (move(r1, c1, r2, c2)) {
                // Cambiar de turno si el movimiento fue válido
                turn = (turn == 'X') ? 'O' : 'X';
            } else {
                System.out.println(">> ¡Movimiento inválido! Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    // Inicializa el tablero con las fichas en sus posiciones de origen
    private static void initBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if ((r + c) % 2 != 0) {
                    if (r < 3) board[r][c] = 'O';      // Jugador 2 (Arriba)
                    else if (r > 4) board[r][c] = 'X'; // Jugador 1 (Abajo)
                    else board[r][c] = '.';           // Casilla vacía jugable
                } else {
                    board[r][c] = ' ';                 // Casilla no jugable
                }
            }
        }
    }

    // Muestra el tablero con coordenadas numeradas
    private static void printBoard() {
        System.out.println("\n   0 1 2 3 4 5 6 7");
        System.out.println("  -----------------");
        for (int r = 0; r < SIZE; r++) {
            System.out.print(r + " |");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  -----------------");
    }

    // Lógica para validar y realizar el movimiento/captura
    private static boolean move(int r1, int c1, int r2, int c2) {
        // Validar que las coordenadas estén dentro del rango del tablero
        if (r1 < 0 || r1 >= SIZE || c1 < 0 || c1 >= SIZE ||
            r2 < 0 || r2 >= SIZE || c2 < 0 || c2 >= SIZE) return false;

        // Validar que la pieza seleccionada sea del jugador actual y el destino esté vacío
        if (board[r1][c1] != turn || board[r2][c2] != '.') return false;

        int rowDiff = r2 - r1;
        int colDiff = Math.abs(c2 - c1);
        int direction = (turn == 'X') ? -1 : 1; // 'X' sube (-1), 'O' baja (+1)

        // 1. Movimiento simple (1 casilla en diagonal hacia adelante)
        if (rowDiff == direction && colDiff == 1) {
            board[r2][c2] = turn;
            board[r1][c1] = '.';
            return true;
        }

        // 2. Movimiento de captura (2 casillas en diagonal saltando al enemigo)
        if (rowDiff == 2 * direction && colDiff == 2) {
            int midR = r1 + direction;
            int midC = (c1 + c2) / 2;
            char enemy = (turn == 'X') ? 'O' : 'X';

            if (board[midR][midC] == enemy) {
                board[r2][c2] = turn;
                board[r1][c1] = '.';
                board[midR][midC] = '.'; // Eliminar la pieza comida
                System.out.println(">> ¡Pieza enemiga capturada!");
                return true;
            }
        }

        return false;
    }
}
package tictactoe;

public class Field {

    static final int SIZE = 3;
    static char[][] field = new char[SIZE][SIZE];
    static final char CROSS = 'X';
    static final char ZERO = 'O';
    static final char EMPTY = ' ';
    static char currentPlayer = CROSS;
    static char nextPlayer = ZERO;
    static boolean isEndOfGame = false;
    static char winner;

    public static void createField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
    }

    public static void printField() {
        System.out.println("---------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2c", field[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static boolean isCellOccupied(String coordinates) {
        int x = Character.getNumericValue(coordinates.charAt(0)) - 1;
        int y = Character.getNumericValue(coordinates.charAt(2)) - 1;
        if (field[x][y] != EMPTY) {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }
        return false;
    }

    public static boolean isEndOfGame() {
        int countDiag1 = 0;
        int countDiag2 = 0;
        for (int i = 0; i < SIZE; i++) {
            int countRow = 0;
            int countCol = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == currentPlayer) countRow++;
                if (field[j][i] == currentPlayer) countCol++;
            }
            if (field[i][i] == currentPlayer) countDiag1++;
            if (field[i][SIZE - 1 - i] == currentPlayer) countDiag2++;
            if (countRow == SIZE || countCol == SIZE || countDiag1 == SIZE || countDiag2 == SIZE) {
                System.out.println(currentPlayer + " wins");
                winner = currentPlayer;
                return true;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == EMPTY) return false;
            }
        }
        System.out.println("Draw");
        return true;
    }
}

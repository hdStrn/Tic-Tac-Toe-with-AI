package tictactoe;

import java.util.Random;

public class MediumAI extends Player {

    public MediumAI() {
        this.name = "medium";
    }
    
    public void turn() {
        checkWin();
        System.out.println("Making move level \"medium\"");
        Field.field[coordinates[0]][coordinates[1]] = Field.currentPlayer;
        Field.printField();
        Field.isEndOfGame = Field.isEndOfGame();
        turnSwitch();
    }

    public void checkWin() {
        Random random = new Random();
        char[] players = new char[]{Field.currentPlayer, Field.nextPlayer};
        for (char player : players) {
            for (int i = 0; i < Field.SIZE; i++) {
                int countRow = 0;
                int countCol = 0;
                for (int j = 0; j < Field.SIZE; j++) {
                    if (Field.field[i][j] == player) countRow++;
                    if (Field.field[j][i] == player) countCol++;
                }
                if (countRow == Field.SIZE - 1) {
                    for (int j = 0; j < Field.SIZE; j++) {
                        if (Field.field[i][j] == Field.EMPTY) {
                            coordinates[0] = i;
                            coordinates[1] = j;
                            return;
                        }
                    }
                }
                if (countCol == Field.SIZE - 1) {
                    for (int j = 0; j < Field.SIZE; j++) {
                        if (Field.field[j][i] == Field.EMPTY) {
                            coordinates[0] = j;
                            coordinates[1] = i;
                            return;
                        }
                    }
                }
            }
            int countDiag1 = 0;
            int countDiag2 = 0;
            for (int i = 0; i < Field.SIZE; i++) {
                if (Field.field[i][i] == player) countDiag1++;
                if (Field.field[i][Field.SIZE - 1 - i] == player) countDiag2++;
            }
            if (countDiag1 == Field.SIZE - 1) {
                for (int i = 0; i < Field.SIZE; i++) {
                    if (Field.field[i][i] == Field.EMPTY) {
                        coordinates[0] = i;
                        coordinates[1] = i;
                        return;
                    }
                }
            }
            if (countDiag2 == Field.SIZE - 1) {
                for (int i = 0; i < Field.SIZE; i++) {
                    if (Field.field[i][Field.SIZE - 1 - i] == Field.EMPTY) {
                        coordinates[0] = i;
                        coordinates[1] = Field.SIZE - 1 - i;
                        return;
                    }
                }
            }
        }
        do {
            coordinates[0] = random.nextInt(3);
            coordinates[1] = random.nextInt(3);
        } while (Field.field[coordinates[0]][coordinates[1]] != Field.EMPTY);
    }
}

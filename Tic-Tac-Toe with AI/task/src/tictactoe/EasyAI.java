package tictactoe;

import java.util.Random;

public class EasyAI extends Player {

    public EasyAI() {
        this.name = "easy";
    }

    @Override
    public void turn() {
        Random random = new Random();
        do {
            coordinates[0] = random.nextInt(3);
            coordinates[1] = random.nextInt(3);
        } while (Field.field[coordinates[0]][coordinates[1]] != Field.EMPTY);
        System.out.println("Making move level \"easy\"");
        Field.field[coordinates[0]][coordinates[1]] = Field.currentPlayer;
        Field.printField();
        Field.isEndOfGame = Field.isEndOfGame();
        turnSwitch();
    }
}

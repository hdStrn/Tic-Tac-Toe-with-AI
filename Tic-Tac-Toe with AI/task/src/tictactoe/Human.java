package tictactoe;

public class Human extends Player {

    public Human() {
        this.name = "user";
    }

    @Override
    public void turn() {
        String textCoordinates;
        do {
            textCoordinates = Input.coordinatesInput();
        } while (Field.isCellOccupied(textCoordinates));
        coordinates[0] = Character.getNumericValue(textCoordinates.charAt(0)) - 1;
        coordinates[1] = Character.getNumericValue(textCoordinates.charAt(2)) - 1;
        Field.field[coordinates[0]][coordinates[1]] = Field.currentPlayer;
        Field.printField();
        Field.isEndOfGame = Field.isEndOfGame();
        turnSwitch();
    }
}

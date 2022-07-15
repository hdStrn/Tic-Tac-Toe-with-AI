package tictactoe;

public abstract class Player {

    protected String name;
    protected int[] coordinates = new int[2];

    public String getName() {
        return name;
    }

    public static final Player[] PLAYERS = {
            new Human(),
            new EasyAI(),
            new MediumAI(),
            new HardAI()
    };
    public abstract void turn();

    public void turnSwitch() {
        if (Field.currentPlayer == Field.CROSS) {
            Field.currentPlayer = Field.ZERO;
            Field.nextPlayer = Field.CROSS;
        } else {
            Field.currentPlayer = Field.CROSS;
            Field.nextPlayer = Field.ZERO;
        }
    }

    public static Player[] playersChoose() {
        Player[] actualPlayers = new Player[2];
        String[] input = Input.gameModeInput();
        if ("exit".equals(input[0])) {
            System.exit(0);
        }
        for (Player player : PLAYERS) {
            if (input[1].equals(player.getName())) actualPlayers[0] = player;
            if (input[2].equals(player.getName())) actualPlayers[1] = player;
        }
        return actualPlayers;
    }
}

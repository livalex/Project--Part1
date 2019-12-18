package main;

import players.Human;
import players.PlayersFactory;

import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        // Objects used read and write data.
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();

        // Instantiations.
        MapBuilder mapBuilder = MapBuilder.getInstance(input.getBattleGround());
        VectorCreator vectorCreator = VectorCreator.getInstance();
        ActionCreator actionCreator = ActionCreator.getInstance();
        PlayersFactory playersFactory = new PlayersFactory();

        // Build the 'map'.
        ArrayList<String> ground = mapBuilder.getBattleGround();

        // Create the players vector
        ArrayList<Human> players = vectorCreator.createVector(input.getP(), playersFactory, input);

        // Play game.
        players = actionCreator.createMoves(input.getR(), input.getP(), input, players, ground);

        // Display the output.
        inputLoader.exposeOutput(players);
    }
}

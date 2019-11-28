package main;

import players.Human;
import players.PlayersFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();
        MapBuilder mapBuilder = MapBuilder.getInstance(input.getBattleGround());
        VectorCreator vectorCreator = VectorCreator.getInstance();
        ActionCreator actionCreator = ActionCreator.getInstance();
//        OutputDisplayer outputDisplayer = OutputDisplayer.getInstance();
        PlayersFactory playersFactory = new PlayersFactory();

        ArrayList<String> ground = mapBuilder.getBattleGround();
        ArrayList<Human> players = vectorCreator.createVector(input.getP(), playersFactory, input);

        players = actionCreator.createMoves(input.getR(), input.getP(), input, players, ground);
//        outputDisplayer.displayOutput(players);
        inputLoader.exposeOutput(players);
    }
}

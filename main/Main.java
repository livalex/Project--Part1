package main;

import angels.Angel;
import angels.AngelsFactory;
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
        AngelsVectorCreator angelsVectorCreator = AngelsVectorCreator.getInstance();
        ActionCreator actionCreator = ActionCreator.getInstance();
        PlayersFactory playersFactory = new PlayersFactory();
        AngelsFactory angelsFactory = new AngelsFactory();

        // Build the 'map'.
        ArrayList<String> ground = mapBuilder.getBattleGround();

        // Create the players vector
        ArrayList<Human> players = vectorCreator.createVector(input.getP(), playersFactory, input);

        // Play game.
        players = actionCreator.createMoves(input.getR(), input.getP(),
                input, players, ground, inputLoader);

        //ArrayList<Angel> angels = angelsVectorCreator.createAngelArray(input.getR(),
                //angelsFactory, input, inputLoader);

//        for (int i = 0; i < angels.size(); ++i) {
//            Angel angel = angels.get(i);
//            System.out.print(angel.getAngelType() + " " + angel.getMyAbscissa() + " " + angel.getMyOrdinate());
//            System.out.println();
//        }

        // Display the output.
        inputLoader.exposeOutput(players);
    }
}

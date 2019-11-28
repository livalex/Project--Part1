package main;

import players.Human;
import players.PlayersFactory;

import java.util.ArrayList;

public final class VectorCreator {
    private static VectorCreator vectorCreator = null;

    private VectorCreator() {
    }

    public static VectorCreator getInstance() {
        if (vectorCreator == null) {
            vectorCreator = new VectorCreator();
        }
        return vectorCreator;
    }

    public ArrayList<Human> createVector(final int n, final PlayersFactory playersFactory,final Input input) {
        ArrayList<Human> players = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String strategy = input.getPlayerTypes().get(i);
            int ab = input.getFirstCoordonates().get(i);
            int or = input.getSecondCoordonates().get(i);

            players.add(playersFactory.getPlayer(strategy, ab, or));
        }

        return players;
    }
}

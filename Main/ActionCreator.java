package main;

import players.Human;
import java.util.ArrayList;

public final class ActionCreator {
    private static ActionCreator actionCreator = null;

    private ActionCreator() {
    }

    public static ActionCreator getInstance() {
        if (actionCreator == null) {
            actionCreator = new ActionCreator();
        }
        return actionCreator;
    }

    public void groundSetter(final ArrayList<String> ground, final Human player) {
        if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'L') {
            player.setCurrentGround(0);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'V') {
            player.setCurrentGround(1);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'D') {
            player.setCurrentGround(2);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'W') {
            player.setCurrentGround(3);
        }
    }

    public ArrayList<Human> battle(final int n, final int m, ArrayList<Human> players) {
        for (int k = 0; k < m; ++k) {
            Human player1 = players.get(k);
            for (int l = 0; l < m; ++l) {
                if (k != l) {
                    Human player2 = players.get(l);
                    if (player1.getCurrentAbscissa() == player2.getCurrentAbscissa() &&
                            player1.getCurrentOrdinate() == player2.getCurrentOrdinate()) {
                        player2.accept(player1);
                    }
                }
            }
        }

        return players;
    }


    public ArrayList<Human> createMoves(final int n, final int m, final Input input,
                                        ArrayList<Human> players, final ArrayList<String> ground) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Human player = players.get(j);
                if (input.getMoves().get(i).charAt(j) == 'R' && !player.isImmobility()) {
                    player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() + 1);
                    groundSetter(ground, player);
                } else if (input.getMoves().get(i).charAt(j) == 'L' && !player.isImmobility()) {
                    player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() - 1);
                    groundSetter(ground, player);
                } else if (input.getMoves().get(i).charAt(j) == 'U' && !player.isImmobility()) {
                    player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() - 1);
                    groundSetter(ground, player);
                } else if (input.getMoves().get(i).charAt(j) == 'D' && !player.isImmobility()) {
                    player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() + 1);
                    groundSetter(ground, player);
                } else if (input.getMoves().get(i).charAt(j) == '_' && !player.isImmobility()) {
                    groundSetter(ground, player);
                }
            }

            for (int k = 0; k < m; ++k) {
                Human player = players.get(k);
                player.computeLevel();
            }

            players = battle(n, m, players);

        }
        return players;
    }
}

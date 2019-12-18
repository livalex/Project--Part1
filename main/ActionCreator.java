package main;

import angels.Angel;
import angels.AngelsFactory;
import constants.Constants;
import players.Human;
import java.util.ArrayList;

public final class ActionCreator {
    private int vectorIterator = Constants.DEFAULT_STARTING_VALUE;

    public int getVectorIterator() {
        return vectorIterator;
    }

    public void setVectorIterator(int vectorIterator) {
        this.vectorIterator = vectorIterator;
    }

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
            player.setCurrentGround(Constants.ZERO_TYPE_GROUND);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'V') {
            player.setCurrentGround(Constants.ONE_TYPE_GROUND);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'D') {
            player.setCurrentGround(Constants.TWO_TYPE_GROUND);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'W') {
            player.setCurrentGround(Constants.THREE_TYPE_GROUND);
        }
    }

    public void xpGiver(final Human player2, final Human player1) {
        // Update xp.
        player2.setXp(player2.getXp() + Math.max(0,
                Constants.XP_FORMULA_FACTOR - (player2.getLevel()
                        - player1.getLevel()) * Constants.XP_FORMULA_MULTIPLICATION));
        while (player2.getXp() >= Constants.LVL_UP_FACTOR
                + player2.getLevel() * Constants.LVL_UP_MULTIPLICATION) {
            // Calculate the level of the player.
            int lifeIncrease = 0;
            if (player2.getPlayerType() == Constants.ZERO_TYPE_GROUND) {
                lifeIncrease = Constants.PYRO_INCREASE;
            } else if (player2.getPlayerType() == Constants.ONE_TYPE_GROUND) {
                lifeIncrease = Constants.KNIGHT_INCREASE;
            } else if (player2.getPlayerType() == Constants.TWO_TYPE_GROUND) {
                lifeIncrease = Constants.WIZARD_INCREASE;
            } else {
                lifeIncrease = Constants.ROGUE_INCREASE;
            }
            // Update the stats.
            player2.setLevel(player2.getLevel() + 1);
            player2.setMaxHp(player2.getMaxHp() + lifeIncrease);
            player2.setHp(player2.getMaxHp());
        }
    }

    public ArrayList<Human> battle(final int n, final int m, ArrayList<Human> players) {
        for (int k = 0; k < m - 1; ++k) {
            Human player1 = players.get(k);
            for (int l = k + 1; l < m; ++l) {
                Human player2 = players.get(l);
                // Check if their are in the same position.
                if (player1.getCurrentAbscissa() == player2.getCurrentAbscissa()
                        && player1.getCurrentOrdinate() == player2.getCurrentOrdinate()) {
                    // Check for them not to be dead.
                    if (!player1.isDead() && !player2.isDead()) {
                        // Make sure that wizard strikes second.
                        if (player1.getPlayerType() != 2 && player2.getPlayerType() == 2) {
                            player1.accept(player2);
                            player2.accept(player1);

                            if (player1.isDead()) {
                                xpGiver(player2, player1);
                            }

                            if (player2.isDead()) {
                                xpGiver(player1, player2);
                            }

                        } else {
                            player2.accept(player1);
                            player1.accept(player2);
                            if (player1.isDead()) {
                                xpGiver(player2, player1);
                            }

                            if (player2.isDead()) {
                                xpGiver(player1, player2);
                            }
                        }
                    }
                }
            }
        }

        return players;
    }

    public ArrayList<Human> checkForMovement(final int m, final ArrayList<Human> players,
                                  final ArrayList<String> ground, final int i,
                                  final Input input) {
        for (int j = 0; j < m; ++j) {
            // Check if they move and if they can move.
            Human player = players.get(j);
            if (input.getMoves().get(i).charAt(j) == 'R'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() + 1);
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == 'L'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() - 1);
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == 'U'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() - 1);
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == 'D'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() + 1);
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == '_'
                    && !player.isImmobility() && !player.isParalysed()) {
                groundSetter(ground, player);
            }
        }
        return players;
    }

    public ArrayList<Angel> angelsVectorCreator(final Input input, final int i,
                                                int vectorIterator, final InputLoader inputLoader) {
        ArrayList<Angel> angels = new ArrayList<>();
        AngelsFactory angelsFactory = new AngelsFactory();
        for (int j = 0; j < input.getNumberAngelsRound().get(i); ++j) {
            String string = input.getAngelTypes().get(vectorIterator);
            String angelType = string.substring(0, string.length() - 4);
            Integer firstCoordinate = Character.getNumericValue(string.charAt(string.length() - 3));
            Integer secondCoordinate = Character.getNumericValue(string.charAt(string.length() - 1));
            Angel angel = angelsFactory.getAngel(angelType, firstCoordinate, secondCoordinate);
            angels.add(angel);
            inputLoader.displayAngel(angel);
            setVectorIterator(getVectorIterator() + 1);
        }
        return angels;
    }

    public ArrayList<Human> createMoves(final int n, final int m, final Input input,
                                        ArrayList<Human> players, final ArrayList<String> ground,
                                        final InputLoader inputLoader) {
        for (int i = 0; i < n; ++i) {
            inputLoader.displayRound(i + 1);
            players = checkForMovement(m, players, ground, i, input);

            // Take into consideration their overtime affections.
            for (int k = 0; k < m; ++k) {
                Human player = players.get(k);
                player.checkOverTimeAbility();
            }
            ArrayList<Angel> angels = angelsVectorCreator(input, i, vectorIterator, inputLoader);

            players = battle(n, m, players);

            inputLoader.createSpace();
        }
        return players;
    }
}

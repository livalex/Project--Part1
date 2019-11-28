package main;

import players.Human;

import java.util.ArrayList;

public final class OutputDisplayer {
    private static OutputDisplayer outputDisplayer = null;

    private OutputDisplayer() {
    }

    public static OutputDisplayer getInstance() {
        if (outputDisplayer == null) {
            outputDisplayer = new OutputDisplayer();
        }
        return outputDisplayer;
    }

    public void displayOutput(final ArrayList<Human> players) {
        for (int i = 0; i < players.size(); ++i) {
            Human player = players.get(i);
            if (player.getHp() <= 0) {
                if (player.getPlayerType() == 0) {
                    System.out.println("P dead");
                } else if (player.getPlayerType() == 1) {
                    System.out.println("K dead");
                } else if (player.getPlayerType() == 2) {
                    System.out.println("W dead");
                } else if (player.getPlayerType() == 3) {
                    System.out.println("R dead");
                }
            } else {
                if (player.getPlayerType() == 0) {
                    System.out.println("P " + player.getLevel() + " " + player.getXp() + " " + player.getHp() + " " +
                            player.getCurrentAbscissa() + " " + player.getCurrentOrdinate());
                } else if (player.getPlayerType() == 1) {
                    System.out.println("K " + player.getLevel() + " " + player.getXp() + " " + player.getHp() + " " +
                            player.getCurrentAbscissa() + " " + player.getCurrentOrdinate());
                } else if (player.getPlayerType() == 2) {
                    System.out.println("W " + player.getLevel() + " " + player.getXp() + " " + player.getHp() + " " +
                            player.getCurrentAbscissa() + " " + player.getCurrentOrdinate());
                } else if (player.getPlayerType() == 3) {
                    System.out.println("R " + player.getLevel() + " " + player.getXp() + " " + player.getHp() + " " +
                            player.getCurrentAbscissa() + " " + player.getCurrentOrdinate());
                }
            }
        }
    }
}

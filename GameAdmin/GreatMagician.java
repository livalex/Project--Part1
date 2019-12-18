package GameAdmin;

import angels.Angel;
import players.Human;

import java.util.ArrayList;

public final class GreatMagician implements Observer {

    private static GreatMagician greatMagician = null;

    private ArrayList<Integer> angelAbs = new ArrayList<>();
    private ArrayList<Integer> angelOrd = new ArrayList<>();
    private ArrayList<Human> helpedPlayers = new ArrayList<>();
    private ArrayList<Human> hitPlayers = new ArrayList<>();
    private ArrayList<Human> killedPlayers = new ArrayList<>();

    private GreatMagician() {
    }

    public static GreatMagician getInstance() {
        if (greatMagician == null) {
            greatMagician = new GreatMagician();
        }
        return greatMagician;
    }

    @Override
    public void attachAbs(final int x) {
        angelAbs.add(x);
    }

    @Override
    public void attachOrd(final int y) {
        angelOrd.add(y);
    }

    @Override
    public void attachHelpedPlayers(final Human human) {
        helpedPlayers.add(human);
    }

    @Override
    public void attachHitPlayers(final Human human) {
        hitPlayers.add(human);
    }

    @Override
    public void attachKilledPlayers(final Human human) {
        killedPlayers.add(human);
    }

}

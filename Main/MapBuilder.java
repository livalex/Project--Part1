package main;

import java.util.ArrayList;

public final class MapBuilder {
    private static MapBuilder mapBuilder = null;

    private ArrayList<String> battleGround;

    private MapBuilder(final ArrayList<String> battleGround) {
        this.battleGround = battleGround;
    }

    public ArrayList<String> getBattleGround() {
        return battleGround;
    }

    public static MapBuilder getInstance(final ArrayList<String> battleGround) {
        if (mapBuilder == null) {
            mapBuilder = new MapBuilder(battleGround);
        }
        return mapBuilder;
    }
}

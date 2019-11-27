package main;

import java.util.ArrayList;

public final class MapBuilder {
    private static MapBuilder mapBuilder = null;

    ArrayList<String> battleGround;

    private MapBuilder(ArrayList<String> battleGround) {
        this.battleGround = battleGround;
    }

    public ArrayList<String> getBattleGround() {
        return battleGround;
    }

    public static MapBuilder getInstance(ArrayList<String> battleGround) {
        if (mapBuilder == null) {
            mapBuilder = new MapBuilder(battleGround);
        }
        return mapBuilder;
    }
}

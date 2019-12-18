package main;

import java.util.ArrayList;

public final class Input {

    // Input fields.
    private final int n;
    private final int m;
    private final int p;
    private final int r;
    private final ArrayList<String> battleGround;
    private final ArrayList<String> playerTypes;
    private final ArrayList<Integer> firstCoordonates;
    private final ArrayList<Integer> secondCoordonates;
    private final ArrayList<String> moves;

    public Input() {
        n = 0;
        m = 0;
        p = 0;
        r = 0;
        battleGround = null;
        playerTypes = null;
        secondCoordonates = null;
        firstCoordonates = null;
        moves = null;
    }

    public Input(final int n, final int m, final ArrayList<String> battleGround, final int p,
                 final ArrayList<String> playerTypes, final ArrayList<Integer> firstCoordonates,
                 final ArrayList<Integer> secondCoordonates, final int r,
                 final ArrayList<String> moves) {
        this.n = n;
        this.m = m;
        this.battleGround = battleGround;
        this.p = p;
        this.playerTypes = playerTypes;
        this.firstCoordonates = firstCoordonates;
        this.secondCoordonates = secondCoordonates;
        this.r = r;
        this.moves = moves;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getP() {
        return p;
    }

    public int getR() {
        return r;
    }

    public ArrayList<String> getBattleGround() {
        return battleGround;
    }

    public ArrayList<String> getPlayerTypes() {
        return playerTypes;
    }

    public ArrayList<Integer> getFirstCoordonates() {
        return firstCoordonates;
    }

    public ArrayList<Integer> getSecondCoordonates() {
        return secondCoordonates;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

}

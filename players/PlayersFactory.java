package players;

public final class PlayersFactory {
    // It returns a player of certain stats and certain type.
    public Human getPlayer(final String type, final int abs, final int ord) {
        if (type.equalsIgnoreCase("R")) {
            return new Rogue(abs, ord);
        } else if (type.equalsIgnoreCase("W")) {
            return new Wizard(abs, ord);
        } else if (type.equalsIgnoreCase("P")) {
            return new Pyromancer(abs, ord);
        } else if (type.equalsIgnoreCase("K")) {
            return new Knight(abs, ord);
        }

        return null;
    }
}

package players;

import constants.Constants;

public class Knight extends Human implements Visitable, Visitor {
    Knight(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_ONE);
        setHp(Constants.DEFAULT_KNIGHT_HP);
        setMaxHp(Constants.DEFAULT_KNIGHT_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setPlayerNumber(getPlayerNumber() + 1);
    }

    // Accept the visitor.
    @Override
    public final void accept(final Visitor visitor) {
        visitor.fight(this);
    }

    @Override
    public final void fight(final Pyromancer pyromancer) {
        super.pyroGame(pyromancer, Constants.FB_IGN_KNIGHT_MOD,
                Constants.FB_IGN_KNIGHT_MOD, Constants.VOLCANIC_GRD_BONUS);
    }

    // Be the visitor.
    @Override
    public final void fight(final Rogue rogue) {
        super.rogueGame(rogue, Constants.BACKSTAB_KNIGHT_MOD,
                Constants.PARALYSIS_KNIGHT_MOD, Constants.WOODS_GRD_BONUS);
    }

    @Override
    public final void fight(final Knight knight) {
        super.knightGame(knight, Constants.EXEC_KNIGHT_MOD,
                Constants.SLAM_KNIGHT_MOD, Constants.LAND_GRD_BONUS);

    }

    @Override
    public final void fight(final Wizard wizard) {
        super.wizardGame(wizard, Constants.DRAIN_KNIGHT_MOD,
                Constants.DEFLECT_KNIGHT_MOD, Constants.DESERT_GRD_BONUS);
    }
}

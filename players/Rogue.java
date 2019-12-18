package players;

import constants.Constants;

public class Rogue extends Human implements Visitable, Visitor {
    Rogue(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_THREE);
        setHp(Constants.DEFAULT_ROGUE_HP);
        setMaxHp(Constants.DEFAULT_ROGUE_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setPlayerNumber(getPlayerNumber() + 1);
    }

    // Accept the visitor.
    @Override
    public final void accept(final Visitor visitor) {
        visitor.fight(this);
    }

    // Be the visitor.
    @Override
    public final void fight(final Pyromancer pyromancer) {
        super.pyroGame(pyromancer, Constants.FB_ROGUE_MOD,
                Constants.IGNITE_ROGUE_MOD, Constants.VOLCANIC_GRD_BONUS);
    }

    @Override
    public final void fight(final Rogue rogue) {
        super.rogueGame(rogue, Constants.BACKSTAB_ROGUE_MOD,
                Constants.PARALYSIS_ROGUE_MOD, Constants.WOODS_GRD_BONUS);
    }

    @Override
    public final void fight(final Knight knight) {
        super.knightGame(knight, Constants.EXEC_ROGUE_MOD,
                Constants.SLAM_ROGUE_MOD, Constants.LAND_GRD_BONUS);
    }

    @Override
    public final void fight(final Wizard wizard) {
        super.wizardGame(wizard, Constants.DRAIN_ROGUE_MOD,
                Constants.DEFLECT_ROGUE_MOD, Constants.DESERT_GRD_BONUS);
    }
}

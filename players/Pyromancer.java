package players;

import constants.Constants;

public class Pyromancer extends Human implements Visitable, Visitor {
    Pyromancer(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_ZERO);
        setHp(Constants.DEFAULT_PYRO_HP);
        setMaxHp(Constants.DEFAULT_PYRO_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
    }

    // Accept he visitor.
    @Override
    public final void accept(final Visitor visitor) {
        visitor.fight(this);
    }

    // Be the visitor.
    @Override
    public final void fight(final Pyromancer pyromancer) {
        super.pyroGame(pyromancer, Constants.FB_IGN_PYRO_MOD,
                Constants.FB_IGN_PYRO_MOD, Constants.VOLCANIC_GRD_BONUS);
    }

    @Override
    public final void fight(final Rogue rogue) {
        super.rogueGame(rogue, Constants.BACKSTAB_PYRO_MOD,
                Constants.PARALYSIS_PYRO_MOD, Constants.WOODS_GRD_BONUS);
    }

    @Override
    public final void fight(final Knight knight) {
        super.knightGame(knight, Constants.EXEC_PYRO_MOD,
                Constants.SLAM_PYRO_MOD, Constants.LAND_GRD_BONUS);
    }

    @Override
    public final void fight(final Wizard wizard) {
        super.wizardGame(wizard, Constants.DRAIN_PYRO_MOD,
                Constants.DEFLECT_PYRO_MOD, Constants.DESERT_GRD_BONUS);
    }
}

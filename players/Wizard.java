package players;

import constants.Constants;

public class Wizard extends Human implements Visitable, Visitor {
    Wizard(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_TWO);
        setHp(Constants.DEFAULT_WIZARD_HP);
        setMaxHp(Constants.DEFAULT_WIZARD_HP);
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
        super.pyroGame(pyromancer, Constants.FB_IGN_WIZARD_MOD,
                Constants.FB_IGN_WIZARD_MOD, Constants.VOLCANIC_GRD_BONUS);
    }

    @Override
    public final void fight(final Rogue rogue) {
        super.rogueGame(rogue, Constants.BACKSTAB_PARALYSIS_WIZARD_MOD,
                Constants.BACKSTAB_PARALYSIS_WIZARD_MOD, Constants.WOODS_GRD_BONUS);
    }

    @Override
    public final void fight(final Knight knight) {
        super.knightGame(knight, Constants.EXECUTE_WIZARD_MOD,
                Constants.SLAM_WIZARD_MOD, Constants.LAND_GRD_BONUS);
    }

    @Override
    public final void fight(final Wizard wizard) {
        super.wizardGame(wizard, Constants.DRAIN_WIZARD_MOD,
                Constants.DRAIN_WIZARD_MOD, Constants.DESERT_GRD_BONUS);
    }
}

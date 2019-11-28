package players;

import constants.Constants;

public class Pyromancer extends Human implements Visitable, Visitor {
    Pyromancer(final int abscissa, final int ordinate) {
        setPlayerType(0);
        setHp(Constants.DEFAULT_PYRO_HP);
        setMaxHp(Constants.DEFAULT_PYRO_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
    }

    @Override
    public void computeLevel() {
        if (getXp() >= 250 + getLevel() * 50) {
            setLevel(getLevel() + 1);
            setMaxHp(getMaxHp() + Constants.PYRO_INCREASE);
            setHp(getMaxHp());
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.fight(this);
    }

    // Visit from visitor
    @Override
    public void fight(Pyromancer pyromancer) {
        super.checkOverTimeAbility();
        super.pyroGame(pyromancer, Constants.FB_IGN_PYRO_MOD, Constants.FB_IGN_PYRO_MOD, Constants.VOLCANIC_GRD_BONUS);
    }

    @Override
    public void fight(Rogue rogue) {

    }

    @Override
    public void fight(Knight knight) {
        super.checkOverTimeAbility();
        super.knightGame(knight, Constants.EXEC_PYRO_MOD, Constants.SLAM_PYRO_MOD, Constants.LAND_GRD_BONUS);
    }

    @Override
    public void fight(Wizard wizard) {

    }
}

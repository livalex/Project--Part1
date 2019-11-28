package players;

import constants.Constants;

public class Knight extends Human implements Visitable, Visitor {
    Knight(final int abscissa, final int ordinate) {
        setPlayerType(1);
        setHp(Constants.DEFAULT_KNIGHT_HP);
        setMaxHp(Constants.DEFAULT_KNIGHT_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
    }

    @Override
    public void computeLevel() {
        if (getXp() >= 250 + getLevel() * 50) {
            setLevel(getLevel() + 1);
            setMaxHp(getMaxHp() + Constants.KNIGHT_INCREASE);
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
        super.pyroGame(pyromancer, Constants.FB_IGN_KNIGHT_MOD,
                Constants.FB_IGN_KNIGHT_MOD, Constants.VOLCANIC_GRD_BONUS);
    }

    @Override
    public void fight(Rogue rogue) {

    }

    @Override
    public void fight(Knight knight) {
        super.checkOverTimeAbility();
        super.knightGame(knight, Constants.EXEC_KNIGHT_MOD, Constants.SLAM_KNIGHT_MOD, Constants.LAND_GRD_BONUS);
    }

    @Override
    public void fight(Wizard wizard) {

    }

}

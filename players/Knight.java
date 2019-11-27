package players;

import constants.Constants;

public class Knight extends Human implements Visitable, Visitor {
    Knight(final int abscissa, final int ordinate) {
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

    public void accept(Visitor visitor) {
        visitor.fight(this);
    }

    // Visit from visitor
    public void fight(Pyromancer pyromancer) {

    }

    public void fight(Rogue rogue) {

    }

    public void fight(Knight knight) {

    }

    public void fight(Wizard wizard) {

    }

}

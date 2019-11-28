package players;

import constants.Constants;

public class Wizard extends Human implements Visitable, Visitor {
    Wizard(final int abscissa, final int ordinate) {
        setPlayerType(2);
        setHp(Constants.DEFAULT_WIZARD_HP);
        setMaxHp(Constants.DEFAULT_WIZARD_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
    }

    @Override
    public void computeLevel() {
        if (getXp() >= 250 + getLevel() * 50) {
            setLevel(getLevel() + 1);
            setMaxHp(getMaxHp() + Constants.WIZARD_INCREASE);
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
        if (!isDead()) {
            if (isNewOvertimeAffection()) {
                if (isIgniteFlag()) {
                    setOveryimeAbilityCounter(2);
                    setHp(getHp() - getIgniteDmgTakeRound());
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            } else {
                if (isIgniteFlag()) {
                    setHp(getHp() - getIgniteDmgTakeRound());
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getOveryimeAbilityCounter() == 0) {
                        setIgniteFlag(false);
                        setOveryimeAbilityCounter(2);
                    }
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            }
        }

        setNewOvertimeAffection(false);

        if (!isDead()) {
            pyromancer.setFireBlast(pyromancer.getFireBlast() + pyromancer.getLevel() * Constants.PYRO_INCREASE);
            pyromancer.setIgnite(pyromancer.getIgnite() + pyromancer.getLevel() * Constants.IGN_LVL_DMG);
            pyromancer.setIgniteDmgGiveRound(pyromancer.getIgniteDmgGiveRound() +
                    pyromancer.getLevel() * Constants.IGN_SEC_LVL_DMG);

            if (pyromancer.getCurrentGround() == 1) {
                pyromancer.setFireBlast(Math.round(pyromancer.getFireBlast() +
                        Constants.VOLCANIC_GRD_BONUS * pyromancer.getFireBlast()));
                pyromancer.setIgnite(Math.round(pyromancer.getIgnite() +
                        Constants.VOLCANIC_GRD_BONUS * pyromancer.getIgnite()));
                pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound() +
                        Constants.VOLCANIC_GRD_BONUS * pyromancer.getIgniteDmgGiveRound()));
            }

            pyromancer.setFireBlast(Math.round(pyromancer.getFireBlast() -
                    Constants.FB_IGN_WIZARD_MOD * pyromancer.getFireBlast()));
            pyromancer.setIgnite(Math.round(pyromancer.getIgnite() -
                    Constants.FB_IGN_WIZARD_MOD * pyromancer.getIgnite()));
            pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound() -
                    Constants.FB_IGN_WIZARD_MOD * pyromancer.getIgniteDmgGiveRound()));

            setIgniteDmgTakeRound(pyromancer.getIgniteDmgGiveRound());
            setNewOvertimeAffection(true);
            setIgniteFlag(true);
            setImmobility(false);

            int finalDamage = pyromancer.getFireBlast() + pyromancer.getIgnite();
            setHp(getHp() - finalDamage);

            if (getHp() <= 0) {
                setDead(true);
                pyromancer.setXp(Math.max(0, 200 - (pyromancer.getLevel() - getLevel()) * 40));
            }
        }
    }

    @Override
    public void fight(Rogue rogue) {

    }

    @Override
    public void fight(Knight knight) {

    }

    @Override
    public void fight(Wizard wizard) {

    }

}

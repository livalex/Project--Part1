package players;

import constants.Constants;

public class Pyromancer extends Human implements Visitable, Visitor {
    Pyromancer(final int abscissa, final int ordinate) {
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

    public void accept(Visitor visitor) {
        visitor.fight(this);
    }

    // Visit from visitor
    public void fight(Pyromancer pyromancer) {
        if (isDead() == false) {
            if (isNewOvertimeAffection() == true) {
                if (isIgniteFlag() == true) {
                    setIgniteCounterRounds(2);
                    setHp(getHp() - getIgniteDmgTakeRound());
                    setIgniteCounterRounds(getIgniteCounterRounds() - 1);
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            } else {
                if (isIgniteFlag() == true) {
                    setHp(getHp() - getIgniteDmgTakeRound());
                    setIgniteCounterRounds(getIgniteCounterRounds() - 1);
                    if (getIgniteCounterRounds() == 0) {
                        setIgniteFlag(false);
                        setIgniteCounterRounds(2);
                    }
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            }
        }

        setNewOvertimeAffection(false);

        if (isDead() == false) {
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
                    Constants.FB_IGN_PYRO_MOD * pyromancer.getFireBlast()));
            pyromancer.setIgnite(Math.round(pyromancer.getIgnite() -
                    Constants.FB_IGN_PYRO_MOD * pyromancer.getIgnite()));
            pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound() -
                    Constants.FB_IGN_PYRO_MOD * pyromancer.getIgniteDmgGiveRound()));

            setIgniteDmgTakeRound(pyromancer.getIgniteDmgGiveRound());
            setNewOvertimeAffection(true);
            setIgniteFlag(true);

            int finalDamage = pyromancer.getFireBlast() + pyromancer.getIgnite();
            setHp(getHp() - finalDamage);

            if (getHp() <= 0) {
                setDead(true);
                pyromancer.setXp(Math.max(0, 200 - (pyromancer.getLevel() - getLevel()) * 40));
            }
        }
    }

    public void fight(Rogue rogue) {

    }

    public void fight(Knight knight) {

    }

    public void fight(Wizard wizard) {

    }
}

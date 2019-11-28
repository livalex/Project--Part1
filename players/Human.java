package players;

import constants.Constants;

public abstract class Human implements Visitor, Visitable {
    private int hp = Constants.STARTING_HP;
    private int xp = Constants.STARTING_XP;
    private int currentGround = Constants.STARTING_GROUND;
    private int currentAbscissa = Constants.DEFAULT_ABSCISSA;
    private int currentOrdinate = Constants.DEFAULT_ORDINATE;
    private int level = Constants.DEFAULT_LEVEL;
    private int maxHp = Constants.STARTING_HP;
    private boolean igniteFlag = false;
    private boolean dead = false;
    private int overyimeAbilityCounter = 2;
    private int fireBlast = Constants.FIREBLAST_DAMAGE;
    private int ignite = Constants.IGNITE_BASE_DAMAGE;
    private int igniteDmgTakeRound = Constants.PYRO_INCREASE;
    private int igniteDmgGiveRound = Constants.PYRO_INCREASE;
    private boolean newOvertimeAffection = false;
    private int playerType = Constants.DEFAULT_PLAYER;
    private int execute = Constants.EXECUTE_DAMAGE;
    private int slam = Constants.SLAM_DAMAGE;
    private boolean immobility = false;

    public boolean isImmobility() {
        return immobility;
    }

    public void setImmobility(boolean immobility) {
        this.immobility = immobility;
    }

    public int getSlam() {
        return slam;
    }

    public void setSlam(int slam) {
        this.slam = slam;
    }

    public int getExecute() {
        return execute;
    }

    public void setExecute(int execute) {
        this.execute = execute;
    }

    public int getPlayerType() {
        return playerType;
    }

    public void setPlayerType(int playerType) {
        this.playerType = playerType;
    }

    public boolean isNewOvertimeAffection() {
        return newOvertimeAffection;
    }

    public void setNewOvertimeAffection(boolean newOvertimeAffection) {
        this.newOvertimeAffection = newOvertimeAffection;
    }

    public int getIgniteDmgGiveRound() {
        return igniteDmgGiveRound;
    }

    public void setIgniteDmgGiveRound(int igniteDmgGiveRound) {
        this.igniteDmgGiveRound = igniteDmgGiveRound;
    }

    public int getIgniteDmgTakeRound() {
        return igniteDmgTakeRound;
    }

    public void setIgniteDmgTakeRound(int igniteDmgRound) {
        this.igniteDmgTakeRound = igniteDmgRound;
    }

    public int getFireBlast() {
        return fireBlast;
    }

    public void setFireBlast(int fireBlast) {
        this.fireBlast = fireBlast;
    }

    public int getIgnite() {
        return ignite;
    }

    public void setIgnite(int ignite) {
        this.ignite = ignite;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isIgniteFlag() {
        return igniteFlag;
    }

    public void setIgniteFlag(boolean igniteFlag) {
        this.igniteFlag = igniteFlag;
    }

    public int getOveryimeAbilityCounter() {
        return overyimeAbilityCounter;
    }

    public void setOveryimeAbilityCounter(int overyimeAbilityCounter) {
        this.overyimeAbilityCounter = overyimeAbilityCounter;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCurrentGround() {
        return currentGround;
    }

    public void setCurrentGround(int currentGround) {
        this.currentGround = currentGround;
    }

    public int getCurrentAbscissa() {
        return currentAbscissa;
    }

    public void setCurrentAbscissa(int currentAbscissa) {
        this.currentAbscissa = currentAbscissa;
    }

    public int getCurrentOrdinate() {
        return currentOrdinate;
    }

    public void setCurrentOrdinate(int currentOrdinate) {
        this.currentOrdinate = currentOrdinate;
    }

    public abstract void computeLevel();

    public abstract void accept(Visitor visitor);

    public abstract void fight(Pyromancer pyromancer);

    public abstract void fight(Rogue rogue);

    public abstract void fight(Knight knight);

    public abstract void fight(Wizard wizard);

    public void checkOverTimeAbility() {
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
    }

    public void pyroGame(Pyromancer pyromancer, float modifier1, float modifier2, float groundBonus) {
        if (!isDead()) {
            pyromancer.setFireBlast(Constants.FIREBLAST_DAMAGE + pyromancer.getLevel() * Constants.PYRO_INCREASE);
            pyromancer.setIgnite(Constants.IGNITE_BASE_DAMAGE + pyromancer.getLevel() * Constants.IGN_LVL_DMG);
            pyromancer.setIgniteDmgGiveRound(Constants.PYRO_INCREASE +
                    pyromancer.getLevel() * Constants.IGN_SEC_LVL_DMG);

            if (pyromancer.getCurrentGround() == 1) {
                pyromancer.setFireBlast(Math.round(pyromancer.getFireBlast() +
                        groundBonus * pyromancer.getFireBlast()));
                pyromancer.setIgnite(Math.round(pyromancer.getIgnite() +
                        groundBonus * pyromancer.getIgnite()));
                pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound() +
                        groundBonus * pyromancer.getIgniteDmgGiveRound()));
            }

            pyromancer.setFireBlast(Math.round(pyromancer.getFireBlast() +
                    modifier1 * pyromancer.getFireBlast()));
            pyromancer.setIgnite(Math.round(pyromancer.getIgnite() +
                    modifier2 * pyromancer.getIgnite()));
            pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound() +
                    modifier2 * pyromancer.getIgniteDmgGiveRound()));

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

    public void knightGame(Knight knight, float modifier1, float modifier2, float groundBonus) {
        if (!isDead()) {
            float percentage = Constants.HP_LIMIT_FPARAM + knight.getLevel() * Constants.HP_LIMIT_SPARAM;
            if (percentage > Constants.MAX_KNIGHT_HP_LIMIT) {
                percentage = Constants.MAX_KNIGHT_HP_LIMIT;
            }
            int hpLimit = Math.round(percentage * getMaxHp());

            if (getHp() < hpLimit) {
                setDead(true);
                knight.setXp(Math.max(0, 200 - (knight.getLevel() - getLevel()) * 40));
            } else {
                knight.setExecute(Constants.EXECUTE_DAMAGE + knight.getLevel() * Constants.EXECUTE_INCREASE);
                knight.setSlam(Constants.SLAM_DAMAGE + knight.getLevel() * Constants.SLAM_INCREASE);

                if (knight.getCurrentGround() == 0) {
                    knight.setExecute(Math.round(knight.getExecute() + groundBonus * knight.getExecute()));
                    knight.setSlam(Math.round(knight.getSlam() + groundBonus * knight.getSlam()));
                }

                knight.setExecute(Math.round(knight.getExecute() + modifier1 * knight.getExecute()));
                knight.setSlam(Math.round(knight.getSlam() + modifier2 * knight.getSlam()));

                setNewOvertimeAffection(true);
                setIgniteFlag(false);
                setImmobility(true);

                int finalDamage = knight.getExecute() + knight.getSlam();
                setHp(getHp() - finalDamage);

                if (getHp() <= 0) {
                    setDead(true);
                    knight.setXp(Math.max(0, 200 - (knight.getLevel() - getLevel()) * 40));
                }
            }
        }
    }
}

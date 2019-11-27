package players;

import constants.Constants;

public abstract class Human {
    private int hp = Constants.STARTING_HP;
    private int xp = Constants.STARTING_XP;
    private int currentGround = Constants.STARTING_GROUND;
    private int currentAbscissa = Constants.DEFAULT_ABSCISSA;
    private int currentOrdinate = Constants.DEFAULT_ORDINATE;
    private int level = Constants.DEFAULT_LEVEL;
    private int maxHp = Constants.STARTING_HP;
    private boolean igniteFlag = false;
    private boolean dead = false;
    private int igniteCounterRounds = 2;
    private int fireBlast = Constants.FIREBLAST_DAMAGE;
    private int ignite = Constants.IGNITE_BASE_DAMAGE;
    private int igniteDmgTakeRound = Constants.PYRO_INCREASE;
    private int igniteDmgGiveRound = Constants.PYRO_INCREASE;
    private boolean newOvertimeAffection = false;

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

    public int getIgniteCounterRounds() {
        return igniteCounterRounds;
    }

    public void setIgniteCounterRounds(int igniteCounterRounds) {
        this.igniteCounterRounds = igniteCounterRounds;
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
}

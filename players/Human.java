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
    private int overyimeAbilityCounter = Constants.ABILITY_COUNTER;
    private int fireBlast = Constants.FIREBLAST_DAMAGE;
    private int ignite = Constants.IGNITE_BASE_DAMAGE;
    private int igniteDmgTakeRound = Constants.PYRO_INCREASE;
    private int igniteDmgGiveRound = Constants.PYRO_INCREASE;
    private boolean newOvertimeAffection = false;
    private int playerType = Constants.DEFAULT_PLAYER;
    private int execute = Constants.EXECUTE_DAMAGE;
    private int slam = Constants.SLAM_DAMAGE;
    private boolean immobility = false;
    private int backStabCounter = Constants.DEFAULT_BS_COUNTER;
    private int backStab = Constants.BACKSTAB_DEFAULT_DAMAGE;
    private boolean paralysed = false;
    private int paralysis = Constants.PARALYSIS_DEFAULT_DAMAGE;
    private boolean woodsHitFlag = false;
    private int paralysisDmgTakeRound = Constants.DEFAULT_STARTING_VALUE;
    private int noRaceDamage = Constants.DEFAULT_STARTING_VALUE;
    private int playerNumber = Constants.DEFAULT_PLAYER_NUMBER;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public final int getNoRaceDamage() {
        return noRaceDamage;
    }

    public final void setNoRaceDamage(final int noRaceDamage) {
        this.noRaceDamage = noRaceDamage;
    }

    public final int getParalysisDmgTakeRound() {
        return paralysisDmgTakeRound;
    }

    public final void setParalysisDmgTakeRound(final int paralysisDmgTakeRound) {
        this.paralysisDmgTakeRound = paralysisDmgTakeRound;
    }

    public final boolean isWoodsHitFlag() {
        return woodsHitFlag;
    }

    public final void setWoodsHitFlag(final boolean woodsHitFlag) {
        this.woodsHitFlag = woodsHitFlag;
    }

    public final boolean isParalysed() {
        return paralysed;
    }

    public final void setParalysed(final boolean paralysed) {
        this.paralysed = paralysed;
    }

    public final int getParalysis() {
        return paralysis;
    }

    public final void setParalysis(final int paralysis) {
        this.paralysis = paralysis;
    }

    public final int getBackStabCounter() {
        return backStabCounter;
    }

    public final void setBackStabCounter(final int backStabCounter) {
        this.backStabCounter = backStabCounter;
    }

    public final int getBackStab() {
        return backStab;
    }

    public final void setBackStab(final int backStab) {
        this.backStab = backStab;
    }

    public final boolean isImmobility() {
        return immobility;
    }

    public final void setImmobility(final boolean immobility) {
        this.immobility = immobility;
    }

    public final int getSlam() {
        return slam;
    }

    public final void setSlam(final int slam) {
        this.slam = slam;
    }

    public final int getExecute() {
        return execute;
    }

    public final void setExecute(final int execute) {
        this.execute = execute;
    }

    public final int getPlayerType() {
        return playerType;
    }

    public final void setPlayerType(final int playerType) {
        this.playerType = playerType;
    }

    public final boolean isNewOvertimeAffection() {
        return newOvertimeAffection;
    }

    public final void setNewOvertimeAffection(final boolean newOvertimeAffection) {
        this.newOvertimeAffection = newOvertimeAffection;
    }

    public final int getIgniteDmgGiveRound() {
        return igniteDmgGiveRound;
    }

    public final void setIgniteDmgGiveRound(final int igniteDmgGiveRound) {
        this.igniteDmgGiveRound = igniteDmgGiveRound;
    }

    public final int getIgniteDmgTakeRound() {
        return igniteDmgTakeRound;
    }

    public final void setIgniteDmgTakeRound(final int igniteDmgRound) {
        this.igniteDmgTakeRound = igniteDmgRound;
    }

    public final int getFireBlast() {
        return fireBlast;
    }

    public final void setFireBlast(final int fireBlast) {
        this.fireBlast = fireBlast;
    }

    public final int getIgnite() {
        return ignite;
    }

    public final void setIgnite(final int ignite) {
        this.ignite = ignite;
    }

    public final boolean isDead() {
        return dead;
    }

    public final void setDead(final boolean dead) {
        this.dead = dead;
    }

    public final boolean isIgniteFlag() {
        return igniteFlag;
    }

    public final void setIgniteFlag(final boolean igniteFlag) {
        this.igniteFlag = igniteFlag;
    }

    public final int getOveryimeAbilityCounter() {
        return overyimeAbilityCounter;
    }

    public final void setOveryimeAbilityCounter(final int overyimeAbilityCounter) {
        this.overyimeAbilityCounter = overyimeAbilityCounter;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    public final void setMaxHp(final int maxHp) {
        this.maxHp = maxHp;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getHp() {
        return hp;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    public final int getXp() {
        return xp;
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final int getCurrentGround() {
        return currentGround;
    }

    public final void setCurrentGround(final int currentGround) {
        this.currentGround = currentGround;
    }

    public final int getCurrentAbscissa() {
        return currentAbscissa;
    }

    public final void setCurrentAbscissa(final int currentAbscissa) {
        this.currentAbscissa = currentAbscissa;
    }

    public final int getCurrentOrdinate() {
        return currentOrdinate;
    }

    public final void setCurrentOrdinate(final int currentOrdinate) {
        this.currentOrdinate = currentOrdinate;
    }

    public abstract void accept(Visitor visitor);

    public abstract void fight(Pyromancer pyromancer);

    public abstract void fight(Rogue rogue);

    public abstract void fight(Knight knight);

    public abstract void fight(Wizard wizard);

    // Check the player's overtime ability and
    // If any of them affects a player, update
    // The player's stats.
    public final void checkOverTimeAbility() {
        if (!isDead()) {
            // The effect has just been given.
            if (isNewOvertimeAffection()) {
                // For Paralysed effect.
                if (isParalysed()) {
                    if (isWoodsHitFlag()) {
                        setOveryimeAbilityCounter(Constants.WOODS_HIT);
                        setWoodsHitFlag(false);
                    } else {
                        setOveryimeAbilityCounter(Constants.NORMAL_HIT);
                    }

                    setHp(getHp() - getParalysisDmgTakeRound());
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }

                // For ignite effect
                if (isIgniteFlag()) {
                    setOveryimeAbilityCounter(2);
                    setHp(getHp() - getIgniteDmgTakeRound());
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            } else {
                // Same thing as above
                // But for abilities that have been given
                // Earlier in the game.
                if (isIgniteFlag()) {
                    setHp(getHp() - getIgniteDmgTakeRound());
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getOveryimeAbilityCounter() == 0) {
                        setIgniteFlag(false);
                    }
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }

                if (isParalysed()) {
                    setHp(getHp() - getParalysisDmgTakeRound());
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getOveryimeAbilityCounter() == 0) {
                        setParalysed(false);
                        setOveryimeAbilityCounter(0);
                    }
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            }
        }
        setNewOvertimeAffection(false);
        setImmobility(false);
    }

    /**
     * The way wizard strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param wizard
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void wizardGame(final Wizard wizard, final float modifier1,
                           final float modifier2, final float groundBonus) {
        float percentage;
        int drainDamage;
        int finalDamage;
        int deflectDamage = 0;

        // Level factor.
        percentage = Constants.WIZARD_PROCENT + wizard.getLevel()
                * Constants.WIZARD_LEVEL_MULTIPLIER;

        // Ground factor.
        if (wizard.getCurrentGround() == 2) {
            percentage = percentage + groundBonus * percentage;
        }

        // Modifiers factor.
        percentage = percentage + modifier1 * percentage;

        drainDamage = Math.round(percentage
                * Math.min(Constants.WIZARD_MULTIPLIER_FACTOR * getMaxHp(), getHp()));

        // Check for wizard vs wizard.
        if (getPlayerType() != 2) {
            float percentageOperator = 0.0f;

            // Level factor.
            percentageOperator = Constants.DEFLECT_PERCENTAGE + wizard.getLevel()
                    * Constants.DEFLECT_LVL_MULTIPLIER;


            if (percentageOperator > Constants.DEFLECT_MAX_PERCENTAGE) {
                percentageOperator = Constants.DEFLECT_MAX_PERCENTAGE;
            }

            // Ground factor.
            if (getCurrentGround() == 2) {
                percentageOperator = percentageOperator + groundBonus * percentageOperator;  // !!!!
            }

            // Modifiers factor.
            percentageOperator = percentageOperator + modifier2 * percentageOperator;
            deflectDamage = Math.round(percentageOperator * getNoRaceDamage());
        }

        if (getPlayerType() != 2) {
            // In case of wizard vs any other player.
            finalDamage = drainDamage + deflectDamage;
        } else {
            // In case of wizard vs wizard.
            finalDamage = drainDamage;
        }

        setHp(getHp() - finalDamage);

        if (getHp() <= 0) {
            setDead(true);
        }

    }

    /**
     * The way pyromancer strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param pyromancer
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void pyroGame(final Pyromancer pyromancer, final float modifier1,
                         final float modifier2, final float groundBonus) {

        // Level factor.
        pyromancer.setFireBlast(Constants.FIREBLAST_DAMAGE
                + pyromancer.getLevel() * Constants.PYRO_INCREASE);
        pyromancer.setIgnite(Constants.IGNITE_BASE_DAMAGE
                + pyromancer.getLevel() * Constants.IGN_LVL_DMG);
        pyromancer.setIgniteDmgGiveRound(Constants.PYRO_INCREASE
                + pyromancer.getLevel() * Constants.IGN_SEC_LVL_DMG);

        // Ground factor.
        if (pyromancer.getCurrentGround() == 1) {
            pyromancer.setFireBlast(Math.round(pyromancer.getFireBlast()
                    + groundBonus * pyromancer.getFireBlast()));
            pyromancer.setIgnite(Math.round(pyromancer.getIgnite()
                    + groundBonus * pyromancer.getIgnite()));
            pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound()
                    + groundBonus * pyromancer.getIgniteDmgGiveRound()));
        }

        // Damage taken as a parameter for the deflect ability of the wizard.
        pyromancer.setNoRaceDamage(pyromancer.getFireBlast() + pyromancer.getIgnite());

        // Modifiers factor.
        pyromancer.setFireBlast(Math.round(pyromancer.getFireBlast()
                + modifier1 * pyromancer.getFireBlast()));
        pyromancer.setIgnite(Math.round(pyromancer.getIgnite()
                + modifier2 * pyromancer.getIgnite()));
        pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound()
                + modifier2 * pyromancer.getIgniteDmgGiveRound()));

        // Turn on the new affection and ignite flags and off the others.
        setIgniteDmgTakeRound(pyromancer.getIgniteDmgGiveRound());
        setNewOvertimeAffection(true);
        setIgniteFlag(true);
        setImmobility(false);
        setParalysed(false);

        int finalDamage = pyromancer.getFireBlast() + pyromancer.getIgnite();
        setHp(getHp() - finalDamage);

        if (getHp() <= 0) {
            setDead(true);
        }
    }

    /**
     * The way knight strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param knight
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void knightGame(final Knight knight, final float modifier1,
                           final float modifier2, final float groundBonus) {
        float percentage = Constants.HP_LIMIT_FPARAM
                + knight.getLevel() * Constants.HP_LIMIT_SPARAM;
        if (percentage > Constants.MAX_KNIGHT_HP_LIMIT) {
            percentage = Constants.MAX_KNIGHT_HP_LIMIT;
        }
        int hpLimit = Math.round(percentage * getMaxHp());

        // Calculates if the victim immediately dies.
        if (getHp() < hpLimit) {
            setHp(0);
            setDead(true);
            knight.setXp(Math.max(0, Constants.XP_FORMULA_FACTOR
                    - (knight.getLevel() - getLevel()) * Constants.XP_FORMULA_MULTIPLICATION));
        } else {
            // Level factor.
            knight.setExecute(Constants.EXECUTE_DAMAGE
                    + knight.getLevel() * Constants.EXECUTE_INCREASE);
            knight.setSlam(Constants.SLAM_DAMAGE + knight.getLevel() * Constants.SLAM_INCREASE);

            // Ground factor.
            if (knight.getCurrentGround() == 0) {
                knight.setExecute(Math.round(knight.getExecute()
                        + groundBonus * knight.getExecute()));
                knight.setSlam(Math.round(knight.getSlam() + groundBonus * knight.getSlam()));
            }

            // Damage taken as a parameter for the deflect ability of the wizard.
            knight.setNoRaceDamage(knight.getExecute() + knight.getSlam());

            // Modifiers factor.
            knight.setExecute(Math.round(knight.getExecute() + modifier1 * knight.getExecute()));
            knight.setSlam(Math.round(knight.getSlam() + modifier2 * knight.getSlam()));

            // Turn on the new affection and immobility flags and off the others.
            setNewOvertimeAffection(true);
            setIgniteFlag(false);
            setImmobility(true);
            setParalysed(false);

            int finalDamage = knight.getExecute() + knight.getSlam();
            setHp(getHp() - finalDamage);

            if (getHp() <= 0) {
                setDead(true);
            }
        }
    }

    /**
     * The way rogue strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param rogue
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void rogueGame(final Rogue rogue, final float modifier1,
                          final float modifier2, final float groundBonus) {
        // Level factor.
        rogue.setBackStab(Constants.BACKSTAB_DEFAULT_DAMAGE
                + rogue.getLevel() * Constants.BACKSTAB_LVL_INC);
        rogue.setParalysis(Constants.PARALYSIS_DEFAULT_DAMAGE
                + rogue.getLevel() * Constants.PARALYSIS_LVL_INC);

        // Ground factor.
        if (rogue.getCurrentGround() == Constants.THREE_TYPE_GROUND) {
            rogue.setBackStab(Math.round(rogue.getBackStab()
                    + groundBonus * rogue.getBackStab()));
            rogue.setParalysis(Math.round(rogue.getParalysis()
                    + groundBonus * rogue.getParalysis()));
            setWoodsHitFlag(true);
        }

        // Damage taken as a parameter for the deflect ability of the wizard.
        // It also adds the critical hit factor.
        if (rogue.getCurrentGround() == Constants.THREE_TYPE_GROUND
                && rogue.getBackStabCounter() == Constants.DEFAULT_BS_COUNTER) {
            rogue.setNoRaceDamage(Math.round(rogue.getBackStab() * Constants.CRITICAL_HIT)
                    + rogue.getParalysis());
        } else {
            rogue.setNoRaceDamage(rogue.getBackStab() + rogue.getParalysis());
        }

        // Modifiers factor.
        rogue.setBackStab(Math.round(rogue.getBackStab() + modifier1 * rogue.getBackStab()));
        rogue.setParalysis(Math.round(rogue.getParalysis() + modifier2 * rogue.getParalysis()));

        // Critical hit factor.
        if (rogue.getCurrentGround() == Constants.THREE_TYPE_GROUND
                && rogue.getBackStabCounter() == Constants.DEFAULT_BS_COUNTER) {
            rogue.setBackStab(Math.round(rogue.getBackStab() * Constants.CRITICAL_HIT));
            rogue.setBackStabCounter(0);
        }

        // Turn on the new affection and paralysed flags and off the others.
        setParalysisDmgTakeRound(rogue.getParalysis());
        setNewOvertimeAffection(true);
        setIgniteFlag(false);
        setImmobility(false);
        setParalysed(true);

        int finalDamage = rogue.getBackStab() + rogue.getParalysis();
        setHp(getHp() - finalDamage);
        rogue.setBackStabCounter(rogue.getBackStabCounter() + 1);

        if (getHp() <= 0) {
            setDead(true);
        }
    }
}

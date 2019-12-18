package angels;

import GameAdmin.GreatMagician;
import constants.Constants;

public abstract class Angel implements Subject {
    private int myAbscissa = Constants.DEFAULT_ABSCISSA;
    private int myOrdinate = Constants.DEFAULT_ORDINATE;
    private int angelType = Constants.DAMAGE_ANGEL;
    private GreatMagician greatMagician = GreatMagician.getInstance();

    public GreatMagician getGreatMagician() {
        return greatMagician;
    }

    public int getMyAbscissa() {
        return myAbscissa;
    }

    public void setMyAbscissa(int myAbscissa) {
        this.myAbscissa = myAbscissa;
    }

    public int getMyOrdinate() {
        return myOrdinate;
    }

    public void setMyOrdinate(int myOrdinate) {
        this.myOrdinate = myOrdinate;
    }

    public int getAngelType() {
        return angelType;
    }

    public void setAngelType(int angelType) {
        this.angelType = angelType;
    }

    @Override
    public void updateAngelAbs(final int x) {
        getGreatMagician().attachAbs(x);
    }

    @Override
    public void updateAngelOrd(final int y) {
    }

    @Override
    public void updateHelpedPlayers() {
    }

    @Override
    public void updateHitPlayers() {
    }

    @Override
    public void updateKilledPlayers() {
    }
}

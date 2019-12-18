package angels;

import constants.Constants;

public class LifeGiver extends Angel implements Subject {
    public LifeGiver(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.LIFE_GIVER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }
}

package angels;

import constants.Constants;

public class LevelUpAngel extends Angel implements Subject{
    public LevelUpAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.LEVEL_UP_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }
}

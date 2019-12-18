package angels;

import constants.Constants;

public class TheDoomer extends Angel implements Subject {

    public TheDoomer(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.THE_DOOMER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }
}

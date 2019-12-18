package angels;

import constants.Constants;

public class GoodBoy extends Angel implements Subject {
    public GoodBoy(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.GOOD_BOY_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }
}

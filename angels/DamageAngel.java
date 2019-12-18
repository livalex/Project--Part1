package angels;

import constants.Constants;

public class DamageAngel extends Angel implements Subject {

    public DamageAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.DAMAGE_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }
}

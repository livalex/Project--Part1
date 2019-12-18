package angels;

public class AngelsFactory {

    /* We use this method to get the type of
    angel that we want.
     */
    public Angel getAngel(final String angelType,
                          final int x, final int y) {
        if (angelType.equals("DamageAngel")) {
            return new DamageAngel(x, y);
        } else if (angelType.equals("DarkAngel")) {
            return new DarkAngel(x, y);
        } else if (angelType.equals("Dracula")) {
            return new Dracula(x, y);
        } else if (angelType.equals("GoodBoy")) {
            return new GoodBoy(x, y);
        } else if (angelType.equals("LevelUpAngel")) {
            return new LevelUpAngel(x, y);
        } else if (angelType.equals("LifeGiver")) {
            return new LifeGiver(x, y);
        } else if (angelType.equals("SmallAngel")) {
            return new SmallAngel(x, y);
        } else if (angelType.equals("Spawner")) {
            return new Spawner(x, y);
        } else if (angelType.equals("TheDoomer")) {
            return new TheDoomer(x, y);
        } else if (angelType.equals("XPAngel")) {
            return new XPAngel(x, y);
        }
        return null;
    }
}

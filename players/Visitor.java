package players;

import players.Rogue;
import players.Wizard;

public interface Visitor {
    public void fight(Pyromancer pyromancer);
    public void fight(Rogue rogue);
    public void fight(Knight knight);
    public void fight(Wizard wizard);
}

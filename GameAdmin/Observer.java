package GameAdmin;

import angels.Angel;
import players.Human;

public interface Observer {

    void attachAbs(final int x);

    void attachOrd(final int y);

    void attachHelpedPlayers(final Human human);

    void attachHitPlayers(final Human human);

    void attachKilledPlayers(final Human human);
}

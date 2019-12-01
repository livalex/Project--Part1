package main;

import constants.Constants;
import fileio.FileSystem;
import players.Human;

import java.util.ArrayList;

public final class InputLoader {
    private final String inpPath, outPath;

    InputLoader(final String inpPath, final String outPath) {
        this.inpPath = inpPath;
        this.outPath = outPath;
    }

    public Input load() {
        int n = 0, m = 0, p = 0, r = 0;
        ArrayList<String> battleGround = new ArrayList<>();
        ArrayList<String> playerTypes = new ArrayList<>();
        ArrayList<Integer> firstCoordonates = new ArrayList<>();
        ArrayList<Integer> secondCoordonates = new ArrayList<>();
        ArrayList<String> moves = new ArrayList<>();

        try {
            FileSystem fileSystem = new FileSystem(inpPath, outPath);

            n = fileSystem.nextInt();
            m = fileSystem.nextInt();

            for (int j = 0; j < n; ++j) {
                battleGround.add(fileSystem.nextWord());
            }

            p = fileSystem.nextInt();

            for (int j = 0; j < p; ++j) {
                playerTypes.add(fileSystem.nextWord());
                firstCoordonates.add(fileSystem.nextInt());
                secondCoordonates.add(fileSystem.nextInt());
            }

            r = fileSystem.nextInt();

            for (int j = 0; j < r; ++j) {
                moves.add(fileSystem.nextWord());
            }

            fileSystem.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Input(n, m, battleGround, p, playerTypes,
                firstCoordonates, secondCoordonates, r, moves);
    }

    // Check the first letter of the output of the player.
    public void typeDecider(final Human player, final FileSystem fileSystem) {
        try {
            if (player.getPlayerType() == Constants.PLAYER_TYPE_ZERO) {
                fileSystem.writeCharacter('P');
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_ONE) {
                fileSystem.writeCharacter('K');
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_TWO) {
                fileSystem.writeCharacter('W');
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_THREE) {
                fileSystem.writeCharacter('R');
            }
            fileSystem.writeCharacter(' ');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Used to display if the file.
    public void exposeOutput(final ArrayList<Human> players) {
        try {
            FileSystem fileSystem = new FileSystem(inpPath, outPath);

            int j, size = players.size();
            for (j = 0; j < size; ++j) {
                Human player = players.get(j);
                if (player.isDead()) {
                    typeDecider(player, fileSystem);
                    fileSystem.writeWord("dead");
                    fileSystem.writeNewLine();
                } else {
                    typeDecider(player, fileSystem);
                    fileSystem.writeInt(player.getLevel());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getXp());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getHp());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getCurrentAbscissa());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getCurrentOrdinate());
                    fileSystem.writeNewLine();
                }
            }

            fileSystem.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

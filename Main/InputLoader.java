package main;

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
            e.printStackTrace();;
        }

        return new Input(n, m, battleGround, p, playerTypes,
                firstCoordonates, secondCoordonates, r, moves);
    }

//    public void exposeDeath(Human player) {
//        FileSystem fileSystem = new FileSystem(inpPath, outPath);
//        try {
//            if (player.getPlayerType() == 0) {
//                fileSystem.writeCharacter('P');
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void exposeOutput(ArrayList<Human> players) {
        try {
            FileSystem fileSystem = new FileSystem(inpPath, outPath);

            int j, size = players.size();
            for (j = 0; j < size; ++j) {
                Human player = players.get(j);
                if (player.getHp() <= 0) {
                    if (player.getPlayerType() == 0) {
                        fileSystem.writeCharacter('P');
                    } else if (player.getPlayerType() == 1) {
                        fileSystem.writeCharacter('K');
                    } else if (player.getPlayerType() == 2) {
                        fileSystem.writeCharacter('W');
                    } else if (player.getPlayerType() == 3) {
                        fileSystem.writeCharacter('R');
                    }
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeWord("dead");
                    fileSystem.writeNewLine();
                } else {
                    if (player.getPlayerType() == 0) {
                         fileSystem.writeCharacter('P');
                    } else if (player.getPlayerType() == 1) {
                        fileSystem.writeCharacter('K');
                    } else if (player.getPlayerType() == 2) {
                        fileSystem.writeCharacter('W');
                    } else if (player.getPlayerType() == 3) {
                        fileSystem.writeCharacter('R');
                    }
                    fileSystem.writeCharacter(' ');
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

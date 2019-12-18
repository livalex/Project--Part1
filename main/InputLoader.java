package main;

import angels.Angel;
import constants.Constants;
import fileio.FileSystem;
import players.Human;

import java.util.ArrayList;

public final class InputLoader {
    private final String inpPath, outPath;
    FileSystem fileSystem;

    InputLoader(final String inpPath, final String outPath) {
        this.inpPath = inpPath;
        this.outPath = outPath;
        try {
            fileSystem = new FileSystem(inpPath, outPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // FileSystem fileSystem = new FileSystem(inpPath, outPath);

    public Input load() {
        int n = 0, m = 0, p = 0, r = 0;
        ArrayList<String> battleGround = new ArrayList<>();
        ArrayList<String> playerTypes = new ArrayList<>();
        ArrayList<Integer> firstCoordonates = new ArrayList<>();
        ArrayList<Integer> secondCoordonates = new ArrayList<>();
        ArrayList<String> moves = new ArrayList<>();
        ArrayList<Integer> numberAngelsRound = new ArrayList<>();
        ArrayList<String> angelTypes = new ArrayList<>();


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

            for (int j = 0; j < r; ++j) {
                numberAngelsRound.add(fileSystem.nextInt());
                //System.out.println(numberAngelsRound.get(j));
                if (numberAngelsRound.get(j) != 0) {
                    for (int z = 0; z < numberAngelsRound.get(j); ++z) {
                        angelTypes.add(fileSystem.nextWord());
                    }
                }
            }

            fileSystem.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Input(n, m, battleGround, p, playerTypes,
                firstCoordonates, secondCoordonates, r, moves, numberAngelsRound , angelTypes);
    }

    // Check the first letter of the output of the player.
    public void typeDecider(final Human player) {
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
            // FileSystem fileSystem = new FileSystem(inpPath, outPath);

            int j, size = players.size();
            fileSystem.writeWord("~~");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("Results");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("~~");
            fileSystem.writeNewLine();
            for (j = 0; j < size; ++j) {
                Human player = players.get(j);
                if (player.isDead()) {
                    typeDecider(player);
                    fileSystem.writeWord("dead");
                    fileSystem.writeNewLine();
                } else {
                    typeDecider(player);
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

    public void angelTypeDecider(final Angel angel, final FileSystem fileSystem) {
        try {
            if (angel.getAngelType() == Constants.DAMAGE_ANGEL) {
                fileSystem.writeWord("DamageAngel");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.DARK_ANGEL) {
                fileSystem.writeWord("DarkAngel");
                fileSystem.writeCharacter(' ');
            }  else if (angel.getAngelType() == Constants.DRACULA_ANGEL) {
                fileSystem.writeWord("Dracula");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.GOOD_BOY_ANGEL) {
                fileSystem.writeWord("GoodBoy");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.LEVEL_UP_ANGEL) {
                fileSystem.writeWord("LevelUpAngel");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.LIFE_GIVER_ANGEL) {
                fileSystem.writeWord("LifeGiver");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.SMALL_ANGEL) {
                fileSystem.writeWord("SmallAngel");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.SPAWNER_ANGEL) {
                fileSystem.writeWord("Spawner");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.THE_DOOMER_ANGEL) {
                fileSystem.writeWord("TheDoomer");
                fileSystem.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.XP_ANGEL) {
                fileSystem.writeWord("XPAngel");
                fileSystem.writeCharacter(' ');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayAngel(final Angel angel) {
        try {
            // FileSystem fileSystem = new FileSystem(inpPath, outPath);

            // System.out.println("Display");
            fileSystem.writeWord("Angel");
            fileSystem.writeCharacter(' ');
            angelTypeDecider(angel, fileSystem);
            fileSystem.writeWord("was");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("spawned");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("at");
            fileSystem.writeCharacter(' ');
            fileSystem.writeInt(angel.getMyAbscissa());
            fileSystem.writeCharacter(' ');
            fileSystem.writeInt(angel.getMyOrdinate());
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayRound(final int roundNumber) {
        try {
            //FileSystem fileSystem = new FileSystem(inpPath, outPath);

            // System.out.println("Round");
            fileSystem.writeWord("~~");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("Round");
            fileSystem.writeCharacter(' ');
            fileSystem.writeInt(roundNumber);
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("~~");
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSpace() {
        try {
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package main;

import fileio.FileSystem;
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
}

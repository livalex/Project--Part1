package main;

import angels.Angel;
import angels.AngelsFactory;

import java.util.ArrayList;

public final class AngelsVectorCreator {
    private static AngelsVectorCreator angelsVectorCreator = null;

    private AngelsVectorCreator() {
    }

    public static AngelsVectorCreator getInstance() {
        if (angelsVectorCreator == null) {
            angelsVectorCreator = new AngelsVectorCreator();
        }
        return angelsVectorCreator;
    }

    /* Using the factory pattern it adds
    angels in the 'angels' array.*/
    public ArrayList<Angel> createAngelArray(final int rounds, final AngelsFactory angelsFactory,
                                             final Input input, final InputLoader inputLoader) {
        ArrayList<Angel> angels = new ArrayList<>();

        int vectorIterator = 0;
        for (int i = 0; i < rounds; ++i) {
            inputLoader.displayRound(i + 1);
//            for (int j = 0; j < input.getNumberAngelsRound().get(i); ++j) {
//                String string = input.getAngelTypes().get(vectorIterator);
//                String angelType = string.substring(0, string.length() - 4);
//                Integer firstCoordinate = Character.getNumericValue(string.charAt(string.length() - 3));
//                Integer secondCoordinate = Character.getNumericValue(string.charAt(string.length() - 1));
//                Angel angel = angelsFactory.getAngel(angelType, firstCoordinate, secondCoordinate);
//                angels.add(angel);
//                inputLoader.displayAngel(angel);
//                // System.out.print("Angel");
//                ++vectorIterator;
//            }
        }
        return angels;
    }
}

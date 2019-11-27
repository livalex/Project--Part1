package main;

import players.Human;
import players.PlayersFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();
        MapBuilder mapBuilder = MapBuilder.getInstance(input.getBattleGround());
        PlayersFactory playersFactory = new PlayersFactory();

        ArrayList<String> ground = mapBuilder.getBattleGround();

        ArrayList<Human> players = new ArrayList<>();

        for (int i = 0; i < input.getP(); ++i) {
            String strategy = input.getPlayerTypes().get(i);
            int ab = input.getFirstCoordonates().get(i);
            int or = input.getSecondCoordonates().get(i);

            players.add(playersFactory.getPlayer(strategy, ab, or));
        }

//        System.out.println(input.getN() + " " + input.getM());
//
//        for (int i = 0; i < input.getN(); ++i) {
//            System.out.println(input.getBattleGround().get(i));
//        }
//
//        System.out.println(input.getP());
//
//        for (int i = 0; i < input.getP(); ++i) {
//            System.out.print(input.getPlayerTypes().get(i));
//            System.out.print(" ");
//            System.out.print(input.getFirstCoordonates().get(i));
//            System.out.print(" ");
//            System.out.print(input.getSecondCoordonates().get(i));
//            System.out.println();
//        }
//
//        System.out.println(input.getR());
//
//        for (int i = 0; i < input.getR(); ++i) {
//            System.out.println(input.getMoves().get(i));
//        }
    }
}

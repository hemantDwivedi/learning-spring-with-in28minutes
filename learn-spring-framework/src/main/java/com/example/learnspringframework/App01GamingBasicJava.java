package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.PacemanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacemanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}

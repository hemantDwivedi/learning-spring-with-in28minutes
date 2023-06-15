package com.example.learnspringframework.game;

public class SuperContraGame implements GamingConsole {
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Dodge");
    }

    public void left() {
        System.out.println("Back");
    }

    public void right() {
        System.out.println("Run");
    }
}

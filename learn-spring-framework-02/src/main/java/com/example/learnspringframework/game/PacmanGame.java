package com.example.learnspringframework.game;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacmanGame implements GamingConsole {
    public void up() {
        System.out.println("move up");
    }

    public void down() {
        System.out.println("move down");
    }

    public void left() {
        System.out.println("move left");
    }

    public void right() {
        System.out.println("move right");
    }
}

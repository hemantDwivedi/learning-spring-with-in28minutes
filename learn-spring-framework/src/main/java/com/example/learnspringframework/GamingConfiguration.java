package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import com.example.learnspringframework.game.PacemanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole game(){
        return new PacemanGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        return new GameRunner(game);
    }
}

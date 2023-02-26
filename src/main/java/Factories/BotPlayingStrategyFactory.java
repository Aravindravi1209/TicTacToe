package Factories;

import Models.BotDifficultyLevel;
import Strategies.BotPlayingStrategies.BotPlayingStrategy;
import Strategies.BotPlayingStrategies.RandomBotPlayingStrategy;

import static Models.BotDifficultyLevel.*;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy createBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {

//        BotPlayingStrategy strategy = null;
//
//        switch (difficultyLevel) {
//            case EASY ->
//        }

        return switch (difficultyLevel) {
            case EASY, MEDIUM, HARD -> new RandomBotPlayingStrategy();
            default -> throw new IllegalStateException("Unexpected value: " + difficultyLevel);
        };
    }
}

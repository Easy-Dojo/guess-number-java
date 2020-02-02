package com.thoughtworks.guessnumber.controllers;

import com.google.inject.Inject;
import com.thoughtworks.guessnumber.Game;
import com.thoughtworks.guessnumber.GuessResult;
import com.thoughtworks.guessnumber.commands.InputCommand;
import com.thoughtworks.guessnumber.exception.OutOfGuessCountException;
import com.thoughtworks.guessnumber.views.GameView;

import java.io.IOException;

public class GameController {
    private final Game game;
    private final GameView gameView;

    @Inject
    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    public void beginGame() throws IOException {
        gameView.showBegin();
    }

    public void play(InputCommand command) throws IOException, OutOfGuessCountException {

        if (game.checkContinue()) {
            GuessResult guessResult = game.guess(command.input());
            gameView.showGuessResult(guessResult);
            gameView.showGuessHistory(game.guessHistory());
            play(command);
        } else {
            gameView.showGameStatus(game.checkStatus());
        }
    }

}

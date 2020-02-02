package com.thoughtworks.guessnumber;


import com.google.inject.Injector;
import com.thoughtworks.guessnumber.commands.GuessInputCommand;
import com.thoughtworks.guessnumber.controllers.GameController;
import com.thoughtworks.guessnumber.exception.OutOfGuessCountException;

import static com.google.inject.Guice.createInjector;

public class Main {

    public static void main(String[] args) throws Exception, OutOfGuessCountException {

        Injector injector = createInjector();
        GameController gameController = injector.getInstance(GameController.class);

        gameController.beginGame();
        gameController.play(new GuessInputCommand());

    }
}

package com.thoughtworks.guessnumber;

import com.google.inject.Inject;
import com.thoughtworks.guessnumber.exception.OutOfGuessCountException;
import com.thoughtworks.guessnumber.exception.OutOfRangeAnswerException;
import com.thoughtworks.guessnumber.generator.AnswerGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.guessnumber.GameStatus.*;

public class Game {

    private static final int MAX_TIMES = 6;
    private static final String CORRECT_RESULT = "4A0B";
    private final Answer answer;
    private final List<GuessResult> guessResults;

    @Inject
    public Game(AnswerGenerator answerGenerator) throws OutOfRangeAnswerException {
        this.answer = answerGenerator.generate();
        this.guessResults = new ArrayList();
    }

    public GuessResult guess(Answer inputAnswer) throws OutOfGuessCountException {
        if (!checkContinue()) {
            throw new OutOfGuessCountException("Guess count cant over 6!");
        }
        String result = answer.check(inputAnswer);
        GuessResult guessResult = new GuessResult(result, inputAnswer);

        guessResults.add(guessResult);
        return guessResult;
    }

    public boolean checkContinue() {
        return this.checkStatus().equals(CONTINUE);
    }

    public String checkStatus() {
        String status;
        if (guessResults.size() >= MAX_TIMES) {
            status = FAIL;
        } else if (checkCorrectGuessResult()) {
            status = SUCCESS;
        } else {
            status = CONTINUE;
        }
        return status;
    }

    private boolean checkCorrectGuessResult() {
        return guessResults.stream().anyMatch(result -> result.getResult().contentEquals(CORRECT_RESULT));
    }

    public List<GuessResult> guessHistory() {
        return guessResults;
    }

}

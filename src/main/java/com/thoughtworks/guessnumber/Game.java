package com.thoughtworks.guessnumber;

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
    private final List<String> guessResults;


    public Game(AnswerGenerator answerGenerator) throws OutOfRangeAnswerException {
        this.answer = answerGenerator.generate();
        this.guessResults = new ArrayList();
    }

    public String guess(Answer inputAnswer) throws OutOfGuessCountException {
        if (!checkContinue()) {
            throw new OutOfGuessCountException("Guess count cant over 6!");
        }
        String guessResult = answer.check(inputAnswer);
        guessResults.add(guessResult);
        return guessResult;
    }

    private boolean checkContinue() {
        return this.checkStatus().equals(CONTINUE);
    }

    private String checkStatus() {
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
        return guessResults.stream().anyMatch(result -> result.contentEquals(CORRECT_RESULT));
    }
}

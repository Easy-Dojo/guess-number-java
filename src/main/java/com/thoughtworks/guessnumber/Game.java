package com.thoughtworks.guessnumber;

import com.thoughtworks.guessnumber.exception.OutOfRangeAnswerException;
import com.thoughtworks.guessnumber.generator.AnswerGenerator;

public class Game {

    private final Answer answer;

    public Game(AnswerGenerator answerGenerator) throws OutOfRangeAnswerException {
        this.answer = answerGenerator.generate();
    }

    public String guess(Answer inputAnswer) {
        return answer.check(inputAnswer);
    }
}

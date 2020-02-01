package com.thoughtworks.guessnumber;

public class Game {


    private final Answer answer;

    public Game(Answer expectAnswer) {
        this.answer = expectAnswer;
    }

    public String guess(Answer inputAnswer) {
        return answer.check(inputAnswer);
    }
}

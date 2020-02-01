package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GuessNumberGame {
    @Test
    public void should_return_0A0B_when_no_number_is_correct() {
        //given
        Answer expectAnswer = Answer.createAnswer("1 2 3 4");
        Game game = new Game(expectAnswer);
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        //when
        String result = game.guess(inputAnswer);

        //then
        assertThat(result , is("0A0B"));
    }

    @Test
    public void should_return_0A0B_when_1_is_correct() {
        //given
        Answer expectAnswer = Answer.createAnswer("1 2 3 4");
        Game game = new Game(expectAnswer);
        Answer inputAnswer = Answer.createAnswer("1 5 6 7");

        //when
        String result = game.guess(inputAnswer);

        //then
        assertThat(result , is("1A0B"));
    }
}

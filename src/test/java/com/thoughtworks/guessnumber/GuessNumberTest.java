package com.thoughtworks.guessnumber;

import com.thoughtworks.guessnumber.exception.OutOfRangeAnswerException;
import com.thoughtworks.guessnumber.generator.AnswerGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberTest {


    private static final Answer EXPECTED_ANSWER = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(EXPECTED_ANSWER);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_return_0A0B_when_no_number_is_correct() throws OutOfRangeAnswerException {
        //given
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        //when
        String result = game.guess(inputAnswer);

        //then
        assertThat(result , is("0A0B"));
    }

    @Test
    public void should_return_0A0B_when_1_is_correct() throws OutOfRangeAnswerException {
        //given
        Answer inputAnswer = Answer.createAnswer("1 5 6 7");

        //when
        String result = game.guess(inputAnswer);

        //then
        assertThat(result , is("1A0B"));
    }
}

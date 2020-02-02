package com.thoughtworks.guessnumber.generator;

import com.thoughtworks.guessnumber.Answer;
import com.thoughtworks.guessnumber.exception.OutOfRangeAnswerException;

public class AnswerGenerator {
    private final RandomIntGenerator randomIntGenerator;

    public AnswerGenerator(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    public Answer generate() throws OutOfRangeAnswerException {
        String randomNumStr = this.randomIntGenerator.generateNums(9, 4);
        Answer answer = Answer.createAnswer(randomNumStr);
        answer.validate();
        return answer;
    }
}

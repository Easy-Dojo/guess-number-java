package com.thoughtworks.guessnumber.generator;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomIntGenerator {
    public RandomIntGenerator() {
    }

    public String generateNums(Integer digitMax, Integer numbersOfNeed) {

        if (digitMax < numbersOfNeed) {
            throw new IllegalArgumentException("Can't ask for more numbers than are available");
        }

        Random rng = new Random();
        Set<String> generated = new LinkedHashSet<>();
        while (generated.size() < numbersOfNeed) {
            Integer next = rng.nextInt(digitMax);
            generated.add(next.toString());
        }
        return String.join(" ", generated);
    }
}

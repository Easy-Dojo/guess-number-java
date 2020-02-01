package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public Boolean validate(String numStr) {
        List<String> numList = numStrToList(numStr);
        int numCount = 4;
        Boolean isValidate = validateDigitsCount(numList, numCount);
        return isValidate && validateSingleDigit(numList, numCount);
    }

    private boolean validateSingleDigit(List<String> numList, int numCount) {
        return numList.stream()
                .map(Integer::parseInt)
                .distinct()
                .filter(num -> num < 10).count() == numCount;
    }

    private Boolean validateDigitsCount(List<String> numList, int numCount) {
        return numList.size() == numCount;
    }

    private List<String> numStrToList(String numStr) {
        return Arrays.stream(numStr.split(" "))
                .collect(Collectors.toList());
    }
}

package com.thoughtworks.guessnumber;

public class Record {
    private int countOfCorrectNumberAndCorrectPosition;
    private int countOfOnlyCorrectNumber;

    public Record() {
        this.countOfCorrectNumberAndCorrectPosition = 0;
        this.countOfOnlyCorrectNumber = 0;
    }

    public void increaseCurrentNum() {
        countOfCorrectNumberAndCorrectPosition++;
    }

    public void increaseIncludeOnlyNum() {
        countOfCorrectNumberAndCorrectPosition++;
    }

    @Override
    public String toString() {
        return countOfCorrectNumberAndCorrectPosition + "A" + countOfOnlyCorrectNumber + "B";
    }
}

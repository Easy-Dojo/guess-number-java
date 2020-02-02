package com.thoughtworks.guessnumber.commands;


import com.thoughtworks.guessnumber.Answer;

import java.io.IOException;

public interface InputCommand {
    Answer input() throws IOException;
}

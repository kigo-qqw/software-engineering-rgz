package ru.nstu.se.rgz.model.command;

public interface Command {
    void execute();

    void unExecute();
}

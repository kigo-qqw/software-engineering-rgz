package ru.nstu.se.rgz.model.command.manager;

import ru.nstu.se.rgz.model.command.Command;

import java.util.List;

public interface CommandManager {
    void execute(Command command);

    void reDo();

    void unDo();

    List<Command> getCommands();
}

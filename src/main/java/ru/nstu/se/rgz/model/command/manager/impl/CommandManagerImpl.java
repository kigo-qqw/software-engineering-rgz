package ru.nstu.se.rgz.model.command.manager.impl;

import ru.nstu.se.rgz.model.command.Command;
import ru.nstu.se.rgz.model.command.manager.CommandManager;
import ru.nstu.se.rgz.util.fixedsizestack.FixedSizeStack;

import java.util.List;

public class CommandManagerImpl implements CommandManager {
    private final FixedSizeStack<Command> fixedSizeStack;

    public CommandManagerImpl(FixedSizeStack<Command> fixedSizeStack) {
        this.fixedSizeStack = fixedSizeStack;
    }

    @Override
    public void execute(Command command) {
        this.fixedSizeStack.push(command);
        command.execute();
    }

    @Override
    public void reDo() {
        Command command = this.fixedSizeStack.peek();
        this.fixedSizeStack.push(command);
        command.execute();
    }

    @Override
    public void unDo() {
        Command command = this.fixedSizeStack.pop();
        command.unExecute();
    }

    @Override
    public List<Command> getCommands() {
        return this.fixedSizeStack.toList();
    }
}

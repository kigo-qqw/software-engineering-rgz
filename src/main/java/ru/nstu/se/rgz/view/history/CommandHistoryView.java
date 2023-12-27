package ru.nstu.se.rgz.view.history;

import ru.nstu.se.rgz.controller.history.CommandHistoryController;
import ru.nstu.se.rgz.model.command.Command;

import java.util.List;

public interface CommandHistoryView {
    void setCommandHistoryController(CommandHistoryController commandHistoryController);

    void setPrevCommandDisable(boolean value);

    void setReExecuteCommandDisable(boolean value);

    void updateCommandHistory(List<Command> commands);
}

package ru.nstu.se.rgz.controller.history;

public interface CommandHistoryController {
    void updateCommandHistory();
    void prevCommand();
    void reExecuteCommand();
}

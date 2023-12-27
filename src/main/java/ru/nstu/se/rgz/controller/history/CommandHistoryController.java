package ru.nstu.se.rgz.controller.history;

import ru.nstu.se.rgz.controller.Controller;

public interface CommandHistoryController extends Controller {
    void updateCommandHistory();

    void prevCommand();

    void reExecuteCommand();
}

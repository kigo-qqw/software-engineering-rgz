package ru.nstu.se.rgz.controller.history.impl;

import ru.nstu.se.rgz.controller.canvas.CanvasController;
import ru.nstu.se.rgz.controller.history.CommandHistoryController;
import ru.nstu.se.rgz.model.Model;
import ru.nstu.se.rgz.view.history.CommandHistoryView;

public class CommandHistoryControllerImpl implements CommandHistoryController {
    private final Model model;
    private final CommandHistoryView commandHistoryView;
    private CanvasController canvasController;

    public CommandHistoryControllerImpl(Model model, CommandHistoryView commandHistoryView) {
        this.model = model;
        this.commandHistoryView = commandHistoryView;
    }

    @Override
    public void updateCommandHistory() {
        this.commandHistoryView.updateCommandHistory(this.model.getCommands());
    }

    @Override
    public void prevCommand() {
        this.model.unDo();
        this.canvasController.update();
    }

    @Override
    public void reExecuteCommand() {
        this.model.reDo();
        this.canvasController.update();
    }

    public void setCanvasController(CanvasController canvasController) {
        this.canvasController = canvasController;
    }
}

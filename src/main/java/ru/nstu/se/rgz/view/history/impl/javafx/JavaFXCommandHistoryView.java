package ru.nstu.se.rgz.view.history.impl.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.nstu.se.rgz.controller.history.CommandHistoryController;
import ru.nstu.se.rgz.model.command.Command;
import ru.nstu.se.rgz.view.history.CommandHistoryView;

import java.util.List;
import java.util.Objects;

public class JavaFXCommandHistoryView extends VBox implements CommandHistoryView {
    private CommandHistoryController commandHistoryController;
    private final Button prevCommand = new Button("prev");
    private final Button reExecuteCommand = new Button("re execute");
    private final VBox commands = new VBox();

    public JavaFXCommandHistoryView() {
        super();

        setMinWidth(200);
        setMaxWidth(200);

        setStyle("-fx-background-color: grey;");

        this.prevCommand.setOnAction(event -> this.commandHistoryController.prevCommand());
        this.reExecuteCommand.setOnAction(event -> this.commandHistoryController.reExecuteCommand());

        getChildren().addAll(this.prevCommand, this.reExecuteCommand, this.commands);
    }

    @Override
    public void setCommandHistoryController(CommandHistoryController commandHistoryController) {
        this.commandHistoryController = commandHistoryController;
    }

    @Override
    public void setPrevCommandDisable(boolean value) {
        this.prevCommand.setDisable(value);
    }

    @Override
    public void setReExecuteCommandDisable(boolean value) {
        this.reExecuteCommand.setDisable(value);
    }

    @Override
    public void updateCommandHistory(List<Command> commands) {
        this.commands.getChildren().clear();
        this.commands.getChildren().addAll(commands.stream().filter(Objects::nonNull).map(command -> new Label(command.toString())).toList());
        System.out.println(this.commands.getChildren());
    }
}

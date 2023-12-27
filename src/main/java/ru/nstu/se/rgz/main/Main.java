package ru.nstu.se.rgz.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.nstu.se.rgz.controller.canvas.impl.CanvasControllerImpl;
import ru.nstu.se.rgz.controller.history.CommandHistoryController;
import ru.nstu.se.rgz.controller.history.impl.CommandHistoryControllerImpl;
import ru.nstu.se.rgz.controller.toolbox.impl.ToolboxControllerImpl;
import ru.nstu.se.rgz.model.canvas.impl.CanvasImpl;
import ru.nstu.se.rgz.model.command.Command;
import ru.nstu.se.rgz.model.command.manager.impl.CommandManagerImpl;
import ru.nstu.se.rgz.model.impl.ModelImpl;
import ru.nstu.se.rgz.util.fixedsizestack.ArrayFixedSizeStack;
import ru.nstu.se.rgz.view.canvas.impl.javafx.JavaFXCanvasView;
import ru.nstu.se.rgz.view.history.impl.javafx.JavaFXCommandHistoryView;
import ru.nstu.se.rgz.view.impl.javafx.JavaFXMainView;
import ru.nstu.se.rgz.view.shape.impl.javafx.JavaFXShapeViewFactory;
import ru.nstu.se.rgz.view.toolbox.impl.javafx.JavaFXToolboxView;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        var canvas = new CanvasImpl(100, 100);
        var shapeViewFactory = new JavaFXShapeViewFactory();
        var canvasView = new JavaFXCanvasView(shapeViewFactory);
        shapeViewFactory.setCanvasView(canvasView);
        var fixedSizeStack = new ArrayFixedSizeStack<Command>(4);
        var commandManager = new CommandManagerImpl(fixedSizeStack);
        var model = new ModelImpl(canvas, commandManager);
        var commandHistoryView = new JavaFXCommandHistoryView();
        var commandHistoryController = new CommandHistoryControllerImpl(model, commandHistoryView);
        commandHistoryView.setCommandHistoryController(commandHistoryController);
        var canvasController = new CanvasControllerImpl(model, canvasView, commandHistoryController);
        canvasView.setCanvasController(canvasController);
        commandHistoryController.setCanvasController(canvasController);
        var toolboxController = new ToolboxControllerImpl(canvasController);
        var toolboxView = new JavaFXToolboxView(toolboxController);
        var mainView = new JavaFXMainView(toolboxView, canvasView, commandHistoryView);
        var scene = new Scene(mainView, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

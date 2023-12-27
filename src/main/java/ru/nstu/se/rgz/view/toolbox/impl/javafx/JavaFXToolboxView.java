package ru.nstu.se.rgz.view.toolbox.impl.javafx;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import ru.nstu.se.rgz.controller.toolbox.ToolboxController;
import ru.nstu.se.rgz.view.toolbox.ToolboxView;

public class JavaFXToolboxView extends HBox implements ToolboxView {
    private final ToolboxController toolboxController;

    public JavaFXToolboxView(ToolboxController toolboxController) {
        super();
        this.toolboxController = toolboxController;

        setStyle("-fx-background-color: grey;");

        var createCircleButton = new Button("Circle");
        getChildren().add(createCircleButton);
        createCircleButton.setOnAction(event -> this.toolboxController.createCircle());

        var createRectangleButton = new Button("Rectangle");
        getChildren().add(createRectangleButton);
        createRectangleButton.setOnAction(event -> this.toolboxController.createRectangle());

        var rotateButton = new Button("rotate");
        getChildren().add(rotateButton);
        rotateButton.setOnAction(event -> this.toolboxController.rotateSelected());

        var scaleButton = new Button("scale");
        getChildren().add(scaleButton);
        scaleButton.setOnAction(event -> this.toolboxController.scaleSelected());

        var translateButton = new Button("translate");
        getChildren().add(translateButton);
        translateButton.setOnAction(event -> this.toolboxController.translateSelected());

        var deleteButton = new Button("delete");
        getChildren().add(deleteButton);
        deleteButton.setOnAction(event -> this.toolboxController.deleteSelected());
    }
}

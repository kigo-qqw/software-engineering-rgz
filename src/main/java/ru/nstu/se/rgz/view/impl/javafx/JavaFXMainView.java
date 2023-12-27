package ru.nstu.se.rgz.view.impl.javafx;

import javafx.scene.layout.BorderPane;
import ru.nstu.se.rgz.view.MainView;
import ru.nstu.se.rgz.view.canvas.impl.javafx.JavaFXCanvasView;
import ru.nstu.se.rgz.view.history.impl.javafx.JavaFXCommandHistoryView;
import ru.nstu.se.rgz.view.toolbox.impl.javafx.JavaFXToolboxView;

public class JavaFXMainView extends BorderPane implements MainView {
    private final JavaFXToolboxView toolboxView;
    private final JavaFXCanvasView canvasView;
    private final JavaFXCommandHistoryView commandHistoryView;

    public JavaFXMainView(JavaFXToolboxView toolboxView, JavaFXCanvasView canvasView, JavaFXCommandHistoryView commandHistoryView) {
        super();

        this.toolboxView = toolboxView;
        this.canvasView = canvasView;
        this.commandHistoryView = commandHistoryView;

        setTop(this.toolboxView);
        setCenter(this.canvasView);
        setRight(this.commandHistoryView);

        this.toolboxView.setViewOrder(-Double.MAX_VALUE);
        this.commandHistoryView.setViewOrder(-Double.MAX_VALUE);
    }
}

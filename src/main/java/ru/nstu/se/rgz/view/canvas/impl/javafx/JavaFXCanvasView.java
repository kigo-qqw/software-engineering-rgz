package ru.nstu.se.rgz.view.canvas.impl.javafx;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.AnchorPane;
import ru.nstu.se.rgz.controller.canvas.CanvasController;
import ru.nstu.se.rgz.model.shape.Circle;
import ru.nstu.se.rgz.model.shape.Shape;
import ru.nstu.se.rgz.util.javafx.draggable.MakeDraggable;
import ru.nstu.se.rgz.view.canvas.CanvasView;
import ru.nstu.se.rgz.view.shape.ShapeView;
import ru.nstu.se.rgz.view.shape.impl.javafx.JavaFXShapeView;
import ru.nstu.se.rgz.view.shape.impl.javafx.JavaFXShapeViewFactory;

import java.util.Map;
import java.util.TreeMap;

public class JavaFXCanvasView extends AnchorPane implements CanvasView {
    private CanvasController canvasController = null;
    private final JavaFXShapeViewFactory shapeViewFactory;
    private Map<Integer, Shape> shapesCache = new TreeMap<>();

    public JavaFXCanvasView(JavaFXShapeViewFactory shapeViewFactory) {
        super();
        this.shapeViewFactory = shapeViewFactory;
        heightProperty().addListener(this::handleResize);
        widthProperty().addListener(this::handleResize);
    }

    @Override
    public void updateCanvasData(Map<Integer, Shape> shapes) {
        this.shapesCache = shapes;
        System.out.println("updateCanvasData()");
        System.out.println(shapes);
        getChildren().clear();
        for (Map.Entry<Integer, Shape> entry : shapes.entrySet()) {
            JavaFXShapeView shapeView = (JavaFXShapeView) this.shapeViewFactory.fromShape(entry.getKey(), entry.getValue());
            shapeView.draw();
        }
    }

    @Override
    public double getCanvasWidth() {
        return this.canvasController.getCanvasWidth();
    }

    @Override
    public double getCanvasHeight() {
        return this.canvasController.getCanvasHeight();
    }

    @Override
    public void setCanvasController(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public CanvasController getCanvasController() {
        return this.canvasController;
    }

    private void handleResize(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        if (!MakeDraggable.dragModeActiveProperty.get())
            updateCanvasData(this.shapesCache);
    }
}

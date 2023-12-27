package ru.nstu.se.rgz.view.shape.impl.javafx;

import ru.nstu.se.rgz.model.shape.Shape;
import ru.nstu.se.rgz.view.canvas.impl.javafx.JavaFXCanvasView;
import ru.nstu.se.rgz.view.shape.ShapeView;

public abstract class JavaFXShapeView implements ShapeView {
    private final JavaFXCanvasView canvasView;
    private final Shape shape;
    private int shapeId;

    public JavaFXShapeView(JavaFXCanvasView canvasView, Shape shape) {
        this.canvasView = canvasView;
        this.shape = shape;
    }

    @Override
    public void setId(int id) {
        this.shapeId = id;
    }

    @Override
    public int getId() {
        return this.shapeId;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    public JavaFXCanvasView getCanvasView() {
        return canvasView;
    }

    public double calculateX() {
        return this.canvasView.getWidth() / this.canvasView.getCanvasWidth() * this.shape.getX();
    }

    public double calculateY() {
        return this.canvasView.getHeight() / this.canvasView.getCanvasHeight() * this.shape.getY();
    }
}

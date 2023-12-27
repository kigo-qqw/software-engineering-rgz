package ru.nstu.se.rgz.view.shape.impl.javafx;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import ru.nstu.se.rgz.model.shape.Shape;
import ru.nstu.se.rgz.util.javafx.draggable.MakeDraggable;
import ru.nstu.se.rgz.view.canvas.impl.javafx.JavaFXCanvasView;

public class JavaFXRectangleView extends JavaFXShapeView {
    private final Rectangle rectangle;
    private final MakeDraggable makeDraggable = new MakeDraggable();

    public JavaFXRectangleView(JavaFXCanvasView canvasView, Shape shape) {
        super(canvasView, shape);
        this.rectangle = new Rectangle(calculateX(), calculateY(), 100 * shape.getScale(), 50 * shape.getScale());
        this.rectangle.setFill(Paint.valueOf("00ff00"));
        this.rectangle.setRotate(shape.getRotation());
        this.rectangle.setOnMouseClicked(event -> {
            getCanvasView().getCanvasController().setSelected(getId());
        });
        this.makeDraggable.makeDraggable(this.rectangle, (x, y) -> {
            if (Math.sqrt(x * x + y * y) > 100)
                getCanvasView().getCanvasController().translateById(
                        getId(),
                        x / getCanvasView().getWidth() * getCanvasView().getCanvasWidth(),
                        y / getCanvasView().getHeight() * getCanvasView().getCanvasHeight()
                );
        });
    }

    @Override
    public void draw() {
        getCanvasView().getChildren().add(this.rectangle);
    }
}

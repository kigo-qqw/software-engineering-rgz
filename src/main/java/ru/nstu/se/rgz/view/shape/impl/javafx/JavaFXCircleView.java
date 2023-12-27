package ru.nstu.se.rgz.view.shape.impl.javafx;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import ru.nstu.se.rgz.model.shape.Shape;
import ru.nstu.se.rgz.util.javafx.draggable.MakeDraggable;
import ru.nstu.se.rgz.view.canvas.impl.javafx.JavaFXCanvasView;

public class JavaFXCircleView extends JavaFXShapeView {
    private final Circle circle;
    private final MakeDraggable makeDraggable = new MakeDraggable();

    public JavaFXCircleView(JavaFXCanvasView canvasView, Shape shape) {
        super(canvasView, shape);
        this.circle = new Circle(calculateX(), calculateY(), 50 * shape.getScale(), Paint.valueOf("ff0000"));
        this.circle.setRotate(shape.getRotation());
        this.circle.setOnMouseClicked(event -> {
            getCanvasView().getCanvasController().setSelected(getId());
        });
        this.makeDraggable.makeDraggable(this.circle, (x, y) -> {
            if (Math.sqrt(x * x + y * y) > 100)
                getCanvasView().getCanvasController().translateById(
                        getId(),
                        x / getCanvasView().getWidth() * getCanvasView().getCanvasWidth(),
                        y / getCanvasView().getHeight() * getCanvasView().getCanvasHeight()
                );
        });
    }

    public void draw() {
        getCanvasView().getChildren().add(this.circle);
    }
}

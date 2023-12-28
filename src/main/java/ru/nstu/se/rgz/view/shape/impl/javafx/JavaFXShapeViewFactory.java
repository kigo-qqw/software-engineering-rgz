package ru.nstu.se.rgz.view.shape.impl.javafx;

import ru.nstu.se.rgz.model.shape.Circle;
import ru.nstu.se.rgz.model.shape.Rectangle;
import ru.nstu.se.rgz.model.shape.Shape;
import ru.nstu.se.rgz.view.canvas.impl.javafx.JavaFXCanvasView;
import ru.nstu.se.rgz.view.shape.ShapeView;
import ru.nstu.se.rgz.view.shape.ShapeViewFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class JavaFXShapeViewFactory implements ShapeViewFactory {
    private final Map<Class<? extends Shape>, Class<? extends JavaFXShapeView>> transformations = new HashMap<>();
    private JavaFXCanvasView canvasView;

    public JavaFXShapeViewFactory() {
        this.transformations.put(Circle.class, JavaFXCircleView.class);
        this.transformations.put(Rectangle.class, JavaFXRectangleView.class);
    }

    @Override
    public ShapeView fromShape(int shapeId, Shape shape) {
        Class<? extends JavaFXShapeView> shapeViewClass = this.transformations.get(shape.getClass());
        if (shapeViewClass == null) throw new RuntimeException("illegal shape");
        try {
            final JavaFXShapeView shapeView = shapeViewClass
                    .getDeclaredConstructor(JavaFXCanvasView.class, Shape.class)
                    .newInstance(this.canvasView, shape);
            shapeView.setId(shapeId);
            return shapeView;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCanvasView(JavaFXCanvasView canvasView) {
        this.canvasView = canvasView;
    }
}

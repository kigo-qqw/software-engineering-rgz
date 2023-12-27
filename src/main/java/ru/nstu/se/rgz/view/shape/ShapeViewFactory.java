package ru.nstu.se.rgz.view.shape;

import ru.nstu.se.rgz.model.shape.Shape;

public interface ShapeViewFactory {
    ShapeView fromShape(int shapeId, Shape shape);
}

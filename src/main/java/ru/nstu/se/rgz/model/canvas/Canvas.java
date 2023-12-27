package ru.nstu.se.rgz.model.canvas;

import ru.nstu.se.rgz.model.shape.Shape;

import java.util.Map;

public interface Canvas {
    float getWidth();

    float getHeight();

    int addShape(Shape shape);

    Shape getShapeById(int shapeId);

    void deleteShapeById(int shapeId);

    Map<Integer, Shape> getAll();
}

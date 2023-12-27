package ru.nstu.se.rgz.model;

import ru.nstu.se.rgz.model.command.Command;
import ru.nstu.se.rgz.model.shape.Shape;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Model {
    void createShape(Shape shape);

    void deleteShapeById(int shapeId);

    void rotateShapeById(int shapeId, double angle);

    void scaleShapeById(int shapeId, double scale);

    void translateShapeById(int shapeId, double byX, double byY);

    Map<Integer, Shape> getAll();

    double getCanvasWidth();

    double getCanvasHeight();

    List<Command> getCommands();

    void unDo();

    void reDo();
}

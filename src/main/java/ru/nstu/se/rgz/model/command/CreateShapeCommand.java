package ru.nstu.se.rgz.model.command;

import ru.nstu.se.rgz.model.canvas.Canvas;
import ru.nstu.se.rgz.model.shape.Shape;

public class CreateShapeCommand implements Command {
    private final Canvas canvas;
    private final Shape shape;
    private int shapeId;

    @Override
    public String toString() {
        return "Create";
    }

    public CreateShapeCommand(Canvas canvas, Shape shape) {
        this.canvas = canvas;
        this.shape = shape;
    }

    @Override
    public void execute() {
        this.shapeId = this.canvas.addShape(shape);
    }

    @Override
    public void unExecute() {
        this.canvas.deleteShapeById(this.shapeId);
    }

    @Override
    public void reExecute() {

    }
}

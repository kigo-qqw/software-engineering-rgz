package ru.nstu.se.rgz.model.command;

import ru.nstu.se.rgz.model.canvas.Canvas;
import ru.nstu.se.rgz.model.shape.Shape;

public class DeleteShapeCommand implements Command {
    private final Canvas canvas;
    private final int shapeId;
    private Shape shape;

    @Override
    public String toString() {
        return "Delete";
    }

    public DeleteShapeCommand(Canvas canvas, int shapeId) {
        this.canvas = canvas;
        this.shapeId = shapeId;
    }

    @Override
    public void execute() {
        this.shape = canvas.getShapeById(this.shapeId);
        this.canvas.deleteShapeById(this.shapeId);
    }

    @Override
    public void unExecute() {
        this.canvas.addShape(this.shape);
    }
}

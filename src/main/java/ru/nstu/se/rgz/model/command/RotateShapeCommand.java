package ru.nstu.se.rgz.model.command;

import ru.nstu.se.rgz.model.canvas.Canvas;

public class RotateShapeCommand implements Command {
    private final Canvas canvas;
    private final int shapeId;
    private final double angle;

    @Override
    public String toString() {
        return "Rotate at " + this.angle;
    }

    public RotateShapeCommand(Canvas canvas, int shapeId, double angle) {
        this.canvas = canvas;
        this.shapeId = shapeId;
        this.angle = angle;
    }

    @Override
    public void execute() {
        var shape = this.canvas.getShapeById(shapeId);
        shape.setRotation(shape.getRotation() + this.angle);
    }

    @Override
    public void unExecute() {
        var shape = this.canvas.getShapeById(shapeId);
        shape.setRotation(shape.getRotation() - this.angle);
    }

    @Override
    public void reExecute() {
    }
}

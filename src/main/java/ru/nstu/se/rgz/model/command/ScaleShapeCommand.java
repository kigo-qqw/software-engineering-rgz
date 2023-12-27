package ru.nstu.se.rgz.model.command;

import ru.nstu.se.rgz.model.canvas.Canvas;

public class ScaleShapeCommand implements Command {
    private final Canvas canvas;
    private final int shapeId;
    private final double scale;

    @Override
    public String toString() {
        return "Scale to " + this.scale;
    }

    public ScaleShapeCommand(Canvas canvas, int shapeId, double scale) {
        this.canvas = canvas;
        this.shapeId = shapeId;
        this.scale = scale;
    }

    @Override
    public void execute() {
        var shape = this.canvas.getShapeById(shapeId);
        shape.setScale(shape.getScale() * this.scale);
    }

    @Override
    public void unExecute() {
        var shape = this.canvas.getShapeById(shapeId);
        shape.setScale(shape.getScale() / this.scale);
    }
}

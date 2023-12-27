package ru.nstu.se.rgz.model.command;

import ru.nstu.se.rgz.model.canvas.Canvas;

import java.text.DecimalFormat;

public class TranslateShapeCommand implements Command {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private final Canvas canvas;
    private final int shapeId;
    private final double byX;
    private final double byY;

    public TranslateShapeCommand(Canvas canvas, int shapeId, double byX, double byY) {
        this.canvas = canvas;
        this.shapeId = shapeId;
        this.byX = byX;
        this.byY = byY;
    }

    @Override
    public String toString() {
        return "Translate to (" + df.format(this.byX) + ", " + df.format(this.byY) + ")";
    }

    @Override
    public void execute() {
        var shape = this.canvas.getShapeById(shapeId);
        shape.setX(shape.getX() + this.byX);
        shape.setY(shape.getY() + this.byY);
    }

    @Override
    public void unExecute() {
        var shape = this.canvas.getShapeById(shapeId);
        shape.setX(shape.getX() - this.byX);
        shape.setY(shape.getY() - this.byY);
    }

    @Override
    public void reExecute() {
    }
}

package ru.nstu.se.rgz.model.impl;

import ru.nstu.se.rgz.model.Model;
import ru.nstu.se.rgz.model.canvas.Canvas;
import ru.nstu.se.rgz.model.command.*;
import ru.nstu.se.rgz.model.command.manager.CommandManager;
import ru.nstu.se.rgz.model.shape.Shape;

import java.util.List;
import java.util.Map;

public class ModelImpl implements Model {
    private final Canvas canvas;
    private final CommandManager commandManager;

    public ModelImpl(Canvas canvas, CommandManager commandManager) {
        this.canvas = canvas;
        this.commandManager = commandManager;
    }

    @Override
    public void createShape(Shape shape) {
        var command = new CreateShapeCommand(this.canvas, shape);
        this.commandManager.execute(command);
    }

    @Override
    public void deleteShapeById(int shapeId) {
        var command = new DeleteShapeCommand(this.canvas, shapeId);
        this.commandManager.execute(command);
    }

    @Override
    public void rotateShapeById(int shapeId, double angle) {
        var command = new RotateShapeCommand(this.canvas, shapeId, angle);
        this.commandManager.execute(command);
    }

    @Override
    public void scaleShapeById(int shapeId, double scale) {
        var command = new ScaleShapeCommand(this.canvas, shapeId, scale);
        this.commandManager.execute(command);
    }

    @Override
    public void translateShapeById(int shapeId, double byX, double byY) {
        var command = new TranslateShapeCommand(this.canvas, shapeId, byX, byY);
        this.commandManager.execute(command);
    }

    @Override
    public Map<Integer, Shape> getAll() {
        System.out.println(this.commandManager.getCommands());
        return this.canvas.getAll();
    }

    @Override
    public double getCanvasWidth() {
        return this.canvas.getWidth();
    }

    @Override
    public double getCanvasHeight() {
        return this.canvas.getHeight();
    }

    @Override
    public List<Command> getCommands() {
        return this.commandManager.getCommands();
    }

    @Override
    public void unDo() {
        this.commandManager.unDo();
    }

    @Override
    public void reDo() {
        this.commandManager.reDo();
    }
}

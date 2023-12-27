package ru.nstu.se.rgz.model.canvas.impl;

import ru.nstu.se.rgz.model.canvas.Canvas;
import ru.nstu.se.rgz.model.shape.Shape;

import java.util.Map;
import java.util.TreeMap;

public class CanvasImpl implements Canvas {
    private final float width;
    private final float height;
    private final Map<Integer, Shape> shapeMap;
    private int maxShapeId = -1;

    public CanvasImpl(float width, float height) {
        this.width = width;
        this.height = height;
        this.shapeMap = new TreeMap<>();
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }

    @Override
    public int addShape(Shape shape) {
        this.maxShapeId++;
        this.shapeMap.put(this.maxShapeId, shape);
        return this.maxShapeId;
    }

    @Override
    public Shape getShapeById(int shapeId) {
        return this.shapeMap.get(shapeId);
    }

    @Override
    public void deleteShapeById(int shapeId) {
        this.shapeMap.remove(shapeId);
    }

    @Override
    public Map<Integer, Shape> getAll() {
        return this.shapeMap;
    }
}

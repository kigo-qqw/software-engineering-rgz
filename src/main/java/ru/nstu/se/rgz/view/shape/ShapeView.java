package ru.nstu.se.rgz.view.shape;

import ru.nstu.se.rgz.model.shape.Shape;

public interface ShapeView {
    void setId(int id);

    int getId();

    Shape getShape();

    void draw();
}

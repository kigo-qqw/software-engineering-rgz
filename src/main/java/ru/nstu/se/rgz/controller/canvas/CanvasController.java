package ru.nstu.se.rgz.controller.canvas;

import ru.nstu.se.rgz.controller.Controller;
import ru.nstu.se.rgz.model.shape.Shape;

public interface CanvasController extends Controller {
    //    void createShape(Shape shape);
//
//    void deleteShape(int shapeId);
//
//    void rotateShape(int shapeId, double angle);
//
//    void scaleShape(int shapeId, double scale);
//
//    void translateShape(int shapeId, double byX, double byY);
    void createShape(Shape shape);

    void setSelected(int shapeId);

    void rotateSelected();

    void scaleSelected();

    void translateSelected();

    void translateById(int shapeId, double byX, double byY);

    void deleteSelected();

    double getCanvasWidth();

    double getCanvasHeight();

    void update();
}

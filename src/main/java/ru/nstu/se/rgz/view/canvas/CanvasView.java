package ru.nstu.se.rgz.view.canvas;

import ru.nstu.se.rgz.controller.canvas.CanvasController;
import ru.nstu.se.rgz.model.shape.Shape;
import ru.nstu.se.rgz.view.View;
import ru.nstu.se.rgz.view.shape.ShapeView;

import java.util.Map;

public interface CanvasView extends View {
    void setCanvasController(CanvasController canvasController);
    CanvasController getCanvasController();

    void updateCanvasData(Map<Integer, Shape> shapes);

    double getCanvasWidth();

    double getCanvasHeight();
}

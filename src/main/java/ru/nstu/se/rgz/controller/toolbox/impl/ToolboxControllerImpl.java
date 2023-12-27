package ru.nstu.se.rgz.controller.toolbox.impl;

import ru.nstu.se.rgz.controller.canvas.CanvasController;
import ru.nstu.se.rgz.controller.toolbox.ToolboxController;
import ru.nstu.se.rgz.model.shape.Circle;
import ru.nstu.se.rgz.model.shape.Rectangle;

public class ToolboxControllerImpl implements ToolboxController {
    private final CanvasController canvasController;

    public ToolboxControllerImpl(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    @Override
    public void createCircle() {
        this.canvasController.createShape(new Circle());
    }

    @Override
    public void createRectangle() {
        this.canvasController.createShape(new Rectangle());
    }

    @Override
    public void rotateSelected() {
//        if (this.selectedShapeId != -1)
//            this.canvasController.rotateShape(this.selectedShapeId, 10 / 180f * Math.PI);
        this.canvasController.rotateSelected();
    }

    @Override
    public void scaleSelected() {
//        if (this.selectedShapeId != -1)
//            this.canvasController.scaleShape(this.selectedShapeId, 1.5);
        this.canvasController.scaleSelected();
    }

    @Override
    public void translateSelected() {
//        if (this.selectedShapeId != -1)
//            this.canvasController.translateShape(this.selectedShapeId, 10, 10);
        this.canvasController.translateSelected();
    }

    @Override
    public void deleteSelected() {
//        if (this.selectedShapeId != -1)
//            this.canvasController.deleteShape(this.selectedShapeId);
//        this.selectedShapeId = -1;
        this.canvasController.deleteSelected();
    }
}

package ru.nstu.se.rgz.controller.canvas.impl;

import ru.nstu.se.rgz.controller.canvas.CanvasController;
import ru.nstu.se.rgz.controller.history.CommandHistoryController;
import ru.nstu.se.rgz.model.Model;
import ru.nstu.se.rgz.model.shape.Shape;
import ru.nstu.se.rgz.view.canvas.CanvasView;

public class CanvasControllerImpl implements CanvasController {
    private final Model model;
    private final CanvasView canvasView;
    private final CommandHistoryController commandHistoryController;
    private int selectedShapeId = -1;

    public CanvasControllerImpl(Model model, CanvasView canvasView, CommandHistoryController commandHistoryController) {
        this.model = model;
        this.canvasView = canvasView;
        this.commandHistoryController = commandHistoryController;
    }

    @Override
    public void createShape(Shape shape) {
        this.model.createShape(shape);
        update();
    }

    @Override
    public void setSelected(int shapeId) {
        this.selectedShapeId = shapeId;
    }

    @Override
    public void rotateSelected() {
        if (this.selectedShapeId != -1) {
            this.model.rotateShapeById(this.selectedShapeId, 10);  // FIXME:
            update();
        }
    }

    @Override
    public void scaleSelected() {
        if (this.selectedShapeId != -1) {
            this.model.scaleShapeById(this.selectedShapeId, 1.5);  // FIXME:
            update();
        }

    }

    @Deprecated
    @Override
    public void translateSelected() {
        if (this.selectedShapeId != -1) {
            this.model.translateShapeById(this.selectedShapeId, 10, 10);
            update();
        }

    }

    @Override
    public void translateById(int shapeId, double byX, double byY) {
        this.model.translateShapeById(shapeId, byX, byY);
        update();
    }

    @Override
    public void deleteSelected() {
        if (this.selectedShapeId != -1) {
            this.model.deleteShapeById(this.selectedShapeId);
            update();
        }
    }

//    @Override
//    public void deleteShape(int shapeId) {
//        this.model.deleteShapeById(shapeId);
//        this.canvasView.updateCanvasData(this.model.getAll());
//    }
//
//    @Override
//    public void rotateShape(int shapeId, double angle) {
//        this.model.rotateShapeById(shapeId, angle);
//        this.canvasView.updateCanvasData(this.model.getAll());
//    }
//
//    @Override
//    public void scaleShape(int shapeId, double scale) {
//        this.model.scaleShapeById(shapeId, scale);
//        this.canvasView.updateCanvasData(this.model.getAll());
//    }
//
//    @Override
//    public void translateShape(int shapeId, double byX, double byY) {
//        this.model.translateShapeById(shapeId, byX, byY);
//        this.canvasView.updateCanvasData(this.model.getAll());
//    }

    @Override
    public double getCanvasWidth() {
        return this.model.getCanvasWidth();
    }

    @Override
    public double getCanvasHeight() {
        return this.model.getCanvasHeight();
    }

    public void update() {
        this.canvasView.updateCanvasData(this.model.getAll());
        this.commandHistoryController.updateCommandHistory();
    }
}

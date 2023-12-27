package ru.nstu.se.rgz.controller.toolbox;

import ru.nstu.se.rgz.controller.Controller;

public interface ToolboxController extends Controller {
    void createCircle();

    void createRectangle();

    void rotateSelected();

    void scaleSelected();

    void translateSelected();

    void deleteSelected();
}

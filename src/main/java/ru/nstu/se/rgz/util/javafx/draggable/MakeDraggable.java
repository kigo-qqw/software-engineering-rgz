package ru.nstu.se.rgz.util.javafx.draggable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.util.function.BiConsumer;

public class MakeDraggable {
    public static final BooleanProperty dragModeActiveProperty =
            new SimpleBooleanProperty(false);
    private double mouseAnchorX;
    private double mouseAnchorY;

    public void makeDraggable(Node node, BiConsumer<Double, Double> consumer) {
        node.setOnMousePressed(event -> {
            dragModeActiveProperty.set(true);
            this.mouseAnchorX = event.getX();
            this.mouseAnchorY = event.getY();
            event.consume();
        });
        node.setOnMouseDragged(event -> {
            node.setTranslateX(event.getSceneX() - this.mouseAnchorX);
            node.setTranslateY(event.getSceneY() - this.mouseAnchorY);
            event.consume();
        });
        node.setOnMouseReleased(event -> {
            dragModeActiveProperty.set(false);
            consumer.accept(node.getTranslateX(), node.getTranslateY());
            event.consume();
        });
    }
}

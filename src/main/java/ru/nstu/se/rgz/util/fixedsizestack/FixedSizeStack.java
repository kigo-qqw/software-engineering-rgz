package ru.nstu.se.rgz.util.fixedsizestack;


import java.util.EmptyStackException;
import java.util.List;

public interface FixedSizeStack<E> {
    boolean empty();

    E peek() throws EmptyStackException;

    E pop() throws EmptyStackException;

    void push(E item);

    List<E> toList();
}

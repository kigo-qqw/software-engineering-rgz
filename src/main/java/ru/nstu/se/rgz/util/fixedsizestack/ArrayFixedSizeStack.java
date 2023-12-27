package ru.nstu.se.rgz.util.fixedsizestack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayFixedSizeStack<E> implements FixedSizeStack<E> {
    private final Object[] data;
    private final int capacity;
    private int first = -1;
    private int last = -1;

    public ArrayFixedSizeStack(int capacity) {
        this.capacity = capacity;
        this.data = new Object[this.capacity];
    }

    @Override
    public boolean empty() {
        return this.first == this.last;
    }

    @Override
    public E peek() throws EmptyStackException {
        if (empty())
            throw new EmptyStackException();
        return (E) this.data[this.last];
    }

    @Override
    public E pop() throws EmptyStackException {
        if (empty())
            throw new EmptyStackException();
        E item = (E) this.data[this.last];
        this.last = (this.last - 1) % this.capacity;
        return item;
    }

    @Override
    public void push(E item) {
        if (this.first == -1) {
            this.first = 0;
            this.last = 0;
        } else {
            this.last = (this.last + 1) % this.capacity;
            checkCollision();
        }
        this.data[this.last] = item;
    }

    @Override
    public List<E> toList() {
        var list = new ArrayList<E>();
        for (int i = this.first; i != this.last; i = (i + 1) % this.capacity) {
            list.add((E) this.data[i]);
        }
        list.add((E) this.data[this.last]);
        return list;
    }

    private void checkCollision() {
        if (this.last == this.first) {
            this.first = (this.first + 1) % this.capacity;
        }
    }
}

package ru.gb.hm4.list;

public class MyQueue<E> {
    private TwoWayList<E> list;

    public MyQueue() {
        list = new TwoWayList<>();
    }

    public void enqueue(E value) {
        list.addLast(value);
    }

    public E dequeue() {
        E value = list.get(0);
        list.removeAt(0);
        return value;
    }

    public E first() {
        return list.get(0);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

package ru.gb.hm4_task1;

public class TwoWayList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void add(E value) {
        Node<E> newNode = new Node<>();
        newNode.value = value;
        if (head != null) {
            head.previousNode = newNode;
            newNode.nextNode = head;
        }
        if (size == 1) tail = head;
        head = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Node<E> currentNode = head;
        int counter = 0;
        while (counter < index) {
            counter++;
            if (currentNode.nextNode == null) throw new ArrayIndexOutOfBoundsException();
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    public boolean contains(E value) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return true;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public int indexOf(E value) {
        int counter = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return counter;
            counter++;
            currentNode = currentNode.nextNode;
        }
        return -1;
    }

    public void add(E value, int index) throws ArrayIndexOutOfBoundsException {
        if (index > size() || index < 0) throw new ArrayIndexOutOfBoundsException();
        if (index != 0) {
            Node<E> currentNode = head;
            while (index > 1) {
                index--;
                currentNode = currentNode.nextNode;
            }
            Node<E> newNode = new Node<>();
            newNode.value = value;
            currentNode.nextNode = newNode;
            Node<E> tmp = currentNode.nextNode;
            newNode.nextNode = tmp;
            size++;
        } else add(value);
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<>();
        newNode.value = value;
        if (size() == 0) {
            head = newNode;
            size++;
            return;
        }
        if (tail != null) {
            tail.nextNode = newNode;
            newNode.previousNode = tail;
        }
        tail = newNode;
        if (size() == 1) {
            head.nextNode = tail;
            tail.previousNode = head;
        }
        size++;
    }

    public void reverse() {
        Node<E> currentNode = head;
        int counter = 0;
        while (counter < size()) {
            Node<E> temp = new Node<>();
            Node<E> newNode = new Node<>();
            temp = currentNode.nextNode;
            newNode = tail;

            tail = currentNode;
            tail.nextNode = null;
            currentNode.previousNode = newNode;

            head = temp;
            head.previousNode = null;
            tail.nextNode = null;
            newNode.nextNode = tail;
            currentNode = head;
            counter++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> currentNode = head;
        int counter = 1;
        while (currentNode != null) {
            sb.append(currentNode.value);
            if (counter < size()) sb.append(", ");
            currentNode = currentNode.nextNode;
            counter++;
        }
        sb.append("]");
        return sb.toString();
    }
}

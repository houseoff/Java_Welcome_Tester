package ru.gb.hm4.list;

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

    public void removeAt(int index) {
        if (index >= size() || index < 0) throw new ArrayIndexOutOfBoundsException();
        else if (index == 0) {
            head = head.nextNode;
            head.previousNode = null;
        }
        else if (index == size() - 1) {
            tail = tail.previousNode;
            tail.nextNode = null;
        }
        else {
            Node<E> currentNode = head;
            while (index > 0) {
                index--;
                currentNode = currentNode.nextNode;
            }
            currentNode.previousNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.previousNode = currentNode.previousNode;
        }
        size--;
    }

    private void remove(E value, Boolean all) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                if (currentNode.previousNode == null) {
                    head = head.nextNode;
                    head.previousNode = null;
                } else if (currentNode.nextNode == null) {
                    tail = tail.previousNode;
                    tail.nextNode = null;
                } else {
                    currentNode.previousNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode.previousNode = currentNode.previousNode;
                }
                size--;
                if (!all) return;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void remove(E value) {
        remove(value, false);
    }

    public void removeAll(E value) {
        remove(value, true);
    }

    public void reverse() {
        Node<E> temp = head;
        head = tail;
        tail = temp;

        Node<E> currentNode = head;
        while (currentNode != null) {
            temp = currentNode.nextNode; 
            currentNode.nextNode = currentNode.previousNode; 
            currentNode.previousNode = temp; 
            currentNode = currentNode.nextNode;
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

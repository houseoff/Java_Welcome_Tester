import ru.gb.hm4.list.*;

public class Main {
    public static void main(String[] args) {
        task2();
    }

    public static void task1() {
        TwoWayList<Integer> list = new TwoWayList<>();
        list.addLast(1);
        list.addLast(2);
        list.add(3);
        list.addLast(4);
        System.out.println("Original List: " + list);
        list.reverse();
        System.out.println("Reversed List: " + list);
    }

    public static void task2() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue);
        System.out.println(myQueue.first());
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
    }
}

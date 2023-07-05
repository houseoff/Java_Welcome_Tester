import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import ru.gb.hm4.calc.Calc;
import ru.gb.hm4.list.*;

public class Main {
    public static void main(String[] args) {
        task3();
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

    public static void task3() {
        try {
            Logger logger = Logger.getLogger(Calc.class.getName());
            FileHandler fh = new FileHandler("log_calc.log", true);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
            logger.addHandler(fh);
            Calc calc = new Calc();
            logger.info("START CALC");
            String expr = "2 + 2";
            logger.info("expr: " + expr);
            double result = calc.getResult(expr);
            logger.info("result: " + result);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

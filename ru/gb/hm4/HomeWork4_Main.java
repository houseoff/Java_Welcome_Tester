package ru.gb.hm4;

import ru.gb.hm4.calc.*;
import ru.gb.hm4.list.*;
import ru.gb.hm4.view.*;

public class HomeWork4_Main {
//    public static void main(String[] args) {
//        task3();
//    }

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
        Boolean flag = true;
        Boolean clear = true;
        Calc calc = new Calc();
        Form form = new Form();
        InputChecker inputChecker = new InputChecker();
        String expr = null;
        double exprResult;
        while (flag) {
            form.show("Меню", FormPatterns.mainMenu(), clear);
            clear = true;
            int result = inputChecker.checkInput(FormPatterns.mainMenu(), "Ошибка! Выберите пункт меню: ");
            switch (result) {
                case 1:
                    expr = inputChecker.uncheckedInput("Введите выражение для вычисления: ");
                    exprResult = calc.getResult(expr);
                    form.show(String.format("Результат вычисления выражения: \"%s\" равен %s", expr, exprResult), clear);
                    calc.fixOperation(expr, exprResult);
                    clear = false;
                    break;
                case 2:
                    if (calc.getHistory().isEmpty()) {
                        form.show("История операций пуста", clear);
                    } else {
                        form.show("История операций", clear);
                        for (var el : calc.getHistory()) {
                            System.out.println(el);
                        }
                    }
                    clear = false;
                    break;
                case 3:
                    while (flag) {
                        form.show("Введите ID операции", clear);
                        int id = inputChecker.checkInput("Ошибка. Введите ID записи: ");
                        if (id - 1 >= calc.getHistory().size() || id <= 0) {
                            clear = false;
                            form.show("Ошибка. Не найдено записи с ID " + id, clear);
                        } else {
                            Double historyResult = calc.getHistory().get(id - 1).getResult();
                            expr = inputChecker.uncheckedInput("Введите часть выражения, начиная со знака операции для использования значения " + historyResult);
                            expr = historyResult.intValue() + " " + expr;
                            exprResult = calc.getResult(expr);
                            form.show(String.format("Результат вычисления выражения: \"%s\" равен %s", expr, exprResult), clear);
                            calc.fixOperation(expr, exprResult);
                            clear = false;
                            flag = false;
                        }
                    }
                    flag = true;
                    break;
                case 4:
                    return;
            }
        }
    }
}
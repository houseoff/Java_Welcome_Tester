package ru.gb.hm4.view;

import java.util.HashMap;

public class FormPatterns {

    private static HashMap<Integer, String> mainMenu = new HashMap<>() {{
        put(1, "Вычислить выражение");
        put(2, "Посмотреть историю операций");
        put(3, "Использовать результат из истории операций");
        put(4, "Выход");
    }};

    public static HashMap<Integer, String> mainMenu() {
        return mainMenu;
    }
}

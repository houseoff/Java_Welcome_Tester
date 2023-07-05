package ru.gb.hm4.view;
import java.util.HashMap;

public class Form {

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при очистке консоли: " + e.getMessage());
        }
    }

    public void show(String startMsg, HashMap<Integer, String> formPattern, Boolean clearConsole) {
        if (clearConsole) clearConsole();
        System.out.println(startMsg);
        for (var entry : formPattern.entrySet()) {
            System.out.printf("%d - %s\n", entry.getKey(), entry.getValue());
        }
    }

    public void show(String startMsg, Boolean clearConsole) {
        if (clearConsole) clearConsole();
        System.out.println(startMsg);
    }
}

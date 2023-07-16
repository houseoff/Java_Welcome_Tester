package ru.gb.hm6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cat {
    private int id;
    private String name;
    private Integer age;
    private Boolean isVaccinated;
    private List<String> medicalHistory;
    private Object obj;

    public Cat(int id, String name, Integer age, Boolean isVaccinated) {
        this.id   = id;
        this.name = name;
        this.age  = age;
        this.isVaccinated = isVaccinated;
        medicalHistory = new ArrayList<>();
    }

    public Cat(int id, String name, Integer age) {
        this(id, name, age, false);
    }

    private String BoolToString(Boolean value) {
        if (value) return "Да";
        else       return "Нет";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getVaccinatedInfo() {
        return BoolToString(this.isVaccinated);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(Integer newAge) {
        this.age = newAge;
    }

    public void setVaccinatedInfo(Boolean newValue) {
        this.isVaccinated = newValue;
    }

    public void sayMeow() {
        Random r = new Random();
        System.out.printf("Кот мяукнул %d раз(а)", r.nextInt(1, 10));
    }

    public void isVaccinated() {
        String m;
        if (this.isVaccinated) m = "Кот уже вакцинирован";
        else                   m = "Кот ещё не вакцинирован";
        System.out.println(m);
    }

    public void addMedicalHistory(String disease) {
        this.medicalHistory.add(disease);
    }

    public void showMedicalHistory() {
        if (this.medicalHistory.isEmpty()) {
            System.out.println("История болезней пуста");
        } else {
            System.out.println("История болезней");
            for (String s : medicalHistory) {
                System.out.println(s);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return ((Cat) obj).id == this.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(this.id).append(", ");
        sb.append("Имя: ").append(this.name).append(", ");
        sb.append("Возраст: ").append(this.age).append(", ");
        sb.append("Привит: ").append(BoolToString(this.isVaccinated));
        return sb.toString();
    }
}

import ru.gb.hm6.Cat;
import ru.gb.hm6.IDGenerator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        IDGenerator idGenerator = new IDGenerator();

        // Если в конструктор передать одинаковые id, то в множество добавится только один объект
        Cat cat1 = new Cat(idGenerator.getID(), "Васька", 4);
        Cat cat2 = new Cat(idGenerator.getID(), "Маська", 5);
        Cat cat3 = new Cat(idGenerator.getID(), "Масяська", 6);

        HashSet<Cat> cats = new HashSet<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        System.out.println(cats);
    }
}

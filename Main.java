import ru.gb.hm4_task1.TwoWayList;

public class Main {
    public static void main(String[] args) {
        TwoWayList<Integer> list = new TwoWayList<>();
        list.addLast(1);
        System.out.println(list);
        list.addLast(2);
        list.add(3);
        list.addLast(4);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }

}

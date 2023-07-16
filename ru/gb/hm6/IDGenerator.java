package ru.gb.hm6;

public class IDGenerator {
    private int ID;

    public IDGenerator(int startID) {
        this.ID = Math.max(startID, 0);
    }

    public IDGenerator() {}

    public int getID() { return ++ID; }

    public int showLastID() {return ID;}

}

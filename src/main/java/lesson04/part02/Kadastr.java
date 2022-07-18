package lesson04.part02;

public class Kadastr extends Tasks {
    public int thisNumber;

    public Kadastr() {
        thisNumber = num();
    }

    @Override
    public int prioritet() {
        return 6;
    }

    @Override
    public int time() {
        return 15;
    }

    @Override
    public String toString() {
        return "Task: Kadastr, Number: " + thisNumber + ", priority: " + prioritet() + ", time: " + time();
    }
}

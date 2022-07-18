package lesson04.part02;

public class Snils extends Tasks {
    public int thisNumber;

    public Snils() {
        thisNumber = num();
    }

    @Override
    public int prioritet() {
        return 9;
    }

    @Override
    public int time() {
        return 5;
    }

    @Override
    public String toString() {
        return "Task: SNILS, Number: " + thisNumber + ", priority: " + prioritet() + ", time: " + time();
    }
}

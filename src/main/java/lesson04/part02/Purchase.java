package lesson04.part02;

public class Purchase extends Tasks {
    public int thisNumber;

    public Purchase() {
        thisNumber = num();
    }

    @Override
    public int prioritet() {
        return 7;
    }

    @Override
    public int time() {
        return 40;
    }

    @Override
    public String toString() {
        return "Task: Purchase, Number: " + thisNumber + ", priority: " + prioritet() + ", time: " + time();
    }
}

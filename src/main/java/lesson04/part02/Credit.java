package lesson04.part02;

public class Credit extends Tasks {
    public int thisNumber;

    public Credit() {
        thisNumber = num();
    }

    @Override
    public int prioritet() {
        return 3;
    }

    @Override
    public int time() {
        return 15;
    }

    @Override
    public String toString() {
        return "Task: Credit, Number: " + thisNumber + ", priority: " + prioritet() + ", time: " + time();
    }
}

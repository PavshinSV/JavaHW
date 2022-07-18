package lesson04.part02;

public class Insurance extends Tasks {
    public int thisNumber;

    public Insurance() {
        thisNumber = num();
    }

    @Override
    public int prioritet() {
        return 1;
    }

    @Override
    public int time() {
        return 20;
    }

    @Override
    public String toString() {
        return "Task: Insurance, Number: " + thisNumber + ", priority: " + prioritet() + ", time: " + time();
    }
}

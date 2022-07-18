package lesson04.part02;

public class Passport extends Tasks{

    public int thisNumber;
    public Passport(){
        thisNumber=num();
    }
    @Override
    public int prioritet() {
        return 5;
    }

    @Override
    public long time() {
        return 10;
    }

    @Override
    public String toString() {
        return "Task: Passport, Number: "+thisNumber+", priority: "+prioritet()+", time: "+time();
    }
}

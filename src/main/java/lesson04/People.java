package lesson04;

public class People {
    private String firstName;
    private String secondName;
    private int strength;
    private int speed;

    public People(String fName, String sName, int strength, int speed) {
        this.firstName = fName;
        this.secondName = sName;
        this.strength = strength;
        this.speed = speed;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void print(){
        System.out.println(this.firstName+", "+this.secondName+", strength="+this.strength+", speed="+this.speed);
    }
}

package lesson04;

public class People {
    private String firstName;
    private String secondName;
    private int strength;
    private int dexterity;
    private int speed;

    //public People(){ //String fName, String sName, int str, int dex, int speed
    public void setFirstName(String fName){
        this.firstName=fName;
    }
    public void setSecondName(String sName){
        this.secondName=sName;
    }

    public void setStrength(int str){
        this.strength=str;
    }
    public void setDexterity(int dex){
        this.dexterity=dex;
    }

    public void setSpeed(int speed){
        this.speed=speed;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getDexterity(){
        return this.dexterity;
    }

    public int getSpeed(){
        return this.speed;
    }
}

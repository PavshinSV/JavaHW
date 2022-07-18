package lesson04;

public class Barrier {
    private int neededSpeed;
    private int neededStrength;
    private String title;
    public Barrier(String title, int neededSpeed, int neededStrength){
        this.neededSpeed=neededSpeed;
        this.neededStrength=neededStrength;
        this.title=title;
    }

    public String getTitle(){
        return this.title;
    }

    public int getNeededSpeed(){
        return this.neededSpeed;
    }

    public int getNeededStrength(){
        return this.neededStrength;
    }

    @Override
    public String toString() {
        return "Barrier name: "+this.title+"\nnecessary strength: "+this.neededStrength+"\nnecessary speed: "+this.neededSpeed+"\n";
    }
}

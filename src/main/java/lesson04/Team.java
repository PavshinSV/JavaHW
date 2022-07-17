package lesson04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
    private String title;
    private List<People> gamers=new ArrayList<>();
    public  Team(String title, int count, String[] familys, String[] names){
        this.title = title;
        for (int i =0;i<count;i++){
            int fIndex = new Random().nextInt(familys.length);
            int sIndex = new Random().nextInt(names.length);
            int str = new Random().nextInt(10)+1;
            int sp = new Random().nextInt(10)+1;
            People gamer = new People(familys[fIndex],names[sIndex],str,sp);
            this.gamers.add(gamer);
        }
    }

    @Override
    public String toString() {
        String str="Team name: "+this.title;
        for (People el :
                this.gamers) {
            str+="\n"+el.getFirstName()+" "+el.getSecondName()+", strength:"+el.getStrength()+", speed:"+el.getSpeed();
        }
        str+="\n";
        return str;
    }

    public String getTitle(){
        return this.title;
    }

    public int size(){
        return this.gamers.size();
    }

    public List<People> getList(){
        return this.gamers;
    }
    int f;
    String str;
}

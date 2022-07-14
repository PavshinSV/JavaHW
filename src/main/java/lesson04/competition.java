package lesson04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class competition {
    public static void main(String[] args){
        int players = 10;
        List<People> gamers = new ArrayList<>(players);
        String[] familys = new String[]{"Pavshin","Jashin","Fetisov","Ozerov","Ivanov","Petrov","Koshkin","Mamin","Olgin","Itogin"};
        String[] names = new String[]{"Sergey","Oleg","Vitally","Ivan","Maxim","Petr","Alexey","Evgeny","Andrey","Dmitry"};
        for (int i =0;i<players;i++){
            int fIndex = new Random().nextInt(familys.length);
            int sIndex = new Random().nextInt(names.length);
            int str = new Random().nextInt(10)+1;
            int sp = new Random().nextInt(10)+1;
            People gamer = new People(familys[fIndex],names[sIndex],str,sp);
            gamers.add(i,gamer);
        }
        for (People el: gamers) {
            el.print();
        }


    }
}
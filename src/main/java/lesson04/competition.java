package lesson04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class competition {
    public static void main(String[] args){
        int players = 4; //кол-во игроков в каждой команде
        String[] familys = new String[]{"Pavshin","Jashin","Fetisov","Ozerov","Ivanov","Petrov","Koshkin","Mamin","Olgin","Itogin"};
        String[] names = new String[]{"Sergey","Oleg","Vitally","Ivan","Maxim","Petr","Alexey","Evgeny","Andrey","Dmitry"};

        Team team1 = new Team("Boogers", players,familys,names);
        Team team2 = new Team("Booger winners", players,familys,names);
        System.out.println(team1);
        System.out.println(team2);
        Barrier barrier1 = new Barrier("Rope",2,6);
        Barrier barrier2 = new Barrier("Track",7,3);
        Barrier barrier3 = new Barrier("Boat",6,6);
        Barrier barrier4 = new Barrier("Pull-up",2,8);
        BarrierList barrierOrder = new BarrierList();
        barrierOrder.addBarrier(barrier1);
        barrierOrder.addBarrier(barrier2);
        barrierOrder.addBarrier(barrier3);
        barrierOrder.addBarrier(barrier4);
        System.out.println(barrierOrder);
        Competition(team1,team2,barrierOrder);
    }

    public static void Competition(Team team1, Team team2, BarrierList order){
        double time1=0;
        double time2=0;
        List<People> tList1 = team1.getList();
        List<People> tList2 = team2.getList();
        for (int i=0;i<tList1.size();i++){
            for (Barrier barrier: order.getList()) {
                time1+=barrier.getNeededSpeed()/tList1.get(i).getSpeed()+barrier.getNeededStrength()/tList1.get(i).getStrength();
                time2+=barrier.getNeededSpeed()/tList2.get(i).getSpeed()+barrier.getNeededStrength()/tList2.get(i).getStrength();
            }
        }

        System.out.printf("Time for %s: %.2f, minutes\n", team1.getTitle(),time1);
        System.out.printf("Time for %s: %.2f, minutes\n", team2.getTitle(),time2);
        if (time1>time2) {
            System.out.printf("Team %s win\n", team2.getTitle());
        }
        else if (time1<time2) {
            System.out.printf("Team %s win\n", team1.getTitle());
        } else {
            System.out.println("Stand off");
        }
        People gamer = new People("Pavshin", "Sergey",10,8);

    }
}
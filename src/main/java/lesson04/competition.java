package lesson04;

public class competition {
    public static void main(String[] args){
        //"Pavshin","Sergey",5,5,5
        //Team t = new Team();
        //t.f=44;
        Obstacal ob1 = new Obstacal();
        ob1.f=54;
        ob1.str="dkj";
        System.out.println(ob1.f);

        //People gamer1 = new People();
        //System.out.println(gamer1.getFirstName());
        //System.out.println(gamer1.getSecondName());
//        System.out.println(gamer1.getStrength());
//        System.out.println(gamer1.getDexterity());
//        System.out.println(gamer1.getSpeed());
    }

    public static class Obstacal {
        int f;
        String str;
    }


}
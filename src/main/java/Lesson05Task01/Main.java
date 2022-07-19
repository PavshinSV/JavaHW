package Lesson05Task01;
/**
 * Жанр
 * Название песни
 * количество прослушиваний
 */

import java.util.*;

public class Main {

    static Map<String, Map<String, Integer>> playList = new HashMap<>();

    public static void main(String[] args) {
        fillList();
        boolean inputError = true;
        Scanner sc = new Scanner(System.in);
        int chose;
        while (inputError) {
            System.out.println("Input number for wanted play list:\n1. For Gym\n2. For Rave\n3. Songs of the Day\n4. Random");
            String str=sc.nextLine();
            if (tryParse(str)==true){
                chose=Integer.parseInt(str);
                if (chose>0 && chose<5){
                    inputError=false;
                }
            } else {
                System.out.println("WARNING!!!\nIncorrect data\nRepeat input");
            }
        }
        switch (chose){
        }


    }

    public static boolean tryParse(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public static Map<String, Map<String, Integer>> GymPlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();

        return newList;
    }

    public static Map<String, Map<String, Integer>> RavePlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();

        return newList;
    }

    public static Map<String, Map<String, Integer>> DayPlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();

        return newList;
    }

    public static Map<String, Map<String, Integer>> RandomPlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();

        return newList;
    }

    public static void fillList() {
        Map<String, Integer> rock = new HashMap<>();
        rock.put("Smells like teen spirit", 152);
        rock.put("The roof on the fire", 215);
        rock.put("Poly wants a cracker", 126);
        rock.put("Stairway to heaven", 85);
        rock.put("Enter sandman", 250);
        rock.put("Runway", 123);
        rock.put("Enjoy the silence", 187);
        rock.put("Personal Jesus", 127);
        rock.put("Show must go on", 212);
        rock.put("Like a Rolling Stone", 172);
        playList.put("Rock", rock);
        Map<String, Integer> blues = new HashMap<>();
        blues.put("If I had money", 75);
        blues.put("Blues In My bottle", 85);
        blues.put("She`s crazy", 64);
        blues.put("Picasso Blue", 98);
        blues.put("Lonely world", 69);
        blues.put("I`m talking about it", 78);
        blues.put("The River", 91);
        blues.put("Kiss of fire", 83);
        blues.put("Bad luck man", 63);
        blues.put("Bad women blues", 76);
        playList.put("Blues", blues);
        Map<String, Integer> pop = new HashMap<>();
        pop.put("Shivers", 218);
        pop.put("Until I Found You", 215);
        pop.put("Thousand Miles", 216);
        pop.put("Billie Jean", 211);
        pop.put("Stayin' Alive", 212);
        pop.put("I Will Survive", 214);
        pop.put("Whole Lotta Love", 221);
        pop.put("Sweet Child O'Mine", 223);
        pop.put("Scream And Shout", 234);
        pop.put("Santeria", 231);
        playList.put("Pop", pop);
        Map<String, Integer> rap = new HashMap<>();
        rap.put("True Love", 102);
        rap.put("Hello Mate", 107);
        rap.put("Vegas", 113);
        rap.put("I Like You", 115);
        rap.put("First Class", 119);
        rap.put("Jimmy Cooks", 103);
        rap.put("PUSSY", 107);
        rap.put("N95", 115);
        rap.put("I Used to Love H.E.R.", 117);
        rap.put("Rapper's Delight", 103);
        playList.put("RAP",rap);
    }


}
package Lesson05Task02;

import java.util.*;

public class Main {
    static List<Song> Pop = new ArrayList<>();
    static List<Song> RAP = new ArrayList<>();
    static List<Song> Blues = new ArrayList<>();
    static List<Song> Rock = new ArrayList<>();
    static int listLength = 10;

    public static void main(String[] args) {
        fillList();
        List<Song> todayPlayList = getChoice();
        for (Song song : todayPlayList) {
            System.out.println(song);
        }
    }


    public static List<Song> getChoice(){
        boolean inputError = true;
        int chose=0;
        while (inputError) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input number for wanted play list:\n1. For Gym\n2. For Rave\n3. Songs of the Day\n4. Random");
            String str = sc.nextLine();
            if (tryParse(str)) {
                chose = Integer.parseInt(str);
                if (chose > 0 && chose < 5) {
                    inputError = false;
                } else {
                    System.out.println("WARNING!!!\nIncorrect data\nRepeat input");
                }
            } else {
                System.out.println("WARNING!!!\nIncorrect data\nRepeat input");
            }
        }
        getSorted();

        return switch (chose) {
            case (1) -> GymPlay();
            case (2) -> RavePlay();
            case (3) -> DayPlay();
            case (4) -> RandomPlay();
            default -> new ArrayList<>();
        };
    }

    public static List<Song> GymPlay(){
        List<Song> result = new ArrayList<>();
        int half = listLength/2;
        for (int i=0; i<half; i++){
            result.add(Rock.get(i));
        }
        for (int i=0;i<listLength-half;i++){
            result.add(RAP.get(i));
        }
        return result;
    }

    public static List<Song> RavePlay(){
        List<Song> result = new ArrayList<>();
        int half = listLength/2;
        for (int i=0; i<half; i++){
            result.add(Rock.get(i));
        }
        for (int i=0;i<listLength-half;i++){
            result.add(Pop.get(i));
        }
        return result;
    }
    
    public static List<Song> DayPlay(){
        List<Song> result = new ArrayList<>();
        int quarter = listLength/4;
        for (int i=0; i<quarter; i++){
            result.add(Rock.get(i));
        }
        for (int i=0;i<quarter;i++){
            result.add(RAP.get(i));
        }
        for (int i=0;i<quarter;i++){
            result.add(Blues.get(i));
        }
        for (int i=0;i<listLength-quarter*3;i++){
            result.add(Pop.get(i));
        }
        return result;
    }

    public static List<Song> RandomPlay(){
        List<Song> result = new ArrayList<>();
        for (int i =0;i<listLength;i++){
            int r = new Random().nextInt(1,5);
            switch (r) {
                case (1) -> result.add(Pop.get(new Random().nextInt(Pop.size())));
                case (2) -> result.add(Rock.get(new Random().nextInt(Rock.size())));
                case (3) -> result.add(RAP.get(new Random().nextInt(RAP.size())));
                case (4) -> result.add(Blues.get(new Random().nextInt(Blues.size())));
            }
        }
        return result;
    }

    public static void getSorted(){
        Comparator<Song> comparator = (o1, o2) -> o2.getListenCount().compareTo(o1.getListenCount());
        Pop.sort(comparator);
        RAP.sort(comparator);
        Blues.sort(comparator);
        Rock.sort(comparator);
    }

    public static boolean tryParse(String str){
        boolean result;
        try {
            Integer.parseInt(str);
            result =true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static void fillList() {
        Rock.add(new Song("Rock", "Smells like teen spirit", 152));
        Rock.add(new Song("Rock", "The roof on the fire", 215));
        Rock.add(new Song("Rock", "Poly wants a cracker", 126));
        Rock.add(new Song("Rock", "Stairway to heaven", 85));
        Rock.add(new Song("Rock", "Enter sandman", 250));
        Rock.add(new Song("Rock", "Runway", 123));
        Rock.add(new Song("Rock", "Enjoy the silence", 187));
        Rock.add(new Song("Rock", "Personal Jesus", 127));
        Rock.add(new Song("Rock", "Show must go on", 212));
        Rock.add(new Song("Rock", "Like a Rolling Stone", 172));
        Blues.add(new Song("Blues", "If I had money", 75));
        Blues.add(new Song("Blues", "Blues In My bottle", 85));
        Blues.add(new Song("Blues", "She`s crazy", 64));
        Blues.add(new Song("Blues", "Picasso Blue", 98));
        Blues.add(new Song("Blues", "Lonely world", 69));
        Blues.add(new Song("Blues", "I`m talking about it", 78));
        Blues.add(new Song("Blues", "The River", 91));
        Blues.add(new Song("Blues", "Kiss of fire", 83));
        Blues.add(new Song("Blues", "Bad luck man", 63));
        Blues.add(new Song("Blues", "Bad women blues", 76));
        Pop.add(new Song("Pop", "Shivers", 218));
        Pop.add(new Song("Pop", "Until I Found You", 215));
        Pop.add(new Song("Pop", "Thousand Miles", 216));
        Pop.add(new Song("Pop", "Billie Jean", 211));
        Pop.add(new Song("Pop", "Staying' Alive", 212));
        Pop.add(new Song("Pop", "I Will Survive", 214));
        Pop.add(new Song("Pop", "Whole Lotta Love", 221));
        Pop.add(new Song("Pop", "Sweet Child O'Mine", 223));
        Pop.add(new Song("Pop", "Scream And Shout", 234));
        Pop.add(new Song("Pop", "Santeria", 231));
        RAP.add(new Song("RAP", "True Love", 102));
        RAP.add(new Song("RAP", "Hello Mate", 107));
        RAP.add(new Song("RAP", "Vegas", 113));
        RAP.add(new Song("RAP", "I Like You", 115));
        RAP.add(new Song("RAP", "First Class", 119));
        RAP.add(new Song("RAP", "Jimmy Cooks", 103));
        RAP.add(new Song("RAP", "PUSSY", 107));
        RAP.add(new Song("RAP", "N95", 115));
        RAP.add(new Song("RAP", "I Used to Love H.E.R.", 117));
        RAP.add(new Song("RAP", "Rapper's Delight", 103));
    }
}
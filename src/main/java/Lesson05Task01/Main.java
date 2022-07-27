package Lesson05Task01;
/**
 * Жанр
 * Название песни
 * количество прослушиваний
 */

import java.security.SecureRandom;
import java.util.*;

public class Main {

    static Map<String, Map<String, Integer>> playList = new HashMap<>();
    static int listLength = 10;

    public static void main(String[] args) {
        fillList();
        boolean inputError = true;
        Scanner sc = new Scanner(System.in);
        int chose = 0;
        while (inputError) {
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

        Map<String, Map<String, Integer>> music = switch (chose) {
            case (1) -> GymPlay();
            case (2) -> RavePlay();
            case (3) -> DayPlay();
            case (4) -> RandomPlay();
            default -> new HashMap<>();
        };
        printList(music);
    }

    public static void printList(Map<String, Map<String, Integer>> toPrint){
        for (Map.Entry<String, Map<String, Integer>> style: toPrint.entrySet()){
            System.out.println(style.getKey());
            for (Map.Entry<String ,Integer> song: style.getValue().entrySet()){
                System.out.printf("\t Song: %s; Listen: %d\n",song.getKey(),song.getValue());
            }
        }
    }

    public static Map<String, Map<String, Integer>> getSongs(String styleKey, int count) {
        Map<String, Map<String, Integer>> topList = new HashMap<>();
        String[] keys = playList.get(styleKey).keySet().toArray(new String[playList.get(styleKey).keySet().size()]);
        Integer[] values = playList.get(styleKey).values().toArray(new Integer[playList.get(styleKey).values().size()]);
        boolean move = true;
        while (move) {
            move = false;
            for (int i = 1; i < keys.length; i++) {
                if (values[i] > values[i - 1]) {
                    int temp = values[i];
                    values[i] = values[i - 1];
                    values[i - 1] = temp;
                    String str = keys[i];
                    keys[i] = keys[i - 1];
                    keys[i - 1] = str;
                    move = true;
                }
            }
        }
        Map<String, Integer> tmp = new HashMap<>();
        for (int i = 0; i < count; i++) {
            tmp.put(keys[i], values[i]);
        }
        topList.put(styleKey, tmp);
        return topList;
    }

    public static boolean tryParse(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Map<String, Map<String, Integer>> GymPlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();
        newList.putAll(getSongs("Rock", listLength / 2));
        newList.putAll(getSongs("RAP", listLength / 2));
        return newList;
    }

    public static Map<String, Map<String, Integer>> RavePlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();
        newList.putAll(getSongs("Rock", listLength / 2));
        newList.putAll(getSongs("Pop", listLength / 2));
        return newList;
    }

    public static Map<String, Map<String, Integer>> DayPlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();
        newList.putAll(getSongs("Pop", (listLength / 2 - listLength / 4)));
        newList.putAll(getSongs("Blues", listLength / 4));
        newList.putAll(getSongs("Rock", (listLength / 2 - listLength / 4)));
        newList.putAll(getSongs("RAP", listLength / 4));
        return newList;
    }

    public static Map<String, Map<String, Integer>> RandomPlay() {
        Map<String, Map<String, Integer>> newList = new HashMap<>();
        List<String> styles = playList.keySet().stream().toList();
        Map<String, Integer> styleRepeat = new HashMap<>();
        var random = new SecureRandom();
        for (int i = 0; i < listLength; i++) {
            String key = styles.get(random.nextInt(styles.size()));
            if (styleRepeat.containsKey(key)) {
                styleRepeat.put(key, styleRepeat.get(key) + 1);
            } else {
                styleRepeat.put(key, 1);
            }
        }
        for (Map.Entry<String, Integer> el : styleRepeat.entrySet()) {
            List<String> songs = playList.get(el.getKey()).keySet().stream().toList();
            Map<String, Integer> tmp = new HashMap<>();
            for (int i = 0; i < el.getValue(); i++) {
                String songKey = songs.get(random.nextInt(songs.size()));
                tmp.put(songKey, playList.get(el.getKey()).get(songKey));
            }
            newList.put(el.getKey(), tmp);
        }

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
        playList.put("RAP", rap);
    }


}
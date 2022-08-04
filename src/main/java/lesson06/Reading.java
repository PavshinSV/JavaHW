package lesson06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reading {
    public static AppData getReading() {
        AppData data = new AppData();
        String v1 = new String();
        String v2 = new String();
        String v3 = new String();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        try {
            File file = new File("AppData.csv");
            Scanner fr = new Scanner(file);
            String line = new String();
            String[] arr = new String[3];
            int i = 0;
            while (fr.hasNext()) {
                line = fr.nextLine();
                arr = line.split(";");
                if (i == 0) {
                    v1 = arr[0];
                    v2 = arr[1];
                    v3 = arr[2];
                } else {
                    l1.add(Integer.parseInt(arr[0]));
                    l2.add(Integer.parseInt(arr[0]));
                    l3.add(Integer.parseInt(arr[0]));
                }
                i++;
            }


        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        data.addAllData(v1, l1);
        data.addAllData(v2, l2);
        data.addAllData(v3, l3);
        return data;
    }
}

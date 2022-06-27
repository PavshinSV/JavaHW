//Дан список из 10 - 20 слов с повторами, вывести этот же спиок без повторов
// и указать сколько раз оно встречалось до изменения.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson03Task01 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("Привет");
        list.add("Лена");
        list.add("Отлично");
        list.add("Лена");
        list.add("Hi");
        list.add("Exelent");
        list.add("Yellow");
        list.add("Color");
        list.add("Отлично");
        list.add("Лена");
        list.add("Hi");
        list.add("Exelent");
        list.add("Yellow");
        list.add("Color");
        list.add("Отлично");
        list.add("Color");
        list.add("Отлично");

        Map<String, Integer> mapa = new HashMap<>();

        for (int i=0;i<list.size();i++)
        {
            if (mapa.containsKey(list.get(i)))
            {
                mapa.put(list.get(i), mapa.get(list.get(i))+1);
            } else
            {
                mapa.put(list.get(i), 1);
            }
        }
        System.out.println(mapa);
    }

}
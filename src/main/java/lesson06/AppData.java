package lesson06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppData {
    static private Map<String, List<Integer>> data;

    public static Map<String, List<Integer>> getMap() {
        return data;
    }

    public void addData(String key, Integer toAdd) {
        if (data.containsKey(key)) {
            data.get(key).add(toAdd);
        } else {
            data.put(key, new ArrayList<>(toAdd));
        }
    }

    public void addAllData(String key, List<Integer> toAdd) {
        if (data.containsKey(key)) {
            data.get(key).addAll(toAdd);
        } else {
            data.put(key, toAdd);
        }
    }
}

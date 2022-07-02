// Определить является ли строка полиндромом

public class Lesson02Task01 {
    public static void main(String[] args) {
        String letters = "Я иду с мечем судия";
        System.out.println(isPolyndrom(letters));
    }

    public static boolean isPolyndrom(String str) {
        str = str.toLowerCase();
        str=str.replaceAll("\\s+","");
        boolean polyndrom = true;
        int min = 0;
        int max = str.length()-1;
        while (min < max) {
            if (str.charAt(min) != str.charAt(max)) {
                polyndrom = false;
            }
            min++;
            max--;
        }
        return polyndrom;
    }
}
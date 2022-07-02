//Задание 1.
//Создать карту (Map), будет хранить в себе данные телефонной книги (Фамилии и телефонные номера),
// если будут дубликаты фамилий, то должны выводиться оба номера (если помним Map не может хранить дубликаты,
// будет заменять номер телефона по ключу, нужно подумать как не допустить такого)



import java.util.HashMap;
import java.util.Map;

public class Lesson03HW01 {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();

        phoneBook.put("89535887936", "Pavshin Sergey");
        phoneBook.put("83912180169", "Pavshin Sergey");
        phoneBook.put("84999224710", "GeekBrains");
        phoneBook.put("88007006841", "GeekBrains");

        printBook(phoneBook);
        System.out.println("=======================================");
        printBook(phoneBook, "Pavshin Sergey");
    }

    public static void printBook(HashMap<String, String> mapa) {
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            System.out.printf("Фамилия: %s, номер телефона: %s\n", entry.getValue(), entry.getKey());
        }
    }

    public static void printBook(HashMap<String, String> mapa, String name) {
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            if (entry.getValue() == name) {
                System.out.printf("Фамилия: %s, номер телефона: %s\n", entry.getValue(), entry.getKey());
            }
        }
    }
}
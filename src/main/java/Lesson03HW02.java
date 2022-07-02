//Задание 2.
//       Написать метод, который проверяет валидность логина и пароля
//       (где нибудь в переменных сохраните) и при помощи конструкции try-catch
//       рекурсивно принимайте данные (нужно ограничить колиичество попыток до 6
//       и после 3 попытки должно быть сообщение, мол вы привысили количество попыток,
//       немного пододождите тут можете поток заслипить на некоторое время.
//       А когда попытки кончатся - выйти)


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Lesson03HW02 {
    public static void main(String[] args) {
        int pauseCount = 3;
        int stopCount = 6;
        List<Repository> db = new ArrayList<>();
        Repository temp = getInput(pauseCount, stopCount);

        if (temp.login.equals("ExceptionIO") || temp.password.equals("ExceptionIO")) {
            System.out.println("Сожалеем, но вы не смогли безопасным образом зарегистрироваться.\nМожет быть в следующий раз :-(");
        } else {
            db.add(temp);
            for (Repository item : db) {
                System.out.println("\nLogin: " + item.login);
                System.out.println("password: " + item.password);
            }
        }
    }


    public static Repository getInput(int pause, int stop) {
        Repository result = new Repository();
        Repository temp = new Repository();
        result.login = "ExceptionIO";
        result.password = "ExceptionIO";
        if (pause == 0) {
            System.out.println("Вы видимо \"не алё\"!,\nещё раз посмотрите условие ввода и повторите попытку,\nа пока отдохните минутку");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (stop == 0) {
            System.out.println("Попытки кончились. Вы не справились");
            return result;
        }

        Scanner sc = new Scanner(System.in);
        System.out.printf("\nОсталось %d попыток ввода\n", stop);
        System.out.println("Введите login:\n(Должен начинаться c буквы, может содержать буквы и цифры, никаких спецсимволов и пробелов, длина не менее 3х символов)");
        temp.login = sc.nextLine();
        System.out.println("Введите password:\n(Должен начинаться c буквы, может содержать буквы и цифры, никаких спецсимволов и пробелов, длина не менее 3х символов)");
        temp.password = sc.nextLine();
        String pattern = "^[a-zA-zа-яА-я][a-zA-zа-яА-я0-9]{2,}$";
        if (Pattern.matches(pattern, temp.login) && Pattern.matches(pattern, temp.password)) {
            result.login = temp.login;
            result.password = temp.password;
        } else {
            return getInput(--pause, --stop);
        }

        return result;
    }

    public static class Repository {
        String login;
        String password;
    }
}
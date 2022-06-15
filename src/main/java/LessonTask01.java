import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LessonTask01 {
    public static void main(String[] args) {
        ArrayList<data> numbers = getInput();
        try (FileWriter fr = new FileWriter("output.txt", false)) {
            for (data item : numbers) {
                double operation = pow(item.num, item.exp);
                System.out.printf("%.0f^%d = %.2f\n", item.num, item.exp, operation);
                fr.append(String.valueOf(operation));
                fr.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static double pow(double num, int exp) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || exp == 0) {
            return 1;
        } else if (exp < 0) {
            exp *= -1;
            num = 1 / num;
        }
        if (exp % 2 == 0 && exp != 2) {
            double temp = pow(num, exp / 2);
            return temp * temp;
        } else {
            double temp = 1;
            for (int i = 0; i < exp; i++) {
                temp *= num;
            }
            return temp;
        }
    }

    static class data {
        double num;
        int exp;
    }

    public static ArrayList<data> getInput() {
        ArrayList<data> result = new ArrayList<>();
        try (FileReader fr = new FileReader("input.txt")) {
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() > 0) {
                    data temp = new data();
                    String[] arr = line.split(",");
                    temp.num = Double.parseDouble(arr[0]);
                    temp.exp = Integer.parseInt(arr[1]);
                    result.add(temp);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

}

import java.util.Random;

public class HW_Task02 {
    public static void main(String[] args) {
        int num;
        boolean notYet = true;
        while (notYet) {
            num = new Random().nextInt(999);
            int temp = num;
            int summ = 0;
            while (temp > 0) {
                summ += temp % 10;
                temp /= 10;
            }
            if (num % summ == 0) {
                System.out.printf("Для числа %d сумма всех чисел равна %d\n", num, summ);
                System.out.printf("%d делится без остатка на %d, результат деления равен: %d", num, summ, num / summ);
                notYet = false;
            }

        }
    }
}
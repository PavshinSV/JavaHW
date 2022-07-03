public class Lesson03HW03 {

    public static void main(String[] args) {
        hanoi(4, 1, 2);
    }

    public static void hanoi(int n, int i, int k) {
        if (n == 1) {
            System.out.printf("Переложите диск %d со штырька %d на штырек %d.\n", n, i, k);
        } else {
            int tmp = 6 - i - k;
            hanoi(n - 1, i, tmp);
            System.out.printf("Переложите диск %d со штырька %d на штырек %d.\n", n, i, k);
            hanoi(n - 1, tmp, k);
        }

    }
}
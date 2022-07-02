//Вывести массив всех чисел в заданном интервале, которые делятся на сумму цифр этого числа

public class Lesson02Task03 {
    public static void main(String[] args) {
        int min = 10;
        int max = 100;
        System.out.printf("\nВ диапозоне от %d до %d числами делящимися без остатка на сумму своих цифр являются:\n",min,max);
        getPrint(getNum(min, max));
        System.out.println("\n");
    }

    public static int[] getNum(int startMin, int startMax) {
        startMax += 1;
        StringBuilder numbers = new StringBuilder();
        int numTemp;
        for (int i = startMin; i < startMax; i++) {
            numTemp=0;
            int temp = i;
            while (temp > 0) {
                numTemp += temp % 10;
                temp /= 10;
            }
            if(i%numTemp==0){
                numbers.append(i).append(";");
            }
        }
        numbers = new StringBuilder(numbers.substring(0, numbers.length() - 1));
        String[] str = numbers.toString().split(";");

        int[] res = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            res[i] = Integer.parseInt(str[i]);
        }
        return res;
    }

    public static void getPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[" + arr[i]+", ");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

}
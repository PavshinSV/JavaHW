//У вас есть отсортированный массив, нужно используя минимальное колличество попыток найти загаданное число

import java.util.Arrays;
import java.util.Random;

public class Lesson02Task011 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        int indexToFind = 3;

        System.out.println("Массив заполненный случайными числами:");
        for (int el : arr) {
            System.out.print(el + " ");
        }

        int toFind = arr[indexToFind];
        System.out.println("\nИскомое число: " + toFind);

        Arrays.sort(arr);
        System.out.println("Отсортированный массив:");
        for (int el : arr) {
            System.out.print(el + " ");
        }

        int min = 0;
        int max = arr.length - 1;
        int index = 1;
        if (arr[min] == toFind) {
            indexToFind = min;
        } else if (arr[max] == toFind) {
            indexToFind = max;
        } else {
            while (arr[indexToFind] != toFind) {
                if (toFind > arr[indexToFind]) {
                    min = indexToFind;
                    indexToFind = (max + indexToFind) / 2;
                } else {
                    max = indexToFind;
                    indexToFind = (min + indexToFind) / 2;
                }
                index++;
            }
        }
        System.out.printf("\nИскомое значение %d находится на %d индексе.\nПотребовалос %d итераций", toFind, indexToFind, index);

    }

}
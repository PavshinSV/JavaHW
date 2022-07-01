//Написать программу перебора n комбинаций из цифр от 0 - 9 (n длина массива)
// те 0 0 0 0 0 1 0 0 2 - - - 9 9 9 n - длина одной строки

//Всетаки я допер как это работает


import java.util.Arrays;


public class Lesson03Task02 {


    public static void main(String[] args)
    {
        int n = 2;
        generate(new int[n],0,9);


    }

    public static void generate(int[] comb, int index, int n){
        if (comb.length==index){
            System.out.println(Arrays.toString(comb));
            return;
        }
        for (int i = 0; i <= n; i++) {
            comb[index]=i;
            generate(comb,index+1,n);
        }
    }
}
import java.util.Scanner;

public class HW_Task01 {
    public static void main(String[] args){
        int num = getInput();
        System.out.println("Для введенного значения треугольное число равно: "+triangleNumber(num));
    }

    public static int getInput(){
        int num=0;
        boolean inputError = true;
        while (inputError){
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите значение для которого вы хотите расчитать треугольное число");
            String line = scan.nextLine();
            if (line.length()>0 && isNumeric(line)) {
                inputError=false;
                num=Integer.parseInt(line);
            } else {
                System.out.println("Вы ввели неверное значение.\nВведите целое число\n");
            }
        }
        return num;
    }

    public static boolean isNumeric(String str){
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    public static double triangleNumber(int num){
        return (0.5*num*(num+1));
    }
}
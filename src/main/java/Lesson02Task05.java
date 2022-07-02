// 5.Задано уравнение вида q+w=e,q,w,e>=0.
// Некоторые цифры могут быть заменены знаком вопроса,например 2?+?5=69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить,что его нет.

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson02Task05 {
    public static void main(String[] args) {
        System.out.println("Необходимо ввести значения переменных уравнения\nq + w = e, при этом q,w,e >= 0,\nНекоторые цифры в числах могут быть заменены на знак '?'");
        String q = getString("q");
        String w = getString("w");
        String e = getString("e");
        ArrayList<Data> equal = getEqual(q, w, e);
        System.out.printf("\nДля уравнения %s + %s = %s существуют следующие решения\n", q, w, e);
        if (equal.size() == 0) {
            System.out.println("Решений нет");
        } else {
            System.out.print("\n\tq\tw\te\n");
            for (Data data : equal) {
                System.out.printf("\t%d \t%d \t%d\n", data.a, data.b, data.c);
            }
        }
    }

    public static String getString(String arg) {
        System.out.printf("\nВведите значение переменной %s: ", arg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static ArrayList<Data> getEqual(String a, String b, String c) {
        ArrayList<Data> res = new ArrayList<>();
        char[] numeric = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Data temp = new Data();
        int cInt = 0;
        int bInt = 0;
        int aInt = 0;
        if (tryParse(c)) {
            cInt = Integer.parseInt(c);
        } else {
            StringBuilder var = new StringBuilder(c);
            int index = c.indexOf('?');
            for (char ch : numeric) {
                var.setCharAt(index, ch);
                ArrayList<Data> prom;
                prom = getEqual(a, b, var.toString());
                for (Data el :
                        prom) {
                    boolean notInRes = true;
                    for (Data el2 :
                            res) {
                        if (el.a == el2.a && el.b == el2.b && el.c == el2.c) {
                            notInRes = false;
                            break;
                        }
                    }
                    if (notInRes) {
                        res.add(el);
                    }
                }
            }
        }

        if (tryParse(b)) {
            bInt = Integer.parseInt(b);
        } else {
            StringBuilder var = new StringBuilder(b);
            int index = b.indexOf('?');
            for (char ch : numeric) {
                var.setCharAt(index, ch);
                ArrayList<Data> prom;
                prom = getEqual(a, var.toString(), c);
                for (Data el :
                        prom) {
                    boolean notInRes = true;
                    for (Data el2 :
                            res) {
                        if (el.a == el2.a && el.b == el2.b && el.c == el2.c) {
                            notInRes = false;
                            break;
                        }
                    }
                    if (notInRes) {
                        res.add(el);
                    }
                }
            }

        }
        if (tryParse(a)) {
            aInt = Integer.parseInt(a);
        } else {
            StringBuilder var = new StringBuilder(a);
            int index = a.indexOf('?');
            for (char ch : numeric) {
                var.setCharAt(index, ch);
                ArrayList<Data> prom;
                prom = getEqual(var.toString(), b, c);
                for (Data el :
                        prom) {
                    boolean notInRes = true;
                    for (Data el2 :
                            res) {
                        if (el.a == el2.a && el.b == el2.b && el.c == el2.c) {
                            notInRes = false;
                            break;
                        }
                    }
                    if (notInRes) {
                        res.add(el);
                    }
                }
            }
        }


        if ((aInt != 0 || bInt != 0) && (aInt + bInt == cInt)) {
            temp.a = aInt;
            temp.b = bInt;
            temp.c = cInt;
            res.add(temp);
        }

        return res;
    }

    public static boolean tryParse(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static class Data {
        int a;
        int b;
        int c;
    }

}
//Сократить строку вида aaabbbssskkk до a3b3s3k3
public class Lesson02Task02 {
    public static void main(String[] args) {
        String toCrypt = "aaabbbssskkk";
        System.out.println(getCrypt(toCrypt));
    }

    public static String getCrypt(String str) {
        int len =str.length();
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return str;
        }
        String crypt = new String();
        char previos=str.charAt(0);;
        int cnt=0;
        for (int i = 0; i < len; i++) {
            if (i==0)  {
                crypt+=previos;
                cnt++;
            } else {
               if (previos==str.charAt(i)){
                    cnt++;
                } else {
                    crypt+=String.valueOf(cnt);
                    cnt=1;
                    previos=str.charAt(i);
                    crypt+=previos;
                }
            }
        }
        crypt+=String.valueOf(cnt);
        return crypt;
    }
}
public class LessonTask02 { //Сразу скажу - просто стырил с ГитХаб Федотчева. Так как пока туда не злез - не мог понять,
    //что нужно сделать, потому что в задаче много ошибок. На вход подается 2 числа, а из примера получается, что 4.
    //к1 - увеличивается а на с (2), к2 - увеличивает а на b. А из примера получается что для полчения числа 7 из 1
    //необходимо выполнить 6 команд к1. По моей логике получалось, что это не 7, а 64.
    //Посмотрев реализацию понял, что в условии многое напутано.

    public static void main(String[] args) {
        generate(1,7,1,2,"");
    }

    public static void  generate (int source, int target, int c, int d, String path){
        if (source > target) return;
        if(source == target){
            System.out.println(path);
            return;
        }

        generate(source + c, target,c,d,path + " k1");
        generate(source * d, target,c,d,path + " k2");


    }
}
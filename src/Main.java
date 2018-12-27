
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // N组测试数据，循环N遍，输出每组数据对应的结果
        for (int i = 0; i < N ; i++) {
            String[] s ;
            Scanner sc1 = new Scanner(System.in);
            String str = sc1.nextLine();
            if(str == null || Objects.equals(str, "")) {
                System.out.println(0);
                continue;
            }
            s = str.split(" ");
            Map<String,String> word = new HashMap<>();
            for (String str1 :s) {
                word.put(str1,"true");
            }
            System.out.println(word.size());
        }
    }
}

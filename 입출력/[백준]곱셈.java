import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        //char형 '1'은 아스키코드값인 49이다.
        //charAt(int i) - '0'을 통해 char형 문자를 int형으로 변환시킬 수 있다.
        System.out.println(a*(b.charAt(2)-'0'));
        System.out.println(a*(b.charAt(1)-'0'));
        System.out.println(a*(b.charAt(0)-'0'));
        System.out.println(a*Integer.parseInt(b));
    }
}

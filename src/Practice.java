import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n값 입력받기
        String sNum = sc.next(); //입력받은 숫자를 sNum에 저장
        char[] cNum = sNum.toCharArray(); //sNum을 다시 char[]형 변수 cNum에 변환하여 저장
        int sum = 0; //sum 선언

        for(int i=0; i<cNum.length; i++){ //배열의 각 자릿값을 정수형으로 변환하며 sum에 더하여 누적하기
            sum += cNum[i] - '0'; //cNum[i]를 int형으로 변환하면서 sum에 더하여 누적
            //아스키 코드에서 문자 '0'의 아스키 코드를 빼주면 원하는 숫자를 얻을 수 있다.
        }

        System.out.println(sum);
    }
}

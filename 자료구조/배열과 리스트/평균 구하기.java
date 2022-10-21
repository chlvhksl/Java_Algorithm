import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //과목 수 입력받기
        int[] a = new int[n]; //길이가 n인 배열 선언

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt(); //각 점수 저장하기
        }
        int sum = 0;
        int max = 0;
        for(int i=0; i<n;i++){
            if(a[i] > max){ //최고점 구하기
                max = a[i];
            }
            sum += a[i];//총점 구하기
        }

        System.out.println(sum * 100.0 / max / n); //형 변환위해 100대신 100.0으로
    }

}

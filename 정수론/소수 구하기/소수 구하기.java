import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); //시작 수
        int n = Integer.parseInt(st.nextToken()); //종료 수
        int[] arr = new int[n+1]; //소수 배열

        for(int i=2; i<=n; i++){
            arr[i] = i; //각각의 인덱스 값으로 초기화하기
        }

        for(int i=2; i<Math.sqrt(n); i++){ //n의 제곱근까지 반복하기
            if(arr[i] == 0){ //소수가 아니면 넘어감
                continue;
            }
            for(int j=i+i; j<=n; j=j+i){ //소수의 배수 값을 n까지 반복하기(배수 지우기)
                arr[j] = 0; //이 수가 소수가 아니라는 것을 표시하기
            }
        }

        for(int i=m; i<=n; i++){ //m부터 n까지
            if(arr[i] != 0){ //arr배열에서 소수인 값 출력하기
                System.out.println(arr[i]);
            }
        }
    }
}

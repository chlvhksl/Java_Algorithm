import java.io.*;
import java.util.StringTokenizer;

public class Practice {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken()); //데이터 개수
        int quizNo = Integer.parseInt(st.nextToken()); //질의 개수
        int[] S = new int[suNo +1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=suNo; i++){ //숫자 개수만큼 반복
            S[i] = S[i-1] + Integer.parseInt(st.nextToken()); //합 배열 생성
        }

        for(int q=0; q<quizNo; q++){ //질의 개수만큼 반복
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()); //질의 범위 받기
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i-1]); //구간 합 출력
        }

    }

}

import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0; //정답 변수
        String example = st.nextToken();
        String[] arr = example.split("-"); //들어온 데이터를 "-"기호를 기준으로 split() 수행하기
        for(int i=0; i<arr.length; i++){ //나눠진 데이터 개수만큼 반복하기
            int temp = mySum(arr[i]); //mySum메소드 실행하기
            if(i==0){ //첫번째 인덱스 값만 더함
                answer += temp;
            }else{ //뒷부분 부터는 mySum에서 더한 값을 뺌
                answer -= temp;
            }
        }
        System.out.println(answer);
    }

    static int mySum(String a){ //현재 String에 있는 수를 모두 더하는 함수
        int sum = 0;
        String[] temp = a.split("[+]"); //현재 들어온 String값을 "+"기호 기준으로 split() 수행하기
        for (int i=0; i<temp.length; i++){ //나눠진 데이터 개수만큼 반복하기
            sum += Integer.parseInt(temp[i]); //String값을 Integer형으로 변환해 리턴값에 더하기
        }
        return sum;
    }
}

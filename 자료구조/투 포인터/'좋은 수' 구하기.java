import java.io.*; 
import java.util.*;

public class Practice {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int num = Integer.parseInt(st.nextToken()); //배열의 데이터 개수
       int array[] = new int[num];
       int result = 0; //좋은 수
       st = new StringTokenizer(br.readLine());
       for(int i=0; i<num; i++){
           array[i] = Integer.parseInt(st.nextToken()); //array배열에 데이터 저장
       }

       Arrays.sort(array); //array배열 정렬

       for(int k=0; k<num; k++){
           int i = 0; //i포인터
           int j = num-1; //j포인터
           while(i < j){
               if(array[i] + array[j] == array[k]){ //array[k] : 찾고자 하는 값 | 두 포인터의 합이 찾고하는 값과 같을 때
                   if(i != k && j != k){ //두 포인터가 k가 아닐 때
                       result++; //결괏 값 반영
                       break; // while문 종료
                   }else if(i == k){ // 포인터 i가 k일 때
                       i++; // i 증가
                   }else if(j == k){ // 포인터 j가 k일 때
                       j++; // j 증가
                   }
               }else if(array[i] + array[j] < array[k]){ //두 포인터의 합이 찾고하는 값보다 작을 때
                   i++;
               }else{ // 두 포인터의 합이 찾고하는 값보다 클 때
                   j--;
               }
           }
       }
       System.out.println(result);
       br.close();
    }
}

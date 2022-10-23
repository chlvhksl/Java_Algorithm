import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //정렬할 수 개수
        int[] array = new int[n]; //정렬할 배열 선언하기
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken()); //array배열 저장하기
        }
        Arrays.sort(array); //array배열 정렬하기

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //탐색할 숫자의 개수

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            boolean find = false; //찾음 판단 
            int target = Integer.parseInt(st.nextToken()); //찾아야 하는 수
            //이진 탐색 시작
            int start = 0; //시작 인덱스
            int end = array.length-1; //종료 인덱스
            while (start<=end){
                int mid = array[start+end/2]; //중간 인덱스
                if(mid > target){
                    end = mid - 1; //종료 인덱스 = 중간 인덱스 - 1
                }else if(mid < target){
                    start = mid + 1; //시작 인덱스 = 중간 인덱스 + 1
                }else{
                    find = true; //찾았으므로
                    break; //반복문 종료하기
                }
            }
            if(find){ //찾았으면
                System.out.println(1); //1출력
            }else{ //못 찾았으면
                System.out.println(0); //0출력
            }
        }
    }
}

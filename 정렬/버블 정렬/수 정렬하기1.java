import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()); //정렬할 수 개수
        int[] array = new int[num]; //정렬할 배열 선언

        for(int i=0; i<num; i++){ //배열 데이터 입력
            st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(array); sort()함수를 사용한 오름차순 정렬
//        Arrays.sort(array, Comparator.reverseOrder()); 내림차순 정렬

        for(int i=0; i<num-1; i++){
            for(int j=0; j<num-1-i; j++){
                if(array[j] > array[j+1]) { //현재 array배열의 값보다 1칸 오른쪽 배열의 값이 더 작으면 두 수 바꾸기
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
        for (int i=0; i<num; i++){ //array배열 출력
            System.out.println(array[i]);
        }
    }
}

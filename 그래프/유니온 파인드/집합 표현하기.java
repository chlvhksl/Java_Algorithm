import java.io.*;
import java.util.*;

public class Practice {
    public static int[] parent; //대표 노드 저장 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //원소 개수
        int m = Integer.parseInt(st.nextToken()); //질의 개수

        parent = new int[n+1]; //수열 배열 채우기
        for (int i=0;i<=n;i++){
            parent[i] = i; //대표 노드를 자기 자신으로 초기화하기
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(question==0){ //if(0이면)집합 합치기 -> union연산
                union(a, b);
            }else{ //같은 집합 원소인지 확인하고 결괏값 출력하기
                if(checkSame(a, b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    //union 연산 : 대표 노드끼리 연결하기
    static void union(int a, int b){
        a = find(a); //a와 b의 대표 노드 찾기
        b = find(b);
        if(a!=b){ //두 원소의 대표 노드끼리 연결하기
            parent[b] = a;
        }
    }
    
    //find 연산
    static int find(int a){
        if(a==parent[a]){ //a가 대표 노드면 리턴
            return a;
        }else{ //아니면 a의 대표값을 find(parent[a]) 값으로 저장 -> 재귀 함수 형태 -> 경로 압축 부분
            return parent[a] = find(parent[a]);
        }
    }

    //checkSame -> 두 원소가 같은 집합인지 학인
    static boolean checkSame(int a, int b){
        a = find(a); //a와 b의 대표 노드 찾기
        b = find(b);
        if(a == b){ //두 대표 노드가 같으면 true return
            return true;
        } //아니면 false return
        return false;
    }
}

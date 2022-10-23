import java.io.*;
import java.util.*;

public class Practice {
    static ArrayList<Integer>[] array;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m = Integer.parseInt(st.nextToken()); //에지 개수
        array = new ArrayList[n+1]; //그래프 데이터 저장 인접 리스트
        visited = new boolean[n+1]; //방문 기록 저장 배열

        for(int i=1; i<n+1; i++){
            array[i] = new ArrayList<Integer>(); //array인접 리스트의 각 ArrayList 초기화 하기
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()); //array인접 리스트에 그래프 데이터 저장하기
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            array[s].add(e);
            array[e].add(s);
        }
        int count = 0;
        for(int i=1; i<n+1; i++){
            if(!visited[i]){ //방문하지 않은 노드가 있다면
                count++; //연결 요소 개수++
                DFS(i); //DFS실행하기
            }
        }
        System.out.println(count);
    }
    static void DFS(int v){
        if(visited[v]){ //현재 노드 == 방문노드면 return
            return;
        }
        visited[v] = true; //visited 배열에 현재 노드 방문 기록하기
        for(int i : array[v]){
            if(visited[i] == false){ //현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS실행하기(재귀 함수 형태)
                DFS(i);
            }
        }
    }
}

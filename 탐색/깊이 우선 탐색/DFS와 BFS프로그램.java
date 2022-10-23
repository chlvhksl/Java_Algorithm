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
        int start = Integer.parseInt(st.nextToken()); //시작점

        array = new ArrayList[n+1]; //그래프 데이터 저장 인접 리스트

        for(int i=1; i<=n; i++){
            array[i] = new ArrayList<Integer>(); //array인접 리스트의 각 ArrayList 초기화 하기
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()); //array인접 리스트에 그래프 데이터 저장하기
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            array[s].add(e);
            array[e].add(s);
        }

        //방문할 수 있는 노드가 여러 개일 경우에는 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for(int i=1; i<=n; i++){
            Collections.sort(array[i]); //각 노드와 관련되 에지를 정렬하기
        }
        visited = new boolean[n+1]; //방문 배열 초기화하기
        DFS(start); //DFS실행하기
        System.out.println();
        visited = new boolean[n+1]; //방문 배열 초기화하기
        BFS(start); //BFS실행하기
        System.out.println();
    }

    public static void DFS(int node){ //DFS구현하기
        System.out.print(node + " "); //현재 노드 출력하기
        visited[node] = true; //visited배열에 현재 노드 방문 기록하기
        for(int i : array[node]){ //현재 노드의 연결 노드 중
            if(!visited[i]){ //방문하지 않은 노드로
                DFS(i); //DFS실행하기(재귀 함수 형태)
            }
        }
    }

    public static void BFS(int node){ //BFS구현하기
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(node); //큐 자료구오제 시작 노드 삽입하기(add연산)
        visited[node] = true; //visited배열에 현재 노드 방문 기록하기

        while (!queue.isEmpty()){ //큐가 비어있을 때까지
            int now_node = queue.poll(); //큐에서 노드 데이터를 가져오기(poll연산)
            System.out.print(now_node+" "); //가져온 노드 출력하기
            for(int i : array[now_node]){ //현재 노드의 연결 노드 중
                if (!visited[i]){ //미방문 노드를
                    queue.add(i); //큐에 삽입(add연산)하고
                    visited[i] = true; //방문 배열에 기록하기
                }
            }
        }
    }
}

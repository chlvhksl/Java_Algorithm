import java.util.*;

public class BFS {
    static int n,m,v;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //정점의 개수
        m = sc.nextInt(); //간선의 개수
        v = sc.nextInt(); //탐색을 시작할 정점의 번호

        visited = new boolean[n+1]; //방문 여부를 검사할 배열
        adjList = new ArrayList[n+1]; //인접 리스트

        for(int i=0; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }

        //두 정점 사이에 여러 개의 간선이 있을 수 있다.
        //입력으로 주어지는 간선은 양방향이다.
        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        //번호가 작은 것을 방문하기 위해 오름차순 정렬
        for(int i=1; i<=n; i++){
            Collections.sort(adjList[i]);
        }

        bfs(v);
    }

    static void bfs(int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true; //현재 노드 방문 기록
        queue.add(v); //큐 자료구조에 시작 노드 삽입

        while(!queue.isEmpty()){ //큐가 비어 있을 때까지
            v = queue.poll(); //큐에서 노드 데이터 가져오기
            System.out.print(v+" "); //가져온 노드 출력
            for(int i : adjList[v]){ //현재 노드의 연결 노드 중
                if(!visited[i]){
                    queue.add(i); //미방문 노드를 큐에 삽입하고
                    visited[i] = true; //방문 배열에 기록하기
                }
            }
        }
    }
}

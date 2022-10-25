import java.io.*;
import java.util.*;

public class Dijkstra {
    static int V, E, start; //(노드 개수, 에지 개수, 출발 노드)
    static int[] dist; //start 노드 부터 end 노드 까지의 최소거리를 저장할 배열
    static boolean[] visited; //방문 여부 배열
    static ArrayList<Node> graph[]; //그래프
    static PriorityQueue<Node> q = new PriorityQueue<Node>(); //우선순위 큐

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        visited = new boolean[V+1];
        graph = new ArrayList[V+1];

        //노드의 번호가 1번부터 시작한다.
        for(int i=1; i<=V; i++){
            //그래프 정보를 저장하는 인접 리스트 초기화한다.
            graph[i] = new ArrayList<Node>(); //그래프 정보를 저장하는 인접 리스트 초기화한다.
        }
        //최소 거리 정보를 담을 배열을 초기화 한다.
        for(int i=0; i<=V; i++){
            //출발 지점 외 나머지 지점까지의 최소 비용은 최대로 지정해둔다.
            dist[i] = Integer.MAX_VALUE;
        }
        //그래프에 값을 넣는다.
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        //다익스트라 알고리즘 수행하기
        //출발 노드는 우선순위 큐에 넣고 시작한다.
        q.add(new Node(start, 0));
        //출발 지점의 비용은 0으로 시작한다.
        dist[start] = 0;
        //큐가 빌 때까지
        while (!q.isEmpty()){
            Node now  = q.poll();
            int nowIdx = now.idx;
            //현재 선택된 노드가 방문되 적이 있는지 확인한다.
            //이미 방문한 적 있는 노드는 다시 큐에 넣지 않는다.
            if(visited[nowIdx]){ 
                continue;
            }
            //현재 노드를 방문 노드로 업데이트한다.
            visited[nowIdx] = true;
            //현재 선택 노드의 에지 개수만큼 반복하낟.
            for(int i=0; i<graph[nowIdx].size(); i++){
                Node nxtNode = graph[nowIdx].get(i);
                int next = nxtNode.idx;
                int value = nxtNode.cost;
                //타깃 노드 방문 전 && 현재 선택 노드 최단 거리 + 비용 < 타깃 노드의 최단 거리 (최소 거리로 업데이트하기)
                if(dist[next] > dist[nowIdx] + value){
                    //타깃 노드의 최단 거리 업데이트하기
                    dist[next] = value + dist[nowIdx];
                    //우선순위 큐에 타깃 노드 추가하기
                    q.add(new Node(next, dist[next]));
                }
            }
        }
        //완성된 거리 배열을 탐색해 출력하기
        for(int i=1; i<=V; i++){
            if(visited[i]){
                System.out.println(dist[i]);
            }else{
                System.out.println("INF");
            }
        }
    }

    //비용이 있는 그래프를 담기 위한 클래스 별도 구현하기
    static class Node implements Comparable<Node>{
        int idx, cost; //(가르키는 토드, 비용)
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        //우선순위 큐 정렬 기준을 위해 compareTo 함수 구현하기
        @Override
        public int compareTo(Node n) {
            if(this.cost > n.cost){
                return -1;
            }
            return 1;
        }
    }
}

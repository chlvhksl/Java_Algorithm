public class DFS {
    //방문 확인 배열 선언(노드개수 + 1)
    static boolean[] visited = new boolean[9];
    //노드 연결 그래프 배열 선언
    //인덱스가 각각의 노드번호가 될 수 있게 0번 인덱스는 아무것도 없는 상태이다.
    static int[][] graph = {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
    public static void main(String[] args) {
        int start = 1; //시작 노드
        dfs(start);
    }

    //dfs알고리즘 실행
    static void dfs(int nodeIdx){
        //현재 노드 방문 처리
        visited[nodeIdx] = true;
        //방문 노드 출력
        System.out.print(nodeIdx + " ");
        //인접 노드 탐색
        for(int node : graph[nodeIdx]){
            //인접한 노드가 방문한 적이 없다면 DFS 수행
            if(!visited[node]){
                dfs(node);
            }
        }
    }
}

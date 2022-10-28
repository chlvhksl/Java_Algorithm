import java.util.Stack;

public class DFS {
    //방문 확인 배열 선언(노드개수 + 1)
    static boolean[] visited = new boolean[9];
    //노드 연결 그래프 배열 선언
    //인덱스가 각각의 노드번호가 될 수 있게 0번 인덱스는 아무것도 없는 상태이다.
    static int[][] graph = {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
    //DFS 사용할 스택
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        //시작 노드를 스택에 넣어준다.
        stack.push(1);

        //스택이 비어있지 않으면 계속 반복
        while(!stack.isEmpty()){
            //스택에서 하나를 꺼낸다.
            int nodeIdx = stack.pop();
            //방문 처리
            visited[nodeIdx] = true;
            //방문 노드 출력
            System.out.print(nodeIdx + " ");
            //꺼낸 노드와 인접한 노드 찾기
            for(int node : graph[nodeIdx]){
                //인접한 노드를 방문하지 않은 경우 스택에 넣고 방문 처리
                if(!visited[node]){
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
    }
}

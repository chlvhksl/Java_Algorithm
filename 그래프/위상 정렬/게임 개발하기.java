import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //건물의 개수
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); //인접 리스트
        for (int i=0; i<=n; i++){ //건물의 개수만큼 인접 리스트 초기화하기
            arr.add(new ArrayList<>());
        }

        int[] indegree = new int[n+1]; //진입 차수 배열
        int[] selfBuild = new int[n+1]; //자기 자신을 짓는 데 걸리는 시간
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (true){
                int preTemp = Integer.parseInt(st.nextToken());
                if(preTemp == -1){
                    break;
                }
                arr.get(preTemp).add(i);
                indegree[i]++;
            }
        }

        //위상 정렬 수행하기
        Queue<Integer> queue = new LinkedList<>(); //큐 생성하기
        for (int i=1; i<=n; i++){
            if(indegree[i] == 0){ //진입 차수 배열의 값이 0인 건물(노드)를 큐에 삽입하기
                queue.offer(i);
            }
        }

        int[] result = new int[n+1];
        while (!queue.isEmpty()){ //큐가 빌 때까지
            int now = queue.poll(); //현재 노드 = 큐에서 데이터 poll
            for (int next : arr.get(now)){ //현재 노드에서 갈 수 있는 노드의 개수
                indegree[next]--; //타깃 노드 진입 차수 배열--
                //시간 업데이트 하기
                result[next] = Math.max(result[next], result[now] + selfBuild[now]); //결과 노드 = Math.max(현재 저장된 값, 현재 출발 노드 + 비용)
                if(indegree[next] == 0){ //타깃 노드의 진입 차수가 0이면
                    queue.offer(next); //우선순위 큐에 타깃 노드 추가하기
                }
            }
        }

        for (int i=1; i<=n; i++){ //위상 정렬 결과 출력하기
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}

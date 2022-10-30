import java.util.*;

class Solution {
    //1. 4방 탐색을 위한 상하좌우(dx, dy) 배열 생성
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    //2. 방문 확인 배열
    static int [][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length]; 
        //3 bfs 탐색
        bfs(maps);
        //도착지 값을 넣어주기
        answer = visited[maps.length-1][maps[0].length-1];
        //갈 수 없다면 -1 리턴
        return answer != 0?answer : -1;
    }
    
    public void bfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        //4. 시작 위치 방문 체크
        visited[0][0] = 1; 
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            //4방 탐색
            for(int i=0; i<4; i++){
                //이동했을 때 위치
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //5. 범위 벗어나는지 체크
                //방문했는지 체크
                //갈 수 있는지 체크
                if(nx >= 0 && nx < maps.length 
                   && ny >= 0 && ny < maps[0].length
                   && visited[nx][ny] == 0 && maps[nx][ny] == 1){
                    //방문했다고 체크해주고 해당 위치까지 방문한 수 +1을 넣어준다.
                    visited[nx][ny] = visited[x][y] + 1;
                    //큐에 넣기
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}

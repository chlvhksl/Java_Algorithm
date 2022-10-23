import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Practice {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // 출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter사용
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int num = Integer.parseInt(st.nextToken());
       int l = Integer.parseInt(st.nextToken());
       st = new StringTokenizer(br.readLine());
       Deque<Node> mydeque = new LinkedList<>();
       for(int i=0; i<num; i++){
           int now = Integer.parseInt(st.nextToken());
           while (!mydeque.isEmpty() && mydeque.getLast().value > now){
               mydeque.removeLast();
           }
           mydeque.addLast(new Node(now, i));
           if(mydeque.getFirst().index <= i - l){
               mydeque.removeFirst();
           }
           bw.write(mydeque.getFirst().value+" ");
       }
       bw.flush();
       bw.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}

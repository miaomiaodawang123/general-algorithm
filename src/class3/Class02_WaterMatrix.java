package class3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Class02_WaterMatrix {

    public static int needWater(int[][] arr){
        if (arr == null || arr.length < 1 || arr[0].length < 1){
            return 0;
        }
        int n = arr.length;
        int m = arr[0].length;
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        //将最外圈的数据存入小根堆，弹出的值就是整圈最薄弱的点
        boolean[][] isEnter = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            queue.add(new Node(arr[0][i],0,i));
            isEnter[0][i] = true;
        }
        for (int i = 1; i < n; i++) {
            queue.add(new Node(arr[i][m - 1],i,m - 1));
            isEnter[i][m - 1] = true;
        }
        for (int i = 0; i < m - 1; i++) {
            queue.add(new Node(arr[n - 1][i],n - 1,i));
            isEnter[n - 1][i] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            queue.add(new Node(arr[i][0],i,0));
            isEnter[i][0] = true;
        }
        int water = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            max = Math.max(max,poll.val);
            if (poll.i - 1 >= 0 && !isEnter[poll.i - 1][poll.j]){
                water += max - arr[poll.i - 1][poll.j];
                isEnter[poll.i - 1][poll.j] = true;
                queue.add(new Node(arr[poll.i - 1][poll.j], poll.i - 1, poll.j));
            }
            if (poll.i + 1 < n && !isEnter[poll.i + 1][poll.j]){
                water += max - arr[poll.i + 1][poll.j];
                isEnter[poll.i + 1][poll.j] = true;
                queue.add(new Node(arr[poll.i + 1][poll.j], poll.i + 1, poll.j));
            }
            if (poll.j - 1 >= 0 && !isEnter[poll.i][poll.j - 1]){
                water += max - arr[poll.i][poll.j - 1];
                isEnter[poll.i][poll.j - 1] = true;
                queue.add(new Node(arr[poll.i][poll.j - 1], poll.i, poll.j - 1));
            }
            if (poll.j + 1 < m && !isEnter[poll.i][poll.j + 1]){
                water += max - arr[poll.i][poll.j + 1];
                isEnter[poll.i][poll.j + 1] = true;
                queue.add(new Node(arr[poll.i][poll.j + 1], poll.i, poll.j + 1));
            }
        }
        return water;
    }


    public static class Node{
        public int val;
        public int i;
        public int j;

        public Node(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public static class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.val - o2.val;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {3,2,3,4,5},
                {3,1,2,1,4},
                {5,2,1,0,3},
                {9,5,2,3,3}
        };
        int water = needWater(arr);
        System.out.println(water);
    }
}

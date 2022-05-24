package class2;

public class Class02_TreePath {

    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 1.路径必须是头节点出发，到叶节点为止，返回最大路径和
     * @param head
     * @return
     */
    public static int headToDown(Node head){
        if (head == null) return 0;
        return process1(head,0);
    }
    //cur 当前来到节点 pre 之前节点最大路径和
    public static int process1(Node cur, int pre){
        //base case: 叶子节点
        if (cur.left == null && cur.right == null){
            return pre + cur.val;
        }
        int max = Integer.MIN_VALUE;
        if (cur.left != null){
            max = Math.max(process1(cur.left, pre + cur.val), max);
        }
        if (cur.right != null){
            max = Math.max(process1(cur.right, pre + cur.val), max);
        }
        return max;
    }

    /**
     * 2.路径可以从任何节点出发，但必须往下走到任何节点，返回最大路径和
     * 采用二叉树递归套路，讨论x节点的最大路径和
     * @param head
     * @return
     */
    public static int curToDown(Node head){
        if (head == null) return 0;
        return process2(head).allPath;
    }
    public static Info process2(Node x){
        if (x == null){
            return null;
        }
        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);
        //与x节点无关 p1 = x的左树的allPath p2 = x的右树的allPath
        //与x节点有关 p3 = x   p4 = x.val + x.left的headPath p5 = x.val + x.right的headPath
        int p1 = leftInfo == null ? Integer.MIN_VALUE : leftInfo.allPath;
        int p2 = rightInfo == null ? Integer.MIN_VALUE : rightInfo.allPath;

        int p3 = x.val;
        int p4 = leftInfo == null ? Integer.MIN_VALUE : x.val + leftInfo.headPath;
        int p5 = rightInfo == null ? Integer.MIN_VALUE : x.val + rightInfo.headPath;

        int all = Math.max(Math.max(p1,p2),Math.max(Math.max(p3,p4),p5));
        int headPath = Math.max(Math.max(p3,p4),p5);
        return new Info(all,headPath);
    }
    public static class Info{
        //节点整棵树的最大路径和
        public int allPath;
        //节点包含头节点的最大路径和
        public int headPath;

        public Info(int allPath, int headPath) {
            this.allPath = allPath;
            this.headPath = headPath;
        }
    }

    /**
     * 3.路径可以从任何节点出发，到任何节点，返回最大路径和
     * 采用二叉树递归套路，讨论x节点的最大路径和
     * @param head
     * @return
     */
    public static int curToCur(Node head){
        if (head == null) return 0;
        return process3(head).allPath;
    }

    private static Info process3(Node x) {
        if (x == null){
            return null;
        }
        Info leftInfo = process3(x.left);
        Info rightInfo = process3(x.right);
        //与x节点无关 p1 = x的左树的allPath p2 = x的右树的allPath
        //与x节点有关 p3 = x   p4 = x.val + x.left的headPath p5 = x.val + x.right的headPath
        //与x节点有关 经过x节点 p6 = x.val + x.right的headPath +  x.left的headPath
        int p1 = leftInfo == null ? Integer.MIN_VALUE : leftInfo.allPath;
        int p2 = rightInfo == null ? Integer.MIN_VALUE : rightInfo.allPath;

        int p3 = x.val;
        int p4 = leftInfo == null ? Integer.MIN_VALUE : x.val + leftInfo.headPath;
        int p5 = rightInfo == null ? Integer.MIN_VALUE : x.val + rightInfo.headPath;
        int p6 = x.val + (leftInfo == null ? 0 : leftInfo.headPath)
                + (rightInfo == null ? 0 : rightInfo.headPath);
        int all = Math.max(Math.max(p1,p2),Math.max(Math.max(p3,p4),Math.max(p5,p6)));
        int headPath = Math.max(Math.max(p3,p4),Math.max(p5,p6));
        return new Info(all,headPath);
    }


    public static void main(String[] args) {
        Node head = new Node(-3);
        head.left = new Node(5);
        head.right = new Node(-5);
        head.left.left = new Node(3);
        head.left.right = new Node(-4);
        head.right.right = new Node(1);
        head.left.right.right = new Node(5);
        int i = headToDown(head);
        System.out.println(i);

        int i1 = curToDown(head);
        System.out.println(i1);

        int i2 = curToCur(head);
        System.out.println(i2);
    }
}

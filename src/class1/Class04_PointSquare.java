package class1;

//本质上就是要R全在G的左边或者全是R或者全是G
public class Class04_PointSquare {

    public static int minPoint(String s) {
        if (s == null || s.equals("")) return 0;
        char[] str = s.toCharArray();
        int n = str.length;
        //辅助数组，right[i] 表示i ~ n-1位置有几个R
        int[] right = new int[n];
        right[n - 1] = str[n - 1] == 'R' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = (str[i] == 'R' ? 1 : 0) + right[i + 1];
        }
        int leftG = 0;
        // 开头边界
        int ans = right[0];
        for (int i = 0; i < n - 1; i++) {
            leftG += str[i] == 'G' ? 1 : 0;
            ans = Math.min(ans, leftG + right[i + 1]);
        }
        // 末尾边界
        ans = Math.min(ans, leftG + (str[n - 1] == 'G' ? 1 : 0));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minPoint("RGRGR"));
        System.out.println(minPoint("RRRGRGRRGGGRR"));
        System.out.println(minPoint("GGGGR"));
        System.out.println(minPoint("RRRRRGG"));
        System.out.println(minPoint("RRRRRG"));
        System.out.println(minPoint("RRRRR"));
        System.out.println(minPoint("GGGGG"));

    }
}

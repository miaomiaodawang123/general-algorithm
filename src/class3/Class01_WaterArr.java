package class3;

public class Class01_WaterArr {

    public static int needWater(int[] arr){
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int n = arr.length;
        //左边的最大值
        int leftMax = arr[0];
        //右边的最大值
        int rightMax = arr[n - 1];
        int L = 1;
        int R = n - 2;
        int water = 0;
        while (L <= R){
            if (leftMax <= rightMax){
                water += Math.max(0,leftMax - arr[L]);
                leftMax = Math.max(arr[L++],leftMax);
            }else {
                water += Math.max(0,rightMax - arr[R]);
                rightMax = Math.max(arr[R--], rightMax);
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,3,2};
        int water = needWater(arr);
        System.out.println(water);
    }
}

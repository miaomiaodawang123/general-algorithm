package class2;

public class Class05_MaxArrMaxDValue {

    /**
     * 贪心，采用获取数组最大值的方式获取减法中第一个项，
     * 那么全局最大值一定是划分在左侧或右侧，那么另一侧的最小的最大值要么就是第一个或者最后一个
     * @param arr
     * @return
     */
    public static int maxDValue(int[] arr){
        if (arr == null || arr.length < 1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max - Math.min(arr[0],arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {4,20,-3,68,10,9};
        int i = maxDValue(arr);
        System.out.println(i);
    }
}

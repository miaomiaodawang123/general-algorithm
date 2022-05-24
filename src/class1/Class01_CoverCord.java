package class1;

public class Class01_CoverCord {

    public static int getMax(int[] arr, int K){
        if (arr == null || arr.length < 1 || K < 0){
            return 0;
        }
        int N = arr.length;
        //滑动窗口左边界，绳子覆盖的范围包含左边界
        int left = 0;
        //滑动窗口右边界，绳子覆盖的范围在右边界的上一个，绳子覆盖区间 [left, right)
        int right = 0;
        int max = 0;
        while (left < N){
            while (right < N && arr[right] - arr[left] <= K){
                right++;
            }
            max = Math.max(max, right - left);
            left ++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,8,9,14,17};
        int k = 8;
        System.out.println(getMax(arr,k));
    }
}

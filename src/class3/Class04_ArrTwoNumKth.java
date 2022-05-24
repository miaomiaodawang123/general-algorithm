package class3;

import java.util.Arrays;

public class Class04_ArrTwoNumKth {
    public static void main(String[] args) {
        int[] arr = {3,1,2,9,6,0,4};
        //遍历输出第1。。。数组长度小的数值对
        for (int i = 1; i <= arr.length * arr.length; i++) {
            System.out.println(Arrays.toString(getNum(arr, i)));
        }


    }


    /**
     * 主方法
     * 第一个数在排好序的数组中的位置(k - 1)/N
     * 第二个数在排好序的数组中的位置：（k - (N * 小于第一个数的个数)  - 1 ）/ 等于第一个数的个数
     * @param arr
     * @param k
     * @return
     */
    public static int[] getNum(int[] arr, int k) {
        int N = arr.length;

        int firstK = (k - 1) / N;
        int one = getKth(arr, firstK);
        int lessOne = 0;
        int midOne = 0;
        for (int i : arr) {
            if (i == one) midOne++;
            if (i < one) lessOne++;
        }
        int restK = (k - (N * lessOne) - 1) / midOne;
        return new int[]{one,getKth(arr,restK)};
    }

    /**
     * 找到数组第K小的数 k范围：[0,arr.length - 1]
     *
     * @param arr
     * @param k
     * @return
     */
    public static int getKth(int[] arr, int k) {
        int L = 0;
        int R = arr.length - 1;
        while (L < R) {
            int pri = arr[L + (int) (Math.random() * (R - L + 1))];
            int[] partition = partition(L,R, arr, pri);
            if (partition[0] <= k && k <= partition[1]) {
                return pri;
            } else if (k < partition[0]) {
                R = partition[0] - 1;
            } else {
                L = partition[1] + 1;
            }
        }
        return arr[L];
    }

    /**
     * 小于flag的放左边 大于flag的放右边 等于的放中间
     * @param L
     * @param R
     * @param arr
     * @param flag
     * @return 返回排好序数组中等于flag的起始和结束位置
     */
    public static int[] partition(int L, int R, int[] arr, int flag) {
        if (L == R){
            return new int[]{L,R};
        }
        int less = L - 1;
        int more = R + 1;
        int index = L;
        while (index < more) {
            if (arr[index] < flag) {
                swap(arr, index++, ++less);
            } else if (arr[index] > flag) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}

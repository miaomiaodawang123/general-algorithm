package class3;

import java.util.ArrayList;

public class Class03_ArrToAim {
    /**
     * 1).返回累加和为aim的，所有不同二元组
     * 双指针
     * @param arr
     * @return
     */
    public static ArrayList<ArrayList<Integer>> getTwo(int[] arr, int aim) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr == null || arr.length < 1) {
            return ans;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < aim) {
                left++;
            } else if (arr[left] + arr[right] > aim) {
                right--;
            } else {
                if (left == 0 || arr[left] != arr[left - 1]) {//避免重复值
                    ArrayList<Integer> num = new ArrayList<>();
                    num.add(arr[left]);
                    num.add(arr[right]);
                    ans.add(num);
                }
                left++;
            }
        }
        return ans;
    }

    /**
     * 2).返回累加和为aim的，所有不同三元组
     * 数组每个值当作第一个数据，其余两个用双指针
     * @param arr
     * @return
     */
    public static ArrayList<ArrayList<Integer>> getThree(int[] arr, int aim) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr == null || arr.length < 1) {
            return ans;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i] == arr[i - 1]){
                continue;
            }
            int left = i;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[left] + arr[right] < aim - arr[i]) {
                    left++;
                } else if (arr[left] + arr[right] > aim - arr[i]) {
                    right--;
                } else {
                    if (left == 0 || arr[left] != arr[left - 1]) {//避免重复值
                        ArrayList<Integer> num = new ArrayList<>();
                        num.add(arr[i]);
                        num.add(arr[left]);
                        num.add(arr[right]);
                        ans.add(num);
                    }
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,5,6,6,7,8,9,11};
        int aim = 12;
        ArrayList<ArrayList<Integer>> two = getTwo(arr, aim);
        for (int i = 0; i < two.size(); i++) {
            ArrayList<Integer> integers = two.get(i);
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println("-------");
        ArrayList<ArrayList<Integer>> three = getThree(arr, aim);
        for (int i = 0; i < three.size(); i++) {
            ArrayList<Integer> integers = three.get(i);
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }
}

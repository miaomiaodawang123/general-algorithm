package class2;

import java.util.Arrays;

public class Class01_MakeArr {
    public static int[] makeArr(int M){
        if (M <= 0){
            return new int[0];
        }
        if (M == 1){
            return new int[]{1};
        }
        int[] ans = new int[M];
        //分治 找到两种不同的数的生成方式，一半按照第一种，一半按照第二种


        int halfSize = (M + 1) / 2;
        int[] half = makeArr(halfSize);
        int index = 0;
        //一半用第i个奇数
        for (int i = 0; i < halfSize; i++) {
            ans[index ++] = half[i] * 2 - 1;
        }
        //一半用第i个偶数
        for (int i = 0; i < halfSize && index < M; i++) {
            ans[index ++] = half[i] * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = makeArr(10);
        System.out.println(Arrays.toString(ints));
    }
}

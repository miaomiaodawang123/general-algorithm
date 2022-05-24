package class2;

/**
 * 测试链接：https://leetcode.cn/problems/super-washing-machines
 */
public class Class03_SuperWashingMachines {
    public int findMinMoves(int[] machines){
        if (machines == null || machines.length < 1){
            return -1;
        }
        int N = machines.length;
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % N != 0){
            return -1;
        }
        int avg = sum / N;
        //数组来到i位置， i左边实际上的总数 - 理论上平均总和 > 0 i左侧有剩余的可以往i以及i右面挪
        //i右边边实际上的总数 - 理论上平均总和 > 0 i右侧有剩余的可以往i以及i左面挪
        //如果两边差值都是0就是不需要挪动
        int max = -1;
        int leftSum = 0;
        for (int i = 0; i < machines.length; i++) {
            int leftNeed = leftSum - i * avg;
            int rightNeed = (sum - leftSum - machines[i]) - avg * (N - i - 1);
            if (leftNeed < 0 && rightNeed < 0){//两边都缺，则从i位置往两边挪，不能同时挪
                max = Math.max(max, Math.abs(leftNeed) + Math.abs(rightNeed));
            }else {//两边不都缺，一定是一面需要i给，一面给i，可以同时进行，所有取最大值
                max = Math.max(max, Math.max(leftNeed,rightNeed));
            }
            leftSum += machines[i];
        }
        return max;
    }
}

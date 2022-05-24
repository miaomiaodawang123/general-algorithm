package class2;

public class Class03_MatrixFind {

    //从右上角开始找，小于要查找的数就往左找，大于要查找的数就往下找
    public static boolean find(int[][] matrix, int num){
        if (matrix == null || matrix.length < 1){
            return false;
        }
        int j = matrix[0].length - 1;
        int i = 0;
        while (j >= 0 && i < matrix.length){
           if (matrix[i][j] == num){
               return true;
           }else if (matrix[i][j] > num){
               j --;
           }else {
               i ++;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,9,12,15},
                {17,25,29,55,56,60},
                {66,78,79,90,95,99}
        };
        System.out.println(find(arr,1));
        System.out.println(find(arr,78));
        System.out.println(find(arr,15));
        System.out.println(find(arr,17));
        System.out.println(find(arr,56));
        System.out.println(find(arr,66));
        System.out.println(find(arr,99));
        System.out.println(find(arr,100908));





    }
}

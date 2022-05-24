package class1;

public class Class05_SquareBorder {

    public static int maxBorder(int[][] matrix){
        if (matrix == null || matrix.length < 1){
            return 0;
        }
        int n = matrix.length;
        //辅助数组 helpRight[i][j] i行j列自己以及右侧有几个1
        int[][] helpRight = new int[n][n];
        //辅助数组 helpDown[i][j] i行j列自己以及下侧有几个1
        int[][] helpDown = new int[n][n];
        for (int i = 0; i < n; i++) {
            helpRight[i][n - 1] = matrix[i][n - 1];
            for (int j = n - 2; j >= 0 ; j--) {
                helpRight[i][j] = matrix[i][j] == 0 ? 0 : 1 + helpRight[i][j + 1];
            }
        }
        for (int j = 0; j < n; j++) {
            helpDown[n - 1][j] = matrix[n - 1][j];
            for (int i = n - 2; i >= 0; i--) {
                helpDown[i][j] = matrix[i][j] == 0 ? 0 : 1 + helpDown[i + 1][j];
            }
        }
        //遍历整个矩阵，以i行j列为小正方形的左上角，尝试不同的边长
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int bian = n - (Math.max(i,j)) - 1; bian > 0; bian--) {
                    //如果i行j列右边下边1的长度 >= 尝试的边长，就说明正方形上面和左边边长有效
                    //i + bian行j列右边，i行j + bian列下边的1的数量 >= 尝试边长，正方形全部边长有效
                    if (helpRight[i][j] >= bian &&
                    helpDown[i][j] >= bian &&
                    helpRight[i + bian][j] >= bian && helpDown[i][j + bian] >= bian){
                        ans = Math.max(ans, bian + 1);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1},
                {1,0,0,1,0,1,1,1},
                {1,0,0,1,0,1,1,1},
                {1,0,0,1,1,1,1,1},
                {1,0,1,1,1,1,1,1},
                {1,1,1,1,1,0,1,1},
                {1,1,1,1,1,0,1,1}
        };
        int i = maxBorder(arr);
        System.out.println(i);
    }
}

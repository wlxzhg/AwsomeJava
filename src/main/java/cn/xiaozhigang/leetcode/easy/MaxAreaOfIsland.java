package cn.xiaozhigang.leetcode.easy;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                int temp = dfs(grid,i,j);
                if(temp > max) max = temp;
            }
        return max;
    }

    public int dfs(int[][] grid,int i,int j) {
        if(grid[i][j] == 0) return 0;
        int sum = 1;
        grid[i][j] = 0;
        if(j - 1 >= 0)
            sum += dfs(grid,i,j - 1);
        if(j + 1 <= grid[0].length - 1)
            sum += dfs(grid,i,j + 1);
        if(i - 1 >= 0)
            sum += dfs(grid,i - 1,j);
        if(i + 1 <= grid.length - 1)
            sum += dfs(grid,i + 1,j);
        return sum;
    }

    public static void main(String[] args) {

    }

}

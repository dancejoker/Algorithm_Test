package com.wang.LeetCode;

/**
 * 题目给了我们一个 2d grid array， 让我们找到所有岛中区域最大的一个，
 * 返回区域值。0代表海洋，1代表陆地。陆地与陆地相连，只能是横向和纵向，不可以斜着。
 * 因为只能横向和纵向相连，所以每一个cell 只能是4个方
 * 向延伸，左 上 右 下。
 * Created by ddp on 2018/2/17.
 */
public class Solution_Max_Area_of_Island_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
        return max_area;
    }

    public int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            //已访问过就将其标记为0
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] gird = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int max = new Solution_Max_Area_of_Island_695().maxAreaOfIsland(gird);
        System.out.println(max);
    }
}

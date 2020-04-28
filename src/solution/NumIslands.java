package solution;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int row = grid.length;
        if (row <= 0) {
            return 0;
        }
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j);
                }

            }
        }
        return islandCount;

    }

    public void dfs(char[][] grid, int n, int m) {
        int row = grid.length;
        int col = grid[0].length;
        if (n < 0 || m < 0 || n >= row || m >= col || grid[n][m] == '0') {
            return;
        }
        grid[n][m] = '0';
        dfs(grid, n - 1, m);
        dfs(grid, n, m - 1);
        dfs(grid, n + 1, m);
        dfs(grid, n, m + 1);
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int islandCount = numIslands.numIslands(grid);
        System.out.println(islandCount);
    }
}

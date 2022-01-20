package src.java.problems.companies;

public class SmartNews {
    public static void main(String[] args) {

    }

    public int solution(int[][] A) {
        int rows = A.length;
        int col = A[0].length;

        int count =0;

        for(int i=0;i<rows; i++){
            for(int j=0;j<col;j++){
                if(A[i][j] != Integer.MIN_VALUE) {
                    count++;
                    int val = A[i][j];
                    dfs(A, i,j, val);
                }
            }
        }

        return count;
    }

    public void dfs(int [][]grid, int i, int j, int val){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != val) return;
        grid[i][j] = Integer.MIN_VALUE;
        dfs(grid, i + 1, j,val);
        dfs(grid, i - 1, j,val);
        dfs(grid, i, j + 1,val);
        dfs(grid, i, j - 1,val);
    }
}

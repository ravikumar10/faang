package src.java.problems;

public class P12 {
    public static void main(String[] args) {
        int [][] grid ={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int p=0;
        for(int i = 0; i<r;i++){
            for(int j=0; j<c;j++){
                if(grid[i][j] != 0) {
                    p += 4;
                    if (i > 0 && grid[i-1][j] == 1) p -= 2;
                    if (j > 0 && grid[i][j-1] == 1) p -= 2;
                }
            }
        }
        return p;
    }
}

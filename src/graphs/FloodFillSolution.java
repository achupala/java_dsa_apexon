package graphs;

public class FloodFillSolution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        if (oldColor == newColor) return image;

        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;

        if (image[r][c] != oldColor) return;

        image[r][c] = newColor;
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        FloodFillSolution sol = new FloodFillSolution();

        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int[][] result = sol.floodFill(image, 1, 1, 2);

        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}

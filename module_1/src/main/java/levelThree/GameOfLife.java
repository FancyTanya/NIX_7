package levelThree;

public class GameOfLife {

    public static void runGameOfLive() {
        int M = 10;
        int N = 10;
        System.out.println();
        System.out.println("Original generation");
        int[][] cells = new int[10][10];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {

                cells[i][j] = (int) (Math.random() * 2);
                if (j == 9) {
                    System.out.print("\n");
                }
                System.out.printf("%3d", cells[i][j]);
            }
        }
        nextGeneration(cells, M, N);
    }

    static void nextGeneration(int[][] cells, int M, int N) {
        int[][] future = new int[M][N];
        for (int i = 1; i < M - 1; i++) {
            for (int m = 1; m < N - 1; m++) {
                int aliveNeighbours = 0;
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        aliveNeighbours += cells[i + j][m + k];
                    }
                }
                aliveNeighbours -= cells[i][m];
                if (cells[i][m] == 1 && aliveNeighbours < 2) {
                    future[i][m] = 0;
                } else if (cells[i][m] == 1 && aliveNeighbours > 3) {
                    future[i][m] = 0;
                } else if (cells[i][m] == 0 && aliveNeighbours == 3) {
                    future[i][m] = 1;
                } else {
                    future[i][m] = cells[i][m];
                }
            }
        }
        System.out.println();
        System.out.println("Next generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 9) {
                    System.out.print("\n");
                }
                System.out.printf("%3d", future[i][j]);
            }
        }
    }
}


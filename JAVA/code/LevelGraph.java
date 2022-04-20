import java.util.Scanner;
 
public class LevelGraph {
    public static final long MOD = 1000000007;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        boolean[][] adj = new boolean[n][n];
        for (int a = 0; a < n; a++) {
            String line = in.next();
            for (int b = 0; b < n; b++) {
                adj[a][b] = line.charAt(b) == '1';
            }
        }
        int[] xs = new int[q];
        int[] froms = new int[q];
        int[] ys = new int[q];
        int[] tos = new int[q];
        for (int j = 0; j < q; j++) {
            xs[j] = in.nextInt() - 1;
            froms[j] = in.nextInt() - 1;
            ys[j] = in.nextInt() - 1;
            tos[j] = in.nextInt() - 1;
        }
        long[][][] dp = new long[k][n + q][n + q];
        for (int h = 0; h < k; h++) {
            if (h > 0) {
                for (int a = 0; a < n + q; a++) {
                    for (int b = 0; b < n + q; b++) {
                        dp[h][a][b] = dp[h - 1][a][b];
                    }
                }
            }
            for (int c = 0; c < n; c++) {
                long[] left = new long[n + q];
                left[c] = 1;
                for (int j = 0; j < q; j++) {
                    if (h == xs[j] && froms[j] == c) {
                        left[n + j] = 1;
                    }
                }
                if (h > 0) {
                    for (int a = 0; a < n + q; a++) {
                        for (int b = 0; b < n; b++) {
                            if (adj[b][c]) {
                                left[a] += dp[h - 1][a][b];
                                left[a] %= MOD;
                            }
                        }
                    }
                }
                long[] right = new long[n + q];
                right[c] = 1;
                for (int j = 0; j < q; j++) {
                    if (h == ys[j] & tos[j] == c) {
                        right[n + j] = 1;
                    }
                }
                if (h > 0) {
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < n + q; b++) {
                            if (adj[c][a]) {
                                right[b] += dp[h - 1][a][b];
                                right[b] %= MOD;
                            }
                        }
                    }
                }
                for (int a = 0; a < n + q; a++) {
                    for (int b = 0; b < n + q; b++) {
                        dp[h][a][b] += left[a] * right[b];
                        dp[h][a][b] %= MOD;
                    }
                }
            }
        }
        for (int j = 0; j < q; j++) {
            System.out.println(dp[k - 1][n + j][n + j]);
        }
    }
}
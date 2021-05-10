public class Queens {
    private int[][] queens;
    private int n;

    public Queens(int n) {
        if(n <= 3) {
            throw new IllegalArgumentException("N has to be bigger than 3");
        }
        this.n = n;
        queens = new int[n][n];
    }

    public int[][] calculate() {
        boolean isLooking = true;
        int[] table = new int[n];
        int k = 0;
        while (k >= 0 && isLooking) {
            table[k]++;
            if (table[k]-1 < n) {
                if (check(table, k)) {
                    if (k == n - 1) {
                        isLooking = false;
                    } else {
                        k++;
                    }
                }
            } else {
                table[k] = 0;
                k--;
            }
        }

        if (!isLooking) {
            for (int i = 0; i < n; i++) {
                queens[table[i]-1][i] = 1;
            }
        } else {
            System.out.println("No solution found!");
        }
        return queens;
    }

    private boolean check(int[] table, int k) {
        //decrease row index to compensate for elements in table
        int i = table[k]-1;
        //no need to check vertically as there is always only one queen in a column
        return checkHorizontal(table, i, k) && checkPrimaryDiagonal(table, i, k) && checkSecondaryDiagonal(table, i, k);
    }

    //check if there are other elements on the same line as the currently placed queen
    private boolean checkHorizontal(int[] table, int i, int j) {
        for (int index = 0; index < j; index++) {
            if (index != j)
                if (table[index]-1 == i)
                    return false;
        }
        return true;
    }

    //check if there are queens on the primary diagonal, starting from (except) the queen and to the left
    //as there are no queens placed on the right, no need to check there
    private boolean checkPrimaryDiagonal(int[] table, int i, int j) {
        while (i > 0 && j > 0) {
            i--;
            j--;
            if (table[j] == i+1)
                return false;
        }
        return true;
    }


    //check if there are queens on the secondary diagonal, starting from (except) the queen and to the left
    //as there are no queens placed on the right, no need to check there
    private boolean checkSecondaryDiagonal(int[] table, int i, int j) {
        while (i < n && j > 0) {
            i++;
            j--;
            if (table[j] == i+1)
                return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                output.append("+---");
                if (j == n - 1)
                    output.append("+\n");
            }

            for (int j = 0; j < n; j++) {

                output.append("| ").append(queens[i][j]).append(" ");
                if (j == n - 1)
                    output.append("|\n");
            }
            if (i == n - 1) {
                for (int j = 0; j < n; j++) {
                    output.append("+---");
                    if (j == n - 1)
                        output.append("+\n");
                }
            }
        }
        return output.toString();
    }
}

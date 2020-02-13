public class MyArray2DExplorer {

    public static void main(String[] args) {
        int array[][] = {{4, 1, 8, 5},
                {0, 2, 3, 4},
                {6, 6, 2, 2}};
        MyArray2DExplorer exp = new MyArray2DExplorer();

        System.out.println("Test evenRow: \n Row w/ odd, Expecting: false \n Actual: " + exp.evenRow(array, 0));
        System.out.println("Test evenRow: \n Row w/o odd, Expecting: true \n Actual: " + exp.evenRow(array, 2));

        System.out.println();

        System.out.println("Test oddColSum: \n Col w/ odd Sum, Expecting: true \n Actual: " + exp.oddColSum(array, 1));
        System.out.println("Test oddColSum: \n Col w/ even, Expecting: false \n Actual: " + exp.oddColSum(array, 0));

        System.out.println();


        System.out.print("Test minRow: \n Expecting: {0 2 3 4} \n Actual: {");
        int[] row = exp.minRow(array);
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i] + " ");
        }
        System.out.print("]");

    }

    //WRITE YOUR METHODS BELOW

    public boolean evenRow(int[][] mat, int row) {
        for (int n : mat[row]) {
            if (n % 2 != 0) return false;
        }
        return true;
    }

    //returns true if the sum of the numbers the given col is odd.
    public boolean oddColSum(int [][] nums, int col) {
        int sum = 0;
        for (int[] row : nums) {
            sum += row[col];
        }
        return sum % 2 != 0;
    }

    public int[] minRow(int[][] mat) {
        int min = mat[0][0];
        int minrowindex = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int n : mat[r]) {
                if (n < min) {
                    minrowindex = r;
                    min = n;
                }
            }
        }
        return mat[minrowindex];
    }
}
public class MyArray2DExplorer {

    public static void main(String[] args) {
        int array [][] = {  {4,1,8,5},
                {0,2,3,4},
                {6,6,2,2} };
        MyArray2DExplorer exp = new MyArray2DExplorer();

        System.out.println("Test evenRow: \n Row w/ odd, Expecting: false \n Actual: " + exp.evenRow(array,0));
        System.out.println("Test evenRow: \n Row w/o odd, Expecting: true \n Actual: " + exp.evenRow(array,2));

        System.out.println();

        System.out.println("Test oddColSum: \n Col w/ odd Sum, Expecting: true \n Actual: " + exp.oddColSum(array,1));
        System.out.println("Test oddColSum: \n Col w/ even, Expecting: false \n Actual: " + exp.oddColSum(array,0));

        System.out.println();


        System.out.print("Test minRow: \n Expecting: {0 2 3 4} \n Actual: {");
        int [] row = exp.minRowPractice(array);
        for(int i = 0; i < row.length; i++){
            System.out.print(row[i] + " ");
        }
        System.out.print("]");

        System.out.println();

        System.out.print("Test minRowAssignment: \n Expecting: 2 \n Actual: ");
        System.out.println(exp.minRowAssignment(array, 2));

        System.out.println();

        System.out.print("Test colMax: \n Expecting: {6 6 8 5} \n Actual: {");
        int [] colMaxs = exp.colMaxs(array);
        for(int i = 0; i < colMaxs.length; i++){
            System.out.print(colMaxs[i] + " ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("Test allRowSum: \n Expecting: {18 9 16} \n Actual: {");
        int [] sum = exp.allRowSums(array);
        for(int i = 0; i < sum.length; i++){
            System.out.print(sum[i] + " ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("Test averageCol: \n Expecting: {3.333333 3.0 4.333333 3.6666667} \n Actual: {");
        double [] avg = exp.averageCol(array);
        for(int i = 0; i < avg.length; i++){
            System.out.print(avg[i] + " ");
        }
        System.out.print("}");


        System.out.println();
        System.out.println();

        System.out.print("Test smallEven: \n Expecting: 0 \n Actual: ");
        System.out.println(exp.smallEven(array));

        System.out.println();
        System.out.println();

        System.out.print("Test biggestRow: \n Expecting: 0 \n Actual: ");
        System.out.println(exp.biggestRow(array));

        System.out.println();
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

    public int[] minRowPractice(int[][] mat) {
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
    public int minRowAssignment(int[][] nums, int row) {
        int min = nums[row][0];
        for (int n : nums[row]) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }
    public int[] colMaxs(int[][] matrix) {
        int[] end = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int maxN = matrix[0][i];
            for (int[] row : matrix) {
                if (row[i] > maxN) {
                    maxN = row[i];
                }
            }
            end[i] = maxN;
        }
        return end;
    }
    public int[] allRowSums(int[][] data) {
        int[] sums = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int sum = 0;
            for (int n : data[i]) {
                sum += n;
            }
            sums[i] = sum;
        }
        return sums;
    }
    public double[] averageCol(int[][] nums) {
        double[] end = new double[nums[0].length];
        for (int i = 0; i < nums[0].length; i++) {
            double sum = 0;
            for (int[] row : nums) {
                sum += row[i];
            }
            end[i] = sum/nums.length;
        }
        return end;
    }
    public int smallEven(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int col : row) {
                if (col % 2 == 0 && col < min) {
                    min = col;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    public int biggestRow(int[][] nums) {
        int index = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < nums.length; r++) {
            int sum = 0;
            for (int n : nums[r]) {
                sum += n;
            }
            if (sum > maxSum) {
                maxSum = sum;
                index = r;
            }
        }
        return index;
    }
}
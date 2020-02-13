import java.util.Scanner;

public class FrequencyChart {
    private int[] dataSet;

    public FrequencyChart(int[] dataSet) {
        this.dataSet = dataSet;
    }

    public String makeChart() {
        String finalString = "";
        for (int i = 1; i < 100; i += 10) {
            finalString += i + " - " + (i + 9);
            // these two lines fix the spacing
            if (i != 91) finalString += " ";
            if (i == 1) finalString += " ";
            finalString += "| ";
            finalString += makeStarString(i, i + 9);
            finalString += "\n";
        }
        return finalString;
    }

    private String makeStarString(int lBound, int uBound) {
        String returnString = "";
        for (int num : dataSet) {
            if (num >= lBound && num <= uBound) returnString += "*";
        }
        return returnString;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many values are in your data set?");

        int[] data = new int[scan.nextInt()];

        System.out.println("Do you want to input your own data? (y/n)");
        String response = scan.next();

        if (response.toLowerCase().equals("y")) {
            System.out.println("Enter data values one at a time, followed by enter:");
            for (int i = 0; i < data.length; i++) {
                data[i] = scan.nextInt();
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                data[i] = (int) (Math.random() * 100) + 1;
            }
            FrequencyChart chart = new FrequencyChart(data);

            System.out.println(chart.makeChart());

        }
    }
}

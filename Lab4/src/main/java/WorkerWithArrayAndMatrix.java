import java.util.*;

public class WorkerWithArrayAndMatrix {
    public static ArrayList<Integer> createArray() {
        ArrayList<Integer> array = new ArrayList<>();

        System.out.println("Enter the length of array elements: ");

        int lengthOfArray = getIntInput();

        for (int i = 0; i < lengthOfArray; i++) {
            System.out.println("Enter array value");
            array.add(getIntInput());
        }

        return array;
    }

    public static int getIntInput() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (Exception ex) {
            return getIntInput();
        }
    }

    public static ArrayList<Integer> pairedArray(ArrayList<Integer> array){
        ArrayList<Integer> pairedArray = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                pairedArray.add(array.get(i));
            }
        }

        return pairedArray;
    }

    public static double geometricMean(ArrayList<Integer> pairedArray) {
        double gm = 1.0;

        for (int i = 0; i < pairedArray.size(); i++) {
            gm *= pairedArray.get(i);
        }

        return Math.pow(gm, 1.0/pairedArray.size());

    }

    public static int largestByModule(ArrayList<Integer> array) {
        int max = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if ( Math.abs(array.get(i)) > Math.abs(max) ) {
                max = array.get(i);
            }
        }

        return Math.abs(max);

    }

    public static int maximumPairedItem(ArrayList<Integer> array) {
        int max = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if ( array.get(i) > max ) {
                max = array.get(i);
            }
        }

        return max;

    }

    public static double arithmeticMean(ArrayList<Integer> array) {
        int mean, sumOfArr = 0, sum = 0, result;

        ArrayList<Integer> minElements = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            sumOfArr += array.get(i);
        }

        mean = sumOfArr / array.size();

        return mean;

    }

    public static int findModuleMinimized(ArrayList<Integer> array) {
        int min = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if ( Math.abs(array.get(i)) < Math.abs(min) ) {
                min = array.get(i);
            }
        }

        return min;

    }

    public static int findSumInInterval(ArrayList<Integer> array) {
        int sum = 0;

        if (array.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                sum += array.get(i);
            }
        }

        return sum;

    }

    public static int[][] createMatrix() {
        Random random = new Random();
        System.out.println("Enter the order of matrix: ");

        int n = getIntInput();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt();
            }
        }

        return matrix;
    }

    public static int sumOfDiagonal(int [][] matrix) {
        int sumDiagonal = 0;

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sumDiagonal += matrix[i][j];
                }
            }
        }

        return sumDiagonal;
    }

    public static int sumAboveDiagonal(int [][] matrix) {
        int sumAboveDiagonal = 0;

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    sumAboveDiagonal += matrix[i][j];
                }
            }
        }

        return sumAboveDiagonal;

    }

    public static int sumBelowDiagonal(int [][] matrix) {
        int sumBelowDiagonal = 0;

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    sumBelowDiagonal += matrix[i][j];
                }
            }
        }

        return sumBelowDiagonal;

    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        helloWorld();
        arrayAndMatrix();
        sortingAlgorithms();
    }

    private static void helloWorld() {
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }

    private static void arrayAndMatrix() {
        WorkerWithArrayAndMatrix worker = new WorkerWithArrayAndMatrix();
        ArrayList<Integer> array = worker.createArray();
        ArrayList<Integer> pairedArray = worker.pairedArray(array);

        System.out.println("Geometric Mean: " + worker.geometricMean(pairedArray));
        System.out.println("The largest number by module is: " + worker.largestByModule(array));
        System.out.println("The maximum paired item is: " + worker.maximumPairedItem(pairedArray));
        System.out.println("Arithmetic mean of minimum elements of the array: " + worker.arithmeticMean(array));
        System.out.println("The Module-Minimized item is: " + worker.findModuleMinimized(array));
        if (worker.findSumInInterval(array) == 0) {
            System.out.println("The array does not contain this amount of elements.");
        } else {
            System.out.println("The sum in interval [0-10] is: " + worker.findSumInInterval(array));
        }

        int[][] matrix = worker.createMatrix();

        System.out.println("The sum on the main diagonal is: " + worker.sumOfDiagonal(matrix));
        System.out.println("The sum above main diagonal is: " + worker.sumAboveDiagonal(matrix));
        System.out.println("The sum below main diagonal is: " + worker.sumBelowDiagonal(matrix));
    }

    private static void sortingAlgorithms() {
        Sorter sorter = new Sorter();
        int arrLength = 150;

        int[] array = sorter.generateArray(arrLength);
        sorter.printArray(array);

        sorter.bubbleSort(array.clone());
        sorter.oddEvenSort(array.clone());
        sorter.cycleSort(array.clone());
        sorter.combSort(array.clone());
        sorter.javaUtilSort(array.clone());
        sorter.insertion(array.clone());
    }
}

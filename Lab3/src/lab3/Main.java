package lab3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int arrLength = 10000;
        int[] array = generateArray(arrLength);
        printArray(array);

        bubbleSort(array.clone());
        oddEvenSort(array.clone());
        quickSort(array.clone());
        cycleSort(array.clone());
        combSort(array.clone());
        javaUtilSort(array.clone());
        insertion(array.clone());
    }

    static int[] generateArray(int arrLength) {
        Random rand = new Random();
        int[] array = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            array[i] = rand.nextInt(10000);
        }

        return array;
    }

    static void printArray(int[] array) {
        System.out.println("Start array");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i != 0 && i % 30 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    static void bubbleSort(int[] array) {

        long startTime = System.currentTimeMillis();
        int temp;

        for (int i = array.length - 1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.printf("The runtime of bubble sort algorithm is %d %s\n", elapsedTime, "ms");
        System.out.println();

    }

    static void oddEvenSort(int[] array) {

        long startTime = System.currentTimeMillis();
        boolean isSorted = false;

        while (!isSorted) {
            int temp;
            isSorted = true;

            for (int i = 1; i < array.length - 1; i += 2) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }

            for (int i = 0; i < array.length - 1; i += 2) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    isSorted = false;
                }
            }
        }

        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of odd-even sort algorithm is %d %s\n", elapsedTime, "ms");
        System.out.println();

    }

    static void quickSort(int[] array) {

        Random rand = new Random();
        long startTime = System.currentTimeMillis();
        int index = rand.nextInt(array.length);
        int pivot = array[index];

        int bottomBound = 0, topBound = array.length - 1;
        while (bottomBound <= topBound) {
            while (array[bottomBound] < pivot) {
                bottomBound++;
            }

            while (array[topBound] > pivot) {
                topBound--;
            }

            if (bottomBound <= topBound) {
                int temp = array[bottomBound];
                array[bottomBound] = array[topBound];
                array[topBound] = temp;
                bottomBound++;
                topBound--;
            }

        }

        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of quick sort algorithm is %d %s\n", elapsedTime, "ms");
        System.out.println();

    }

    static void cycleSort(int[] array) {

        long startTime = System.currentTimeMillis();

        for (int cycleStart = 0; cycleStart < array.length - 1; cycleStart++) {
            int currentItem = array[cycleStart];

            int pos = cycleStart;
            for (int i = cycleStart + 1; i < array.length; i++) {
                if (array[i] < currentItem) {
                    pos++;
                }
            }

            if (pos == cycleStart) {
                continue;
            }

            while (currentItem == array[pos]) {
                pos++;
            }

            int temp = array[pos];
            array[pos] = currentItem;
            currentItem = temp;

            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < array.length; i++) {
                    if (array[i] < currentItem) {
                        pos++;
                    }
                }

                while (currentItem == array[pos]) {
                    pos++;
                }

                temp = array[pos];
                array[pos] = currentItem;
                currentItem = temp;
            }
        }

        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of cycle sort algorithm is %d %s\n", elapsedTime, "ms");
        System.out.println();

    }

    static void combSort(int[] array) {

        long startTime = System.currentTimeMillis();
        int gap = array.length;
        double shrinkFactor = 1.3;
        boolean isSwapped = false;

        while (gap > 1 || isSwapped) {
            if (gap > 1) {
                gap = (int)(gap / shrinkFactor);
            }

            isSwapped = false;

            for (int i = 0; gap + i < array.length; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    isSwapped = true;
                }
            }
        }

        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of comb sort algorithm is %d %s\n", elapsedTime, "ms");
        System.out.println();

    }

    static void javaUtilSort(int[] array) {

        long startTime = System.currentTimeMillis();

        Arrays.sort(array);

        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of dual-pivot quicksort algorithm is %d %s\n", elapsedTime, "ms");
        System.out.println();

    }

    static void insertion(int[] array) {

        long startTime = System.currentTimeMillis();
        // Loop through the array until sorted.
        for (int i = 1; i < array.length; i++) {
            int index = array[i];
            int j = i;
            // If these aren't the right surrounding numbers, switch the target index up one.
            while ((j > 0) && (array[j - 1] > index)) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            // After the right position has been found, put in the new number.
            array[j] = index;
        }

        long endTime   = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.printf("The runtime of insertion sort algorithm is %d %s\n", elapsedTime, "ms");
        System.out.println();
    }
}
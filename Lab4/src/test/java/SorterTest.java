import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertArrayEquals;


public class SorterTest {
    Sorter sorter;
    int[] array, sortedArray;

    @Before
    public void initialize() {
        sorter = new Sorter();
        sortedArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        array = new int[] { 10, 7, 8, 9, 6, 4, 3, 1, 2, 5 };
    }

    @Test
    public void bubbleSortTest() {
        assertArrayEquals(sortedArray, sorter.bubbleSort(array.clone()));
    }

    @Test
    public void oddEvenSortTest() {
        assertArrayEquals(sortedArray, sorter.oddEvenSort(array.clone()));
    }

    @Test
    public void cycleSortTest() {
        assertArrayEquals(sortedArray, sorter.cycleSort(array.clone()));
    }

    @Test
    public void combSortTest() {
        assertArrayEquals(sortedArray, sorter.combSort(array.clone()));
    }

    @Test
    public void javaUtilSortTest() {
        assertArrayEquals(sortedArray, sorter.javaUtilSort(array.clone()));
    }

    @Test
    public void insertionTest() {
        assertArrayEquals(sortedArray, sorter.insertion(array.clone()));
    }
}
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class WorkerWithArrayAndMatrixTest {
    ArrayList<Integer> pairedArray, array;
    WorkerWithArrayAndMatrix worker;
    int[][] matrix;

    @Before
    public void initialize() {
        pairedArray = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        worker = new WorkerWithArrayAndMatrix();
        matrix = new int[][] {{1, 2, 3},
                              {2, 1, 2},
                              {3, 5, 0}};
    }

    @Test
    public void pairedArrayTest() {
        assertEquals (pairedArray, worker.pairedArray(array));
    }

    @Test
    public void geometricMeanTest() {
        assertEquals (4.52873, worker.geometricMean(array), 0.0005);
    }

    @Test
    public void largestByModuleTest() {
        assertEquals(10, worker.largestByModule(array));
    }

    @Test
    public void maximumPairedItemTest() {
        assertEquals(10, worker.maximumPairedItem(pairedArray));
    }

    @Test
    public void arithmeticMeanTest() {
        assertEquals(5.0, worker.arithmeticMean(array), 0.005);
    }

    @Test
    public void findModuleMinimizedTest() {
        assertEquals(1, worker.findModuleMinimized(array));
    }

    @Test
    public void findSumInIntervalTest() {
        assertEquals(0, worker.findSumInInterval(pairedArray));
        assertEquals(55, worker.findSumInInterval(array));
    }

    @Test
    public void sumOfDiagonalTest() {
        assertEquals(2, worker.sumOfDiagonal(matrix));
    }

    @Test
    public void sumAboveDiagonalTest() {
        assertEquals(7, worker.sumAboveDiagonal(matrix));
    }

    @Test public void sumBelowDiagonalTest() {
        assertEquals(10, worker.sumBelowDiagonal(matrix));
    }
}
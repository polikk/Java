package test.laba6;

import org.junit.Before;
import org.junit.Test;
import laba6.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WordAnalyticsTest {
    private WordAnalytics analizer;

    @Before
    public void init() throws Exception {
        analizer = new WordAnalytics("words0.txt");
    }

    @Test(expected = FileNotFoundException.class)
    public void WordSolverWithInvalidPath() throws Exception {
        WordAnalytics analizer = new WordAnalytics("fantom.txt");
    }
    @Test(expected = IllegalArgumentException.class)
    public void sortEmpty() throws Exception {
        WordAnalytics analizer = new WordAnalytics("noWords.txt");
        analizer.sort();
    }
    @Test
    public void sort() throws Exception {
        analizer.sort();
        assertEquals(analizer.getFullyConcatenatedWords().size(), 9);
        assertEquals(analizer.getPartlyConcatenatedWords().size(), 6);
        assertEquals(analizer.getSimpleWords().size(), 4);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getConcatenatedWordByLengthAtNegative() throws Exception {
        analizer.getConcatenatedWordByLengthAt(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getConcatenatedWordByLengthAtOutOfBound() throws Exception {
        analizer.getConcatenatedWordByLengthAt(20);
    }
    @Test
    public void getConcatenatedWordByLengthAt1WithUnsorted() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        words.add("catcatcatcatscat");
        assertEquals(analizer.getConcatenatedWordByLengthAt(1), words);
    }
    @Test
    public void getConcatenatedWordByLengthAt1() throws Exception {
        WordAnalytics solver = new WordAnalytics("words0.txt");
        ArrayList<String> words = new ArrayList<>();
        words.add("catcatcatcatscat");
        assertEquals(solver.getConcatenatedWordByLengthAt(1), words);
    }
    @Test
    public void getConcatenatedWordByLengthAt2() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        words.add("ratsdogscatsdog");
        assertEquals(analizer.getConcatenatedWordByLengthAt(2), words);
    }
    @Test
    public void getConcatenatedWordByLengthAt4() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        words.add("catsdogcats");
        words.add("catsdogscat");
        assertEquals(analizer.getConcatenatedWordByLengthAt(4), words);
    }
}

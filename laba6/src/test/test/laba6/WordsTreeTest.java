package test.laba6;

import laba6.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WordsTreeTest {
    private WordsTree tree;

    @Before
    public void init() {
        tree = new WordsTree();
        tree.insert("cat");
    }

    @Test
    public void getNodeWithEmptyChar() throws Exception {
        assertTrue(tree.getFinalNode("") == null);
    }
    @Test
    public void getUnexistedNode() throws Exception {
        assertTrue(tree.getFinalNode("dog") == null);
    }
    @Test
    public void getExistedNode() throws Exception {
        assertTrue(tree.getFinalNode("cat") != null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertEmprty() throws Exception {
        tree.insert("");
    }
    @Test
    public void insert() throws Exception {
        tree.insert("cats");
        assertTrue(tree.getFinalNode("cats") != null);
    }
}

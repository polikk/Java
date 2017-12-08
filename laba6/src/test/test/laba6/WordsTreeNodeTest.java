package test.laba6;

import laba6.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WordsTreeNodeTest {
    private WordsTree tree;
    private WordsTreeNode node;

    /** set up tree and final node
     */
    @Before
    public void init() {
        tree  = new WordsTree();
        tree.insert("cat");
        node = tree.getFinalNode("cat");
    }

    /** correct input
     * final node is s
     * so not null
     */
    @Test
    public void getNodeWithExistingLetter() {
        tree.insert("cats");
        assertTrue(node.getNodeWithLetter('s') != null);
    }

    /** catch incorrect input
     * final node is not s
     * so returns null
     */
    @Test
    public void getNodeWithUnexistingLetter() {
        assertTrue(node.getNodeWithLetter('s') == null);
    }
}

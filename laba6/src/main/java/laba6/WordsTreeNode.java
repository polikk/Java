package laba6;

import java.util.ArrayList;

/**
 * Class represent a node of prefix tree which has:
 * a list of subnodes
 * its value(letter) presented by char
 */
public class WordsTreeNode {
    public ArrayList<WordsTreeNode> values;
    public char value;
    public boolean isFinal;

    public WordsTreeNode(char value) {
        values = new ArrayList<>();
        this.value = value;
    }

    /**
     * if a node in values
     * contains the letter
     * returns that node
     */
    public WordsTreeNode getNodeWithLetter(char letter) {
        for (WordsTreeNode node: values)
            if (node.value == letter)
                return node;

        return null;
    }
}

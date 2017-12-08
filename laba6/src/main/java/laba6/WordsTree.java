package laba6;

public class WordsTree {
    private WordsTreeNode root;

    public WordsTree() {
        root = new WordsTreeNode('\0');
    }

    /**
     * Method extends tree with new word
     * @param word
     * @throws IllegalArgumentException
     */
    public void insert(String word) throws IllegalArgumentException {
        if (word.isEmpty())
            throw new IllegalArgumentException("Empty string");

        WordsTreeNode currentNode = root;
        char currentLetter;
        WordsTreeNode nextNode;

        for (int i = 0; i < word.length(); i++) {
            currentLetter = word.charAt(i);
            nextNode = currentNode.getNodeWithLetter(currentLetter);
            if (nextNode == null) {
                nextNode = new WordsTreeNode(currentLetter);
                currentNode.values.add(nextNode);
                currentNode = nextNode;
            }
            else
                currentNode = nextNode;
        }

        currentNode.isFinal = true;
    }

    /**
     * isFinal signifies ends of words
     * Method checks if the word has
     * an end in the tree
     * and thus, if it exists in the tree
     * then returns that ending
     * @param word
     * @throws IllegalArgumentException
     */
    public WordsTreeNode getFinalNode(String word) {
        WordsTreeNode currentNode = root;
        if (word.isEmpty())
            return null;

        char currentLetter;
        WordsTreeNode nextNode;
        for (int i = 0; i < word.length(); i++) {
            currentLetter = word.charAt(i);
            nextNode = currentNode.getNodeWithLetter(currentLetter);
            if (nextNode != null)
                currentNode = nextNode;
            else
                return null;
        }

        if (currentNode.isFinal)
            return currentNode;

        return null;
    }
}

package laba6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/** does many(way too many)
 * usefull things with words
 * gets words from file
 * sorts them into lists
 * can get the bestest words
 */
public class WordAnalytics {
    private String filePath;
    private WordsTree tree;
    private List<String> allWords;
    private List<String> simpleWords;
    private List<String> partlyConcatenatedWords;
    private List<String> fullyConcatenatedWords;

    public void setFilePath(String filePath) throws FileNotFoundException {
        if (!new File(filePath).isFile())
            throw new FileNotFoundException("The file under this path doesn't exist");
        this.filePath = filePath;
    }
    public List<String> getSimpleWords() {
        return simpleWords;
    }
    public List<String> getPartlyConcatenatedWords() {
        return partlyConcatenatedWords;
    }
    public List<String> getFullyConcatenatedWords() {
        return fullyConcatenatedWords;
    }

    /**
     * @param path to file with words
     * @throws FileNotFoundException if path directs to folder
     */
    public WordAnalytics(String path) throws FileNotFoundException {
        this();
        setFilePath(path);
    }
    public WordAnalytics() {
        tree = new WordsTree();
        allWords = new ArrayList<>();
        simpleWords = new ArrayList<>();
        partlyConcatenatedWords = new ArrayList<>();
        fullyConcatenatedWords = new ArrayList<>();
    }

    /**
     * Sorts all words form file
     * to simpleWords, concatenatedWords
     * and partlyConcatenatedWords lists
     * if they belong there
     * (does not sort words by size)
     */
    public void sort() {
        getAllWordsFromFile();
        for (String word : allWords) {
            if (isFullyConcatenated(true, word)) {
                fullyConcatenatedWords.add(word);
                continue;
            }
            if (isPartlyConcatenated(word)) {
                partlyConcatenatedWords.add(word);
                continue;
            }
            simpleWords.add(word);
        }
    }

    /**
     * A method checks if word is fully concatenated
     * @param isEntire indicates whether it is initial version of word
     * otherwise it knows it's in recursion
     * @param word to check
     * @return true if word is fully concatenated
     */
    private boolean isFullyConcatenated(boolean isEntire, String word) {
        String prefix;
        String suffix;
        for (int i = 0; i < word.length(); i++) {
            prefix = word.substring(0, i + 1);
            suffix = word.substring(i + 1, word.length());
            if (tree.getFinalNode(prefix) != null)
                if ((!isEntire && suffix.isEmpty()) || tree.getFinalNode(suffix) != null ||
                        (!suffix.isEmpty() && isFullyConcatenated(false, suffix)))
                    return true;
        }

        return false;
    }

    /**
     * A method checks if word is partly concatenated
     * word must be non-fully concatenated (previous sort)
     * @param word to check for part. concatenation
     * @return true if word is partly concatenated
     */
    private boolean isPartlyConcatenated(String word) {
        String prefix;
        String suffix;
        for (int i = 0; i < word.length(); i++) {
            prefix = word.substring(0, i + 1);
            suffix = word.substring(i + 1, word.length());
            if (prefix.length() == 0 || suffix.length() == 0)
                break;

            if (tree.getFinalNode(prefix) != null || tree.getFinalNode(suffix) != null)
                return true;
        }

        return false;
    }

    /**
     * A method creates Map with length and concatenated words of it
     * @param indexFromEnd indicates how many concatenated words to get, 1 gets a single biggest word
     * @return all words with same length
     * @throws IllegalArgumentException when index is invalid or no concatenated words in file
     */
    @SuppressWarnings("unchecked")
    public List<String> getConcatenatedWordByLengthAt(int indexFromEnd) throws IllegalArgumentException {
        if (indexFromEnd < 1)
            throw new IllegalArgumentException("invalid index");

        if (allWords.size() == 0)
            sort();
        if (fullyConcatenatedWords.size() == 0)
            throw new IllegalArgumentException("no fully concatenated words");

        Map<Integer, List<String>> wordsByLength = getWordsByLength();
        Map<Integer, List<String>> sortedWordsByLength = new TreeMap<>(wordsByLength);
        if (indexFromEnd > sortedWordsByLength.keySet().size())
            throw new IllegalArgumentException("invalid index");

        return (List<String>)sortedWordsByLength.values().toArray()[sortedWordsByLength.size() - indexFromEnd];
    }
    private Map<Integer, List<String>> getWordsByLength() {
        Map<Integer, List<String>> wordsByLengths = new HashMap<>();
        List<String> wordsWithCurrentLength = new ArrayList<>();
        for (String concatenatedWord : fullyConcatenatedWords) {
            wordsWithCurrentLength.clear();
            int currentLength = concatenatedWord.length();
            if (!wordsByLengths.containsKey(currentLength)) {
                for (String word : fullyConcatenatedWords)
                    if (word.length() == currentLength)
                        wordsWithCurrentLength.add(word);
                wordsByLengths.put(currentLength, new ArrayList<>(wordsWithCurrentLength));
            }
        }
        return wordsByLengths;
    }

    /**
     * Method reads words form file at filePath
     * and fills list allWords and tree with the words from file path
     * @throws IllegalArgumentException when file contains no words
     */
    private void getAllWordsFromFile() throws IllegalArgumentException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(word -> {
                allWords.add(word);
                tree.insert(word);
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (allWords.size() == 0)
            throw new IllegalArgumentException("Empty file");
    }
}

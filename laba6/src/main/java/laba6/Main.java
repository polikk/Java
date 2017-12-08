package laba6;

import java.util.List;

/** data printer
 * gets data out of WordAnalytics solver
 * prints it on screen
 */
public class Main {
    public static void main(String[] args) throws Exception {
        long time = System.nanoTime();
        WordAnalytics analizer = new WordAnalytics("words.txt");
        analizer.sort();
        System.out.println((System.nanoTime() - time) * Math.pow(10, -6) + " millisec");
        getMemoryConsumption();

        getWordsInformation(analizer);
    }

    private static void getWordsInformation(WordAnalytics analazer) {
        int simpleWordsCount = analazer.getSimpleWords().size();
        int partlyConcatenatedWordsCount = analazer.getPartlyConcatenatedWords().size();
        int fullyConcatenatedWordsCount = analazer.getFullyConcatenatedWords().size();
        System.out.println("Simple words: " + simpleWordsCount);
        System.out.println("Partly concatenated words: " + partlyConcatenatedWordsCount);
        System.out.println("Fully concatenated words: " + fullyConcatenatedWordsCount);
        if (simpleWordsCount == 0 && partlyConcatenatedWordsCount == 0 && fullyConcatenatedWordsCount == 0)
            System.out.println("ERROR");

        List<String> longestWords = analazer.getConcatenatedWordByLengthAt(1);
        System.out.println("The longest concatenated word: " + longestWords +
                " with length " + longestWords.get(0).length());
        System.out.println("The 2nd longest concatenated word: " + analazer.getConcatenatedWordByLengthAt(2));
    }


    private static void getMemoryConsumption() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Memory used: %d B \n", memory);
    }
}
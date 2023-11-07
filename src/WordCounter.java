public class WordCounter {
    public int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}

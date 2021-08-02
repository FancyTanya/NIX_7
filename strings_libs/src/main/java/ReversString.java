public class ReversString {

    public static String reverseString(String input) {
        StringBuilder result = new StringBuilder();
        String[] split = input.split(" ");

        for (String word: split) {
            StringBuilder reverseOfWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseOfWord.append(word.charAt(i));
            }
            result.append(reverseOfWord).append(' ');
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }

    public static String reverseString(String input, String dest) {
        StringBuilder result = new StringBuilder();

        if (input.contains(dest)) {
            int indexOfStart = input.indexOf(dest);
            int indexOfEnd = indexOfStart + dest.length() - 1;
            String head = input.substring(0, indexOfStart);
            String reverse = input.substring(indexOfStart, indexOfEnd + 1);
            String tail = input.substring(indexOfEnd + 1);

            result.append(head);
            result.append(reverseString(reverse));
            result.append(tail);
        }
        return result.toString();
    }

    public static String reverseString(String input, int firstIndex, int lastIndex) {
        StringBuilder result = new StringBuilder();

        String head = input.substring(0, firstIndex);
        String reverse = input.substring(firstIndex, lastIndex);
        String tail = input.substring(lastIndex + 1);

        result.append(head);
        result.append(reverseString(reverse));
        result.append(tail);
        return result.toString();
    }

}

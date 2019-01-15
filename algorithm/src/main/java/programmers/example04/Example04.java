package programmers.example04;

/**
 * Created by wyparks2@gmail.com on 2019. 1. 14.
 * Blog : http://WonYoungPark.github.io
 * Github : http://github.com/WonYoungPark
 */
public class Example04 {

    public static void main(String[] args) {

    }

    private static final int ALPHABET_A_ASCII_CODE = 97;
    private static final int ALPHABET_Z_ASCII_CODE = 122;
    private static final String PERFECT_RESULT = "perfect";

    public String solution(String sentence) {
        verify(sentence);

        final boolean[] usedAlphabetAsciiCodes = decideUsedAlphabet(sentence);

        return resultUnusedAlphabetList(usedAlphabetAsciiCodes);
    }

    private void verify(String sentence) {
        if (sentence.length() > 5000)
            throw new IllegalArgumentException("sentence의 길이는 5,000 이하여야 합니다.");
    }

    private boolean[] decideUsedAlphabet(String sentence) {
        final boolean usedAlphabetAsciiCodes[] = new boolean[26];

        final char[] chars = sentence.toLowerCase().toCharArray();
        for (char character : chars) {
            final int ascii = (int) character;

            if (isLowerCaseAlphabet(ascii))
                usedAlphabetAsciiCodes[convertAsciiToIndex(ascii)] = true;
        }
        return usedAlphabetAsciiCodes;
    }

    private String resultUnusedAlphabetList(boolean[] usedAlphabetAsciiCodes) {
        final StringBuilder sb = new StringBuilder();
        final int length = usedAlphabetAsciiCodes.length;
        for (int index = 0; index < length; index++) {
            if (isNotUsedAlphabet(usedAlphabetAsciiCodes[index]))
                sb.append((char) convertIndexToAscii(index));
        }

        if (isPerfect(sb))
            return PERFECT_RESULT;

        return sb.toString();
    }

    private boolean isPerfect(StringBuilder sb) {
        return sb.length() == 0;
    }

    private int convertAsciiToIndex(int ascii) {
        return ascii - ALPHABET_A_ASCII_CODE;
    }

    private int convertIndexToAscii(int index) {
        return ALPHABET_A_ASCII_CODE + index;
    }

    private boolean isNotUsedAlphabet(boolean usedAlphabetAsciiCode) {
        return !usedAlphabetAsciiCode;
    }

    private boolean isLowerCaseAlphabet(int ascii) {
        return ascii >= ALPHABET_A_ASCII_CODE && ascii <= ALPHABET_Z_ASCII_CODE;
    }
}
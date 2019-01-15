package programmers.example01;

import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2018. 10. 29.
 * Blog : http://WonYoungPark.github.io
 * Github : http://github.com/WonYoungPark
 */
public class Example01 {

    public static void main(String[] args) {
        Example01 example = new Example01();
        System.out.println(example.solution(1, 100));
    }

    public int solution(int n, int m) {

        return (int) IntStream.rangeClosed(n, m)
             .filter(this::isPalindrome)
             .count();
    }

    private boolean isPalindrome(int number) {
        final String original = String.valueOf(number);
        final String reversed = new StringBuilder(original).reverse().toString();

        return original.equals(reversed);
    }
}

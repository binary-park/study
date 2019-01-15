package programmers.example02;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by wyparks2@gmail.com on 2018. 10. 29.
 * Blog : http://WonYoungPark.github.io
 * Github : http://github.com/WonYoungPark
 */
public class Example02 {

    public static void main(String[] args) {
        Example02 example = new Example02();
        System.out.println(example.solution("()()"));
        System.out.println(example.solution("(())()"));
        System.out.println(example.solution(")()("));
        System.out.println(example.solution("(()("));

    }

    boolean solution(String s) {
        if (s.length() % 2 == 1)
            return false;

        final Stack stack = new Stack<>();

        final char openBracket = '(';
        try {
            for (char ch : s.toCharArray()) {
                if (ch == openBracket)
                    stack.push(ch);
                else
                    stack.pop();
            }
        } catch (EmptyStackException e) {
            return false;
        }

        return stack.empty();
    }
}

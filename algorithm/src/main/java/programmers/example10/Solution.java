package programmers.example10;

import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
  public String solution(String number, int k) {
    Stack<Character> stack = new Stack<>();

    for (char ch : number.toCharArray()) {
        while (!stack.isEmpty() && stack.peek() < ch && k-- > 0) {
          stack.pop();
        }
        stack.push(ch);
      }

    return stack.stream()
        .map(Object::toString)
        .collect(Collectors.joining(""));
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    var solution1 = solution.solution("4177252841", 5);
    System.out.printf("");
  }
}

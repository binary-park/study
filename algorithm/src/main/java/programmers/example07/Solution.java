package programmers.example07;

/*
알파벳이 대소문자 각각 26글자라는 점을 이용해서 26으로 나눈 나머지로 처리한 것 같습니다. 즉 1부터 a라고 할때, n을 더한 값이 27이라면 다시 a겠지요? 26으로 27을 나눈 나머지가 1이니까요!
 */
public class Solution {
  public String solution(String s, int n) {

    String result = "";
    for (char ch : s.toCharArray()) {
      if (Character.isLowerCase(ch)) {
        result += (char) ((ch - 'a' + n) % 26 + 'a');
      } else if (Character.isUpperCase(ch)) {
        result += (char) ((ch - 'A' + n) % 26 + 'A');
      } else if (ch == ' ') {
        result += " ";
      }

    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.solution("AB", 1);
    solution.solution("z", 1);
  }
}

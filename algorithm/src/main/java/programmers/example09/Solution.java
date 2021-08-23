package programmers.example09;

public class Solution {
  private static final String TEXT = "수박";
  public String solution(int n) {

    String text = "";
    for (int index = 0; index < n; index++) {
      text += TEXT;
    }

    return text.substring(0, n);
  }
}

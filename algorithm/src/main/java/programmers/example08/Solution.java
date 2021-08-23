package programmers.example08;

import java.time.LocalDate;

public class Solution {
  private static final String[] DAYS = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
  public String solution(int a, int b) {
    LocalDate date = LocalDate.of(2016, a, b);
    var dayOfWeek = date.getDayOfWeek().getValue();
    return DAYS[dayOfWeek];
  }
}

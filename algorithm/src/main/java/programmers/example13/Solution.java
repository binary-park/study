package programmers.example13;

public class Solution {
  private static final int[] MONTHLY_DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public int[] solution(int day, int k) {
    int[] answer = new int[12];

    int sum = 0;
    for (int i = 0; i < MONTHLY_DAY.length; i++) {
      for (int j = 1; j <= MONTHLY_DAY[i]; j++) {
        sum ++;

        // 관리비 납부일이 아닐 경우
        if (j != k) continue;

        var currentDay = (sum + day - 1) % 7;

        if (isWeekend(currentDay)) {
          answer[i] = 1;
        } else {
          answer[i] = 0;
        }
      }
    }

    return answer;
  }

  private boolean isWeekend(int currentDay) {
    return currentDay == 5 || currentDay == 6;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    var solution1 = solution.solution(6, 1);
    var solution2 = solution.solution(6, 25);

    System.out.printf("");
  }
}

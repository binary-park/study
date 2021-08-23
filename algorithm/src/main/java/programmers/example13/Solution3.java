package programmers.example13;

public class Solution3 {
  public int solution(int[] foods) {
    if (foods.length < 3) {
      return 0;
    }

    int result = 0;
    final int LENGTH = foods.length;
    for (int i = 0; i < LENGTH - 1; i++) {
      for (int j = i + 2; j < LENGTH; j++) {
        int firstPig = 0;
        int secondPig = 0;
        int thirdPig = 0;

        for (int index = 0; index <= i; index++) {
          firstPig += foods[index];
        }

        for (int index = i + 1; index < j; index++) {
          secondPig += foods[index];
        }

        for (int index = j; index < LENGTH; index++) {
          thirdPig += foods[index];
        }

        if (firstPig == secondPig && firstPig == thirdPig)
          result++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();

    var solution = solution3.solution(new int[] {1, 2, 3, 0, 3});
    System.out.printf("");
  }
}

package programmers.example12;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int[] solution(int[] numbers) {

    Set<Integer> sumList = new HashSet<>();

    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        sumList.add(numbers[i] + numbers[j]);
      }
    }

    return sumList.stream().mapToInt(x -> x).sorted().toArray();
  }
}

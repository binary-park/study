package inflearn.section01.example_04_단어_뒤집기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public List<String> solution(int n, String[] str) {
    List<String> answer = new ArrayList<>();
    for (String x : str) {
      String temp = new StringBuilder(x).reverse().toString();
      answer.add(temp);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main main = new Main();

    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    String[] str = new String[n];

    for (int index = 0; index < n; index++) {
      str[index] = scanner.next();
    }

    for (String x : main.solution(n, str)) {
      System.out.println(x);
    }
  }
}

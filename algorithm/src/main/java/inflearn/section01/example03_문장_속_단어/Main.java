package inflearn.section01.example03_문장_속_단어;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "";
    int maxLength = 0;
    String[] s = str.split(" ");

    for (String x : s) {
      int length = x.length();

      if (length > maxLength) {
        maxLength = length;
        answer = x;
      }
    }

    return answer;
  }


  public static void main(String[] args) {
    Main main = new Main();

    Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine();

    System.out.print(main.solution(str));
  }
}

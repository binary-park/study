package inflearn.section01.example02_대소문자_변환;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    StringBuilder answer = new StringBuilder();

    for (char x : str.toCharArray()) {
      if (Character.isLowerCase(x)) {
        answer.append(Character.toUpperCase(x));
      } else {
        answer.append(Character.toLowerCase(x));
      }
    }

    return answer.toString();
  }

  /**
   * 아스키코드로 처리.
   * <p>
   * https://namu.wiki/w/%EC%95%84%EC%8A%A4%ED%82%A4%20%EC%BD%94%EB%93%9C
   */
  public String solution2(String str) {
    StringBuilder answer = new StringBuilder();

    for (char x : str.toCharArray()) {
      // 소문자
      if (x >= 97 && x <= 122) {
        answer.append((char) (x - 31));
      }

      // 대문자
      if (x >= 65 && x < 90) {
        answer.append((char) (x + 31));
      }
    }

    return answer.toString();
  }


  public static void main(String[] args) {
    Main main = new Main();

    Scanner scanner = new Scanner(System.in);

    String str = scanner.next();

    System.out.print(main.solution(str));
  }
}

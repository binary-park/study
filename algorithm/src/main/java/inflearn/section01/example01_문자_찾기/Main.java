package inflearn.section01.example01_문자_찾기;

import java.util.Scanner;

public class Main {

  public int solution(String str, char c) {
    int answer = 0;

    // 대소문자 구분을 없애기 위해 모두 대문자 처리
    str = str.toUpperCase();
    c = Character.toUpperCase(c);

    for (char x : str.toCharArray()) {
      if (x == c) {
        answer++;
      }
    }

    return answer;
  }


  public static void main(String[] args) {
    Main solution = new Main();

    Scanner scanner = new Scanner(System.in);

    String str = scanner.next();
    char c = scanner.next().charAt(0);

    System.out.print(solution.solution(str, c));
  }
}

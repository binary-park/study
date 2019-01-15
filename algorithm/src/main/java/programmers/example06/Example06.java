package programmers.example06;

import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2019. 1. 15.
 * Blog : http://WonYoungPark.github.io
 * Github : http://github.com/WonYoungPark
 */
public class Example06 {

    public int solution(int num) {
        verify(num);

        return (int) IntStream.rangeClosed(1, num)
                .filter(number -> {
                    final String strNum = String.valueOf(number);
                    return strNum.contains("3") || strNum.contains("6") || strNum.contains("9");
                }).count();
    }

    private void verify(int num) {
        if (num < 1 || num > 100000)
            throw new IllegalArgumentException("num은 1 이상 100,000 이하인 자연수이어야 합니다.");
    }
}

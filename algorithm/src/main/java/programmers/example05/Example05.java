package programmers.example05;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by wyparks2@gmail.com on 2019. 1. 14.
 * Blog : http://WonYoungPark.github.io
 * Github : http://github.com/WonYoungPark
 */
public class Example05 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 4));
    }

    public static class Solution {
        private Map<Integer, BigInteger> cache = new HashMap<>();

        public long solution(int r, int c) {
            return calculate(r, c);
        }

        /**
         * 공식
         * (row + column)! / (row! * column!)
         *
         * @param row
         * @param column
         * @return
         */
        private long calculate(int row, int column) {
            row--;
            column--;

            final BigInteger numerator = factorialWithCache(row + column); // 분자
            final BigInteger denominator = factorialWithCache(row).multiply(factorialWithCache(column)); // 분모

            return numerator.divide(denominator).longValue();
        }

        /**
         * long Type으로 표현하지 못하는 데이터를 표현하기 위해 BigInteger 사용
         * @param num
         * @return
         */
        private BigInteger factorialWithCache(int num) {
            return IntStream.rangeClosed(1, num)
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ONE, (bigInteger, bigInteger2) ->
                            cache.computeIfAbsent(bigInteger2.intValue(), key ->
                                    bigInteger.multiply(bigInteger2)
                            )
                    );
        }
    }
}
package programmers.example03;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2018. 10. 27.
 * Blog : http://WonYoungPark.github.io
 * Github : http://github.com/WonYoungPark
 */
public class Example03 {

    public static void main(String args[]) {
        Example03 example = new Example03();

        int result1 = example.solution(new int[] {3, 1, 2, 3});
        int result2 = example.solution(new int[] {3,3,3,2,2,4});
        int result3 = example.solution(new int[] {3,3,3,2,2,2});
        int result4 = example.solution(new int[] {3,3,3,2,2,2, 1, 5, 7, 9});

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    public int solution(int[] nums) {
        Set<Integer> pokemonKinds = Arrays.stream(nums)
                                          .boxed()
                                          .collect(Collectors.toSet());

        final int maxChoiceLimit = nums.length / 2;

        return pokemonKinds.size() > maxChoiceLimit ? maxChoiceLimit : pokemonKinds.size();
    }
}

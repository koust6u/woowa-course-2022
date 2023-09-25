package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {

    private static final List<Integer> list = List.of(3,6,9);
    public static int solution(int number) {
        return  (int)IntStream.rangeClosed(1, number)
                .mapToObj(String::valueOf)
                .flatMap(element -> Arrays.stream(element.split("")))
                .mapToInt(Integer::parseInt)
                .filter(list::contains)
                .count();
    }


}

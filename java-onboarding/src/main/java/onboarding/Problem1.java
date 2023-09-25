package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validation(pobi, crong)) return -1;
        if (getMax(pobi) == getMax(crong)) return 0;
        return getMax(pobi)>getMax(crong)?1:2;
    }

    private static boolean validation(List<Integer> pobi, List<Integer> crong){
        return pobi.size() == 2 && crong.size() == 2
                && pobi.get(0) + 1 == pobi.get(1)
                && crong.get(0) + 1 == crong.get(1)
                && pobi.get(0) % 2 == 1
                && crong.get(0) % 2 == 1
                && pobi.get(0)> 0
                && crong.get(0)> 0
                && pobi.get(1) <= 400
                && crong.get(1) <= 400;
    }

    private static IntStream decomposition(List<Integer> list){
        return list.stream()
                .flatMap(page -> Arrays.stream(String.valueOf(page).split("")))
                .mapToInt(Integer::parseInt);
    }
    private static int getMax(List<Integer> list) {
        int mul = decomposition(list).reduce(1, (x,y) -> x*y);
        int sum = decomposition(list).sum();
        return Math.max(sum, mul);
    }
}
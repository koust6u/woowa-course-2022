package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem5 {
    // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원
    private static final List<Integer> currency = List.of(50000,10000,5000,1000,500,100,50,10,1);
    public static List<Integer> solution(int money) {
        Integer[] answer = new Integer[9];
        Arrays.fill(answer, 0);
        int index = 0;
        while (index < currency.size()){
            while (currency.get(index) <= money){
                answer[index]++;
                money -= currency.get(index);
            }
            index++;
        }
        return Arrays.asList(answer);
    }
}

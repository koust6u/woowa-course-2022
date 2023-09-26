package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    /**
     *
     * - 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
     * - 크루는 1명 이상 10,000명 이하이다.
     * - 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
     * - 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
     * - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
     * - result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
     */
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> decomposition = decomposition(forms);
        List<String> duplicated = decomposition.keySet().stream()
                .filter(name -> decomposition.get(name) > 1)
                .collect(Collectors.toList());
        return forms.stream()
                .filter(form -> !isDuplicate(form.get(1), duplicated))
                .map(form -> form.get(0))
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean isDuplicate(String name, List<String> piece){
        for (String s : piece) {
            if (name.contains(s)) return false;
        }
        return true;
    }

    private static Map<String, Integer> decomposition(List<List<String>> forms){
        return forms.stream()
                .filter(form -> validateEmail(form.get(0)) && validateName(form.get(1)))
                .map(form -> form.get(1))
                .flatMap(e -> divideName(e).stream())
                .collect(Collectors.toMap(e -> e, e -> 1, (oldValue, newValue) -> newValue += oldValue));
    }

    private static List<String> divideName(String name){
        List<String> divided = new ArrayList<>();
        for (int i = 0; i < name.length()-1; i++){
            divided.add(name.substring(i, i+2));
        }
        return divided;
    }

    private static boolean validateEmail(String email){
        return emailLengthInRange(email) && isEmailFormat(email);
    }

    private static boolean validateName(String name){
        return isNameFormat(name) && nameLengthInRange(name);
    }


    private static boolean emailLengthInRange(String email){
        return email.length() >= 11 && email.length() < 20;
    }

    private static boolean isEmailFormat(String email){
        String[] split = email.split("@");
        return split[1].equals("email.com");
    }
    private static boolean nameLengthInRange(String name){
        return name.length() >= 1 && name.length() < 20;
    }

    private static boolean isNameFormat(String name){
        return name.matches("^[가-힣]*$");
    }
}

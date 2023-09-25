package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static String compact(String cipher){
        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i < cipher.length()-1; i++){
            if (cipher.charAt(i) == cipher.charAt(i+1)) i++;
            else sb.append(cipher.charAt(i));
        }
        return sb.toString();
    }
}

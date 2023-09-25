package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        while (true){
            int prevLen = cryptogram.length();
            cryptogram = compact(cryptogram);
            if (prevLen == cryptogram.length()) break;
        }
        return cryptogram;
    }

    private static String compact(String cipher){
        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i < cipher.length()-1; i++){
            if (cipher.charAt(i) == cipher.charAt(i+1)) i++;
            else sb.append(cipher.charAt(i));
        }
        if (cipher.length() >= 2 && cipher.charAt(cipher.length()-1) != cipher.charAt(cipher.length()-2))
            sb.append(cipher.charAt(cipher.length()-1));
        return sb.toString();
    }
}

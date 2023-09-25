package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return shiftCipher(word);
    }

    private static String shiftCipher(String plaintext){
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < plaintext.length(); i++){
            if (plaintext.charAt(i) >= 'a' && plaintext.charAt(i) <= 'z')
                sb.append((char)('z' -plaintext.charAt(i) + 'a'));
            else if (plaintext.charAt(i) >= 'A' && plaintext.charAt(i) <= 'Z')
                sb.append((char)('Z' - plaintext.charAt(i) + 'A'));
            else sb.append(plaintext.charAt(i));
        }
        return sb.toString();
    }
}

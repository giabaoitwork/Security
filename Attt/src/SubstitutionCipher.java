import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher {
    Map<Integer, String> key = new HashMap<>();
    public SubstitutionCipher() {
        new UseKey().readFile(key);
    }
    public String encrypt(String plainText) {
        String result = "";
        plainText = plainText.toUpperCase();

        for(int i = 0; i < plainText.length(); i++) {
            if(!inRange(plainText.charAt(i))) return "Enter only the words of the alphabet";
            else result += plainText.charAt(i) != ' ' ? key.get(plainText.charAt(i) - 65) : " ";
        }
        return result;
    }
    public String decrypt(String textEncrypted) {
        String result = "";
        for (int i = 0; i < textEncrypted.length(); i++) {
            if(!inRange(textEncrypted.charAt(i))) return "Enter only the words of the alphabet";
            else result += findMatchWord(String.valueOf(textEncrypted.charAt(i)));
        }
        return result;

    }
    public boolean inRange(char c) {
        if(c == 32) return true;
        return 65 <= c && c <= 90;
    }
    private String findMatchWord(String c) {
        if(c.equals(" ")) return " ";
        for (Integer i: key.keySet()) {
            if(key.get(i).equals(c)) return String.valueOf((char) (i + 65));
        }
        return " ";
    }
    public static void main(String[] args) {
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();
        System.out.println(substitutionCipher.encrypt("Dai hoc nong lam tphcm"));
        System.out.println(substitutionCipher.decrypt("QUX IGO PGPS EUL AHIOL"));
    }
}
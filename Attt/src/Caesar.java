public class Caesar {
    public String encrypt(String plainText, int distance) {
        String result = "";
        plainText = plainText.toUpperCase();
        distance = distance % 26;
        for (int i = 0; i < plainText.length(); i++) {
            if (!inRange(plainText.charAt(i))) return "Enter only the words of the alphabet";
            if (plainText.charAt(i) == ' ')
                result += " ";
            else
                result += plainText.charAt(i) + distance > 90 ? (char) (((plainText.charAt(i) + distance) % 90) + 64) : (char) (plainText.charAt(i) + distance);
            }
        return result;
    }
    public String decrypt(String textEncrypted, int distance) {
        String result = "";
        distance = distance % 26;
        for (int i = 0; i < textEncrypted.length(); i++) {
            if (!inRange(textEncrypted.charAt(i))) return "Enter only the words of the alphabet";
            if (textEncrypted.charAt(i) == ' ')
                result += " ";
            else
                result += textEncrypted.charAt(i) - distance < 65 ? (char) (91 - (65 % (textEncrypted.charAt(i) - distance))) : (char) (textEncrypted.charAt(i) - distance);
        }
        return result;
    }

    public boolean inRange(char c) {
        if(c == 32) return true;
        return 65 <= c && c <= 90;
    }

    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        System.out.println(caesar.encrypt("Dai hoc nong lam", 2));
        System.out.println(caesar.decrypt("FCK JQE PQPI NCO", 2));
    }
}

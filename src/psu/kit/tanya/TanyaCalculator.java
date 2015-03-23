package psu.kit.tanya;

public class TanyaCalculator {

    public TanyaReaction calculate(String s, String t) {

        int[] bigChar = new int[30];
        int[] smallChar = new int[30];
        int yayCount = 0;
        int whoopsCount = 0;


        for (int i = 0; i < t.length(); ++i) {
            char tchar = t.charAt(i);   //charAt- обращение к символу строки

            if (Character.isUpperCase(tchar)) {    //проверяет, записан ли символ в верхнем регистре
                bigChar[tchar - 'A']++;
            }
            if (Character.isLowerCase(tchar)) {    //определяет, записан ли символ в нижнем регистре;
                smallChar[tchar - 'a']++;
            }
        }

        StringBuilder sb = new StringBuilder(s);     //создаст string builder длиной 9 символов и емкостью 16:

        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            if (Character.isUpperCase(schar) && bigChar[schar - 'A'] > 0) {
                bigChar[schar - 'A']--;
                yayCount++;
                sb.setCharAt(i, '\0');
            }
            if (Character.isLowerCase(schar) && smallChar[schar - 'a'] > 0) {
                smallChar[schar - 'a']--;
                yayCount++;
                sb.setCharAt(i, '\0');
            }
        }

        s = sb.toString();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }

            if (Character.isUpperCase(ch) && bigChar[ch - 'A'] > 0) {
                bigChar[ch - 'A']--;
                whoopsCount++;
            }
            if (Character.isLowerCase(ch) && smallChar[ch - 'a'] > 0) {
                smallChar[ch - 'a']--;
                whoopsCount++;
            }
        }
        return new TanyaReaction(yayCount, whoopsCount);
    }
}

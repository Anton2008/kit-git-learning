package psu.kit.tanya;

public class TanyaCalculator {

    public TanyaReaction calculate(String s, String t) {

        int[] upperLetters = new int[26];
        int[] lowerLetters = new int[26];
        int wowCount = 0;
        int dohCount = 0;


        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);

            if (Character.isUpperCase(ch)) {
                ++upperLetters[ch - 'A'];
            }
            if (Character.isLowerCase(ch)) {
                ++lowerLetters[ch - 'a'];
            }
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch) && upperLetters[ch - 'A'] > 0) {
                upperLetters[ch - 'A']--;
                wowCount++;
                sb.setCharAt(i, '\0');
            }
            if (Character.isLowerCase(ch) && lowerLetters[ch - 'a'] > 0) {
                lowerLetters[ch - 'a']--;
                wowCount++;
                sb.setCharAt(i, '\0');
            }
        }

        s = sb.toString();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if(Character.isUpperCase(ch)) {
               ch = Character.toLowerCase(ch);
            } else if(Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }

            if (Character.isUpperCase(ch) && upperLetters[ch - 'A'] > 0) {
                upperLetters[ch - 'A']--;
                dohCount++;
            }
            if (Character.isLowerCase(ch) && lowerLetters[ch - 'a'] > 0) {
                lowerLetters[ch - 'a']--;
                dohCount++;
            }
        }
        return new TanyaReaction(wowCount, dohCount);
    }
}

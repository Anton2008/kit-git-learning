package psu.kit.tanya;

public class TanyaCalculator {

    public TanyaReaction calculate(String s, String t) {

        int whoopsCount = 0;
        int yayCount = 0;

        int[] countS = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                countS[c - 'A']++;
            } else countS[c - 'a' + 26]++;
        }

        int[] countT = new int[52];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (Character.isUpperCase(c)) {
                countT[c - 'A']++;
            } else countT[c - 'a' + 26]++;
        }

        for (int i = 0; i < 26; i++) {
            while (countS[i] > 0 && countT[i] > 0) {
                yayCount++;
                countS[i]--;
                countT[i]--;
            }
        }

        for (int i = 26; i < 52; i++) {

            while (countS[i] > 0 && countT[i] > 0) {
                yayCount++;
                countS[i]--;
                countT[i]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (countS[i] > 0 && countT[i + 26] > 0) {
                whoopsCount++;
                countS[i]--;
                countT[i + 26]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (countS[i + 26] > 0 && countT[i] > 0) {
                whoopsCount++;
                countS[i + 26]--;
                countT[i]--;
            }
        }

        return new TanyaReaction(yayCount, whoopsCount);
    }
}
package psu.kit.tanya;

public class TanyaCalculator {

    public TanyaReaction calculate(String s, String t) {

        int whoopsCount = 0;
        int yayCount = 0;

        int[] countT = new int[52];
        int[] countS = new int[52];

        countLetters(countS, s);
        countLetters(countT, t);

        for (int i = 0; i < 26; i++) {
            while (countS[i] > 0 && countT[i] > 0) {
                yayCount++;
                countS[i]--;
                countT[i]--;
            }
            while (countS[i + 26] > 0 && countT[i + 26] > 0) {
                yayCount++;
                countS[i + 26]--;
                countT[i + 26]--;
            }
            while (countS[i] > 0 && countT[i + 26] > 0) {
                whoopsCount++;
                countS[i]--;
                countT[i + 26]--;
            }
            while (countS[i + 26] > 0 && countT[i] > 0) {
                whoopsCount++;
                countS[i + 26]--;
                countT[i]--;
            }
        }

        return new TanyaReaction(yayCount, whoopsCount);
    }

    private int convertLetterToIndex(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A';
        } else {
            return c - 'a' + 26;
        }
    }

    private void countLetters(int[] a, String s){
        for (int i = 0; i < s.length(); i++){
            a[convertLetterToIndex(s.charAt(i))]++;
        }
    }

}
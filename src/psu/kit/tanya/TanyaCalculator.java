package psu.kit.tanya;

public class TanyaCalculator {

    public int magicConst = 26;
    public TanyaReaction calculate(String s, String t) {

        int whoopsCount = 0;
        int yayCount = 0;

        int[] countT = new int[magicConst * 2];
        int[] countS = new int[magicConst * 2];

        countLetters(countS, s);
        countLetters(countT, t);

        for (int i = 0; i < magicConst; i++) {
            while (countS[i] > 0 && countT[i] > 0) {
                yayCount++;
                countS[i]--;
                countT[i]--;
            }
            while (countS[i + magicConst] > 0 && countT[i + magicConst] > 0) {
                yayCount++;
                countS[i + magicConst]--;
                countT[i + magicConst]--;
            }
            while (countS[i] > 0 && countT[i + magicConst] > 0) {
                whoopsCount++;
                countS[i]--;
                countT[i + magicConst]--;
            }
            while (countS[i + magicConst] > 0 && countT[i] > 0) {
                whoopsCount++;
                countS[i + magicConst]--;
                countT[i]--;
            }
        }

        return new TanyaReaction(yayCount, whoopsCount);
    }

    private int convertLetterToIndex(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A';
        } else {
            return c - 'a' + magicConst;
        }
    }

    private void countLetters(int[] a, String s) {
        for (int i = 0; i < s.length(); i++) {
            a[convertLetterToIndex(s.charAt(i))]++;
        }
    }

}
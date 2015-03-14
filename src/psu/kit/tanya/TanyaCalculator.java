package psu.kit.tanya;

public class TanyaCalculator {

    public int MinValue(int a, int b) {
        return (a > b) ? b : a;
    }

    public TanyaReaction calculate(String s, String t) {

        int yay = 0;
        int woow = 0;

        int[] Up_S = new int[26];
        int[] Low_S = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) Up_S[ch % 26]++;
            else Low_S[(ch - 6) % 26]++;
        }

        int[] Up_T = new int[26];
        int[] Low_T = new int[26];

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (Character.isUpperCase(ch)) Up_T[ch % 26]++;
            else Low_T[(ch - 6) % 26]++;
        }

        for (int i = 0; i < 26; i++) {
            int c = MinValue(Low_S[i], Low_T[i]);
            yay += c;
            Low_S[i] -= c;
            Low_T[i] -= c;

            c = MinValue(Up_S[i], Up_T[i]);
            yay += c;
            Up_S[i] -= c;
            Up_T[i] -= c;
        }

        for (int i = 0; i < 26; i++) {
            int c = MinValue(Low_S[i], Up_T[i]);
            woow += c;
            Low_S[i] -= c;
            Up_T[i] -= c;

            c = MinValue(Up_S[i], Low_T[i]);
            woow += c;
            Up_S[i] -= c;
            Low_T[i] -= c;

        }


        return new TanyaReaction(yay, woow);
    }
}
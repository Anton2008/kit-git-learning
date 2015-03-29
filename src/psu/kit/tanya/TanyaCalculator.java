package psu.kit.tanya;

public class TanyaCalculator {

    public TanyaReaction calculate(String s, String t) {
        int yay = 0, whoops = 0;
        int[] T = new int[60];
        String S = s, tmp = "";

        for (int i = 0; i < T.length; i++) {
            T[i] = 0;
        }

        for (int i = 0; i < t.length(); i++) {
            T[t.charAt(i) % 60]++;
        }

       for (int i = 0; i < S.length(); i++) {
            if (T[S.charAt(i)%60] > 0) {
                yay++;
                T[S.charAt(i)%60]--;
                //S=S.substring(0,i)+S.substring(i+1);
                //i--;
            } else {
                tmp += (Character.isUpperCase(S.charAt(i)))? Character.toLowerCase(S.charAt(i)):Character.toUpperCase(S.charAt(i));
            }
        }
        S = tmp;
        for (int i = 0; i < S.length(); i++) {
                if (T[S.charAt(i)%60] > 0) {
                    whoops++;
                    T[S.charAt(i)%60]--;
                }
        }
        return new TanyaReaction(yay, whoops);
    }
}

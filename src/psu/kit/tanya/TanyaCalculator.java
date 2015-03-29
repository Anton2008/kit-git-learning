package psu.kit.tanya;

public class TanyaCalculator {

    public TanyaReaction calculate(String s, String t) {
        int yay = 0, whoops = 0;
        int[] tArray = new int[60];
        String str = s, tmp = "";

        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = 0;
        }

        for (int i = 0; i < t.length(); i++) {
            tArray[t.charAt(i)-'A']++;
        }

       for (int i = 0; i < str.length(); i++) {
            if (tArray[str.charAt(i) - 'A'] > 0) {
                yay++;
                tArray[str.charAt(i) - 'A']--;
            } else {
                tmp += (Character.isUpperCase(str.charAt(i)))? Character.toLowerCase(str.charAt(i)):Character.toUpperCase(str.charAt(i));
            }
        }
        str = tmp;
        for (int i = 0; i < str.length(); i++) {
                if (tArray[str.charAt(i) - 'A'] > 0) {
                    whoops++;
                    tArray[str.charAt(i) - 'A']--;
                }
        }
        return new TanyaReaction(yay, whoops);
    }
}

package psu.kit.tanya;

import java.util.Hashtable;
import java.util.Map;

public class TanyaCalculator {

    public TanyaReaction calculate(String s, String t) {

        int yay = 0;
        int whoops = 0;
        int i = 0;
        char[] sCopy = s.toCharArray();
        char[] tCopy = t.toCharArray();

        int lenT = tCopy.length;
        int lenS = sCopy.length;

        Map<Character, Integer> map = new Hashtable<Character, Integer>();

        while (i < lenT) {
            map.put(tCopy[i], map.getOrDefault(tCopy[i], 0) + 1);
            ++i;
        }
        i = 0;
        while (i < lenS) {
            if (map.get(sCopy[i]) != null && map.get(sCopy[i]) > 0) {
                ++yay;
                map.put(sCopy[i], map.get(sCopy[i]) - 1);
                sCopy[i] = '_';
            }
            ++i;
        }
        i = 0;
        while (i < lenS) {
            Character a = Character.isUpperCase(sCopy[i]) ? Character.toLowerCase(sCopy[i]) : Character.toUpperCase(sCopy[i]);
            if (map.get(a) != null && map.get(a) > 0) {
                ++whoops;
                map.put(a, map.get(a) - 1);
            }
            ++i;
        }

        return new TanyaReaction(yay, whoops);

    }
}

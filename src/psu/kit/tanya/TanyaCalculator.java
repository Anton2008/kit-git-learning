package psu.kit.tanya;

import java.util.Hashtable;
import java.util.Map;

public class TanyaCalculator {

<<<<<<< HEAD

    public TanyaReaction calculate(String s, String t) {

        int yay=0;
        int whoops=0;
        int i=0;
        char[] sCopy=s.toCharArray();
        char[] tCopy=t.toCharArray();

        int lenT=tCopy.length;
        int lenS=sCopy.length;

        Map<Character,Integer> map=new Hashtable<Character,Integer>();

        while (i<lenT){
            map.put(tCopy[i],0);
            ++i;
        }
        i=0;
        while (i<lenT){
            map.put(tCopy[i],map.get(tCopy[i])+1);
            ++i;
        }
        i=0;
        while (i<lenS){
            if(map.get(sCopy[i])!=null && map.get(sCopy[i])>0){
                ++yay;
                map.put(sCopy[i],map.get(sCopy[i])-1);
                sCopy[i]='_';
            }
            ++i;
        }
        i=0;
        while (i<lenS){
            Character a=Character.isUpperCase(sCopy[i]) ? Character.toLowerCase(sCopy[i]):Character.toUpperCase(sCopy[i]);
            if(map.get(a)!=null && map.get(a)>0){
                ++whoops;
                map.put(a,map.get(a)-1);
            }
            ++i;
        }

        return new TanyaReaction(yay,whoops);
=======
     public TanyaReaction calculate(String s, String t) {
        String tCopy =t;
        String sCopy=s;
        int lenS=sCopy.length();
        int yay=0;
        int whoops=0;
        while(lenS>0) {
            if (tCopy.indexOf(sCopy.charAt(0))!=-1) {
                ++yay;
                tCopy = tCopy.replaceFirst(String.valueOf(sCopy.charAt(0)),"");
                sCopy=sCopy.replaceFirst(String.valueOf(sCopy.charAt(0)),"");
                --lenS;
            } else{

                String sCharacter=String.valueOf(sCopy.charAt(0));
                int indexForYay=Character.isLowerCase(sCopy.charAt(0)) ? sCopy.indexOf(sCharacter.toUpperCase()):sCopy.indexOf(sCharacter.toLowerCase());
                if((indexForYay!=-1)&&(tCopy.indexOf(sCopy.charAt(indexForYay))!=-1)){
                    ++yay;
                    tCopy=tCopy.replaceFirst(String.valueOf(sCopy.charAt(indexForYay)),"");
                    sCopy=sCopy.replaceFirst(String.valueOf(sCopy.charAt(indexForYay)),"");
                    --lenS;
                } else {
                    sCharacter=Character.isUpperCase(sCopy.charAt(0)) ? sCharacter.toLowerCase():sCharacter.toUpperCase();
                    if(tCopy.indexOf(sCharacter)!=-1){
                        ++whoops;
                        tCopy=tCopy.replaceFirst(String.valueOf(sCharacter),"");
                    }
                    sCopy=sCopy.replaceFirst(String.valueOf(sCopy.charAt(0)),"");
                    --lenS;
                }
            }
        }
        TanyaReaction reactor=new TanyaReaction(yay,whoops);
        return reactor;
>>>>>>> 2abd8c1b96922b42f4823ed4ac903b11e5f3308b
    }
}

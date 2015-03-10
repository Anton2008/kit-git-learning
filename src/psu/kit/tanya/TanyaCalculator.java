package psu.kit.tanya;

public class TanyaCalculator {

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
        reactor=new TanyaReaction(yay,whoops);
        return reactor;
    }
}

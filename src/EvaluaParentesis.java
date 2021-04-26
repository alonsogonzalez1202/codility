import java.util.HashMap;
import java.util.Map;

public class EvaluaParentesis {
    static Map<Character, Character> pairs = new HashMap<Character, Character>();

    public static void main(String[] args) {
        Map<Character, Character> pairs = getCharacterCharacterMap();
        String sentence = "[[(21 + 1) + [1 + 1]]]";
        if(isCorrect(sentence)){
            System.out.println(sentence  + " is a valid expression");
        } else{
            System.out.println(sentence  + " is an invalid expression");
        }
    }

    static boolean isCorrect(String s){
        boolean flag = true;
        System.out.println("The original sentence: " + s);

        s = s.replaceAll("[0-9]","");
        s = s.replaceAll("[a-zA-Z\\s]","");
        s = s.replaceAll("\\+","");

        while(s.length() > 0){
            System.out.println("The clean sentence: " + s);
            int index =  s.indexOf(pairs.get(s.charAt(0))) + 1;
            String s2 = s.substring(index);

            if(index < s.length() - 1){
                s =  s.substring(0, index);
            }else{
                flag = false;
            }
            char[] theArray = s.toCharArray();
            System.out.println("The clean sentence block: " + s);
            flag = isFlag(theArray);
            s = s2;
        }


        return flag;
    }

    private static boolean isFlag(char[] theArray) {
        boolean flag = true;
        if(theArray.length%2 == 0){
        for(int i = 0, j = theArray.length - 1; i < theArray.length / 2; i++, j--){
                if(theArray[j] != pairs.get(theArray[i])){
                    System.out.println(theArray[j] + " --> " + pairs.get(theArray[i]));
                    flag = false;
                    break;
                }
            }
        }else{
            flag = false;
        }
        return flag;
    }

    private static Map<Character, Character> getCharacterCharacterMap() {

        pairs.put('[',']');
        pairs.put('{','}');
        pairs.put('(',')');
        return pairs;
    }
}

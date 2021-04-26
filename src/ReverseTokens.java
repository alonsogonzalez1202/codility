import java.util.*;
import java.util.StringTokenizer;

public class ReverseTokens {

    public static void main(String[] args) {
       String sent = " this is a good day   ";
       String r =  reverseSentence(sent);
       System.out.println(r);
    }

    private static String reverseSentence(String sentence)    {
        StringTokenizer st = new StringTokenizer(sentence);
        int size = st.countTokens();
        String arr[] = new String[size];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i++] = st.nextToken();
        }
        for (int j = size - 1; j >= 0; j--) {
           sb.append(arr[j] + " ");
        }

    return sb.toString().trim();
    }
}

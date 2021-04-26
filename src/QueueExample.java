import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QueueExample {

    static HashMap<Character, Character> pairs = new HashMap<Character, Character>();

    public static void main(String[] args) {
        String sentence = "[{[2{()]}]";
        initMap();
        System.out.println(solution(sentence) ? "Si" : "No");
    }

    static boolean solution(String s){
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();
        boolean result = (s != null);

        if(result){
            queue = arrayToQueue(s);
            result = queue.size()%2==0;

            if(result) {
                while (queue.size() > 0) {
                    Character head = queue.poll();
                    if (isTheComplement(stack, head)) {
                        stack.pop();
                    } else {
                        stack.push(head);
                    }
                }
                result = stack.isEmpty();
            }
        }
        return result;
    }

    private static Queue<Character> arrayToQueue(String s) {
        Queue<Character> queue = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c) || pairs.containsValue(c)) {
                queue.add(c);
            }
        }
        printQueue(queue);
        return queue;
    }

    private static void printQueue(Queue<Character> queue) {
        queue.stream().forEach(s -> System.out.print(s + " "));
    }

    private static boolean isTheComplement(Stack<Character> stack, Character head) {
        boolean flag;
        if(stack!= null && stack.size() > 0){
            flag = head.equals(pairs.get(stack.peek()));
        }else{
            flag = false;
        }
        return flag;
    }

    private static Map<Character, Character> initMap() {

        pairs.put('[',']');
        pairs.put('{','}');
        pairs.put('(',')');
        return pairs;
    }
}

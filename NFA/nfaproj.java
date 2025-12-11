package NFA;
import java.util.*;

public class nfaproj {static Map<String, Map<Character, Set<String>>> nfa = new HashMap<>();
    static {
        nfa.put("q0", new HashMap<>());
        nfa.put("q1", new HashMap<>());
        nfa.put("q2", new HashMap<>());
        nfa.get("q0").put('a', new HashSet<>(Arrays.asList("q0", "q1")));
        nfa.get("q0").put('b', new HashSet<>(Arrays.asList("q0")));
        nfa.get("q1").put('b', new HashSet<>(Arrays.asList("q2")));
        nfa.get("q1").put('a', new HashSet<>()); 
        nfa.get("q2").put('a', new HashSet<>(Arrays.asList("q2")));
        nfa.get("q2").put('b', new HashSet<>(Arrays.asList("q2")));
    } public static boolean accepts(String input) {
        Set<String> startStates = new HashSet<>(Arrays.asList("q0"));
        Set<String> resultStates = process(startStates, input, 0);
        return resultStates.contains("q2");
    }
    private static Set<String> process(Set<String> currentStates, String input, int index) {
        if (index == input.length()) {
            return currentStates;
        }
        char symbol = input.charAt(index);
        Set<String> nextStates = new HashSet<>();

        for (String state : currentStates) {
            if (nfa.get(state).containsKey(symbol)) {
                nextStates.addAll(nfa.get(state).get(symbol));
            }
        }
        return process(nextStates, input, index + 1);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Input (type 'exit' to quit): ");
            String input = sc.next().trim(); 
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }
            if (accepts(input)) {
                System.out.println("Output: Accepted\n");
            } else {
                System.out.println("Output: Rejected\n");
            }
        }
        sc.close();
    }
}

import java.util.*;

public class dfa {
    enum state {Q0, Q1,Q2}
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)){
            while (true) {
                System.out.println("Enter a binary string(type 'done' to exit):");
                String input = scan.nextLine().trim(); 
                
                if (input.equalsIgnoreCase("done")){
                    System.out.println("Exiting the program. Bye.");break;
            
                }
                if (!input.matches("[01]*")){
                    System.out.println("Invalid input. Only enter 0s and 1s.");
                    continue;

                }
            state currentstate = state.Q0;

            for (char symbol: input.toCharArray()){
                switch (currentstate){
                    case Q0:
                        currentstate = (symbol == '0') ? state.Q1 : state.Q0; break;
                    case Q1:
                        currentstate = (symbol == '0') ? state.Q1 : state.Q2;break;
                    case Q2:
                        currentstate = (symbol == '0') ? state.Q1 : state.Q0;break;
                        
                }
            }
            if (currentstate == state.Q2){
                System.out.println("Accepted");
            } else{
                System.out.println("Rejected");
            }
            System.out.println();
            }
        }
    }
    
}

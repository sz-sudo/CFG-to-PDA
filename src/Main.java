import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String temp;
        ArrayList<String> grammar = new ArrayList<String>();
        ArrayList<String> trans = new ArrayList<String>();
        ArrayList<Character> terminals = new ArrayList<Character>();
        Stack<Character> stk = new Stack<>();
        stk.push('$');
        //stk.push('S');

        System.out.println("Please enter the production rules and enter '-' when you are done:");
        temp = sc.nextLine();

        while (!temp.equals("-")) {
            grammar.add(temp);
            temp = sc.nextLine();
        }

        CFGtoPDA.CFGtoPDAconverter(grammar, trans, temp, terminals);


        System.out.println();
        System.out.println("The transition functions of the PDA:");
        for (String x : trans)
            System.out.println(x);


        String input = "";
        String push = "S";

        System.out.println();
        System.out.println("Please enter a string to see if it belongs to the PDA:");
        String check = sc.nextLine();

        Parser.stringCheck(stk, grammar, check, input, push);

        System.out.println("This String DOES NOT belong to the PDA");

    }

}


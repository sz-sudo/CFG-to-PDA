import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    public static void stringCheck(Stack<Character> stk, ArrayList<String> grammar, String check, String input, String push) {
        String sb;
        String[] sp;
        int popPush = 0;

        if (input.length() > 100)
            return;

        for (int j = push.length() - 1; j >= 0; j--) {
            stk.push(push.charAt(j));
        }


        if (Character.isLowerCase(stk.peek())) {

            input += stk.pop();
            popPush++;


            if (input.charAt(input.length() - 1) != check.charAt(input.length() - 1)) {
                for (int i = 0; i < push.length() - popPush; i++) {
                    stk.pop();
                }
                return;
            }

            if (input.equals(check)) {

                if (stk.peek() == '$') {
                    System.out.println("This string belongs to the PDA");
                    System.exit(0);
                } else {

                    for (int i = 0; i < push.length() - popPush; i++) {
                        stk.pop();
                    }
                    return;
                }

            }
        }


        for (String x : grammar) {

            if (x.charAt(0) == stk.peek()) {

                stk.pop();

                sb = x.substring(4);

                sp = sb.split("\\|");

                for (String y : sp) {

                    y = y.replaceAll("\\s", "");


                    stringCheck(stk, grammar, check, input, y);
                }
                stk.push(x.charAt(0));
            }

        }


        for (int i = 0; i < push.length() - popPush; i++) {
            stk.pop();
        }
        return;
    }
}

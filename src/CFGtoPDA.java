import java.util.ArrayList;

public class CFGtoPDA {
    public static void CFGtoPDAconverter(ArrayList<String> grammar, ArrayList<String> trans, String temp, ArrayList<Character> terminals) {

        for (int i = 0; i < grammar.size(); i++) {
            temp = grammar.get(i);
            String[] split = temp.split("\\|");
            split[0] = split[0].split("→")[1];

            String output = "δ(q, λ, " + temp.charAt(0) + ") = {";
            for (int j = 0; j < split.length; j++) {
                if (j != split.length - 1)
                    output += "(q, " + split[j].replaceAll("\\s", "") + ")" + " | ";
                else
                    output += "(q, " + split[j].replaceAll("\\s", "") + ")" + "}";
            }
            trans.add(output);
        }

        for (int i = 0; i < grammar.size(); i++) {
            temp = grammar.get(i);
            String output = "";
            for (int j = 0; j < temp.length(); j++) {
                boolean isNew = false;
                if (Character.isLowerCase(temp.charAt(j)) && temp.charAt(j) != 'λ') {
                    isNew = true;
                    for (int k = 0; k < terminals.size(); k++) {
                        if (temp.charAt(j) == terminals.get(k)) {
                            isNew = false;
                            break;
                        }
                    }
                }
                if (isNew == true) {
                    terminals.add(temp.charAt(j));
                    output = "δ(q, " + temp.charAt(j) + ", " + temp.charAt(j) + ") = {(q, λ)}";
                    trans.add(output);
                }
            }

        }
    }
}

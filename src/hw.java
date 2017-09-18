import java.io.*;
import java.util.*;
public class hw {

    public static void main(String[] args) throws Exception{

        if(args.length == 0){
            System.out.println("No argument found");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("The file " + args[0] + " does not exist");
            System.exit(1);
        }

        Stack<Character> symbols = new Stack<>();
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String line = input.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') {
                    symbols.push(ch);
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    findSymbols(symbols, ch);
                }
            }
        }
    }

        private static void findSymbols(Stack<Character> stack, Character ch) {
            if ((stack.peek() == '(' && ch == ')') ||
                    (stack.peek() == '[' && ch == ']') ||
                    (stack.peek() == '{' && ch == '}')) {
                stack.pop();
            }
            else if ((stack.peek() != '(' && ch == ')') ||
                    (stack.peek() != '[' && ch == ']') ||
                    (stack.peek() != '{' && ch == '}')) {
                System.out.println("Your code's symbols are invalid");
                System.exit(1);
            }
        }



}

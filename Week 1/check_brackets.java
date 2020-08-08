import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {

    static boolean Match(char c, char type) {
        if (type == '[' && c == ']')
            return true;
        if (type == '{' && c == '}')
            return true;
        if (type == '(' && c == ')')
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        int flag = 1, pos = 0;

        Stack<Character> opening_brackets_stack = new Stack<Character>();
        Stack<Integer> posi = new Stack<Integer>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(next);
                posi.push(position);
            }

            if (next == ')' || next == ']' || next == '}') {

                if (!opening_brackets_stack.empty()) {
                    char top = opening_brackets_stack.peek();
                    Boolean match = Match(next, top);
                    if (match) {
                        opening_brackets_stack.pop();
                        posi.pop();
                    } else {
                        pos = position;
                        flag = 0;
                        break;
                    }
                }

                else{
                    pos = position;
                    flag = 0;
                    break;
                }

                pos = position;
            }
        }

        if(flag == 0){
            System.out.println(pos+1);
        }
        else if (!opening_brackets_stack.empty()) {
            System.out.println(posi.pop()+1);
        }

        else {
            System.out.println("Success");
        }

    }
}

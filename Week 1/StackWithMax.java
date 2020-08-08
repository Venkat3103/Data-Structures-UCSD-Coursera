import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> MAXstack = new Stack<Integer>();
        

        for (int qi = 0; qi < queries; ++qi) {

            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                if (qi==0) {
                    MAXstack.push(value);
                    stack.push(value);
                }
                else{
                    stack.push(value);
                    if(value>MAXstack.peek()){
                        MAXstack.push(value);
                    }
                    else{
                        MAXstack.push(MAXstack.peek());
                    }
                }
                
                
            } else if ("pop".equals(operation)) {
                stack.pop();
                MAXstack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(MAXstack.peek());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}

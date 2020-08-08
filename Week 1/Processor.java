import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Processor {

    public static void main(String args[]) {
        Queue<Integer> finish = new LinkedList<Integer>();
        Stack<Integer> start = new Stack<Integer>();
        Stack<Integer> fin = new Stack<Integer>();

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int size = 0;

        for (int i = 0; i < n; i++) {
            int flag = 1;
            int ai = sc.nextInt();
            int pi = sc.nextInt();

            if (i == 0) {
                start.push(ai);
                finish.add(ai + pi);
                fin.push(ai + pi);
                size++;
                System.out.println(ai);
            }

            else {
                if (size < s) {
                    int temp = Math.max(fin.peek(), ai);
                    start.push(temp);
                    finish.add(temp + pi);
                    fin.push(temp + pi);
                    size++;
                    System.out.println(temp);
                }

                else if (finish.peek() <= ai) {
                    finish.remove();
                    int temp = Math.max(fin.peek(), ai);
                    start.push(temp);
                    finish.add(temp + pi);
                    fin.push(temp + pi);
                    System.out.println(temp);

                } else {
                    System.out.println("-1");
                }
            }

        }

    }

}

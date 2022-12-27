import java.util.Stack;

public class LC394 {
    /**
     * 不是真394 而是394变形
     * @param args
     */
    public static void main(String[] args) {
        String res = "";
        //String input="(ab(d){3}){2}";
        //String input="(ab){3}(cd){2}";
        String input = "(ab(c){3}d){2}";
        Stack<String> stack = new Stack<>();
        char[] chars = input.toCharArray();
        int index = 0;
        while (index < chars.length) {
            char c = chars[index];
            if (Character.isLetter(c) || c == ')') {
                String s = stack.pop();
                s += c;
                stack.push(s);
                index++;
            } else if (c == '(') {
                stack.push(String.valueOf(c));
                index++;
            } else {
                int num = chars[index + 1] - '0';
                String s = stack.pop();
                s = s.substring(1, s.length() - 1);
                String sSum = "";
                for (int i = 0; i < num; i++) {
                    sSum += s;
                }
                if (!stack.isEmpty()) {
                    String tmp = stack.peek();
                    if (tmp.charAt(tmp.length() - 1) != ')') {
                        tmp += sSum;
                        stack.pop();
                        stack.push(tmp);
                    }
                } else {
                    res += sSum;
                }
                index += 3;
            }
        }
        System.out.println(res);
    }
}

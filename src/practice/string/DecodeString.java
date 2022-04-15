package practice.string;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder digit = new StringBuilder();
        StringBuilder internalStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean flag = Character.isDigit(ch);
            if (flag) {
                if (internalStr.length() > 0) {
                    if (!st.isEmpty() && isAlphabetsOnly(st.peek())) st.push(st.pop() + internalStr);
                    else st.push(internalStr.toString());
                    internalStr = new StringBuilder();
                }
                digit.append(ch);
            } else if (ch == '[') {
                if (digit.length() > 0) {
                    st.push(digit.toString());
                    digit = new StringBuilder();
                }
                st.push("[");
            } else if (ch == ']') {
                if (internalStr.length() > 0) {
                    st.push(internalStr.toString());
                    internalStr = new StringBuilder();
                }
                StringBuilder existingStackStr = new StringBuilder();
                while (isAlphabetsOnly(st.peek())) existingStackStr.insert(0, st.pop());
                st.pop();
                int freq = Integer.parseInt(st.pop());
                StringBuilder res = new StringBuilder();
                for (int j = 0; j < freq; j++) res.append(existingStackStr);
                st.push(res.toString());
            } else {
                internalStr.append(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) result.insert(0, st.pop());
        result.append(internalStr);
        System.out.println(result);
        return result.toString();
    }

    private boolean isAlphabetsOnly(String str) {
      str = str.toLowerCase();
      char[] charArray = str.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
         char ch = charArray[i];
         if (!(ch >= 'a' && ch <= 'z')) return false;
      }
      return true;
   }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        String s4 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s5 = "leetcode";
        DecodeString dc = new DecodeString();
        String decodedResult1 = dc.decodeString(s1);
        String decodedResult2 = dc.decodeString(s2);
        String decodedResult3 = dc.decodeString(s3);
        String decodedResult4 = dc.decodeString(s4);
        String decodedResult5 = dc.decodeString(s5);
        System.out.println(s1 + " is equal: " + decodedResult1.equalsIgnoreCase("aaabcbc"));
        System.out.println(s2 + " is equal: " + decodedResult2.equalsIgnoreCase("accaccacc"));
        System.out.println(s3 + " is equal: " + decodedResult3.equalsIgnoreCase("abcabccdcdcdef"));
        System.out.println(s4 + " is equal: " + decodedResult4.equalsIgnoreCase("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
        System.out.println(s5 + " is equal: " + decodedResult5.equalsIgnoreCase("leetcode"));
    }
}

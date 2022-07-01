import java.util.*;
import java.io.*;
public class BalParen {
    public static boolean isBalanced(String s)
    {
        Stack<Character>st=new Stack<>();
        if(s.equals(""))
            return true;
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(c=='[' || c=='{' || c=='(')
                st.push(c);
            else if(c==')' && st.peek()!='(')return false;
            else if(c=='}' && st.peek()!='{')return false;
            else if(c==']' && st.peek()!='[')return false;
            else
                st.pop();

        }
        return st.isEmpty();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(isBalanced(s)==true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
}

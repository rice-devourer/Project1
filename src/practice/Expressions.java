package practice;

import dataStructures.SArrayList;
import dataStructures.SArrayStack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Expressions {

    public static void main(String[] args) {
        /*
        System.out.println(evaluatePostfix("1 2 3 + * 4 -"));
        System.out.println(balanceBrackets("[ ( ] )"));
        System.out.println(balanceBrackets("[ ( )"));
        System.out.println(balanceBrackets("( ) ]"));
        System.out.println(balanceBrackets("[ ( ) ]"));
         */
        String infix = "1 + 2 * ( 3 + ( 5 - 1 ) )";
        System.out.println("----------------");
        String postfix = infixToPostfix(infix);
        System.out.println("----------------");
        System.out.println(infix);
        System.out.println(postfix);
        System.out.println(evaluatePostfix(postfix));
    }
    /**
     * Example
     * "1 2 3 + * 4 -"
     * = 1
     */

    /**
     * For every operator or operand
     *      If it is a operand
     *          Push it to the stack
     *      If it is a operator
     *          Pop from the stack twice, and perform the operation
     *              If there are less than 2 elements on the stack, the expression is invalid
     *          Push the result to the stack
     *      If there are more than one element on the stack, the expression is invalid
     *      Return the last item on the stack, this is the result
     */
    public static HashMap<String, BiFunction<Integer, Integer, Integer>> OPERATORS = new HashMap<>();
    static {
        OPERATORS.put("+", (a,b) -> b+a);
        OPERATORS.put("-", (a,b) -> b-a);
        OPERATORS.put("*", (a,b) -> b*a);
        OPERATORS.put("/", (a,b) -> b/a);
        OPERATORS.put("^", (a,b) -> (int) Math.pow(b,a));
    }

    public static int evaluatePostfix(String express){
        String[] s = express.split(" ");
        int length = s.length;
        int i = 0;
        SArrayStack<Integer> stack = new SArrayStack<>();
        for (String str : s){
            stack.print();
            if(OPERATORS.containsKey(str)){
                try {
                    stack.push(OPERATORS.get(str).apply(stack.pop(),stack.pop()));
                } catch(NullPointerException e) {
                    throw new IllegalArgumentException("Insufficient Operands");
                }
            }
            else{
                try {
                    stack.push(Integer.valueOf(str));
                } catch (IllegalArgumentException e) {
                    System.out.println("String causing error is: " + str);
                    throw new IllegalArgumentException("Invalid Operand");
                }
            }
        }
        if (stack.size()!=1){
            stack.print();
            throw new IllegalArgumentException("Invalid Operand");
        }
        return stack.pop();
    }

    /**
     * Return true if the expression has balanced bracket and false otherwise
     * Brackets can be [], {}, (), each bracket must be closed by their corresponding closing bracket for the expr to be balanced
     * All operands, operators, and brackets are space separated
     */
    // [ ( ] )  INVALID, Bracket mismatch
    // [ ( )    INVALID, Missing closing bracket
    // ( ) ]    INVALID, Missing opening bracket
    // [ ( ) ]  VALID
    public static HashMap<String, Integer> BRACKET_HASHMAP = new HashMap<>();
    static{
        BRACKET_HASHMAP.put("(",1);
        BRACKET_HASHMAP.put("{",2);
        BRACKET_HASHMAP.put("[",3);
        BRACKET_HASHMAP.put(")",4);
        BRACKET_HASHMAP.put("}",5);
        BRACKET_HASHMAP.put("]",6);
    }

    public static boolean balanceBrackets(String expr) {

        SArrayStack<String> stack = new SArrayStack<>();
        String[] strArray = expr.split(" ");
        for (String s : strArray){
            stack.print();
            if(BRACKET_HASHMAP.containsKey(s)){
                int type = BRACKET_HASHMAP.get(s);
                if (type<4) {
                    stack.push(s);
                } else{
                    if(stack.size()==0){return false;}
                    int temp = BRACKET_HASHMAP.get(stack.pop());
                    System.out.println(temp);
                    System.out.println(type);
                    if(type-temp!=3){
                        return false;
                    }
                }
            }
        }
        if(stack.size()!=0){return false;}
        return true;
    }

    /**
     * Accepts a infix expression and returns the postfix equivalent
     * @param infix
     * @return
     */
    public static HashMap<String, Integer> VALUE = new HashMap<>();
    static {
        VALUE.put("+", 0);
        VALUE.put("-", 0);
        VALUE.put("*", 1);
        VALUE.put("/", 1);
        VALUE.put("^", 2);
    }

    public static boolean checkIfInt(String x){
        try {
            Integer.valueOf(x);
        } catch (NumberFormatException E){
            return false;
        }
        return true;
    }


    public static String infixToPostfix(String infix) {
        SArrayStack<String> stack = new SArrayStack<>();
        String[] strArray = infix.split(" ");
        String current = "";
        for (String s : strArray){
            if (checkIfInt(s)){
                current+=s;
                current+= " ";
            }
            else if(s.equals("(")){
                stack.push(s);
            }
            else if(s.equals(")")){
                while(!stack.isEmpty() && !(stack.peek().equals("("))){
                    current+= stack.pop();
                    current+= " ";
                }
                stack.pop();
            }
            else{
                System.out.println(s);
                System.out.println(stack.peek());
                while(!stack.isEmpty() && !(stack.peek().equals("(")) && VALUE.get(s)<=VALUE.get(stack.peek())){
                    current+=stack.pop();
                    current+= " ";
                }
                stack.push(s);
            }
        }
        while(!stack.isEmpty()){
            current+=stack.pop();
            current+= " ";
        }

        return current;
    }
}

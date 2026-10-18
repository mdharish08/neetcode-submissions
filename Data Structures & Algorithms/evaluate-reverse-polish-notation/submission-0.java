class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> st = new Stack<>();
        List<String> operands = Arrays.asList("*", "/","+","-");
        for(String s : tokens){
            if(operands.contains(s)){
                int operand2 = st.pop() , operand1 = st.pop();
                if(s.equals("+")){
                    st.push(operand1 + operand2);
                }else if(s.equals("-")){
                    st.push(operand1 - operand2);
                }else if(s.equals("*")){
                    st.push(operand1 * operand2);
                }else{
                    st.push(operand1 / operand2);
                }
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}

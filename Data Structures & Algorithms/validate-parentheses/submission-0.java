class Solution {
    public boolean isValid(String s) {
         Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }else {
                if (st.isEmpty()) {
                    return false;
                }
                char cha = st.pop();
                if((c == ')' && cha != '(') || (c == ']' && cha != '[') || (c == '}' && cha != '{') ){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}

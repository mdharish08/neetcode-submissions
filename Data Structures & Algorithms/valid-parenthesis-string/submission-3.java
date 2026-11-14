class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == '*'){
               star.push(i);
            }else if(s.charAt(i) == ')'){
                if(st.isEmpty()){
                   if(star.isEmpty()){
                     return false;
                   }
                   star.pop();
                }else{
                   st.pop();
                }
            }else {
                st.push(i);
            }
        }

        while(!st.isEmpty()){
            if(star.isEmpty() || star.peek() < st.peek()){
                return false;
            }
            star.pop();
            st.pop();
        }

        return st.isEmpty();
    }
}

class Solution {
    private static final Map<Character, String> MAP = Map.of(
    '2', "abc",
    '3', "def",
    '4', "ghi",
    '5', "jkl",
    '6', "mno",
    '7', "pqrs",
    '8', "tuv",
    '9', "wxyz"
);

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        findLetterCombinations(0,digits,new StringBuilder(),ans);
        return ans;
    }

    private void findLetterCombinations(int index,String digits,StringBuilder sb,List<String> ans){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String val = MAP.get(c);

        for(int i = 0 ; i < val.length(); i++){
            char cur = val.charAt(i);
            sb.append(cur);
            findLetterCombinations(index + 1,digits,sb,ans);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}

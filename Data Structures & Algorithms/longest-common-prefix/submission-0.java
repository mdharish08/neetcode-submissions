class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = 0;
        int maxiLength = Integer.MAX_VALUE;
        for(int i = 0 ; i < strs.length; i++){
            maxiLength = Math.min(maxiLength,strs[i].length());
        }
        for(int i = 1 ; i <= maxiLength; i++){
            char cur = strs[0].charAt(i - 1);
            boolean isMatch = true;
            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i-1) != cur){
                    isMatch = false;
                    break;
                }
            }
            if(!isMatch){
                break;
            }
            len++;
        }
        System.out.println(len);
        return strs[0].substring(0,len);
    }
}
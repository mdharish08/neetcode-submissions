class Solution {

   public static String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for(String s : strs){
            ans.append(s.length()).append("#").append(s);
        }
        return ans.toString();
    }

    public static List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i  < str.length()){
            StringBuilder size = new StringBuilder();
            while(i  < str.length() && str.charAt(i) != '#'){
                size.append(str.charAt(i));
                i++;
            }
            i++;
            int sizeAsInt = Integer.parseInt(size.toString());
            ans.add(str.substring(i,i + sizeAsInt));
            i = i + sizeAsInt ;
        }

        return ans;
    }
}

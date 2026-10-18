class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        String begin = "0000";
        Set<String> visited = new HashSet<>();
          for(String s : deadends){
            visited.add(s);
        }
        if(visited.contains(begin)){
            return -1;
        }
        if(target.equals(begin)){
            return 0;
        }
        int ans = 0;
        queue.offer(begin);
        visited.add(begin);
        while(!queue.isEmpty()){
            int n = queue.size();

            for(int i = 0 ; i < n; i++){
                String cur = queue.poll();
                if(cur.equals(target)){
                    return ans;
                }
                for(int j = 0 ; j < 4 ; j++){
                   StringBuilder sb = new StringBuilder(cur);
                   char c = cur.charAt(j);
                   sb.setCharAt(j, c == '9' ? '0' : (char) (c + 1));
                   String next = sb.toString();
                   if(!visited.contains(next)){
                       visited.add(next);
                       queue.offer(next);
                   }

                   sb.setCharAt(j, c == '0' ? '9' : (char) (c - 1));
                   next = sb.toString();
                   if(!visited.contains(next)){
                       visited.add(next);
                       queue.offer(next);
                   }
                }
            }
            ++ans;
        }
        return -1;
    }
}
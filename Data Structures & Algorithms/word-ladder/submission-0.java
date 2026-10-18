class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0 ; i < n; i++){
                String cur = queue.poll();
                if(cur.equals(endWord)){
                    return count;
                }
                char[] array = cur.toCharArray();
                for(int j = 0 ; j < cur.length(); j++){
                    for(int c = 0 ; c < 26; c++){
                        if(cur.charAt(j) - 'a' != c){
                            array[j] = (char) ('a' + c);
                            String newString = new String(array);
                            if(wordList.contains(newString) && visited.add(newString)){
                                queue.offer(newString);
                            }
                            array[j] = cur.charAt(j);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}

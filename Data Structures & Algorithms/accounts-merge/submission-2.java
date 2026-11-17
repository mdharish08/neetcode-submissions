class Solution {

    public static class UnionFind{
        private final int[] parent ;
        private final int[] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public boolean union(int a,int b){
            int parentA = find(a) , parentB = find(b);
            if(parentA == parentB){
                return false;
            }
            if(size[parentA] < size[parentB]){
                int temp = parentB;
                parentB = parentA;
                parentA = temp;
            }
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,Integer> emailVsAccount = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
        for(int i = 0 ; i < accounts.size(); i++){
            List<String> emails = accounts.get(i);
            for(int j = 1 ; j < emails.size(); j++ ){
                if(emailVsAccount.containsKey(emails.get(j))){
                   uf.union(i, emailVsAccount.get(emails.get(j)));
                }else{
                    emailVsAccount.put(emails.get(j), i);
                }
            }
        }
        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for(String email : emailVsAccount.keySet()){
            int accId = emailVsAccount.get(email);
            int leader = uf.find(accId);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }

        for(int accId : emailGroup.keySet()){
            List<String> allEmails = emailGroup.get(accId);
            List<String> result = new ArrayList<>();
            Collections.sort(allEmails);
            result.add(accounts.get(accId).get(0));
            result.addAll(allEmails);
            ans.add(result);
        }
        return ans;
    }
}
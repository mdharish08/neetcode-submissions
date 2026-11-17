class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Map<String,Set<Integer>> accountVsMap = new HashMap<>();
        List<Set<Integer>> groups =new ArrayList<>();
        for(int i = 0 ; i < accounts.size(); i++){
            List<String> info = accounts.get(i);
            String name = info.get(0);
            for(int j = 1 ; j < info.size(); j++){
                String email = info.get(j);
                accountVsMap.putIfAbsent(email, new HashSet<>());
                accountVsMap.get(email).add(i);
            }
        }

        for(int i = 0 ; i < accounts.size(); i++){
            if(!visited.contains(i)){
                Set<Integer> group = new HashSet<>();
                visit(accounts,accountVsMap,visited,group,i);
                groups.add(group);
            }
        }
        for(Set<Integer> group : groups){
             SortedSet<String> emails = new TreeSet<>();
             String name = null;
             for(int u : group){
                if(name == null){
                    name = accounts.get(u).get(0);
                }
                for(int i = 1 ; i < accounts.get(u).size(); i++){
                   emails.add(accounts.get(u).get(i));
                }
             }
             List<String> val = new ArrayList<>();
             val.add(name);
             emails.forEach(val::add);
             ans.add(val);
        }
        return ans;
    }


    private void visit(List<List<String>> accounts,Map<String,Set<Integer>> accountVsMap, Set<Integer> visited,Set<Integer> group, int u){
        visited.add(u);
        group.add(u);
        for(int i = 1 ; i < accounts.get(u).size(); i++){
            String email = accounts.get(u).get(i);
            for(int v : accountVsMap.get(email)){
                if(!visited.contains(v)){
                    visit(accounts,accountVsMap,visited,group,v);
                }
            }
        }
    }
}
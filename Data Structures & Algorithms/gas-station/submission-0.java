class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = Arrays.stream(gas).sum();
        int costSum =  Arrays.stream(cost).sum();

        if(costSum > gasSum){
            return -1;
        }
        int start = 0 , total = 0;
        for(int i = 0 ; i < gas.length; i++){
            total = total + gas[i] - cost[i];
            if(total < 0){
                start = i + 1;
                total = 0;
            }
        }
        return start;
    }
}

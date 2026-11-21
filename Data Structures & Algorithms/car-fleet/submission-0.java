class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0 ; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0],a[0]));
        Stack<Double> time = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            Double t = (target - cars[i][0]) * 1.0 / cars[i][1] * 1.0;
            if(time.isEmpty()){
                time.push(t);
            }else{
                if(t > time.peek()){
                    time.push(t);
                }
            }
        }

        return time.size();
    }
}
